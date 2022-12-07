
create PROC [sp_update_progress]
	@CourseID INT,
	@UserID INT
AS BEGIN
	WITH T AS (
		SELECT [UL].[Status]
		FROM [User_Lesson] AS UL, [Lesson] AS L, [Section] AS S 
		WHERE [UL].[UserID] = @UserID AND S.[CourseID] = @CourseID AND [UL].[LessonID] = [L].[LessonID] AND [L].[SectionID] = [S].[SectionID]
	) 
	UPDATE [User_Course] 
	SET [Progress] = CAST((SELECT COUNT(0) FROM T WHERE T.[Status] = 'Done') AS REAL) * 100 / (select count(0) from Lesson l
		inner join Section s on l.SectionID = s.SectionID
		where s.CourseID = @CourseID)
	WHERE [UserID] = @UserID AND [CourseID] = @CourseID
END

GO	
CREATE TRIGGER [trg_update_user_lesson_status]
ON [User_Lesson]
FOR UPDATE
AS BEGIN
	SELECT * INTO #temp FROM inserted

	WHILE (SELECT COUNT(0) FROM #temp) > 0
	BEGIN
		DECLARE @UserID INT, @CourseID INT, @LessonID INT; 
		SELECT TOP 1 @UserID = [UserID], @CourseID = (
			SELECT [S].CourseID
			FROM [Lesson] AS L, [Section] AS S 
			WHERE [L].[SectionID] = [S].[SectionID] AND [L].[LessonID] = [#temp].[LessonID]
		), @LessonID = [LessonID] FROM #temp;
			
		EXEC [sp_update_progress] @CourseID, @UserID;

		DELETE FROM #temp WHERE [UserID] = @UserID AND [LessonID] = @LessonID;
	END
END

