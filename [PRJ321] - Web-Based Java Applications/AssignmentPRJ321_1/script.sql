USE [master]
GO
/****** Object:  Database [AssignmentPRJ321]    Script Date: 10/1/2018 4:45:49 PM ******/
CREATE DATABASE [AssignmentPRJ321]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AssignmentPRJ321', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\AssignmentPRJ321.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'AssignmentPRJ321_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\AssignmentPRJ321_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [AssignmentPRJ321] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AssignmentPRJ321].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AssignmentPRJ321] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET ARITHABORT OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AssignmentPRJ321] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AssignmentPRJ321] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET  DISABLE_BROKER 
GO
ALTER DATABASE [AssignmentPRJ321] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AssignmentPRJ321] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [AssignmentPRJ321] SET  MULTI_USER 
GO
ALTER DATABASE [AssignmentPRJ321] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AssignmentPRJ321] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AssignmentPRJ321] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AssignmentPRJ321] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [AssignmentPRJ321] SET DELAYED_DURABILITY = DISABLED 
GO
USE [AssignmentPRJ321]
GO
/****** Object:  Table [dbo].[tbl_Product]    Script Date: 10/1/2018 4:45:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Product](
	[ProductID] [varchar](15) NOT NULL,
	[ProductName] [varchar](50) NOT NULL,
	[ProductPrice] [float] NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Status] [varchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_Product] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_Product] ([ProductID], [ProductName], [ProductPrice], [Description], [Status]) VALUES (N'1', N'a', 111, N'a', N'Avaiable')
INSERT [dbo].[tbl_Product] ([ProductID], [ProductName], [ProductPrice], [Description], [Status]) VALUES (N'2', N'a', 1, N'a', N'a')
INSERT [dbo].[tbl_Product] ([ProductID], [ProductName], [ProductPrice], [Description], [Status]) VALUES (N'P0101', N'NoN', 2, N'NONE', N'a')
INSERT [dbo].[tbl_Product] ([ProductID], [ProductName], [ProductPrice], [Description], [Status]) VALUES (N'P021', N'lon coca', 12, N'none', N'Avaiable')
USE [master]
GO
ALTER DATABASE [AssignmentPRJ321] SET  READ_WRITE 
GO
