USE [master]
GO
/****** Object:  Database [PresentDb]    Script Date: 12/11/2018 12:53:21 ******/
CREATE DATABASE [PresentDb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PresentDb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\PresentDb.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PresentDb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\PresentDb_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PresentDb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PresentDb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PresentDb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PresentDb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PresentDb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PresentDb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PresentDb] SET ARITHABORT OFF 
GO
ALTER DATABASE [PresentDb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PresentDb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PresentDb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PresentDb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PresentDb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PresentDb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PresentDb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PresentDb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PresentDb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PresentDb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PresentDb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PresentDb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PresentDb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PresentDb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PresentDb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PresentDb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PresentDb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PresentDb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PresentDb] SET  MULTI_USER 
GO
ALTER DATABASE [PresentDb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PresentDb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PresentDb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PresentDb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PresentDb] SET DELAYED_DURABILITY = DISABLED 
GO
USE [PresentDb]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 12/11/2018 12:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Accounts](
	[Username] [varchar](30) NOT NULL,
	[Password] [varchar](30) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[RoleId] [int] NOT NULL,
	[isActive] [bit] NOT NULL CONSTRAINT [DF_Accounts_isActive]  DEFAULT ((1)),
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 12/11/2018 12:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Contact](
	[FullName] [nvarchar](50) NULL,
	[Email] [varchar](50) NULL,
	[Phone] [varchar](50) NULL,
	[Message] [nvarchar](max) NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Contact] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Events]    Script Date: 12/11/2018 12:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Events](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[DateCreated] [datetime] NULL,
	[DateStarted] [datetime] NULL,
	[ManagerId] [varchar](30) NULL,
	[Banner] [varchar](250) NULL,
	[Location] [varchar](250) NULL,
	[Description] [nvarchar](max) NULL,
	[NoUser] [int] NULL,
	[DateEnded] [datetime] NULL,
 CONSTRAINT [PK_Events] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Prizes]    Script Date: 12/11/2018 12:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Prizes](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Image] [varchar](250) NULL CONSTRAINT [DF_Prizes_Image]  DEFAULT ('assets/upload/prizes.jpg'),
 CONSTRAINT [PK_Prizes] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ranks]    Script Date: 12/11/2018 12:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ranks](
	[Username] [varchar](30) NOT NULL,
	[EventId] [int] NOT NULL,
	[Point] [int] NULL,
	[PrizeId] [int] NULL,
 CONSTRAINT [PK_Ranks_1] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[EventId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 12/11/2018 12:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [varchar](50) NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00001', N'123456', N'Pham Hai Duong', N'duongph@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00002', N'123456', N'Tran Trung Kien', N'kientt@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00003', N'123456', N'Do Thi Hai Yen', N'yendth@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00010', N'123456', N'Tran Dang Minh Nhat', N'nhattd@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00011', N'123456', N'Minh Hieu', N'hieumin@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00012', N'123456', N'Nguyen Nhat Ha', N'nhatha@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00013', N'123456', N'Phuong Trinh', N'trinhphuong@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00014', N'123456', N'Ly Minh Tuan', N'tuanlyminh@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SB00015', N'123456', N'Dinh Tien Dat', N'datinh@gmail.com', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE00001', N'123456', N'Ngoc Anh', N'anhncse00001@fpt.edu.vn', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE00002', N'123456', N'An Du', N'duase00002@fpt.edu.vn', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE00003', N'123456', N'Nguyen Van Hai', N'hainvse00003@fpt.edu.vn', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE00004', N'123456', N'Pham Trang', N'trangpse00004@fpt.edu.vn', 3, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE05344', N'123456', N'Tran Viet Dong', N'dongtvse05344@fpt.edu.vn', 2, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE62884', N'123456', N'Dao Thi Hoai Thuong', N'thuongdthse62884@fpt.edu.vn', 4, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE63329', N'123456', N'Le Hoang Viet Khoi', N'khoilhvse63329@fpt.edu.vn', 3, 0)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE63547', N'123456', N'Tran Van Binh', N'binhtvse63547@fpt.edu.vn', 4, 1)
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [RoleId], [isActive]) VALUES (N'SE63884', N'123456', N'Dinh Phung', N'phungd63884@fpt.edu.vn', 3, 1)
SET IDENTITY_INSERT [dbo].[Contact] ON 

INSERT [dbo].[Contact] ([FullName], [Email], [Phone], [Message], [id]) VALUES (N'dongtv', N'xhunter1412@gmail.com', N'09428875520', N'your website is busit', 5)
INSERT [dbo].[Contact] ([FullName], [Email], [Phone], [Message], [id]) VALUES (N'Tran Viet Dong', N'xhunter1412@gmail.com', N'123-1234567', N'Hello hola :v', 16)
SET IDENTITY_INSERT [dbo].[Contact] OFF
SET IDENTITY_INSERT [dbo].[Events] ON 

INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (56, N'Practical PRJ321', NULL, CAST(N'2018-10-31 12:30:00.000' AS DateTime), N'SE05344', N'css/img/upload/1540618673578thumb-1920-665093.jpg', N'FPT University', N'View Notes - Syllabus PRJ321.xls from SYLLABUS 771 at FPT University. ... Mô t ả The course is Designed to enhance the practical ability of Students. In each ...
', 30, CAST(N'2018-10-31 13:30:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (57, N'Design pattern', NULL, CAST(N'2018-11-20 12:00:00.000' AS DateTime), N'SE05344', N'css/img/upload1/1541685375792.jpg', N'Quang Trung Software City', N'In software engineering, a software <em>design pattern</em> is a general, reusable solution to a commonly occurring problem within a given context in software design.', 300, CAST(N'2018-11-30 12:00:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (60, N'Workshops Spring framework', NULL, CAST(N'2018-12-01 06:00:00.000' AS DateTime), N'SE00002', N'css/img/upload/img161052565853944684.jpg', N'Hoa Sen University', N'Spring Framework 5: Beginner to GuruJohn Thompson. ... Spring Framework 5: Learn Spring Core, Spring AOP, Spring MVC, Spring Security, Spring REST, Hibernate - Most Popular! ... ', 50, CAST(N'2018-12-01 12:00:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (61, N'Asus ROC Strix Radeon', NULL, CAST(N'2018-11-25 12:00:00.000' AS DateTime), N'SE05344', N'css/img/upload/img1115011166500109748.jpg', N'Tinh Te Coffee', N'22 hours ago - The brand is coming back According to rumors floating around, Asus will be returning its ROG Strix brand with the Radeon RX 590 graphics ...', 50, CAST(N'2018-11-30 12:00:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (62, N'WASD cluster?', CAST(N'2018-10-20 19:05:31.393' AS DateTime), CAST(N'2018-10-10 19:04:00.000' AS DateTime), N'SE05344', N'css/img/upload/img8568483801706280018.jpg', N'Thai Ha Street', N'- This article is about the cluster of keys on the keyboard. For the keyboard vendor, see WASD Keyboards. Lavender WASD cluster with arrows ...', 50, CAST(N'2018-11-30 09:22:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (63, N'BMW X7 2019', CAST(N'2018-10-21 12:08:22.070' AS DateTime), CAST(N'2018-10-11 12:02:00.000' AS DateTime), N'SE05344', N'css/img/upload/img8069656569201950751.jpg', N'ShowRoom 1 Districs', N'1 day ago - Will the BMW X7''s newer tech and middle-of-the-class pricing help it stand out from its many rivals in the full-size SUV category? ... The way we see it, the X7''s main competitors will be its German rivals, the Mercedes-Benz GLS and Audi''s tried-and-true Q7.', 50, CAST(N'2018-10-30 12:02:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (64, N'@Samsung_News_ on Twitter', CAST(N'2018-10-21 12:11:07.910' AS DateTime), CAST(N'2018-10-15 12:10:00.000' AS DateTime), N'SE63547', N'css/img/upload/img7083486452390679706.jpg', N'FPT University', N'Concepts --- Tipps via DM --- Editor & Concept/Graphic Designer @AllAboutSamsung. ... We wanted to wait on our iPhone XS and XS Max review until we''d spent a decent amount of time with it. ... #MSPExclusive- Official press render of Quad Camera Phone, the Samsung Galaxy A9s showing off the ', 500, CAST(N'2018-11-15 12:10:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (65, N'Pocophone F1', CAST(N'2018-10-21 12:39:25.003' AS DateTime), CAST(N'2018-10-10 12:38:00.000' AS DateTime), N'SE05344', N'css/img/upload/img1610054604098382025.jpg', N' Android smartphone.', N'13 hours ago - The Pocophone F1 is the best deal you can get if you''re buying an Android smartphone.', 100, CAST(N'2018-10-11 12:38:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (66, N'iPhone XR early presale', CAST(N'2018-10-21 12:41:43.893' AS DateTime), CAST(N'2018-10-10 12:41:00.000' AS DateTime), N'SE05344', N'css/img/upload/img6884702220513410095.jpg', N'Apple', N'Which iPhone XR models are showing shipment delays and what we''re expecting at Apple''s next launch event. Catch up on all your iPhone news for the week.', 50, CAST(N'2018-10-11 12:41:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (67, N'Venom meet Obama ', CAST(N'2018-10-21 12:44:20.030' AS DateTime), CAST(N'2018-09-21 12:43:00.000' AS DateTime), N'SE05344', N'css/img/upload/img794734565560913254.jpg', N'United State', N'Feb 10, 2018 - Download Wallpaper Venom Movie, Venom, 2018 Movies, Movies, Hd Images, Backgrounds, Photos and Pictures For Desktop,Pc,Android ...', 5000, CAST(N'2018-09-21 12:43:00.000' AS DateTime))
INSERT [dbo].[Events] ([Id], [Name], [DateCreated], [DateStarted], [ManagerId], [Banner], [Location], [Description], [NoUser], [DateEnded]) VALUES (80, N'F- Camp is Comming', CAST(N'2018-11-09 10:22:25.997' AS DateTime), CAST(N'2018-11-08 10:21:00.000' AS DateTime), N'SE05344', N'css/img/upload/1541733745994.jpg', N'FPT University', N'Mit Freunden Freizeit gestalten. Sei dabei und erlebe eine unvergessliche Zeit!! Auf dich wartet ein abwechslungsreicher Urlaub mit Freunden: Jung und Alt ...', 1000, CAST(N'2018-11-23 10:21:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Events] OFF
SET IDENTITY_INSERT [dbo].[Prizes] ON 

INSERT [dbo].[Prizes] ([Id], [Name], [Description], [Image]) VALUES (1, N'Cánh diều vàng', N'Cánh diều vàng là giải thưởng danh giá dành cho các cá nhân, tập thể, có thành tích xuất sắc trong việc chế tạo diều phục vụ nhu cầu giải trí và học hỏi của 1 tầng lớp trẻ em hiện nay', N'assets/upload/prizes.jpg')
INSERT [dbo].[Prizes] ([Id], [Name], [Description], [Image]) VALUES (2, N'Bông sen vàng', N'Bông sen vàng là giải thưởng danh giá dành cho các cá nhân, tập thể, có thành tích xuất sắc trong việc chế tạo diều phục vụ nhu cầu giải trí và học hỏi của 1 tầng lớp trẻ em hiện nay', N'assets/upload/prizes.jpg')
INSERT [dbo].[Prizes] ([Id], [Name], [Description], [Image]) VALUES (5, N'Mâm Xôi vàng', N'Mâm xôi vàng là giải thưởng danh giá dành cho các cá nhân, tập thể, có thành tích xuất sắc trong v.', N'assets/upload/prizes.jpg')
INSERT [dbo].[Prizes] ([Id], [Name], [Description], [Image]) VALUES (6, N'Oscar', N'The Academy Awards, also known as the Oscars, are a set of 24 awards for artistic and technical merit in the film industry, given annually by the Academy of ...', N'assets/upload/prizes.jpg')
INSERT [dbo].[Prizes] ([Id], [Name], [Description], [Image]) VALUES (7, N'Michelin', N'One more award for our Vision Concept tire! 🏆 On September 28, we received the « Best of the Best » award from @reddot. Congratulations to our Design Team! 😍 #reddotaward #reddotproductaward', N'assets/upload/prizes.jpg')
SET IDENTITY_INSERT [dbo].[Prizes] OFF
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 56, 0, 1)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 57, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 60, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 62, 1000, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 64, 600, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 65, 100, 5)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 66, 100, 2)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00001', 67, 200, 1)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00002', 56, 0, 2)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00002', 57, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00002', 62, 850, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00002', 64, 45, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00002', 65, 200, 1)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00003', 56, 0, 1)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00003', 57, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00003', 60, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE00003', 65, 100, 2)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE05344', 56, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE62884', 56, 0, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE63547', 65, 200, 2)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE63884', 62, 700, NULL)
INSERT [dbo].[Ranks] ([Username], [EventId], [Point], [PrizeId]) VALUES (N'SE63884', 65, 100, 5)
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([Id], [RoleName]) VALUES (2, N'Admin')
INSERT [dbo].[Roles] ([Id], [RoleName]) VALUES (3, N'User')
INSERT [dbo].[Roles] ([Id], [RoleName]) VALUES (4, N'Manager')
SET IDENTITY_INSERT [dbo].[Roles] OFF
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD  CONSTRAINT [FK_Accounts_Roles] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
GO
ALTER TABLE [dbo].[Accounts] CHECK CONSTRAINT [FK_Accounts_Roles]
GO
ALTER TABLE [dbo].[Ranks]  WITH CHECK ADD  CONSTRAINT [FK_Ranks_Accounts] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
GO
ALTER TABLE [dbo].[Ranks] CHECK CONSTRAINT [FK_Ranks_Accounts]
GO
ALTER TABLE [dbo].[Ranks]  WITH CHECK ADD  CONSTRAINT [FK_Ranks_Events] FOREIGN KEY([EventId])
REFERENCES [dbo].[Events] ([Id])
GO
ALTER TABLE [dbo].[Ranks] CHECK CONSTRAINT [FK_Ranks_Events]
GO
ALTER TABLE [dbo].[Ranks]  WITH CHECK ADD  CONSTRAINT [FK_Ranks_Prizes] FOREIGN KEY([PrizeId])
REFERENCES [dbo].[Prizes] ([Id])
GO
ALTER TABLE [dbo].[Ranks] CHECK CONSTRAINT [FK_Ranks_Prizes]
GO
USE [master]
GO
ALTER DATABASE [PresentDb] SET  READ_WRITE 
GO
