-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 10, 2024 lúc 04:17 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cuahangnuochoa`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctkhuyenmaitheohd`
--

CREATE TABLE `ctkhuyenmaitheohd` (
  `MaKM` int(5) NOT NULL,
  `CTKM` varchar(40) NOT NULL,
  `TgBatDau` date NOT NULL,
  `TgKetThuc` date NOT NULL,
  `PhanTramGiam` int(3) NOT NULL,
  `nvTao` varchar(20) NOT NULL,
  `ĐKHD` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctkhuyenmaitheohd`
--

INSERT INTO `ctkhuyenmaitheohd` (`MaKM`, `CTKM`, `TgBatDau`, `TgKetThuc`, `PhanTramGiam`, `nvTao`, `ĐKHD`) VALUES
(2, 'lễ 20/10', '2024-10-03', '2024-10-19', 15, 'Đỗ Anh Đài', 100000),
(6, 'aabbb', '2024-10-16', '2024-10-17', 90, 'Đỗ Anh Đài', 2000),
(10, 'hihi', '2024-10-20', '2024-10-21', 15, 'Đỗ Anh Đài', 100000),
(11, 'haha', '2024-10-25', '2024-10-27', 14, 'Đỗ Anh Đài', 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctkhuyenmaitheosp`
--

CREATE TABLE `ctkhuyenmaitheosp` (
  `MaKM` int(5) NOT NULL,
  `MaSP` int(5) NOT NULL,
  `TgBatDau` date NOT NULL,
  `TgKetThuc` date NOT NULL,
  `PhanTramGiam` int(3) NOT NULL,
  `nvTao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctkhuyenmaitheosp`
--

INSERT INTO `ctkhuyenmaitheosp` (`MaKM`, `MaSP`, `TgBatDau`, `TgKetThuc`, `PhanTramGiam`, `nvTao`) VALUES
(3, 1, '2024-10-02', '2024-10-05', 12, 'Đỗ Anh Đài'),
(4, 1, '2024-10-11', '2024-10-15', 10, 'Đỗ Anh Đài'),
(4, 2, '2024-10-11', '2024-10-15', 25, 'Đỗ Anh Đài'),
(5, 1, '2024-10-15', '2024-10-19', 15, 'Đỗ Anh Đài'),
(5, 2, '2024-10-15', '2024-10-19', 20, 'Đỗ Anh Đài'),
(7, 4, '2024-10-16', '2024-10-17', 10, 'Đỗ Anh Đài'),
(7, 3, '2024-10-16', '2024-10-17', 25, 'Đỗ Anh Đài'),
(8, 4, '2024-10-16', '2024-10-17', 10, 'Đỗ Anh Đài'),
(8, 3, '2024-10-16', '2024-10-17', 25, 'Đỗ Anh Đài'),
(9, 4, '2024-10-16', '2024-10-17', 100, 'Đỗ Anh Đài'),
(9, 3, '2024-10-16', '2024-10-17', 100, 'Đỗ Anh Đài'),
(15, 1, '2024-10-23', '2024-10-26', 10, 'Đỗ Anh Đài');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `masp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gianhap` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`maphieunhap`, `masp`, `soluong`, `gianhap`) VALUES
(31, 10, 3, 4000),
(31, 1, 12, 2000),
(32, 10, 4, 5000),
(33, 10, 2, 4000),
(33, 1, 3, 30000),
(34, 3, 2, 300),
(35, 4, 3, 400),
(36, 3, 52, 500),
(37, 10, 3, 3000),
(38, 10, 5, 4000),
(39, 8, 2, 2),
(39, 7, 2, 2),
(40, 10, 2, 4700),
(41, 5, 3, 5000),
(42, 5, 5, 58898),
(43, 11, 5, 100),
(44, 11, 3, 200),
(45, 6, 3, 2000),
(45, 8, 3, 1000),
(46, 6, 5, 1000),
(47, 7, 22, 1000),
(47, 5, 23, 15466),
(47, 9, 4, 2466436),
(47, 8, 23, 23525);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieutra`
--

CREATE TABLE `ctphieutra` (
  `maphieutra` int(11) NOT NULL,
  `masp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieutra`
--

INSERT INTO `ctphieutra` (`maphieutra`, `masp`, `soluong`, `dongia`) VALUES
(1, 5, 5, 58898),
(2, 6, 5, 1000),
(3, 5, 23, 15466);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `masp` int(11) NOT NULL DEFAULT 0,
  `soluong` int(11) NOT NULL DEFAULT 0,
  `dongia` bigint(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieuxuat`
--

INSERT INTO `ctphieuxuat` (`maphieuxuat`, `masp`, `soluong`, `dongia`) VALUES
(33, 10, 3, 4800),
(34, 10, 2, 4800),
(34, 1, 4, 2080),
(35, 3, 2, 306),
(36, 8, 2, 2),
(37, 10, 3, 3150),
(38, 10, 6, 4160),
(40, 5, 2, 5200),
(41, 5, 2, 5200),
(42, 1, 1, 5200),
(43, 11, 2, 120),
(44, 6, 8, 2400);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctquyen`
--

CREATE TABLE `ctquyen` (
  `manhomquyen` int(11) NOT NULL,
  `machucnang` int(11) NOT NULL,
  `hanhdong` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctquyen`
--

INSERT INTO `ctquyen` (`manhomquyen`, `machucnang`, `hanhdong`) VALUES
(1, 1, 'add'),
(1, 1, 'delete'),
(1, 1, 'edit'),
(1, 1, 'view'),
(1, 2, 'add'),
(1, 2, 'view'),
(1, 3, 'add'),
(1, 3, 'delete'),
(1, 3, 'view'),
(1, 4, 'add'),
(1, 4, 'delete'),
(1, 4, 'edit'),
(1, 4, 'view'),
(1, 5, 'add'),
(1, 5, 'delete'),
(1, 5, 'edit'),
(1, 5, 'view'),
(1, 6, 'add'),
(1, 6, 'delete'),
(1, 6, 'edit'),
(1, 6, 'view'),
(1, 7, 'add'),
(1, 7, 'delete'),
(1, 7, 'edit'),
(1, 7, 'view'),
(1, 8, 'add'),
(1, 8, 'delete'),
(1, 8, 'edit'),
(1, 8, 'view'),
(1, 9, 'add'),
(1, 9, 'delete'),
(1, 9, 'edit'),
(1, 9, 'view'),
(1, 10, 'add'),
(1, 10, 'delete'),
(1, 10, 'edit'),
(1, 10, 'view'),
(1, 11, 'add'),
(1, 11, 'delete'),
(1, 11, 'edit'),
(1, 11, 'view'),
(1, 11, 'add'),
(1, 11, 'delete'),
(1, 11, 'edit'),
(1, 11, 'view'),
(1, 12, 'add'),
(1, 12, 'delete'),
(1, 12, 'edit'),
(1, 12, 'view'),
(1, 13, 'add'),
(1, 13, 'delete'),
(1, 13, 'edit'),
(1, 13, 'view'),
(2, 1, 'view'),
(2, 1, 'add'),
(2, 2, 'view'),
(2, 2, 'add'),
(2, 3, 'view'),
(2, 3, 'add'),
(2, 4, 'view'),
(2, 4, 'add'),
(2, 5, 'view'),
(2, 5, 'add'),
(2, 7, 'view'),
(2, 7, 'add'),
(2, 8, 'view'),
(2, 8, 'edit'),
(2, 10, 'view'),
(2, 10, 'add'),
(2, 10, 'edit'),
(2, 10, 'delete'),
(2, 12, 'view'),
(2, 12, 'add'),
(2, 12, 'edit'),
(2, 12, 'delete'),
(3, 2, 'view'),
(3, 7, 'view'),
(3, 13, 'view'),
(3, 13, 'add'),
(3, 13, 'edit'),
(3, 13, 'delete'),
(4, 1, 'view'),
(4, 1, 'add'),
(4, 1, 'edit'),
(4, 1, 'delete'),
(4, 2, 'view'),
(4, 2, 'add'),
(4, 2, 'edit'),
(4, 2, 'delete'),
(4, 3, 'view'),
(4, 3, 'add'),
(4, 3, 'edit'),
(4, 3, 'delete'),
(4, 4, 'view'),
(4, 4, 'add'),
(4, 4, 'edit'),
(4, 4, 'delete'),
(4, 5, 'view'),
(4, 5, 'add'),
(4, 5, 'edit'),
(4, 5, 'delete'),
(4, 6, 'view'),
(4, 6, 'add'),
(4, 6, 'edit'),
(4, 6, 'delete'),
(4, 7, 'view'),
(4, 7, 'add'),
(4, 7, 'edit'),
(4, 7, 'delete'),
(4, 8, 'view'),
(4, 8, 'add'),
(4, 8, 'edit'),
(4, 8, 'delete'),
(4, 9, 'view'),
(4, 9, 'add'),
(4, 9, 'edit'),
(4, 9, 'delete'),
(4, 10, 'view'),
(4, 10, 'add'),
(4, 10, 'edit'),
(4, 10, 'delete'),
(4, 11, 'view'),
(4, 11, 'add'),
(4, 11, 'edit'),
(4, 11, 'delete'),
(4, 12, 'view'),
(4, 12, 'add'),
(4, 12, 'edit'),
(4, 12, 'delete'),
(4, 13, 'view'),
(4, 13, 'add'),
(4, 13, 'edit'),
(4, 13, 'delete');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucchucnang`
--

CREATE TABLE `danhmucchucnang` (
  `machucnang` int(10) NOT NULL,
  `tenchucnang` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmucchucnang`
--

INSERT INTO `danhmucchucnang` (`machucnang`, `tenchucnang`, `trangthai`) VALUES
(1, 'Quản lý khách hàng', 1),
(2, 'Quản lý khu vực kho', 1),
(3, 'Quản lý nhà cung cấp', 1),
(4, 'Quản lý nhân viên', 1),
(5, 'Quản lý nhập hàng', 1),
(6, 'Quản lý nhóm quyền', 1),
(7, 'Quản lý sản phẩm', 1),
(8, 'Quản lý tài khoản', 1),
(9, 'Quản lý thống kê', 1),
(10, 'Quản lý thuộc tính', 1),
(11, 'Quản lý khuyến mãi', 1),
(12, 'Quản lý trả hàng', 1),
(13, 'Quản lý phiếu xuất', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giamgia`
--

CREATE TABLE `giamgia` (
  `magiamgia` int(11) NOT NULL,
  `tenctgiamgia` varchar(50) NOT NULL,
  `mocgiamgia` int(11) NOT NULL,
  `sotienduocgiam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giamgia`
--

INSERT INTO `giamgia` (`magiamgia`, `tenctgiamgia`, `mocgiamgia`, `sotienduocgiam`) VALUES
(1, 'mua 2 tang 1', 200000, 20000),
(2, 'Sự kiện mua sắm lớn', 500000, 20000),
(3, 'Giảm giá đặc biệt', 1000000, 100000),
(4, 'Mùa hè rực rỡ', 2000000, 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `tenkhachhang` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `ngaythamgia` date NOT NULL DEFAULT current_timestamp(),
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkhachhang`, `diachi`, `gioitinh`, `sdt`, `ngaythamgia`, `trangthai`) VALUES
(1, 'Nguyễn Văn A', 'Gia Đức, Ân Đức, Hoài Ân, Bình Định', 'Nam', '0387913347', '2023-04-19', 1),
(2, 'Trần Nhất Nhất', '205 Trần Hưng Đạo, Phường 10, Quận 5, Thành phố Hồ Chí Minh', 'Nam', '0123456789', '2023-04-19', 1),
(3, 'Hoàng Gia Bo', 'Khoa Trường, Hoài Ân, Bình Định', 'Nam', '0987654321', '2023-04-19', 1),
(4, 'Hồ Minh Hưng', 'Khoa Trường, Hoài Ân, Bình Định', 'Nam', '0867987456', '2023-04-19', 1),
(5, 'dsgsdg', 'dfhdh', 'Nam', '0123456789', '2024-10-04', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuvuckho`
--

CREATE TABLE `khuvuckho` (
  `makhuvuc` int(11) NOT NULL,
  `tenkhuvuc` varchar(255) NOT NULL,
  `ghichu` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khuvuckho`
--

INSERT INTO `khuvuckho` (`makhuvuc`, `tenkhuvuc`, `ghichu`, `trangthai`) VALUES
(1, 'Khu vực A', 'hdhg', 1),
(2, 'Khu vực B', 'bánh kẹo', 1),
(3, 'Khu vực C', 'đồ ăn', 1),
(4, 'Khu vực D', 'đồ dùng học tập', 1),
(5, 'Khu vực E', 'nước ngọt', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` int(5) NOT NULL,
  `LoaiKM` varchar(15) NOT NULL,
  `TgBatDau` date NOT NULL,
  `TgKetThuc` date NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `LoaiKM`, `TgBatDau`, `TgKetThuc`, `TrangThai`) VALUES
(2, 'Theo hóa đơn', '2024-10-03', '2024-10-19', 1),
(3, 'Theo sản phẩm', '2024-10-02', '2024-10-05', 0),
(4, 'Theo sản phẩm', '2024-10-11', '2024-10-15', 1),
(5, 'Theo sản phẩm', '2024-10-15', '2024-10-19', 1),
(6, 'Theo hóa đơn', '2024-10-16', '2024-10-17', 0),
(7, 'Theo sản phẩm', '2024-10-16', '2024-10-17', 0),
(8, 'Theo sản phẩm', '2024-10-16', '2024-10-17', 0),
(9, 'Theo sản phẩm', '2024-10-16', '2024-10-17', 0),
(10, 'Theo hóa đơn', '2024-10-20', '2024-10-21', 1),
(11, 'Theo hóa đơn', '2024-10-25', '2024-10-27', 1),
(14, 'Theo sản phẩm', '2024-10-17', '2024-10-19', 1),
(15, 'Theo sản phẩm', '2024-10-23', '2024-10-26', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `maloai` int(11) NOT NULL,
  `tenloai` varchar(255) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`maloai`, `tenloai`, `trangthai`) VALUES
(1, 'Food', 1),
(2, 'Nước uống', 1),
(3, 'Rau củ quả', 1),
(4, 'Đồ dùng cá nhân', 1),
(5, 'Dụng cụ học tập', 1),
(6, 'Nước hoa', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `losanpham`
--

CREATE TABLE `losanpham` (
  `malosanpham` int(11) NOT NULL,
  `maphieunhap` int(11) NOT NULL,
  `masp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gianhap` int(11) NOT NULL,
  `giaban` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `losanpham`
--

INSERT INTO `losanpham` (`malosanpham`, `maphieunhap`, `masp`, `soluong`, `gianhap`, `giaban`) VALUES
(10, 25, 7, 5, 4000, 4200),
(11, 26, 1, 2, 5000, 5200),
(13, 28, 3, 2, 300, 315),
(14, 29, 3, 3, 400, 440),
(15, 30, 2, 4, 25000, 26250),
(16, 31, 4, 9896, 100000, 130000),
(22, 35, 4, 3, 400, 428),
(23, 36, 3, 52, 500, 525),
(28, 40, 10, 1, 4700, 4888),
(29, 41, 5, 0, 5000, 5200),
(31, 43, 11, 3, 100, 120),
(32, 44, 11, 3, 200, 220),
(34, 45, 8, 0, 1000, 1020),
(36, 47, 7, 22, 1000, 1040);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` int(11) NOT NULL,
  `tenncc` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`mancc`, `tenncc`, `diachi`, `email`, `sdt`, `trangthai`) VALUES
(1, 'Công Ty TNHH rau', ' Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', 'lienhe@gmail.com', '0383512345', 1),
(2, 'Công ty bánh kẹo Việt Nam', 'Số 79 đường số 6, Hưng Phước 4, Phú Mỹ Hưng, quận 7, TPHCM', 'contact@paviet.vn', '19009477', 1),
(3, 'Công Ty TNHH đồ ăn nhanh', '8/38 Đinh Bô Lĩnh, P.24, Q. Bình Thạnh, Tp. Hồ Chí Minh', 'contact@baola.vn', '02835119060', 1),
(4, 'Công Ty nguyễn long ', 'Phòng 703, Tầng7, Tòa Nhà Metropolitan, 235 Đồng Khởi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM)', 'chau.nguyen@nokia.com', '02838236894', 1),
(5, 'Hệ Thống Phân Phối nước ngọt', '261 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', 'info@mihome.vn', '0365888866', 1),
(6, 'Công Ty atech Việt Nam', 'Tòa nhà tài chính Bitexco, 2 Hải Triều, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'contact@samsung.vn', '0988788456', 1),
(7, 'Công ty suzuki Việt Nam', '27 Đ. Nguyễn Trung Trực, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'oppovietnam@oppo.vn', '0456345234', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` varchar(10) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `gioitinh` varchar(11) NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `gioitinh`, `ngaysinh`, `sdt`, `email`, `trangthai`) VALUES
('31220001', 'Đỗ Anh Đài', 'Nam', '2003-12-20', '0387913347', 'doanhdaigr5.2004@gmail.com', 1),
('31220002', 'Vũ Em', 'Nam', '2023-04-11', '0355374322', 'aaaa@gmail.com', 1),
('31220003', 'Đỗ Nam Công Chính', 'Nữ', '2003-04-11', '0123456789', 'bbbbb@gmail.com', 1),
('31220004', 'Đinh Ngọc Ân', 'Nam', '2003-04-03', '0123456789', 'ccccc@gmail.com', 1),
('31220005', 'Vũ Trung Hiếu', 'Nam', '2023-05-06', '0123456789', 'ddddd@gmail.com', 1),
('31220009', 'Bùi Bảo Long', 'Nam', '2024-09-18', '0789654321', 'aa@gmail.com', 1),
('31220010', 'Đỗ Anh Đài', 'Nam', '2003-12-20', '0387913347', 'doanhdaigr5.2004@gmail.com', 1),
('31220011', 'Vũ Em', 'Nam', '2023-04-11', '0355374322', 'aaaa@gmail.com', 1),
('31220012', 'Đỗ Nam Công Chính', 'Nam', '2003-04-11', '0123456789', 'bbbbb@gmail.com', 1),
('31220013', 'Đinh Ngọc Ân', 'Nam', '2003-04-03', '0123456789', 'ccccc@gmail.com', 1),
('31220014', 'Vũ Trung Hiếu', 'Nam', '2023-05-06', '0123456789', 'ddddd@gmail.com', 1),
('31220015', 'Bùi Bảo Long', 'Nam', '2024-09-18', '0789654321', 'aa@gmail.com', 1);

--
-- Bẫy `nhanvien`
--
DELIMITER $$
CREATE TRIGGER `new_ma_nhanvien` BEFORE INSERT ON `nhanvien` FOR EACH ROW BEGIN
  DECLARE max_manv INT;
  
  -- Lấy mã nhân viên cao nhất hiện có
  SELECT MAX(CAST(SUBSTRING(manv, 5) AS UNSIGNED)) INTO max_manv FROM nhanvien;
  
  -- Gán mã mới cho manv
  IF max_manv IS NULL THEN
    SET max_manv = 1;
  ELSE
    SET max_manv = max_manv + 1;
  END IF;
  
  SET NEW.manv = CONCAT('3122', LPAD(max_manv, 4, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `manhomquyen` int(11) NOT NULL,
  `tennhomquyen` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhomquyen`
--

INSERT INTO `nhomquyen` (`manhomquyen`, `tennhomquyen`, `trangthai`) VALUES
(1, 'admin', 1),
(2, 'Nhân viên nhập hàng', 1),
(3, 'Nhân viên xuất hàng', 1),
(4, 'Quản lý', 1),
(5, 'Nhân viên mới', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `mancc` int(11) NOT NULL,
  `makhuvuc` int(11) NOT NULL,
  `manv` varchar(10) DEFAULT NULL,
  `thoigian` datetime DEFAULT current_timestamp(),
  `tongtien` bigint(20) NOT NULL DEFAULT 0,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maphieunhap`, `mancc`, `makhuvuc`, `manv`, `thoigian`, `tongtien`, `trangthai`) VALUES
(31, 1, 1, '31220001', '2024-09-22 00:00:00', 36000, 1),
(32, 1, 1, '31220001', '2024-09-23 00:00:00', 20000, 1),
(33, 1, 1, '31220001', '2024-09-24 00:00:00', 98000, 1),
(34, 1, 2, '31220001', '2024-09-25 00:00:00', 600, 0),
(35, 1, 2, '31220001', '2024-09-26 00:00:00', 1200, 1),
(36, 1, 2, '31220001', '2024-09-26 00:00:00', 26000, 1),
(37, 1, 1, '31220001', '2024-09-27 00:00:00', 9000, 1),
(38, 1, 1, '31220001', '2024-09-27 00:00:00', 20000, 1),
(39, 1, 1, '31220001', '2024-09-27 00:00:00', 8, 1),
(40, 1, 1, '31220001', '2024-09-27 00:00:00', 9400, 1),
(41, 1, 3, '31220001', '2024-09-30 00:00:00', 15000, 1),
(42, 1, 3, '31220001', '2024-10-05 00:00:00', 294490, 1),
(43, 1, 3, '31220001', '2024-10-17 00:00:00', 500, 1),
(44, 1, 3, '31220001', '2024-10-17 00:00:00', 600, 1),
(45, 1, 1, '31220001', '2024-10-18 00:00:00', 9000, 1),
(46, 1, 1, '31220001', '2024-10-18 00:00:00', 5000, 1),
(47, 1, 1, '31220001', '2024-10-18 00:00:00', 10784537, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieutra`
--

CREATE TABLE `phieutra` (
  `maphieutra` int(11) NOT NULL,
  `maphieunhap` int(11) NOT NULL,
  `manhacungcap` int(11) NOT NULL,
  `manguoitao` int(11) NOT NULL,
  `thoigiantao` date NOT NULL,
  `tongtien` bigint(20) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieutra`
--

INSERT INTO `phieutra` (`maphieutra`, `maphieunhap`, `manhacungcap`, `manguoitao`, `thoigiantao`, `tongtien`, `trangthai`) VALUES
(1, 42, 1, 31220001, '2024-10-17', 294490, 0),
(2, 46, 1, 31220001, '2024-10-18', 5000, 1),
(3, 47, 1, 31220001, '2024-10-18', 10762537, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp(),
  `tongtien` bigint(20) DEFAULT NULL,
  `soluong` int(11) NOT NULL,
  `manv` varchar(10) DEFAULT NULL,
  `makh` int(11) NOT NULL,
  `magiamgia` int(11) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`maphieuxuat`, `thoigian`, `tongtien`, `soluong`, `manv`, `makh`, `magiamgia`, `trangthai`) VALUES
(33, '2024-09-22 00:00:00', 14400, 0, '31220001', 1, 1, 1),
(34, '2024-09-22 00:00:00', 17920, 0, '31220001', 1, 1, 1),
(35, '2024-09-22 00:00:00', 612, 0, '31220001', 1, 1, 1),
(36, '2024-09-22 00:00:00', 4, 0, '31220001', 1, 1, 1),
(37, '2024-09-22 00:00:00', 9450, 0, '31220001', 1, 1, 1),
(38, '2024-09-22 00:00:00', 24960, 0, '31220001', 1, 1, 1),
(39, '2024-10-03 00:00:00', 0, 0, '31220001', 1, 1, 1),
(40, '2024-10-04 00:00:00', 10400, 0, '31220001', 1, 1, 1),
(41, '2024-10-16 00:00:00', 10400, 0, '31220001', 1, 1, 1),
(42, '2024-10-17 00:00:00', 5200, 0, '31220001', 1, 1, 1),
(43, '2024-10-17 00:00:00', 240, 0, '31220001', 1, 1, 1),
(44, '2024-10-18 00:00:00', 19200, 0, '31220001', 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` int(11) NOT NULL,
  `dungtich` int(11) NOT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `xuatxu` int(11) DEFAULT NULL,
  `thuonghieu` int(11) DEFAULT NULL,
  `gianhap` int(11) NOT NULL,
  `giaban` int(11) NOT NULL,
  `soluongton` int(11) DEFAULT 0,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`masp`, `dungtich`, `tensp`, `hinhanh`, `xuatxu`, `thuonghieu`, `gianhap`, `giaban`, `soluongton`, `trangthai`) VALUES
(1, 15, 'Armaf Club De Nuit Woman EDP', 'src/GUI/imageSanPham/anh1.jpg', 1, 1, 0, 0, 0, 1),
(2, 0, 'Dior Sauvage ', 'src/GUI/imageSanPham/anh2.jpg', 1, 1, 0, 0, 0, 1),
(3, 0, 'Versace Pour Homme EDT', 'src/GUI/imageSanPham/anh3.jpg', 1, 1, 0, 0, 0, 1),
(4, 0, 'Diamond Homme ', 'src/GUI/imageSanPham/anh4.jpg', 2, 1, 0, 0, 0, 1),
(5, 0, 'Diamond Femme Pink ', 'src/GUI/imageSanPham/anh5.jpg', 2, 1, 0, 0, 23, 1),
(6, 0, 'Narciso Rodriguez For Her EDP', 'src/GUI/imageSanPham/anh6.jpg', 1, 1, 0, 0, 8, 1),
(7, 0, 'Narciso Rodriguez Ambrée EDP', 'src/GUI/imageSanPham/anh20.jpg', 2, 1, 0, 0, 27, 1),
(8, 0, 'Narciso Rodriguez Pure Musc For Her EDP', 'src/GUI/imageSanPham/anh19.jpg', 2, 1, 0, 0, 23, 1),
(9, 0, 'Gota Urban Eau de Parfum', 'src/GUI/imageSanPham/anh18.jpg', 2, 2, 0, 0, 4, 1),
(10, 0, 'Narciso Rodriguez For Her EDT', 'src/GUI/imageSanPham/anh17.jpg', 2, 2, 0, 0, 0, 1),
(11, 0, 'Diamond Homme Dark Blue ', 'src/GUI/imageSanPham/anh16.jpg', 2, 1, 0, 0, 0, 1),
(12, 0, 'Marc Jacobs Daisy Love EDT ', 'src/GUI/imageSanPham/anh15.jpg', 2, 2, 0, 0, 0, 1),
(13, 0, 'Carolina Herrera Good Girl EDP', 'src/GUI/imageSanPham/anh14.jpg', 4, 3, 0, 0, 0, 1),
(14, 0, 'Jean Paul Gaultier Scandal EDP', 'src/GUI/imageSanPham/anh13.jpg', 2, 7, 0, 0, 0, 1),
(15, 0, 'Gennie Little Red', 'src/GUI/imageSanPham/anh12.jpg', 2, 2, 0, 0, 0, 1),
(16, 0, 'Gennie Little Rose Dress', 'src/GUI/imageSanPham/anh11.jpg', 2, 4, 0, 0, 0, 1),
(17, 0, 'De Memoria #02', 'src/GUI/imageSanPham/anh10.jpg', 2, 3, 0, 0, 0, 1),
(18, 0, 'Gota Bouncy Eau de Parfum', 'src/GUI/imageSanPham/anh7.jpg', 1, 1, 0, 0, 0, 1),
(19, 0, 'De Memoria EDP', 'src/GUI/imageSanPham/anh8.jpg', 2, 3, 0, 0, 0, 1),
(20, 0, 'Gennie Little Gold Dress', 'src/GUI/imageSanPham/anh9.jpg', 2, 1, 0, 0, 0, 1),
(40, 1, 'Armaf Clud', 'src/GUI/imageSanPham/anh1.jpg', 1, 1, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `mataikhoan` int(11) NOT NULL,
  `manv` varchar(10) DEFAULT NULL,
  `matkhau` char(255) NOT NULL,
  `manhomquyen` int(11) NOT NULL,
  `tendangnhap` varchar(50) NOT NULL DEFAULT '',
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`mataikhoan`, `manv`, `matkhau`, `manhomquyen`, `tendangnhap`, `trangthai`) VALUES
(1, '31220001', 'abc', 1, 'admin', 1),
(2, '31220003', 'abc', 1, 'dai', 1),
(3, '31220002', 'abc', 1, 'vuem', 1),
(4, '31220004', 'abc', 2, 'khuong', 1),
(5, '31220005', 'abc', 2, 'bao', 1),
(9, '31220008', '123', 2, 'longbui', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `mathuonghieu` int(11) NOT NULL,
  `tenthuonghieu` varchar(255) NOT NULL,
  `trangthai` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thuonghieu`
--

INSERT INTO `thuonghieu` (`mathuonghieu`, `tenthuonghieu`, `trangthai`) VALUES
(1, 'Thương hiệu A', 1),
(2, 'Thương hiệu B', 1),
(3, 'Thương hiệu C', 1),
(4, 'Thương hiệu D', 0),
(7, 'Thương hiệu E', 0),
(8, 'Thương hiệu F', 0),
(9, 'Thương hiệu G', 1),
(10, 'Thương hiệu H', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `xuatxu`
--

CREATE TABLE `xuatxu` (
  `maxuatxu` int(11) NOT NULL,
  `tenxuatxu` varchar(50) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `xuatxu`
--

INSERT INTO `xuatxu` (`maxuatxu`, `tenxuatxu`, `trangthai`) VALUES
(1, 'Trung Quốc', 1),
(2, 'Hàn Quốc', 1),
(3, 'Việt Nam', 1),
(4, 'USA', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `fk_ctphieunhap_maphieunhap` (`maphieunhap`),
  ADD KEY `fk_ctphieunhap_masp` (`masp`);

--
-- Chỉ mục cho bảng `ctphieutra`
--
ALTER TABLE `ctphieutra`
  ADD PRIMARY KEY (`maphieutra`);

--
-- Chỉ mục cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD KEY `fk_ctphieuxuat_masp` (`masp`),
  ADD KEY `fk_ctphieuxuat_maphieuxuat` (`maphieuxuat`);

--
-- Chỉ mục cho bảng `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  ADD PRIMARY KEY (`machucnang`);

--
-- Chỉ mục cho bảng `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`magiamgia`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `khuvuckho`
--
ALTER TABLE `khuvuckho`
  ADD PRIMARY KEY (`makhuvuc`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`maloai`);

--
-- Chỉ mục cho bảng `losanpham`
--
ALTER TABLE `losanpham`
  ADD PRIMARY KEY (`malosanpham`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Chỉ mục cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`manhomquyen`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `fk_phieunhap_mancc` (`mancc`),
  ADD KEY `fk_phieunhap_makhuvuc` (`makhuvuc`),
  ADD KEY `fk_phieunhap_manv` (`manv`);

--
-- Chỉ mục cho bảng `phieutra`
--
ALTER TABLE `phieutra`
  ADD PRIMARY KEY (`maphieutra`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`),
  ADD KEY `fk_phieuxuat_manv` (`manv`),
  ADD KEY `fk_phieuxuat_makh` (`makh`),
  ADD KEY `fk_phieuxuat_magiamgia` (`magiamgia`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `fk_sanpham_thuonghieu` (`thuonghieu`),
  ADD KEY `fk_sanpham_xuatxu` (`xuatxu`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`mataikhoan`),
  ADD KEY `fk_taikhoan_manhomquyen` (`manhomquyen`),
  ADD KEY `fk_taikhoan_manv` (`manv`);

--
-- Chỉ mục cho bảng `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`mathuonghieu`);

--
-- Chỉ mục cho bảng `xuatxu`
--
ALTER TABLE `xuatxu`
  ADD PRIMARY KEY (`maxuatxu`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  MODIFY `machucnang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `giamgia`
--
ALTER TABLE `giamgia`
  MODIFY `magiamgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `khuvuckho`
--
ALTER TABLE `khuvuckho`
  MODIFY `makhuvuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `MaKM` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `maloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `losanpham`
--
ALTER TABLE `losanpham`
  MODIFY `malosanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `mancc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `manhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `maphieuxuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `mataikhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `mathuonghieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `xuatxu`
--
ALTER TABLE `xuatxu`
  MODIFY `maxuatxu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `fk_ctphieunhap_maphieunhap` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`maphieunhap`),
  ADD CONSTRAINT `fk_ctphieunhap_masp` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Các ràng buộc cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD CONSTRAINT `fk_ctphieuxuat_maphieuxuat` FOREIGN KEY (`maphieuxuat`) REFERENCES `phieuxuat` (`maphieuxuat`),
  ADD CONSTRAINT `fk_ctphieuxuat_masp` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk_phieunhap_makhuvuc` FOREIGN KEY (`makhuvuc`) REFERENCES `khuvuckho` (`makhuvuc`),
  ADD CONSTRAINT `fk_phieunhap_mancc` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`),
  ADD CONSTRAINT `fk_phieunhap_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `fk_phieuxuat_magiamgia` FOREIGN KEY (`magiamgia`) REFERENCES `giamgia` (`magiamgia`),
  ADD CONSTRAINT `fk_phieuxuat_makh` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `fk_phieuxuat_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `fk_sanpham_thuonghieu` FOREIGN KEY (`thuonghieu`) REFERENCES `thuonghieu` (`mathuonghieu`),
  ADD CONSTRAINT `fk_sanpham_xuatxu` FOREIGN KEY (`xuatxu`) REFERENCES `xuatxu` (`maxuatxu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
