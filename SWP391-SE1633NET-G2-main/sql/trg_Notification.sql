
CREATE PROC [sp_insert_notification]
	@UserID INT,
	@Content nvarchar(max),
	@Action nchar(50),
	@Date datetime
AS BEGIN
	INSERT INTO [dbo].[Notification]
           ([UserID]
           ,[NoticeContent]
           ,[NoticeDate]
           ,[isSeen]
           ,[Action])
     VALUES
           (@UserID
           ,@Content
           ,@Date
           ,0
           ,@Action)
END

GO
CREATE TRIGGER [trg_insert_transaction_notification]
ON [Recharge]
AFTER INSERT
AS BEGIN	
DECLARE @UserID INT, @Content nvarchar(max), @Action nchar(50), @Date datetime
	select @UserID = UserID, @Date = GETDATE(), @Action = Method from inserted
	if(select Method from inserted) = 'Recharge'
	BEGIN
	select @Content = CONCAT(N'Bạn đã nạp ',Amount,' thành công') from inserted	
	EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;
	END
END

GO
CREATE TRIGGER [trg_update_transaction_notification]
ON [Recharge]
AFTER UPDATE
AS BEGIN	
SELECT r.UserID, r.Method, r.Amount INTO #temp FROM inserted i
inner join [Recharge] r on i.RechargeID = r.RechargeID
where r.RechargeID = i.RechargeID
DECLARE @UserID INT, @Content nvarchar(max), @Action nchar(50), @Date datetime, @Amount INT,@Method nchar(50)
	select @UserID = (select UserID from #temp)
	, @Date = GETDATE()
	, @Method = (select Method from #temp)
	,@Amount = (select -Amount from #temp)
	
	if(@Method) = 'Withdraw' and (select [Status] from inserted)=0
	BEGIN
	select @Content = CONCAT(N'Giao dịch rút ', @Amount,N' của bạn đã được duyệt') from inserted
	EXEC [sp_insert_notification] @UserID, @Content, @Method, @Date;
	DELETE FROM #temp WHERE #temp.UserID = #temp.UserID
	END
END

GO
CREATE TRIGGER [trg_user_replycomment_notification]
ON [Comment]
AFTER INSERT
AS BEGIN	
DECLARE @UserID INT, @Content nvarchar(max), @Action nchar(50), @Date datetime
	if(select ParentID from inserted) != 0
	BEGIN
	select @UserID = (
	select c.UserID from Comment c
	join inserted i on i.ParentID = c.CommentID
	where  c.CommentID = i.ParentID
	)
	select @Content = CONCAT(N'Có người trả lời bạn tại ',(
	select VideoName from Video v
	inner join inserted i on i.VideoID = v.VideoID
	where v.VideoID = i.VideoID
	))
	select @Date = GETDATE()
	select @Action = CONCAT('Reply ',(select LessonID
from Video v
inner join inserted i on i.VideoID = v.VideoID
where i.CommentID = i.CommentID))
	EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;
	END
END

GO
CREATE TRIGGER [trg_course_enable_notification]
ON [Course]
AFTER UPDATE
AS BEGIN	
DECLARE @UserID INT, @Content nvarchar(max), @Action nchar(50), @Date datetime, @Coursename nvarchar(100)
	if(select [Status] from inserted)='Enabled'
	BEGIN
		select @UserID = (
		select c.AuthorID from inserted i 
		inner join Course c on c.CourseID = i.CourseID
		where c.CourseID = i.CourseID
		)
		select @Coursename = (select c.CourseName from inserted i inner join Course c on c.CourseID = i.CourseID),
		@Content = CONCAT(N'Khóa học ',@Coursename,N' của bạn đã được duyệt'),
		@Action = CONCAT('Verify ',(select CourseID from inserted)),
		@Date = GETDATE()
		EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;	
	END	
	if(select [Status] from inserted)='Disabled'
	BEGIN
		select @UserID = (
		select c.AuthorID from inserted i 
		inner join Course c on c.CourseID = i.CourseID
		where c.CourseID = i.CourseID
		)
		select @Coursename = (select c.CourseName from inserted i inner join Course c on c.CourseID = i.CourseID),
		@Content = CONCAT(N'Khóa học ',@Coursename,N' của bạn đã bị vô hiệu hóa'),
		@Action = CONCAT('Verify ',(select CourseID from inserted)),
		@Date = GETDATE()
		EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;	
	END
END



GO
CREATE TRIGGER [trg_user_isdisable_notification]
ON [User]
AFTER UPDATE
AS BEGIN	
DECLARE @UserID INT, @Content nvarchar(max), @Action nchar(50), @Date datetime
	if(select isDisable from inserted)=1
	BEGIN
		select @UserID = (select UserID from inserted),
		@Content = N'Tài khoản của bạn đã bị cấm. Vui lòng liên hệ với admin để được mở khóa.',
		@Action = 'Ban',
		@Date = GETDATE()
		EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;	
	END
	else if(select isDisable from inserted)=0
	BEGIN
		select @UserID = (select UserID from inserted),
		@Content = N'Tài khoản của bạn đã được mở khóa, bạn có thể tiếp tục học các bài học.',
		@Action = 'Ban',
		@Date = GETDATE()
		EXEC [sp_insert_notification] @UserID, @Content, @Action, @Date;	
	END	
END





					
