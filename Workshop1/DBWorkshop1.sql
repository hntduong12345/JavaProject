USE [DuongHNTSP23WS01]
GO
/****** Object:  Table [dbo].[Registration]    Script Date: 11/02/2023 12:51:04 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[lastname] [nvarchar](50) NOT NULL,
	[isAdmin] [bit] NOT NULL,
 CONSTRAINT [PK_Registration] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'admin', N'12345', N'Ad do min', 1)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'cacom', N'123', N'Ca com kho to', 0)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'cakho', N'khoca', N'Kho ca ca kho', 0)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'teo', N'123', N'Nguyen Van Teo', 0)
GO
