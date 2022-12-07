CREATE TRIGGER trg_UpdateMentorBal 
ON [User_Course] 
AFTER update AS 
BEGIN
	UPDATE [User]
	SET Balance = Balance + (
		SELECT c.CoursePrice
		FROM inserted i
		inner join [Course] c on c.CourseID = i.CourseID
		WHERE i.CourseID = c.CourseID
	)
	FROM [User]
	inner join Course c on c.CourseID = CourseID
	JOIN inserted ON [User].UserID = c.AuthorID
END

drop trigger trg_UpdateMentorBal