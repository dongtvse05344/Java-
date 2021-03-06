USE [SinhVien]
GO
/****** Object:  Table [dbo].[Flights]    Script Date: 30/10/2018 19:59:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Flights](
	[Code] [varchar](50) NOT NULL,
	[Name] [varchar](50) NULL,
	[Color] [varchar](50) NULL,
	[ChairNo] [int] NULL,
	[isActive] [bit] NULL,
	[DateUpdated] [datetime] NULL,
 CONSTRAINT [PK_Flights] PRIMARY KEY CLUSTERED 
(
	[Code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Fly_Plan]    Script Date: 30/10/2018 19:59:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Fly_Plan](
	[FlightCode] [varchar](50) NULL,
	[DateFly] [date] NULL,
	[CustomerNo] [int] NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Fly_Plan] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-AAA-0001', N'Boeing 747', N'blue', 1000, 1, CAST(N'2018-10-30 19:57:05.117' AS DateTime))
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-ABA-0002', N'AirBus 921', N'green', 120, 1, NULL)
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-EUF-0001', N'UFO 123', N'hidden', 1000, 1, NULL)
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-KKU-0001', N'Boeing 123', N'green', 50, 1, NULL)
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-KKU-0002', N'AirBus 111', N'white', 60, 1, NULL)
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-OOP-0001', N'Lukat 123', N'blue', 12, 0, NULL)
INSERT [dbo].[Flights] ([Code], [Name], [Color], [ChairNo], [isActive], [DateUpdated]) VALUES (N'F-OOP-0002', N'Lukat 565', N'green', 12, 1, CAST(N'2018-10-30 19:39:12.757' AS DateTime))
SET IDENTITY_INSERT [dbo].[Fly_Plan] ON 

INSERT [dbo].[Fly_Plan] ([FlightCode], [DateFly], [CustomerNo], [Id]) VALUES (N'F-AAA-0001', CAST(N'1928-11-12' AS Date), 12, 1)
INSERT [dbo].[Fly_Plan] ([FlightCode], [DateFly], [CustomerNo], [Id]) VALUES (N'F-AAA-0001', CAST(N'1908-09-30' AS Date), 50, 2)
INSERT [dbo].[Fly_Plan] ([FlightCode], [DateFly], [CustomerNo], [Id]) VALUES (N'F-AAA-0001', CAST(N'2018-12-20' AS Date), 12, 3)
INSERT [dbo].[Fly_Plan] ([FlightCode], [DateFly], [CustomerNo], [Id]) VALUES (N'F-AAA-0001', CAST(N'2018-12-12' AS Date), 12, 4)
INSERT [dbo].[Fly_Plan] ([FlightCode], [DateFly], [CustomerNo], [Id]) VALUES (N'F-ABA-0002', CAST(N'2018-12-20' AS Date), 12, 5)
SET IDENTITY_INSERT [dbo].[Fly_Plan] OFF
