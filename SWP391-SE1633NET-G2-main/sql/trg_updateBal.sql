
CREATE TRIGGER trg_UpdateBal ON [Recharge] AFTER INSERT AS 
BEGIN
	UPDATE [User]
	SET Balance = Balance + (
		SELECT Amount
		FROM inserted
		WHERE UserID = [User].UserID
	)
	FROM [User]
	JOIN inserted ON [User].UserID = inserted.UserID
END

