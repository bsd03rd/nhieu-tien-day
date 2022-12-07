CREATE TRIGGER [trg_insert_course_notification]
ON [User_Course]
AFTER INSERT
AS BEGIN	
DECLARE @UserID INT, @Content nvarchar(max), @Action nchar(50), @Date datetime, @CourseName nvarchar(200)
	select @UserID = UserID, @Date = GETDATE(), @Action = CONCAT('Enroll ',CourseID), @CourseName = (
	select c.CourseName
	from Course c
	where c.CourseID = inserted.CourseID
	) from inserted
	select @Content = CONCAT(N'Cảm ơn bạn đã tham gia khóa học ',@CourseName)

	EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;
END

drop trigger [trg_insert_course_notification]