USE [master]
GO
/****** Object:  Database [GundamDB]    Script Date: 06/11/2018 19:27:26 ******/
CREATE DATABASE [GundamDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GundamDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\GundamDB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'GundamDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\GundamDB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [GundamDB] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GundamDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GundamDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GundamDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GundamDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GundamDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GundamDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [GundamDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GundamDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GundamDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GundamDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GundamDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GundamDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GundamDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GundamDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GundamDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GundamDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GundamDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GundamDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GundamDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GundamDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GundamDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GundamDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GundamDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GundamDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [GundamDB] SET  MULTI_USER 
GO
ALTER DATABASE [GundamDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GundamDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GundamDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GundamDB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [GundamDB] SET DELAYED_DURABILITY = DISABLED 
GO
USE [GundamDB]
GO
/****** Object:  Table [dbo].[tbl_Zeon]    Script Date: 06/11/2018 19:27:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Zeon](
	[ID] [varchar](13) NOT NULL,
	[Classification] [varchar](100) NULL,
	[ModelNumber] [varchar](10) NULL,
	[OfficialName] [varchar](50) NULL,
	[Height] [float] NULL,
	[PowerSource] [varchar](100) NULL,
	[FullWeight] [float] NULL,
	[Status] [bit] NULL,
	[TimeOfUpdate] [datetime] NULL,
 CONSTRAINT [PK_tbl_Zeon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_Zeon] ([ID], [Classification], [ModelNumber], [OfficialName], [Height], [PowerSource], [FullWeight], [Status], [TimeOfUpdate]) VALUES (N'Z0001', N'Class ', N'12', N'Zeon Lacu ', 450, N'Rick2', 500, 1, CAST(N'2018-11-02 12:55:08.987' AS DateTime))
INSERT [dbo].[tbl_Zeon] ([ID], [Classification], [ModelNumber], [OfficialName], [Height], [PowerSource], [FullWeight], [Status], [TimeOfUpdate]) VALUES (N'Z0002', N'Class 1', N'1', N'Zeon Lucyka', 400, N'Punky Tep', 500, 1, CAST(N'2018-10-31 13:24:05.330' AS DateTime))
INSERT [dbo].[tbl_Zeon] ([ID], [Classification], [ModelNumber], [OfficialName], [Height], [PowerSource], [FullWeight], [Status], [TimeOfUpdate]) VALUES (N'Z0003', N'Class C', N'Model 1', N'Zeon Likat', 240, N'Power Stone', 600, 1, CAST(N'2018-11-02 12:55:08.987' AS DateTime))
INSERT [dbo].[tbl_Zeon] ([ID], [Classification], [ModelNumber], [OfficialName], [Height], [PowerSource], [FullWeight], [Status], [TimeOfUpdate]) VALUES (N'Z0004', N'Class C', N'Model 1', N'Zeon Likat', 1000, N'Power Stone', 600, 1, CAST(N'2018-11-02 12:55:08.987' AS DateTime))
INSERT [dbo].[tbl_Zeon] ([ID], [Classification], [ModelNumber], [OfficialName], [Height], [PowerSource], [FullWeight], [Status], [TimeOfUpdate]) VALUES (N'Z0005', N'Class C', N'Model 1', N'Zeon Likat', 300, N'Power Stone', 600, 0, CAST(N'2018-11-02 12:55:08.987' AS DateTime))
USE [master]
GO
ALTER DATABASE [GundamDB] SET  READ_WRITE 
GO
