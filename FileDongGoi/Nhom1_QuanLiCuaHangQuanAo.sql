USE [master]
GO
/****** Object:  Database [CuaHangQuanAo]    Script Date: 12/14/2022 11:04:23 AM ******/
CREATE DATABASE [CuaHangQuanAo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CuaHangQuanAo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\CuaHangQuanAo.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CuaHangQuanAo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\CuaHangQuanAo_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [CuaHangQuanAo] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CuaHangQuanAo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CuaHangQuanAo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET ARITHABORT OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [CuaHangQuanAo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CuaHangQuanAo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CuaHangQuanAo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [CuaHangQuanAo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CuaHangQuanAo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CuaHangQuanAo] SET  MULTI_USER 
GO
ALTER DATABASE [CuaHangQuanAo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CuaHangQuanAo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CuaHangQuanAo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CuaHangQuanAo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [CuaHangQuanAo] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CuaHangQuanAo] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [CuaHangQuanAo] SET QUERY_STORE = OFF
GO
USE [CuaHangQuanAo]
GO
/****** Object:  Table [dbo].[CaLam]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CaLam](
	[maCaLam] [nvarchar](6) NOT NULL,
	[ngay] [date] NULL,
	[buoiLam] [nvarchar](1) NULL,
	[maNhanVien] [nvarchar](6) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCaLam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[maCL] [nvarchar](6) NOT NULL,
	[tenCL] [nvarchar](30) NULL,
	[moTa] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maCTSP] [nvarchar](16) NOT NULL,
	[maHD] [nvarchar](6) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maCTSP] ASC,
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[maCTSP] [nvarchar](16) NOT NULL,
	[maSP] [nvarchar](6) NULL,
	[Size] [nvarchar](5) NULL,
	[Mau] [nvarchar](30) NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_ChiTietSanPham] PRIMARY KEY CLUSTERED 
(
	[maCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietTraHang]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTraHang](
	[maCTSP] [nvarchar](16) NOT NULL,
	[maHDTH] [nvarchar](8) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_ChiTietTraHang] PRIMARY KEY CLUSTERED 
(
	[maCTSP] ASC,
	[maHDTH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonBanHang]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonBanHang](
	[maHoaDon] [nvarchar](6) NOT NULL,
	[ngayLapHoaDon] [date] NULL,
	[maKhachHang] [nvarchar](6) NULL,
	[maNhanVien] [nvarchar](6) NULL,
	[giamGia] [float] NULL,
	[tienKhachDua] [float] NULL,
	[tongTienHoaDon] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonTraHang]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonTraHang](
	[maHDTH] [nvarchar](8) NOT NULL,
	[maHoaDon] [nvarchar](6) NULL,
	[ngayLapHoaDon] [date] NULL,
	[maKhachHang] [nvarchar](6) NULL,
	[maNhanVien] [nvarchar](6) NULL,
	[tongTienHoaDon] [float] NULL,
 CONSTRAINT [PK_HoaDonTraHang] PRIMARY KEY CLUSTERED 
(
	[maHDTH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](6) NOT NULL,
	[TenKhachHang] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NULL,
	[loaiKhachHang] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [nvarchar](7) NOT NULL,
	[tenNCC] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NULL,
	[diaChi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](6) NOT NULL,
	[tenNhanVien] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NULL,
	[diaChi] [nvarchar](30) NULL,
	[chucVu] [nvarchar](20) NULL,
	[gioiTinh] [nvarchar](1) NULL,
	[ngaySinh] [date] NULL,
	[ngayVaoLam] [date] NULL,
	[tinhTrang] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](6) NOT NULL,
	[tenSP] [nvarchar](30) NULL,
	[giaGoc] [float] NULL,
	[hinhAnh] [nvarchar](100) NULL,
	[moTa] [nvarchar](100) NULL,
	[gioiTinh] [nvarchar](3) NULL,
	[phongCach] [nvarchar](20) NULL,
	[loai] [nvarchar](20) NULL,
	[coAo] [nvarchar](20) NULL,
	[soLuongLoi] [int] NULL,
	[maCL] [nvarchar](6) NULL,
	[maTH] [nvarchar](6) NULL,
	[maXX] [nvarchar](6) NULL,
	[maNCC] [nvarchar](7) NULL,
	[tinhTrang] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[id] [nvarchar](6) NOT NULL,
	[matKhau] [nvarchar](20) NULL,
	[email] [nvarchar](50) NULL,
	[maNhanVien] [nvarchar](6) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[maTH] [nvarchar](6) NOT NULL,
	[tenTH] [nvarchar](30) NULL,
	[moTa] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maTH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XuatXu]    Script Date: 12/14/2022 11:04:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XuatXu](
	[maXX] [nvarchar](6) NOT NULL,
	[tenXX] [nvarchar](30) NULL,
	[moTa] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maXX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0001', CAST(N'2022-10-20' AS Date), N'0', N'NV0002')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0002', CAST(N'2022-10-20' AS Date), N'1', N'NV0005')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0003', CAST(N'2022-10-20' AS Date), N'0', N'NV0003')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0004', CAST(N'2022-10-21' AS Date), N'1', N'NV0007')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0005', CAST(N'2022-10-21' AS Date), N'0', N'NV0004')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0006', CAST(N'2022-10-20' AS Date), N'1', N'NV0004')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0007', CAST(N'2022-10-20' AS Date), N'0', N'NV0006')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0008', CAST(N'2022-10-20' AS Date), N'1', N'NV0003')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0009', CAST(N'2022-10-20' AS Date), N'0', N'NV0004')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0010', CAST(N'2022-10-20' AS Date), N'1', N'NV0007')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0011', CAST(N'2022-10-20' AS Date), N'0', N'NV0001')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0012', CAST(N'2022-10-21' AS Date), N'1', N'NV0007')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0013', CAST(N'2022-10-21' AS Date), N'0', N'NV0005')
INSERT [dbo].[CaLam] ([maCaLam], [ngay], [buoiLam], [maNhanVien]) VALUES (N'CL0014', CAST(N'2022-10-21' AS Date), N'1', N'NV0007')
GO
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0001', N'Cotton', N'Nhẹ, có độ bền và co giãn cao, cũng như thấm hút mồ hôi tốt.')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0002', N'Kaki', N' Vải dày,tuy có bề mặt thô cứng nhưng lại dễ giặt, ít bị nhăn, ít bám bụi và cứng form.')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0003', N'Jean', N'Vải có tính bền, chắc,không bị co rút hay nhăn.')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0004', N'Kate', N'Vừa có sự mềm mịn, thoáng mát của cotton cùng độ bền, ít nhăn và không bị phai màu của polyeste')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0005', N'V?i n? (flet)', N'Tạo nên cảm giác mềm mịn,có độ bền cao,không bị bạc màu,không nhàu và có khả năng giữ ấm tốt.')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0006', N'V?i len', N'Co giãn,đàn hồi hồi lớn,tạo cảm giác mềm mại,thoải mái,có khả năng giữ nhiệt rất tốt.')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0007', N'V?i l?a', N'Mềm mại, nhẹ nhàng tựa như vẻ đẹp người phụ nữ sang trọng mà quý phái.')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0008', N'V?i Canvas', N'Đồ bền chắc ưu việt,giữ màu,có khả năng chống nước,vải nhẹ & dễ dàng vệ sinh')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0009', N'V?i tuy?t mưa', N'Tạo cảm giác thoải mái dễ chịu,không quá dày và quá mỏng,không bám bụi,phai màu')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0010', N'v?i Chiffon', N'Vải Chiffon lần đầu tiên được sản xuất ở Pháp và được sản xuất tương đối rộng rãi ở Hoa Kỳ')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0011', N'Tr?ng kính polycarbonate', N'n?i b?t v?i kh? năng ch?ng va đ?p, ch?ng v? v?n và ch?n tia UV')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0012', N'French Terry', N' ')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0013', N'Poly', N' ')
INSERT [dbo].[ChatLieu] ([maCL], [tenCL], [moTa]) VALUES (N'CL0014', N'Chat lieu moi', N' ')
GO
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0008', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0009', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0010', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0011', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0013', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0014', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0021', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0023', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0024', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0025', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0026', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-001-S', N'HD0027', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-002-S', N'HD0020', 2)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-002-S', N'HD0023', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-003-M', N'HD0019', 3)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-003-M', N'HD0020', 3)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-004-M', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-004-M', N'HD0007', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-004-M', N'HD0028', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-005-S', N'HD0001', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-006-S', N'HD0028', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-008-S', N'HD0001', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0001-011-S', N'HD0001', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0002-002-L', N'HD0001', 2)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0002-002-L', N'HD0007', 14)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0002-002-L', N'HD0011', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0002-002-L', N'HD0013', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0002-002-L', N'HD0014', 7)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0002-002-L', N'HD0017', 4)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-001-XL', N'HD0003', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-002-M', N'HD0003', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-002-M', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-002-M', N'HD0007', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-002-M', N'HD0017', 3)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-002-M', N'HD0019', 2)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0003-002-M', N'HD0027', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0004-001-XXL', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0004-001-XXL', N'HD0007', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0005-002-S', N'HD0003', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0005-002-S', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0005-002-S', N'HD0007', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0005-002-S', N'HD0012', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0005-002-S', N'HD0022', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0006-001-XL', N'HD0003', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0006-001-XL', N'HD0017', 4)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0006-001-XL', N'HD0022', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0007-001-M', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0007-001-M', N'HD0007', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0008-001-L', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0008-001-L', N'HD0006', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0009-001-L', N'HD0003', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0009-001-L', N'HD0004', 3)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0009-001-L', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0009-001-L', N'HD0006', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0009-001-L', N'HD0027', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0010-001-S', N'HD0004', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0010-001-S', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0010-001-S', N'HD0006', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0010-001-S', N'HD0017', 3)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0011-002-M', N'HD0002', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0011-005-L', N'HD0002', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0011-005-L', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0011-005-L', N'HD0006', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0012-001-XL', N'HD0002', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0012-001-XL', N'HD0005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0012-001-XL', N'HD0006', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0012-005-S', N'HD0029', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0012-006-S', N'HD0002', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0013-001-M', N'HD0028', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0013-004-XXL', N'HD0021', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0013-005-S', N'HD0017', 3)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0026-001-S', N'HD0015', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0038-001-S', N'HD0015', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0074-005-S', N'HD0015', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0086-005-S', N'HD0015', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0130-005-S', N'HD0015', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0130-005-S', N'HD0018', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0146-010-S', N'HD0018', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0170-013-S', N'HD0018', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0182-013-S', N'HD0016', 1)
INSERT [dbo].[ChiTietHoaDon] ([maCTSP], [maHD], [soLuong]) VALUES (N'SP0190-010-S', N'HD0016', 1)
GO
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-001-S', N'SP0001', N'S', N'Xanh', 1)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-002-S', N'SP0001', N'S', N'Xám', 6)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-003-M', N'SP0001', N'M', N'Xanh', 6)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-004-M', N'SP0001', N'M', N'Xám', 38)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-005-S', N'SP0001', N'S', N'Đỏ', 56)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-006-S', N'SP0001', N'S', N'TÍm', 83)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-007-S', N'SP0001', N'S', N'Vàng', 876)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-008-S', N'SP0001', N'S', N'Hồng', 56)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-009-S', N'SP0001', N'S', N'Xanh lá', 356)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-010-S', N'SP0001', N'S', N'Nâu', 3457)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-011-S', N'SP0001', N'S', N'Cam', 353)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0001-012-S', N'SP0001', N'S', N'Xanh ngoc', 235)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0002-001-L', N'SP0002', N'L', N'Đỏ', 200)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0002-002-L', N'SP0002', N'L', N'Đỏ', 546)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0003-001-XL', N'SP0003', N'XL', N'Đens', 120)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0003-002-M', N'SP0003', N'M', N'Vàngf', 536)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0003-003-XL', N'SP0003', N'XL', N'Vàng', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0003-004-M', N'SP0003', N'M', N'Xanh', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0003-005-M', N'SP0003', N'M', N'Den', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0003-006-S', N'SP0003', N'S', N'Xanh', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0004-001-XXL', N'SP0004', N'XXL', N'Đen', 121)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0004-002-XXL', N'SP0004', N'XXL', N'Đen', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0004-003-L', N'SP0004', N'L', N'Xám', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0004-004-L', N'SP0004', N'L', N'Vang', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0005-001-S', N'SP0005', N'S', N'Tím', 345)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0005-002-S', N'SP0005', N'S', N'Tím', 740)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0006-001-XL', N'SP0006', N'XL', N'Xám', 42)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0006-002-L', N'SP0006', N'L', N'Đen', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0007-001-M', N'SP0007', N'M', N'Xanh', 74)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0007-002-L', N'SP0007', N'L', N'Xanh', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0008-001-L', N'SP0008', N'L', N'Xanh', 8)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0008-002-L', N'SP0008', N'L', N'Den', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0009-001-L', N'SP0009', N'L', N'Xanh', 10)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0010-001-S', N'SP0010', N'S', N'Trắng', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0011-002-M', N'SP0011', N'M', N'Đen', 656)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0011-003-L', N'SP0011', N'L', N'Đen', 674)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0011-004-XL', N'SP0011', N'XL', N'Đen', 235)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0011-005-L', N'SP0011', N'L', N'Đen', 543)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-001-XL', N'SP0012', N'XL', N'Xanh', 753)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-002-L', N'SP0012', N'L', N'Trắng', 576)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-003-M', N'SP0012', N'M', N'Trắng', 857)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-004-S', N'SP0012', N'S', N'Trắng', 2534)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-005-S', N'SP0012', N'S', N'Đỏ', 655)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-006-S', N'SP0012', N'S', N'Đen', 764)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-007-XXL', N'SP0012', N'XXL', N'Trắng', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0012-008-XXL', N'SP0012', N'XXL', N'Vàng', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0013-001-M', N'SP0013', N'M', N'Xanh', 35)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0013-002-L', N'SP0013', N'L', N'Xanh', 35)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0013-003-XL', N'SP0013', N'XL', N'Xanh', 36)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0013-004-XXL', N'SP0013', N'XXL', N'Xanh', 545)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0013-005-S', N'SP0013', N'S', N'Xanh', 42)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0014-001-L', N'SP0014', N'L', N'Trắng', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0014-002-L', N'SP0014', N'L', N'Đỏ', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0014-003-L', N'SP0014', N'L', N'Vàng', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0026-001-S', N'SP0026', N'S', N'Vàng', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0038-001-S', N'SP0038', N'S', N'Vàng', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0038-002-L', N'SP0038', N'L', N'Đỏ', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0050-002-L', N'SP0050', N'L', N'Đỏ', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0050-003-M', N'SP0050', N'M', N'Vàng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0062-003-M', N'SP0062', N'M', N'Vàng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0062-004-XXL', N'SP0062', N'XXL', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0074-004-XXL', N'SP0074', N'XXL', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0074-005-S', N'SP0074', N'S', N'Tím', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0082-001-S', N'SP0082', N'S', N'Vàng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0086-005-S', N'SP0086', N'S', N'Tím', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0086-006-XL', N'SP0086', N'XL', N'Xám', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0094-002-L', N'SP0094', N'L', N'Đỏ', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0098-006-XL', N'SP0098', N'XL', N'Xám', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0098-007-M', N'SP0098', N'M', N'Hồng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0106-003-M', N'SP0106', N'M', N'Vàng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0110-007-M', N'SP0110', N'M', N'Hồng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0110-008-L', N'SP0110', N'L', N'Đỏ', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0118-004-XXL', N'SP0118', N'XXL', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0122-008-L', N'SP0122', N'L', N'Đỏ', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0122-009-L', N'SP0122', N'L', N'Nâu', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0130-005-S', N'SP0130', N'S', N'Tím', 28)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0134-009-L', N'SP0134', N'L', N'Nâu', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0134-010-S', N'SP0134', N'S', N'Trắng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0142-006-XL', N'SP0142', N'XL', N'Xám', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0146-010-S', N'SP0146', N'S', N'Trắng', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0146-011-M', N'SP0146', N'M', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0154-007-M', N'SP0154', N'M', N'Hồng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0158-011-M', N'SP0158', N'M', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0158-012-L', N'SP0158', N'L', N'Trắng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0166-008-L', N'SP0166', N'L', N'Đỏ', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0170-012-L', N'SP0170', N'L', N'Trắng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0170-013-S', N'SP0170', N'S', N'Đen', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0178-009-L', N'SP0178', N'L', N'Nâu', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0182-013-S', N'SP0182', N'S', N'Đen', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0190-010-S', N'SP0190', N'S', N'Trắng', 29)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0202-011-M', N'SP0202', N'M', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0214-012-L', N'SP0214', N'L', N'Trắng', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0226-013-S', N'SP0226', N'S', N'Đen', 30)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0227-001-S', N'SP0227', N'S', N'ss', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0227-002-S', N'SP0227', N'S', N'ssss', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0228-001-M', N'SP0228', N'M', N'Xanh', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0229-001-L', N'SP0229', N'L', N'Xanh', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0230-001-L', N'SP0230', N'L', N'Xanh', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0230-002-L', N'SP0230', N'L', N'Đỏ', 0)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0231-001-L', N'SP0231', N'L', N'Tr?ng', 100)
GO
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0232-001-L', N'SP0232', N'L', N'Trắng', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0233-002-S', N'SP0233', N'S', N'Xanh', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0234-003-S', N'SP0234', N'S', N'Đen', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0235-004-S', N'SP0235', N'S', N'Đỏ', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0236-005-XL', N'SP0236', N'XL', N'Tím', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0237-001-L', N'SP0237', N'L', N'Trắng', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0238-002-S', N'SP0238', N'S', N'Xanh', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0239-003-S', N'SP0239', N'S', N'Đen', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0240-004-S', N'SP0240', N'S', N'Đỏ', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0241-005-XL', N'SP0241', N'XL', N'Tím', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0242-001-L', N'SP0242', N'L', N'Trắng', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0243-002-S', N'SP0243', N'S', N'Xanh', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0244-003-S', N'SP0244', N'S', N'Đen', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0245-004-S', N'SP0245', N'S', N'Đỏ', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0246-005-XL', N'SP0246', N'XL', N'Tím', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0247-001-L', N'SP0247', N'L', N'Trắng', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0248-002-S', N'SP0248', N'S', N'Xanh', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0249-003-S', N'SP0249', N'S', N'Đen', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0250-004-S', N'SP0250', N'S', N'Đỏ', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0251-005-XL', N'SP0251', N'XL', N'Tím', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0252-001-L', N'SP0252', N'L', N'Trắng', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0253-002-S', N'SP0253', N'S', N'Xanh', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0254-003-S', N'SP0254', N'S', N'Đen', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0255-004-S', N'SP0255', N'S', N'Đỏ', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0256-005-XL', N'SP0256', N'XL', N'Tím', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0257-001-L', N'SP0257', N'L', N'Trắng', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0258-002-S', N'SP0258', N'S', N'Xanh', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0259-003-S', N'SP0259', N'S', N'Đen', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0260-004-S', N'SP0260', N'S', N'Đỏ', 100)
INSERT [dbo].[ChiTietSanPham] ([maCTSP], [maSP], [Size], [Mau], [soLuong]) VALUES (N'SP0261-005-XL', N'SP0261', N'XL', N'Tím', 100)
GO
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0001-001-S', N'HDTH0012', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0001-001-S', N'HDTH0013', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0001-002-S', N'HDTH0001', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0001-002-S', N'HDTH0002', 2)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0001-003-M', N'HDTH0002', 3)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0001-004-M', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0002-002-L', N'HDTH0003', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-001-XL', N'HDTH0006', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-001-XL', N'HDTH0007', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-001-XL', N'HDTH0008', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-002-M', N'HDTH0006', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-002-M', N'HDTH0007', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-002-M', N'HDTH0008', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0003-002-M', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0004-001-XXL', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0004-001-XXL', N'HDTH0011', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0005-002-S', N'HDTH0006', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0005-002-S', N'HDTH0007', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0005-002-S', N'HDTH0008', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0005-002-S', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0006-001-XL', N'HDTH0006', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0006-001-XL', N'HDTH0007', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0006-001-XL', N'HDTH0008', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0007-001-M', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0008-001-L', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0008-001-L', N'HDTH0010', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0005', 3)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0006', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0007', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0008', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0010', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0009-001-L', N'HDTH0014', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0010-001-S', N'HDTH0005', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0010-001-S', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0010-001-S', N'HDTH0010', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0011-002-M', N'HDTH0004', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0011-005-L', N'HDTH0004', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0011-005-L', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0011-005-L', N'HDTH0010', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0012-001-XL', N'HDTH0004', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0012-001-XL', N'HDTH0009', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0012-001-XL', N'HDTH0010', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0012-005-S', N'HDTH0016', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0012-006-S', N'HDTH0004', 1)
INSERT [dbo].[ChiTietTraHang] ([maCTSP], [maHDTH], [soLuong]) VALUES (N'SP0013-001-M', N'HDTH0015', 1)
GO
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0001', CAST(N'2022-01-26' AS Date), N'KH0001', N'NV0001', 0, 1000000, 625000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0002', CAST(N'2022-02-26' AS Date), N'KH0002', N'NV0001', 81400, 2000000, 1546600)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0003', CAST(N'2022-03-26' AS Date), N'KH0003', N'NV0001', 82750, 2000000, 1572250)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0004', CAST(N'2022-05-26' AS Date), N'KH0004', N'NV0001', 0, 2000000, 2000000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0005', CAST(N'2022-07-26' AS Date), N'KH0005', N'NV0001', 0, 3000000, 2939000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0006', CAST(N'2022-08-26' AS Date), N'KH0006', N'NV0001', 96200, 2000000, 1827800)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0007', CAST(N'2022-10-26' AS Date), N'KH0007', N'NV0001', 0, 3000000, 2555000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0008', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 200000, 135000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0009', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 200000, 135000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0010', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 200000, 135000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0011', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 300000, 245000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0012', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 300000, 235000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0013', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 300000, 245000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0014', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 1000000, 905000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0015', CAST(N'2022-10-31' AS Date), N'KH0002', N'NV0003', 65750, 2000000, 1249250)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0016', CAST(N'2022-10-31' AS Date), N'KH0002', N'NV0003', 36350, 1000000, 690650)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0017', CAST(N'2022-10-31' AS Date), N'KH0010', N'NV0003', 0, 6000000, 5501000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0018', CAST(N'2022-10-31' AS Date), N'KH0003', N'NV0003', 50950, 2000000, 968050)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0019', CAST(N'2022-11-01' AS Date), N'KH0004', N'NV0003', 0, 730000, 725000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0020', CAST(N'2022-11-24' AS Date), N'KH0003', N'NV0003', 33750, 650000, 641250)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0021', CAST(N'2022-12-03' AS Date), N'KH0001', N'NV0003', 0, 400000, 362000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0022', CAST(N'2022-12-03' AS Date), N'KH0002', N'NV0003', 41750, 800000, 793250)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0023', CAST(N'2022-12-09' AS Date), N'KH0001', N'NV0003', 0, 300000, 270000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0024', CAST(N'2022-12-09' AS Date), N'KH0001', N'NV0003', 0, 150000, 135000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0025', CAST(N'2022-12-09' AS Date), N'KH0006', N'NV0003', 6750, 500000, 128250)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0026', CAST(N'2022-12-09' AS Date), N'KH0011', N'NV0003', 0, 200000, 135000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0027', CAST(N'2022-12-09' AS Date), N'KH0012', N'NV0003', 0, 800000, 795000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0028', CAST(N'2022-12-13' AS Date), N'KH0001', N'NV0003', 0, 500000, 497000)
INSERT [dbo].[HoaDonBanHang] ([maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [giamGia], [tienKhachDua], [tongTienHoaDon]) VALUES (N'HD0029', CAST(N'2022-12-14' AS Date), N'KH0001', N'NV0003', 0, 300000, 257000)
GO
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0001', N'HD0020', CAST(N'2022-11-24' AS Date), N'KH0003', N'NV0003', -128250)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0002', N'HD0020', CAST(N'2022-11-27' AS Date), N'KH0003', N'NV0003', -641250)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0003', N'HD0001', CAST(N'2022-12-03' AS Date), N'KH0001', N'NV0003', -110000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0004', N'HD0002', CAST(N'2022-12-03' AS Date), N'KH0002', N'NV0003', -1546600)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0005', N'HD0004', CAST(N'2022-12-03' AS Date), N'KH0004', N'NV0003', -2000000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0006', N'HD0003', CAST(N'2022-12-03' AS Date), N'KH0003', N'NV0003', -1572250)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0007', N'HD0003', CAST(N'2022-12-03' AS Date), N'KH0003', N'NV0003', -1572250)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0008', N'HD0003', CAST(N'2022-12-03' AS Date), N'KH0003', N'NV0003', -1572250)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0009', N'HD0005', CAST(N'2022-12-03' AS Date), N'KH0005', N'NV0003', -2889000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0010', N'HD0006', CAST(N'2022-12-03' AS Date), N'KH0006', N'NV0003', -1827800)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0011', N'HD0007', CAST(N'2022-12-09' AS Date), N'KH0007', N'NV0003', -200000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0012', N'HD0009', CAST(N'2022-12-09' AS Date), N'KH0010', N'NV0003', -135000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0013', N'HD0026', CAST(N'2022-12-09' AS Date), N'KH0011', N'NV0003', -135000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0014', N'HD0027', CAST(N'2022-12-10' AS Date), N'KH0012', N'NV0003', -500000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0015', N'HD0028', CAST(N'2022-12-13' AS Date), N'KH0001', N'NV0003', -227000)
INSERT [dbo].[HoaDonTraHang] ([maHDTH], [maHoaDon], [ngayLapHoaDon], [maKhachHang], [maNhanVien], [tongTienHoaDon]) VALUES (N'HDTH0016', N'HD0029', CAST(N'2022-12-14' AS Date), N'KH0001', N'NV0003', -257000)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0001', N'Hồng Phúc', N'0523877965', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0002', N'Lan Hương', N'0121312456', N'Thân thiết')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0003', N'Việt Nhật', N'0925741632', N'Thân thiết')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0004', N'Huỳnh Hương', N'0826146987', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0005', N'Văn An', N'0632187952', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0006', N'Ngọc Mẫn', N'0912457862', N'Thân thiết')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0007', N'Như Quỳnh', N'0632185479', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0008', N'Phan Long', N'0912457862', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0009', N'Quang Lê', N'0362156952', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0010', N'Đường Tam', N'0123456789', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0011', N'Phi Hành Gia Heo', N'0987463293', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0012', N'Ngọc Thủy Ly', N'0984735382', N'Khách thường')
INSERT [dbo].[KhachHang] ([maKhachHang], [TenKhachHang], [SDT], [loaiKhachHang]) VALUES (N'KH0013', N'Hoàng Luân', N'0957847434', N'Khách thường')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0001', N'Tổng Kho Hoàng Ngọc', N'0902928788', N'P.7, Q.8, Tp.HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0002', N'Xưởng may Xuongmay.net', N'0286684440', N'351/1/3 Lạc Long Quân,P.5,Q.11,Tp.HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0003', N'Xưởng may Ann.com.vn', N'0913268406', N'K4C Bửu Long,Q.10,Tp.HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0004', N'Xưởng may 7Store', N'0262704024', N'33/26 Gò Dầu,P.Tân Qúy,Q.Tân Phú,Tp.HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0005', N'Mandofashion.vn', N'0948541032', N'Q.Nam Từ Liêm,Tp.Hà Nội')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0006', N'Bum Shop', N'0922002119', N'85 Trần Quốc Tuấn,P.1,Q.Gò Vấp,Tp.HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0007', N'Shop khởi nghiệp', N'0972209844', N'40/23 Bàu Cát 2,P.14,Q.Tân Bình,Tp.HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [diaChi]) VALUES (N'NCC0008', N'Nhà cung Cấp 1', N'0945744543', N'Hà Nội')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0001', N'Hồ Ngọc Thủy Ly', N'0909090909', N'Q.Gò Vấp,Tp.HCM', N'Quản lí', N'1', CAST(N'2002-08-02' AS Date), CAST(N'2022-08-02' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0002', N'Võ Thành Nam', N'0909090908', N'Q.Gò Vấp,Tp.HCM', N'Quản lí', N'0', CAST(N'1995-12-17' AS Date), CAST(N'2022-08-02' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0003', N'Trần Như Ý', N'0147954125', N'Q.12,Tp.HCM', N'Nhân viên bán hàng', N'1', CAST(N'1999-11-07' AS Date), CAST(N'2022-10-12' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0004', N'Nguyễn Minh Khôi', N'0325149875', N'Q.9,Tp.HCM', N'Nhân viên bán hàng', N'0', CAST(N'2000-11-02' AS Date), CAST(N'2022-09-17' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0005', N'Lê Ngọc Hạnh', N'0936514781', N'Q.12,Tp.HCM', N'Quản lí', N'1', CAST(N'1990-04-23' AS Date), CAST(N'2022-01-12' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0006', N'Nguyễn Hồng Nhung', N'0125987452', N'Q.Phú Nhuận,Tp.HCM', N'Nhân viên bán hàng', N'1', CAST(N'1991-07-19' AS Date), CAST(N'2022-01-14' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0007', N'Lý Ngọc Ái', N'0325698741', N'Q.Gò Vấp,Tp.HCM', N'Nhân viên bán hàng', N'1', CAST(N'1995-12-28' AS Date), CAST(N'2022-01-14' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0008', N'Nguyễn Quốc Duy', N'0415789625', N'Q.Gò Vấp,Tp.HCM', N'Nhân viên bán hàng', N'0', CAST(N'1998-12-14' AS Date), CAST(N'2022-01-14' AS Date), N'Nghỉ việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0009', N'Trần Tuấn', N'0523700457', N'Gò Vấp, Tp HCM', N'Nhân viên bán hàng', N'0', CAST(N'2002-09-18' AS Date), CAST(N'2022-10-31' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0010', N'Đức Bo', N'0954834344', N'Hoàng Khương Thanh Ba Phú Thọ', N'Nhân viên bán hàng', N'1', CAST(N'2001-11-12' AS Date), CAST(N'2022-12-07' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0011', N'Ánh Tuyết', N'0000000000', N'29 Lê Lơi Gò Vấp', N'Nhân viên bán hàng', N'1', CAST(N'1985-11-12' AS Date), CAST(N'2022-12-07' AS Date), N'Đang làm')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [SDT], [diaChi], [chucVu], [gioiTinh], [ngaySinh], [ngayVaoLam], [tinhTrang]) VALUES (N'NV0012', N'Linh Lan', N'0946734332', N'29 Lê Lợi, P4, Gò Vấp', N'Nhân viên bán hàng', N'1', CAST(N'2002-11-04' AS Date), CAST(N'2022-12-10' AS Date), N'Đang làm')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0001', N'Quần Tây Âu Nam MANDO', 135000, N'image/quantay1.jpg', N'Trơn,Khóa kéo,Kiểu dáng Slim Fit', N'Nam', N'Hàn Quốc', N'Quần', N'', 2, N'CL0009', N'TH0014', N'XX0010', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0002', N'Áo thun Unisex N7 Basic Tee', 110000, N'image/Ao1.jpg', N'', N'Uni', N'Cơ bản', N'Áo', N'Cổ tròn', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0002', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0003', N'Áo Khoác Adidas BB', 160000, N'image/ao thun 1.png', N'', N'Nam', N'', N'Áo', N'', 3, N'CL0001', N'TH0011', N'XX0006', N'NCC0003', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0004', N'Dầm sơ mi nhún thân ', 200000, N'image/ao thun 1.png', N'', N'Nữ', N'Công sở', N'Áo', N'Cổ đức', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0004', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0005', N'Áo Sơ Mi Lacoste Men', 235000, N'image/aosomi1.jpg', N'Thiết kế kiểu dáng trẻ trung,hiện đại;được làm từ chất liệu cao cấp,bền đẹp', N'Nam', N'Trẻ trung', N'Áo', N'', 1, N'CL0001', N'TH0009', N'XX0009', N'NCC0005', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0006', N'Áo Hoodie Dsquared2 Be Icon', 600000, N'image/aohoodie1.jpg', N'', N'Nam', N'Nam tính', N'Áo', N'', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0006', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0007', N'Áo Polo Kenzo Men Logo Classic', 300000, N'image/AoThunNganHa.jpg', N'', N'Nam', N'Năng động', N'Áo', N'C? b?', 4, N'CL0001', N'TH0012', N'XX0008', N'NCC0007', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0008', N'Áo Polo Gucci Blue Polo', 110000, N'image/aopolo2.jpg', N'', N'Nam', N'Năng động', N'Áo', N'C? b?', 3, N'CL0001', N'TH0004', N'XX0003', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0009', N'Váy suông vạt xéo Am Young', 500000, N'image/vay1.jpg', N'', N'Nữ', N'Hàn Quốc', N'Váy', N'', 0, N'CL0010', N'TH0015', N'XX0003', N'NCC0002', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0010', N'Kính Mát Gucci Square', 500000, N'image/kinh.jpg', N'chống mờ,chống chói,bảo vệ mắt khỏi tia UV', N'Nữ', N'Hiện đại', N'Kính', N'', 1, N'CL0011', N'TH0004', N'XX0003', N'NCC0003', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0011', N'Áo Khoác Hoodie Zipper', 557000, NULL, N'', N'Uni', N'', N'Áo', N'', 0, N'CL0012', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0012', N'Áo Thun Cổ Trụ', 257000, N'image/AoThunCoTru.jpg', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0013', N'TH0016', N'XX0001', N'NCC0001', N'Ngừng bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0013', N'Áo Thun Cổ Tròn Y', 227000, N'image/AoCottonCompact.jpg', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0014', N'Áo Thun Cổ Tròn Ngân Hà Space', 199000, N'image/AoThunNganHa.jpg', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0016', N'XX0001', N'NCC0004', N'Ngừng bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0026', N'Quần Tây Âu Nam MANDO', 135000, N'', N'', N'Nam', N'', N'Quần', N'', 0, N'CL0009', N'TH0014', N'XX0010', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0038', N'Áo thun Unisex N7 Basic Tee', 110000, N'', N'', N'Uni', N'', N'Áo thun', N'', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0050', N'Áo Khoác Adidas BB', 160000, N'', N'', N'Nam', N'', N'Áo khoác', N'', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0062', N'Đầm sơ mi nhún thân', 135000, N'', N'', N'Nữ', N'', N'Đầm', N'', 0, N'CL0007', N'TH0001', N'XX0001', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0074', N'Áo Sơ Mi Lacoste Men', 235000, N'', N'', N'Nam', N'', N'Áo sơ mi', N'', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0082', N'Quần Tây Âu Nam MANDO', 135000, N'', N'', N'Nam', N'', N'Quần', N'', 0, N'CL0009', N'TH0014', N'XX0010', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0086', N'Áo Hoodie Dsquared2 Be Icon', 600000, N'', N'', N'Nam', N'', N'Áo hoodie', N'', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0094', N'Áo thun Unisex N7 Basic Tee', 110000, N'', N'', N'Uni', N'', N'Áo thun', N'', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0098', N'Áo Polo Kenzo Men Logo Classic', 350000, N'', N'', N'Nam', N'', N'Áo polo', N'', 0, N'CL0001', N'TH0012', N'XX0002', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0106', N'Áo Khoác Adidas BB', 160000, N'', N'', N'Nam', N'', N'Áo khoác', N'', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0110', N'Áo Polo Gucci Blue Polo', 110000, N'', N'', N'Nam', N'', N'Áo polo', N'', 0, N'CL0001', N'TH0004', N'XX0003', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0118', N'Đầm sơ mi nhún thân', 135000, N'', N'', N'Nữ', N'', N'Đầm', N'', 0, N'CL0007', N'TH0001', N'XX0001', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0122', N'Váy suông vạt xéo Am Young', 500000, N'', N'', N'Nữ', N'', N'Váy', N'', 0, N'CL0010', N'TH0015', N'XX0003', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0130', N'Áo Sơ Mi Lacoste Men', 235000, N'', N'', N'Nam', N'', N'Áo sơ mi', N'', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0134', N'Kính Mát Gucci Square', 500000, N'', N'', N'Nữ', N'', N'Kính', N'', 0, N'CL0011', N'TH0004', N'XX0003', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0142', N'Áo Hoodie Dsquared2 Be Icon', 600000, N'', N'', N'Nam', N'', N'Áo hoodie', N'', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0146', N'Áo Khoác Hoodie Zipper', 557000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0012', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0154', N'Áo Polo Kenzo Men Logo Classic', 350000, N'', N'', N'Nam', N'', N'Áo polo', N'', 0, N'CL0001', N'TH0012', N'XX0002', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0158', N'Áo Thun Cổ Trụ', 257000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0013', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0166', N'Áo Polo Gucci Blue Polo', 110000, N'', N'', N'Nam', N'', N'Áo polo', N'', 0, N'CL0001', N'TH0004', N'XX0003', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0170', N'Áo Thun Cổ Tròn Y', 227000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0178', N'Váy suông vạt xéo Am Young', 500000, N'', N'', N'Nữ', N'', N'Váy', N'', 0, N'CL0010', N'TH0015', N'XX0003', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0182', N'Áo Thun Cổ Tròn Y', 227000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0190', N'Kính Mát Gucci Square', 500000, N'', N'', N'Nữ', N'', N'Kính', N'', 0, N'CL0011', N'TH0004', N'XX0003', N'NCC0001', N'1')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0202', N'Áo Khoác Hoodie Zipper', 557000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0012', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0214', N'Áo Thun Cổ Trụ', 257000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0013', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0226', N'Áo Thun Cổ Tròn Y', 227000, N'', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0227', N'Áo Thun Testy ', 423423, N'image/300x300.jpg', N'', N'Nam', N'', N'Áo', N'', 0, N'CL0014', N'TH0017', N'XX0011', N'NCC0004', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0228', N'Ten 8578923452', 600000, N'image/300x300.jpg', N'', N'Nam', N'', N'Áo', N'', 0, N'CL0001', N'TH0001', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0229', N'Áo Thun màu xám', 4000000, N'image/AoThunNganHa.jpg', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0016', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0230', N'Áo khoác xanh lam', 200000, N'image/300x300.jpg', N'', N'Uni', N'', N'Áo', N'', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0231', N'?o thun Unisex N7 Basic Tee', 110000, N'', N'', N'Uni', N'', N'?o', N'', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'C?n b?n')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0232', N'Áo thun Unisex N7 Basic Tee', 110000, N' ', N' ', N'Uni', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0233', N'Áo Khoác Adidas BB', 160000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0234', N'Dầm sơ mi nhún thân', 200000, N' ', N' ', N'Nữ', N' ', N'Áo', N' ', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0235', N'Áo Sơ Mi Lacoste Men', 235000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0236', N'Áo Hoodie Dsquared2 Be Icon', 600000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0237', N'Áo thun Unisex N7 Basic Tee', 110000, N' ', N' ', N'Uni', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0238', N'Áo Khoác Adidas BB', 160000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0239', N'Dầm sơ mi nhún thân', 200000, N' ', N' ', N'Nữ', N' ', N'Áo', N' ', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0240', N'Áo Sơ Mi Lacoste Men', 235000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0241', N'Áo Hoodie Dsquared2 Be Icon', 600000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0242', N'Áo thun Unisex N7 Basic Tee', 110000, N' ', N' ', N'Uni', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0243', N'Áo Khoác Adidas BB', 160000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0244', N'Dầm sơ mi nhún thân', 200000, N' ', N' ', N'Nữ', N' ', N'Áo', N' ', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0245', N'Áo Sơ Mi Lacoste Men', 235000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0246', N'Áo Hoodie Dsquared2 Be Icon', 600000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0247', N'Áo thun Unisex N7 Basic Tee', 110000, N' ', N' ', N'Uni', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0248', N'Áo Khoác Adidas BB', 160000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0249', N'Dầm sơ mi nhún thân', 200000, N' ', N' ', N'Nữ', N' ', N'Áo', N' ', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0250', N'Áo Sơ Mi Lacoste Men', 235000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0251', N'Áo Hoodie Dsquared2 Be Icon', 600000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0252', N'Áo thun Unisex N7 Basic Tee', 110000, N' ', N' ', N'Uni', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0253', N'Áo Khoác Adidas BB', 160000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0254', N'Dầm sơ mi nhún thân', 200000, N' ', N' ', N'Nữ', N' ', N'Áo', N' ', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0255', N'Áo Sơ Mi Lacoste Men', 235000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0256', N'Áo Hoodie Dsquared2 Be Icon', 600000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0257', N'Áo thun Unisex N7 Basic Tee', 110000, N' ', N' ', N'Uni', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0258', N'Áo Khoác Adidas BB', 160000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0011', N'XX0006', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0259', N'Dầm sơ mi nhún thân', 200000, N' ', N' ', N'Nữ', N' ', N'Áo', N' ', 0, N'CL0013', N'TH0007', N'XX0001', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0260', N'Áo Sơ Mi Lacoste Men', 235000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0009', N'XX0009', N'NCC0001', N'Còn bán')
INSERT [dbo].[SanPham] ([maSanPham], [tenSP], [giaGoc], [hinhAnh], [moTa], [gioiTinh], [phongCach], [loai], [coAo], [soLuongLoi], [maCL], [maTH], [maXX], [maNCC], [tinhTrang]) VALUES (N'SP0261', N'Áo Hoodie Dsquared2 Be Icon', 600000, N' ', N' ', N'Nam', N' ', N'Áo', N' ', 0, N'CL0001', N'TH0010', N'XX0010', N'NCC0001', N'Còn bán')
GO
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0001', N'123456', N'foxfessor@gmail.com', N'NV0001')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0002', N'123456', N'taejoon1507@gmail.com', N'NV0002')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0003', N'123456', N'vietnhat0351@gmail.com', N'NV0003')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0004', N'123456', N'huynhhuong205k@gmail.com', N'NV0004')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0005', N'123456', N'huynhhuong205k@gmail.com', N'NV0005')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0006', N'123456', N'huynhhuong205k@gmail.com', N'NV0006')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0007', N'123456', N'huynhhuong205k@gmail.com', N'NV0007')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0008', N'123456', N'huynhhuong205k@gmail.com', N'NV0008')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0009', N'123456PW', N'tranTuan@gmail.comm ', N'NV0009')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0010', N'123456', N'ducbo@gmail.com', N'NV0010')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0011', N'123456', N'anhtuyet@gmail.com', N'NV0011')
INSERT [dbo].[TaiKhoan] ([id], [matKhau], [email], [maNhanVien]) VALUES (N'NV0012', N'123456', N'linhlan@gmail.com', N'NV0012')
GO
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0001', N'IVY MODA', N'Đây là một trong những thương hiệu chất lượng tốt được những quý cô yêu thích.')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0002', N'CHANEL', N'Một nhãn hiệu thời trang cao cấp đáng tự hào nhất của ngành công nghiệp thời trang nước Pháp.')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0003', N'Septwolves', N'Với sự bền bỉ,dẻo dai và mạnh mẽ mang đến cho người dùng những sản phẩm chất lượng.')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0004', N'GUCCI', N' Là  biểu tượng thời trang của nước Ý và một nhãn hiệu đồ da nổi tiếng.')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0005', N'Lane Crawford', N'Một trong những thương hiệu thời trang nội địa được bán chạy nhất tại Trung Quốc')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0006', N'Hermes', N'Nhiều thiết kế quần áo may mặc tiện dụng, phụ kiện phong cách và những dòng nước hoa đắt tiền')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0007', N'Valentino', N'Valentino khẳng định vị thế của mình trong BXH thời trang xa xỉ quan trọng nhất thế giới hiện đại')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0008', N'NEM fashion', N'thương hiệu thời trang nữ cao cấp được chị em yêu thích vì thiết kế thanh lịch, quyến rũ và tinh tế')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0009', N'Lacoste', N'Hãng thời trang thể thao nối tiếng toàn cầu mang nét cổ điển của Pháp và tinh thần hiện đại của Mỹ')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0010', N'DSquared2', N'thương hiệu thời trang nổi tiếng bậc nhất nước Ý với các sản phẩm thời trang cao cấp')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0011', N'Adidas', N'Adidas là cái tên quen thuộc trong làng thời trang luôn gắn liền với biểu tượng ba sọc huyền thoại')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0012', N'Kenzo', N' một hãng thời trang cao cấp của Pháp,thành lập năm 1970')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0013', N'C&A ', N' Sản phẩm của C&A khá đa dạng, hướng đến các đối tượng  khác nhau')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0014', N'MANDO', N'MANDO là thương hiệu thời trang nam dành cho giới trẻ theo phong cách Hàn Quốc')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0015', N'Am Young', N' thương hiệu nữ lấy cảm hứng từ thiết kế đầy phong cách của Hàn-kinh đô thời trang châu Á')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0016', N'Y-ORIGINAL', N' ')
INSERT [dbo].[ThuongHieu] ([maTH], [tenTH], [moTa]) VALUES (N'TH0017', N'Thuong hieu moi', N' ')
GO
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0001', N'Việt Nam', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0002', N'Pháp', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0003', N'Ý', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0004', N'Trung Quốc', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0005', N'Tây Ban Nha', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0006', N'Đức', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0007', N'Ấn Độ', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0008', N'Thổ Nhĩ Kỳ', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0009', N'Mỹ', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0010', N'Hàn Quốc', N'')
INSERT [dbo].[XuatXu] ([maXX], [tenXX], [moTa]) VALUES (N'XX0011', N'Xuat xu moi', N' ')
GO
ALTER TABLE [dbo].[CaLam]  WITH CHECK ADD  CONSTRAINT [CL_NV] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[CaLam] CHECK CONSTRAINT [CL_NV]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_ChiTietSanPham] FOREIGN KEY([maCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([maCTSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_ChiTietSanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDonBanHang] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDonBanHang] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDonBanHang]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham]
GO
ALTER TABLE [dbo].[ChiTietTraHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTraHang_ChiTietSanPham] FOREIGN KEY([maCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([maCTSP])
GO
ALTER TABLE [dbo].[ChiTietTraHang] CHECK CONSTRAINT [FK_ChiTietTraHang_ChiTietSanPham]
GO
ALTER TABLE [dbo].[ChiTietTraHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTraHang_HoaDonTraHang] FOREIGN KEY([maHDTH])
REFERENCES [dbo].[HoaDonTraHang] ([maHDTH])
GO
ALTER TABLE [dbo].[ChiTietTraHang] CHECK CONSTRAINT [FK_ChiTietTraHang_HoaDonTraHang]
GO
ALTER TABLE [dbo].[HoaDonBanHang]  WITH CHECK ADD  CONSTRAINT [HDBH_KH] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDonBanHang] CHECK CONSTRAINT [HDBH_KH]
GO
ALTER TABLE [dbo].[HoaDonBanHang]  WITH CHECK ADD  CONSTRAINT [HDBH_NV] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDonBanHang] CHECK CONSTRAINT [HDBH_NV]
GO
ALTER TABLE [dbo].[HoaDonTraHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonTraHang_HoaDonBanHang] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDonBanHang] ([maHoaDon])
GO
ALTER TABLE [dbo].[HoaDonTraHang] CHECK CONSTRAINT [FK_HoaDonTraHang_HoaDonBanHang]
GO
ALTER TABLE [dbo].[HoaDonTraHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonTraHang_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDonTraHang] CHECK CONSTRAINT [FK_HoaDonTraHang_KhachHang]
GO
ALTER TABLE [dbo].[HoaDonTraHang]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonTraHang_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDonTraHang] CHECK CONSTRAINT [FK_HoaDonTraHang_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CL_SP] FOREIGN KEY([maCL])
REFERENCES [dbo].[ChatLieu] ([maCL])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CL_SP]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [TH_SP] FOREIGN KEY([maTH])
REFERENCES [dbo].[ThuongHieu] ([maTH])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [TH_SP]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [XX_SP] FOREIGN KEY([maXX])
REFERENCES [dbo].[XuatXu] ([maXX])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [XX_SP]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [ck_CTDH] CHECK  (([soLuongLoi]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [ck_CTDH]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [ck_SP2] CHECK  (([giaGoc]>(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [ck_SP2]
GO
USE [master]
GO
ALTER DATABASE [CuaHangQuanAo] SET  READ_WRITE 
GO
