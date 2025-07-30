-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2024 at 04:36 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_klontong`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang_beli`
--

CREATE TABLE `barang_beli` (
  `Kode_produk` varchar(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `Id_pembelian` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang_beli`
--

INSERT INTO `barang_beli` (`Kode_produk`, `jumlah`, `Id_pembelian`) VALUES
('KP3', 1, 'KP1'),
('KP3', 1, 'KP2'),
('KP3', 5, 'KP3'),
('KP3', 10, 'KP4'),
('KP3', 2, 'KP5');

-- --------------------------------------------------------

--
-- Table structure for table `barang_jual`
--

CREATE TABLE `barang_jual` (
  `Kode_produk` varchar(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `Id_penjualan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang_jual`
--

INSERT INTO `barang_jual` (`Kode_produk`, `jumlah`, `Id_penjualan`) VALUES
('KP3', 1, 'KP6'),
('KP3', 1, 'KP6'),
('KP3', 1, 'KP7'),
('KP3', 1, 'KP8'),
('KP3', 1, 'KP9'),
('KP3', 5, 'KP11'),
('KP3', 2, 'KP12'),
('KP3', 3, 'KP13'),
('KP3', 3, 'KP16'),
('KP3', 2, 'KP17'),
('KP3', 2, 'KP17');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `Id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `Sex` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `noTelp` varchar(16) NOT NULL,
  `Member` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`Id_pelanggan`, `nama`, `Sex`, `alamat`, `noTelp`, `Member`) VALUES
('IP7', '32', 'Laki-Laki', '2', '2', 1);

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `Kode_produk` varchar(5) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Jenis` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Harga_satuan` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`Kode_produk`, `Nama`, `Jenis`, `Jumlah`, `Harga_satuan`) VALUES
('KP3', 'Lifeboy', 'Alat Rumah Tangga', 40, 7000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Id_supplier` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `noTelp` varchar(16) NOT NULL,
  `Instansi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Id_supplier`, `nama`, `alamat`, `noTelp`, `Instansi`) VALUES
('SP1', 'sapi', 'Jl babarsari', '123', 'PT');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_pembelian`
--

CREATE TABLE `transaksi_pembelian` (
  `Id_pembelian` varchar(10) NOT NULL,
  `tgl` date NOT NULL,
  `harga` float NOT NULL,
  `Id_supplier` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_pembelian`
--

INSERT INTO `transaksi_pembelian` (`Id_pembelian`, `tgl`, `harga`, `Id_supplier`) VALUES
('KP1', '2022-01-11', 7000, 'SP1'),
('KP2', '0001-01-22', 7000, 'SP1'),
('KP3', '2022-01-01', 35000, 'SP1'),
('KP4', '2022-02-02', 70000, 'SP1'),
('KP5', '2022-02-02', 14000, 'SP1');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_penjualan`
--

CREATE TABLE `transaksi_penjualan` (
  `Id_penjualan` varchar(10) NOT NULL,
  `tgl` date NOT NULL,
  `total` float NOT NULL,
  `Id_pelanggan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_penjualan`
--

INSERT INTO `transaksi_penjualan` (`Id_penjualan`, `tgl`, `total`, `Id_pelanggan`) VALUES
('KP11', '2003-01-12', 35000, 'IP7'),
('KP12', '2003-01-12', 14000, 'IP7'),
('KP13', '2003-01-12', 23000, 'IP7'),
('KP15', '2022-01-13', 7000, 'IP7'),
('KP16', '0002-02-02', 21000, 'IP7'),
('KP17', '2003-01-12', 28000, 'IP7'),
('KP6', '2022-01-01', 14000, 'IP7'),
('KP7', '2022-01-01', 7000, 'IP7'),
('KP8', '0001-01-01', 11000, 'IP7'),
('KP9', '2003-01-12', 11000, 'IP7');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(5) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `leveluser` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `leveluser`) VALUES
(1, 'admin', 'admin', 1),
(2, 'user', 'user', 0),
(4, 'user1', 'user1', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang_beli`
--
ALTER TABLE `barang_beli`
  ADD KEY `Id_pembelian` (`Id_pembelian`),
  ADD KEY `Kode_produk` (`Kode_produk`);

--
-- Indexes for table `barang_jual`
--
ALTER TABLE `barang_jual`
  ADD KEY `Id_penjualan` (`Id_penjualan`),
  ADD KEY `Kode_produk` (`Kode_produk`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`Id_pelanggan`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`Kode_produk`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Id_supplier`);

--
-- Indexes for table `transaksi_pembelian`
--
ALTER TABLE `transaksi_pembelian`
  ADD PRIMARY KEY (`Id_pembelian`),
  ADD KEY `transaksi_pembelian_ibfk_1` (`Id_supplier`);

--
-- Indexes for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD PRIMARY KEY (`Id_penjualan`),
  ADD KEY `Id_pelanggan` (`Id_pelanggan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang_beli`
--
ALTER TABLE `barang_beli`
  ADD CONSTRAINT `barang_beli_ibfk_1` FOREIGN KEY (`Id_pembelian`) REFERENCES `transaksi_pembelian` (`Id_pembelian`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_beli_ibfk_2` FOREIGN KEY (`Kode_produk`) REFERENCES `produk` (`Kode_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `barang_jual`
--
ALTER TABLE `barang_jual`
  ADD CONSTRAINT `barang_jual_ibfk_1` FOREIGN KEY (`Id_penjualan`) REFERENCES `transaksi_penjualan` (`Id_penjualan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_jual_ibfk_2` FOREIGN KEY (`Kode_produk`) REFERENCES `produk` (`Kode_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_pembelian`
--
ALTER TABLE `transaksi_pembelian`
  ADD CONSTRAINT `transaksi_pembelian_ibfk_1` FOREIGN KEY (`Id_supplier`) REFERENCES `supplier` (`Id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD CONSTRAINT `transaksi_penjualan_ibfk_1` FOREIGN KEY (`Id_pelanggan`) REFERENCES `pelanggan` (`Id_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
