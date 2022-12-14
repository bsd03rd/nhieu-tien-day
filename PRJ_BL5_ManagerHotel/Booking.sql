USE [BookingHotel]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[aid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](30) NOT NULL,
	[password] [varchar](30) NOT NULL,
	[name] [nvarchar](100) NULL,
	[phone] [varchar](10) NULL,
	[email] [varchar](200) NULL,
	[roleID] [int] NOT NULL,
 CONSTRAINT [PK__Account__DE508E2E4D7B2F42] PRIMARY KEY CLUSTERED 
(
	[aid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[bid] [int] IDENTITY(1,1) NOT NULL,
	[roomID] [int] NOT NULL,
	[accountID] [int] NOT NULL,
	[datefrom] [date] NOT NULL,
	[dateto] [date] NOT NULL,
	[numPeople] [int] NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK__Booking__C2FFCF13F68D056D] PRIMARY KEY CLUSTERED 
(
	[bid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hotel]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hotel](
	[hid] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[adress] [nvarchar](100) NOT NULL,
	[city] [nvarchar](50) NOT NULL,
	[phone] [varchar](12) NOT NULL,
	[description] [nvarchar](300) NULL,
	[imageURL] [varchar](200) NULL,
	[typeID] [int] NOT NULL,
	[ratingID] [int] NULL,
 CONSTRAINT [PK_Hotel] PRIMARY KEY CLUSTERED 
(
	[hid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[iid] [int] IDENTITY(1,1) NOT NULL,
	[roomID] [int] NOT NULL,
	[imageURL] [varchar](200) NULL,
 CONSTRAINT [PK__Image__DC5021AADBF9BE53] PRIMARY KEY CLUSTERED 
(
	[iid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] NOT NULL,
	[roleName] [varchar](30) NOT NULL,
 CONSTRAINT [PK__Role__C2BEC9101DA56C03] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[rid] [int] IDENTITY(1,1) NOT NULL,
	[hotelID] [int] NOT NULL,
	[name] [nvarchar](80) NOT NULL,
	[roomtype] [varchar](100) NULL,
	[quantity] [int] NOT NULL,
	[price] [int] NOT NULL,
	[description] [nvarchar](200) NULL,
	[status] [bit] NULL,
	[imageURL] [varchar](200) NULL,
 CONSTRAINT [PK__Room__DD37D91A5BECC1B0] PRIMARY KEY CLUSTERED 
(
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Type]    Script Date: 12/14/2022 3:23:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type](
	[tid] [int] NOT NULL,
	[name] [nvarchar](80) NOT NULL,
 CONSTRAINT [PK__RoomType__D837D05F927F58B4] PRIMARY KEY CLUSTERED 
(
	[tid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([aid], [username], [password], [name], [phone], [email], [roleID]) VALUES (1, N'hieu', N'hieu', N'sssss', N'0383139116', N'a@fpt.edu.vn', 1)
INSERT [dbo].[Account] ([aid], [username], [password], [name], [phone], [email], [roleID]) VALUES (3, N'vivi731', N'vitobo123', N'Không', N'0178740564', N'kdkhangduy@gmail.com', 1)
INSERT [dbo].[Account] ([aid], [username], [password], [name], [phone], [email], [roleID]) VALUES (4, N'dat', N'dat', N'Đạt', N'5559861076', N'dat@gmail.com', 1)
INSERT [dbo].[Account] ([aid], [username], [password], [name], [phone], [email], [roleID]) VALUES (5, N'admin', N'admin', N'AD', N'2222222222', N'ad@gmail.com', 2)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Hotel] ON 

INSERT [dbo].[Hotel] ([hid], [name], [adress], [city], [phone], [description], [imageURL], [typeID], [ratingID]) VALUES (1, N'OCD LOVE HOTEL', N'139 P. Ô Chợ Dừa, Chợ Dừa, Đống Đa, Hà Nội, Vietnam', N'Hà Nội', N'3217321207', N'OCD Love Hotel - khách sạn tình nhân dành cho những cặp đôi muốn có giây phút lãng mạng khó quên, sống trong bỏng, hâm nóng tình yêu', N'assets/img/hotel1.jpg', 1, NULL)
INSERT [dbo].[Hotel] ([hid], [name], [adress], [city], [phone], [description], [imageURL], [typeID], [ratingID]) VALUES (2, N'ACOUSTIC HOTEL & SPA', N'39 Thợ Nhuộm, Cửa Nam, Hoàn Kiếm, Hà Nội, Việt Nam', N'Hà Nội', N'4976780570', N'Acoustic Hotel & Spa cung cấp vô số lựa chọn đồ uống và ăn uống ngay trong khuôn viên, bao gồm Nhà hàng Indigo, Eclipse Sky Bar - một trong những quán bar trên tầng thượng tốt nhất ở Hà Nội', N'assets/img/hotel2.jpg', 2, NULL)
INSERT [dbo].[Hotel] ([hid], [name], [adress], [city], [phone], [description], [imageURL], [typeID], [ratingID]) VALUES (3, N'MayHouse', N'11A Xóm Hạ Hồi, Trần Hưng Đạo, Hoàn Kiếm, Hà Nội, Việt Nam', N'Hà Nội', N'1508011567 ', N'Ngôi nhà có thể nằm trong con hẻm nhỏ của Xóm Hạ Hồi - trung tâm của khu phố thời Pháp xưa. Khu vực này, giống như hầu hết Hà Nội, là một sự tương phản của cũ và mới. Các tòa nhà dân cư nguyên bản của kiến ​​trúc ban đầu tương phản với các văn phòng hiện đại, cửa hàng mới và khách sạn sang trọng.', N'assets/img/hotel3.jpg', 3, NULL)
INSERT [dbo].[Hotel] ([hid], [name], [adress], [city], [phone], [description], [imageURL], [typeID], [ratingID]) VALUES (4, N'A25 HOTEL', N'38 Hàng Thiếc, Hàng Gai, Hoàn Kiếm, Hà Nội, Việt Nam', N'Hà Nội', N'1334775389 ', N'Chi nhánh thuộc hệ thống khách sạn A25 với trang thiết bị đạt tiêu chuẩn 3 sao. Phố Hàng Thiếc giao cắt 4 tuyến đường hàng Bồ, Bát Đàn, Thuốc Bắc và Hàng Nón. Xưa kia, cả hai dãy mặt phố hàng Thiếctập trung các nhà sản xuất những mặt hàng bằng tôn, kẽm, sắt tây và gương soi.', N'assets/img/hotel4.jpg', 4, NULL)
INSERT [dbo].[Hotel] ([hid], [name], [adress], [city], [phone], [description], [imageURL], [typeID], [ratingID]) VALUES (5, N'LUCKY BUDDA INN VILLA', N'32 Ngõ 97, Ngọc Thụy, Long Biên, Hà Nội, Việt Nam', N'Hà Nội', N'1296773468', N'Tọa lạc tại thành phố Hà Nội, Lucky Budda Inn Villa có nhà hàng, xe đạp cho khách sử dụng miễn phí và sảnh khách chung. Tọa lạc ở vị trí tuyệt đẹp tại quận Long Biên, khách sạn này có khu vườn cũng như hồ bơi trong nhà. ', N'assets/img/hotel5.jpg', 1, NULL)
SET IDENTITY_INSERT [dbo].[Hotel] OFF
GO
INSERT [dbo].[Role] ([id], [roleName]) VALUES (1, N'customer')
INSERT [dbo].[Role] ([id], [roleName]) VALUES (2, N'employee')
INSERT [dbo].[Role] ([id], [roleName]) VALUES (3, N'admin')
INSERT [dbo].[Role] ([id], [roleName]) VALUES (4, N'oni-chan')
GO
SET IDENTITY_INSERT [dbo].[Room] ON 

INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (1, 1, N'PHÒNG VIP RED', N'Vip', 2, 1, N'Cửa Sổ', 1, N'assets/img/room1.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (2, 1, N'PHÒNG VIP BLUE', N'Vip', 2, 2, N'Cửa Sổ', 1, N'assets/img/room2.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (3, 1, N'PHÒNG VIP BDSM', N'Vip', 2, 3, N'Kín', 1, N'assets/img/room3.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (5, 1, N'PHÒNG KING LỒNG CHIM', N'King', 2, 33, N'Kín', 1, N'assets/img/room4.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (6, 1, N'PHÒNG KING ROYAL', N'King', 2, 44, N'Kín', 1, N'assets/img/room5.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (7, 1, N'PHÒNG KING RUBY', N'King', 2, 55, N'Kín', 1, N'assets/img/room6.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (8, 1, N'PHÒNG KING SAKURA', N'King', 2, 66, N'Kín', 1, N'assets/img/room7.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (9, 1, N'KING GALAXY', N'King', 2, 77, N'Kín', 1, N'assets/img/room8.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (10, 1, N'KING FLAMIGO', N'King', 2, 88, N'Kín', 1, N'assets/img/room9.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (11, 2, N'DELUXE BALCONY', N'Deluxe', 2, 9, N'22 m2

 Cửa Sổ, 
Ban Công', 1, N'assets/img/room11.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (13, 2, N'SENIOR DELUXE', N'Deluxe', 2, 87, N'25 m2, Thành Phố , 
Cửa Sổ', 1, N'assets/img/room13.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (14, 2, N'PREMIER DELUXE BALCONY', N'Deluxe', 2, 3, N'28 m2, Ban Công, Cửa Sổ, 
Thành Phố', 1, N'assets/img/room14.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (16, 2, N'EXECUTIVE SUITE', N'Suite', 2, 47, N'35 m2, Thành Phố, 
Cửa Sổ', 1, N'assets/img/room16.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (17, 2, N'ACOUSTIC SUITE', N'Suite', 2, 32, N'45 m2, Ban Công, 
Cửa Sổ, Thành Phố', 1, N'assets/img/room17.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (19, 3, N'STUDIO 1', N'Normal', 2, 65, N'Cửa Sổ, Ban Công', 1, N'assets/img/room19.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (20, 3, N'STUDIO 2', N'Normal', 2, 24, N'Cửa Sổ, 
Ban Công', 1, N'assets/img/room20.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (21, 3, N'SKY VIEW', N'Normal', 2, 225, N'Cửa Sổ', 1, N'assets/img/room21.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (22, 3, N'MAY ORANGE', N'May', 2, 342, NULL, 1, N'assets/img/room22.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (24, 3, N'MAY YELLOW', N'May', 2, 222, NULL, 1, N'assets/img/room24.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (25, 3, N'MAY PURPLE', N'May', 2, 234, NULL, 1, N'assets/img/room25.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (26, 3, N'MAYPINK', N'May', 2, 124, NULL, 1, N'assets/img/room26.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (27, 4, N'PHÒNG SANG TRỌNG', N'Vip', 2, 170, NULL, 1, N'assets/img/room27.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (28, 4, N'PHÒNG CAO CẤP', N'Vip', 2, 170, NULL, 1, N'assets/img/room28.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (29, 5, N'Superior Double', N'Superior ', 2, 400, NULL, 1, N'assets/img/room29.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (30, 5, N'Family room with bacony', N'Family', 2, 403, NULL, 1, N'assets/img/room30.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (31, 5, N'Family room with swimming pool view', N'Family', 2, 403, N'Pool view', 1, N'assets/img/room31.jpg')
INSERT [dbo].[Room] ([rid], [hotelID], [name], [roomtype], [quantity], [price], [description], [status], [imageURL]) VALUES (33, 5, N'King suite with bacony', N'Suit', 2, 468, N'2 bed ', 1, N'assets/img/room33.jpg')
SET IDENTITY_INSERT [dbo].[Room] OFF
GO
INSERT [dbo].[Type] ([tid], [name]) VALUES (1, N'Tình yêu')
INSERT [dbo].[Type] ([tid], [name]) VALUES (2, N'Sang trọng')
INSERT [dbo].[Type] ([tid], [name]) VALUES (3, N'Du lịch')
INSERT [dbo].[Type] ([tid], [name]) VALUES (4, N'Felicity room')
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK__Account__roleID__267ABA7A] FOREIGN KEY([roleID])
REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK__Account__roleID__267ABA7A]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([aid])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Account]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Room] FOREIGN KEY([roomID])
REFERENCES [dbo].[Room] ([rid])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Room]
GO
ALTER TABLE [dbo].[Hotel]  WITH CHECK ADD  CONSTRAINT [FK_Hotel_Type] FOREIGN KEY([typeID])
REFERENCES [dbo].[Type] ([tid])
GO
ALTER TABLE [dbo].[Hotel] CHECK CONSTRAINT [FK_Hotel_Type]
GO
ALTER TABLE [dbo].[Image]  WITH CHECK ADD  CONSTRAINT [FK_Image_Room] FOREIGN KEY([roomID])
REFERENCES [dbo].[Room] ([rid])
GO
ALTER TABLE [dbo].[Image] CHECK CONSTRAINT [FK_Image_Room]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_Hotel] FOREIGN KEY([hotelID])
REFERENCES [dbo].[Hotel] ([hid])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Hotel]
GO
