-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jun 2024 pada 09.25
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `laporan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `laporan` (
`nama` varchar(25)
,`judul` varchar(50)
,`tgl_pinjam` date
,`tgl_kembali` date
,`keterangan` enum('Telat','Tidak telat','Hilang','')
,`denda` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `lihat_transaksi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `lihat_transaksi` (
`id_anggota` varchar(20)
,`nama` varchar(25)
,`kode_pinjam` varchar(20)
,`judul` varchar(50)
,`tgl_pinjam` date
,`tgl_hrskembali` date
,`kode_kembali` varchar(20)
,`tgl_kembali` date
,`keterangan` enum('Telat','Tidak telat','Hilang','')
,`denda` int(11)
,`kt` enum('Sudah kembali','Belum kembali','','')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `recomendasi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `recomendasi` (
`kode_buku` varchar(20)
,`judul` varchar(50)
,`penulis` varchar(30)
,`tahun_terbit` int(4)
,`kategori` varchar(20)
,`keterangan` enum('Sudah kembali','Belum kembali','','')
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`username`, `password`) VALUES
('abdullah', 'abd123456789'),
('admin', 'admin123'),
('faqih', 'faqih12345');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_anggota`
--

CREATE TABLE `tb_anggota` (
  `id_anggota` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telp` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` enum('Pinjam','Tidak pinjam','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_anggota`
--

INSERT INTO `tb_anggota` (`id_anggota`, `nama`, `password`, `jk`, `telp`, `alamat`, `status`) VALUES
('MHS001', 'Abdullah Faqih', '12345678', 'Laki-laki', '081395384553', 'Cirebon', 'Pinjam'),
('MHS002', 'Affifah Risti Ardi', '12345678', 'Perempuan', '087567521345', 'Bekasi', 'Tidak pinjam'),
('MHS003', 'Eki Ramadhan', 'eki12345', 'Laki-laki', '0876854321544', 'Bekasi', 'Tidak pinjam'),
('MHS004', 'Dea Auliya', 'dea12345', 'Perempuan', '081234556478', 'Bekasi', 'Pinjam'),
('MHS005', 'Moniqca Sandha Iskandar', 'moniq123', 'Perempuan', '087679845123', 'Purwakarta', 'Tidak pinjam'),
('MHS006', 'Ahmad Dzaky', 'ahmad123', 'Laki-laki', '087567455399', 'Semarang', 'Pinjam'),
('MHS007', 'Saputra Ilham', 'ilham123', 'Laki-laki', '089564711676', 'Bekasi', 'Pinjam'),
('MHS008', 'Fahreza', 'eja12345', 'Laki-laki', '081346577711', 'Purwokerto', 'Pinjam'),
('MHS009', 'Khoirunnisa', 'nisa1234', 'Perempuan', '086789654321', 'Cirebon', 'Pinjam'),
('MHS010', 'Pedri', 'pedri12345', 'Laki-laki', '087654321123', 'Barcelona', 'Pinjam'),
('MHS011', 'Ramadhan Eki', 'eki12345', 'Laki-laki', '081234565412', 'Jl. jalan', 'Tidak pinjam'),
('MHS012', 'udin sucipto', 'udin1234', 'Laki-laki', '0812345678', 'Jl. Jalan', 'Tidak pinjam'),
('MHS013', 'Faqih Abdullah', 'faqih123', 'Laki-laki', '1234567890987', 'Palimanan', 'Tidak pinjam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_buku`
--

CREATE TABLE `tb_buku` (
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penulis` varchar(30) NOT NULL,
  `tahun_terbit` int(4) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_buku`
--

INSERT INTO `tb_buku` (`kode_buku`, `judul`, `penulis`, `tahun_terbit`, `kategori`, `jumlah`) VALUES
('BK001', 'Koala Kumal', 'Raditya Dika', 2015, 'Fiksi', 66),
('BK002', 'Pantai dan Kehidupanya', 'Edy Karsono', 2003, 'Non Fiksi', 54),
('BK003', 'Negeri 5 Menara', 'Ahmad Fuadi', 2009, 'Novel', 124),
('BK004', 'The Alpha Girls Guide', 'henry manampiring', 2020, 'Non Fiksi', 24),
('BK005', 'Perburuan Piring Emas', 'Jacques futrelle', 2022, 'Novel', 70),
('BK006', 'Senyum Karyamin', 'Ahmad Tohari', 2013, 'Cerpen', 41),
('BK007', 'Habbit Is Power', 'Tjahjo harry wilopo', 2021, 'Non Fiksi', 27),
('BK008', 'Perahu Kertas', 'Dewi Lestari', 2009, 'Novel', 67),
('BK009', 'Cantik Itu Luka', 'Eka Kurniawan', 2002, 'Novel', 22),
('BK010', 'Laskar Pelangi', 'Andrea Hirata', 2005, 'Novel', 32),
('BK011', 'Amba', 'Laksmi Pamuntjak', 2012, 'Fiksi', 21),
('BK012', 'Manusia Harimau', 'Eka Kurniawan', 2004, 'Fiksi', 50),
('BK013', 'Jejak Langkah', 'Pramoedya Ananta Toer', 1985, 'Non Fiksi', 10),
('BK014', 'Habis Terang Terbitlah Terang', 'Kartini', 1911, 'Non Fiksi', 10),
('BK015', 'Mengajar Dengan Cinta', 'Satang', 2010, 'Pendidikan', 63),
('BK016', 'Mindset : The New Psychology of Succes', 'Carol Dweck', 2018, 'Pendidikan', 21),
('BK017', 'Selamat Tinggal Mitos', 'Kuntowijoyo', 1987, 'Non Fiksi', 11),
('BK018', 'Revolusi Mental', 'Gramedia Pustaka Utama', 2014, 'Non Fiksi', 22),
('BK019', 'Pintu Terlarang', 'Sekar Ayu Asmara', 2004, 'Fiksi', 14),
('BK020', 'Pulang', 'Tere Liye', 2012, 'Novel', 45),
('BK021', 'Bumi Manusia', 'Pramoedya Ananta Toer', 1980, 'Novel', 16),
('BK022', 'Ayat Ayat Cinta', 'Habiburahman El Shirazy', 2004, 'Novel', 37),
('BK023', 'Cinta Itu Luka', 'Eka Kurniawan', 2002, 'Novel', 53),
('BK024', 'Pendidikan Itu Peradaban', 'Grafindo', 2014, 'Pendidikan', 35),
('BK025', 'Mendidiik Anak Dengan Cinta', 'Sinta Yudisia', 2012, 'Pendidikan', 27),
('BK026', '5 Cm', 'Donny Dhirgantoro', 2005, 'Novel', 25),
('BK027', 'Bulan', 'Tere Liye', 2017, 'Novel', 50);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kembali`
--

CREATE TABLE `tb_kembali` (
  `kode_kembali` varchar(20) NOT NULL,
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` int(11) NOT NULL,
  `keterangan` enum('Telat','Tidak telat','Hilang','') NOT NULL,
  `jumlah` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_kembali`
--

INSERT INTO `tb_kembali` (`kode_kembali`, `kode_pinjam`, `id_anggota`, `kode_buku`, `tgl_kembali`, `denda`, `keterangan`, `jumlah`) VALUES
('169336', '86470', 'MHS005', 'BK003', '2024-06-02', 500, 'Telat', 1),
('663215', '120636', 'MHS002', 'BK023', '2024-06-02', 200000, 'Hilang', 0),
('755701', '92752', 'MHS003', 'BK026', '2024-05-27', 0, 'Tidak telat', 1);

--
-- Trigger `tb_kembali`
--
DELIMITER $$
CREATE TRIGGER `kembali_buku` AFTER INSERT ON `tb_kembali` FOR EACH ROW BEGIN
UPDATE tb_buku SET jumlah = jumlah + new.jumlah
WHERE kode_buku = new.kode_buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_petugas`
--

CREATE TABLE `tb_petugas` (
  `id_operator` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telp` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_petugas`
--

INSERT INTO `tb_petugas` (`id_operator`, `nama`, `password`, `jk`, `telp`, `alamat`) VALUES
('PGS01', 'Abdullah Faqih', 'faqih123', 'Laki-laki', '081395384553', 'Cirebon'),
('PGS02', 'Affifah Risti Ardi', 'affifah123', 'Perempuan', '08765467532', 'Bekasi'),
('PGS03', 'Eki Ramadhan', 'eki12345', 'Laki-laki', '089712345678', 'Bekasi'),
('PGS04', 'Dea Auliya', 'dea12345', 'Perempuan', '087453217856', 'Bekasi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pinjam`
--

CREATE TABLE `tb_pinjam` (
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_hrskembali` date NOT NULL,
  `jumlah` int(1) NOT NULL,
  `kt` enum('Sudah kembali','Belum kembali','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pinjam`
--

INSERT INTO `tb_pinjam` (`kode_pinjam`, `id_anggota`, `nama`, `kode_buku`, `judul`, `tgl_pinjam`, `tgl_hrskembali`, `jumlah`, `kt`) VALUES
('120636', 'MHS002', 'Affifah Risti Ardi', 'BK023', 'Cinta Itu Luka', '2024-05-25', '2024-06-01', 1, 'Sudah kembali'),
('180090', 'MHS006', 'Ahmad Dzaky', 'BK012', 'Manusia Harimau', '2024-05-25', '2024-06-01', 1, 'Belum kembali'),
('285477', 'MHS009', 'Khoirunnisa', 'BK026', '5 Cm', '2024-06-02', '2024-06-09', 1, 'Belum kembali'),
('37787', 'MHS010', 'Pedri', 'BK005', 'Perburuan Piring Emas', '2024-05-25', '2024-06-01', 1, 'Belum kembali'),
('680155', 'MHS004', 'Dea Auliya', 'BK021', 'Bumi Manusia', '2024-05-25', '2024-06-01', 1, 'Belum kembali'),
('823795', 'MHS008', 'Fahreza', 'BK026', '5 Cm', '2024-05-25', '2024-06-01', 1, 'Belum kembali'),
('86470', 'MHS005', 'Moniqca Sandha Iskandar', 'BK003', 'Negeri 5 Menara', '2024-05-25', '2024-06-01', 1, 'Sudah kembali'),
('882950', 'MHS007', 'Saputra Ilham', 'BK004', 'The Alpha Girls Guide', '2024-05-25', '2024-06-01', 1, 'Belum kembali'),
('92752', 'MHS003', 'Eki Ramadhan', 'BK026', '5 Cm', '2024-05-25', '2024-06-01', 1, 'Sudah kembali'),
('958908', 'MHS001', 'Abdullah Faqih', 'BK001', 'Koala Kumal', '2024-05-25', '2024-06-01', 1, 'Belum kembali');

--
-- Trigger `tb_pinjam`
--
DELIMITER $$
CREATE TRIGGER `pinjam_buku` AFTER INSERT ON `tb_pinjam` FOR EACH ROW BEGIN
update tb_buku SET jumlah = jumlah - new.jumlah
WHERE kode_buku = new.kode_buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur untuk view `laporan`
--
DROP TABLE IF EXISTS `laporan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan`  AS SELECT `tb_pinjam`.`nama` AS `nama`, `tb_pinjam`.`judul` AS `judul`, `tb_pinjam`.`tgl_pinjam` AS `tgl_pinjam`, `tb_kembali`.`tgl_kembali` AS `tgl_kembali`, `tb_kembali`.`keterangan` AS `keterangan`, `tb_kembali`.`denda` AS `denda` FROM (`tb_pinjam` join `tb_kembali` on(`tb_pinjam`.`kode_pinjam` = `tb_kembali`.`kode_pinjam`))  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `lihat_transaksi`
--
DROP TABLE IF EXISTS `lihat_transaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lihat_transaksi`  AS SELECT `tb_pinjam`.`id_anggota` AS `id_anggota`, `tb_pinjam`.`nama` AS `nama`, `tb_pinjam`.`kode_pinjam` AS `kode_pinjam`, `tb_pinjam`.`judul` AS `judul`, `tb_pinjam`.`tgl_pinjam` AS `tgl_pinjam`, `tb_pinjam`.`tgl_hrskembali` AS `tgl_hrskembali`, `tb_kembali`.`kode_kembali` AS `kode_kembali`, `tb_kembali`.`tgl_kembali` AS `tgl_kembali`, `tb_kembali`.`keterangan` AS `keterangan`, `tb_kembali`.`denda` AS `denda`, `tb_pinjam`.`kt` AS `kt` FROM (`tb_pinjam` left join `tb_kembali` on(`tb_pinjam`.`kode_pinjam` = `tb_kembali`.`kode_pinjam`))  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `recomendasi`
--
DROP TABLE IF EXISTS `recomendasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `recomendasi`  AS SELECT `tb_pinjam`.`kode_buku` AS `kode_buku`, `tb_pinjam`.`judul` AS `judul`, `tb_buku`.`penulis` AS `penulis`, `tb_buku`.`tahun_terbit` AS `tahun_terbit`, `tb_buku`.`kategori` AS `kategori`, `tb_pinjam`.`kt` AS `keterangan` FROM (`tb_pinjam` join `tb_buku` on(`tb_pinjam`.`kode_buku` = `tb_buku`.`kode_buku`))  ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indeks untuk tabel `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indeks untuk tabel `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD PRIMARY KEY (`kode_kembali`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `id_anggota_2` (`id_anggota`),
  ADD KEY `kode_buku_2` (`kode_buku`),
  ADD KEY `kode_pinjam` (`kode_pinjam`);

--
-- Indeks untuk tabel `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`id_operator`);

--
-- Indeks untuk tabel `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD PRIMARY KEY (`kode_pinjam`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `kode_buku_2` (`kode_buku`),
  ADD KEY `id_anggota_2` (`id_anggota`),
  ADD KEY `kode_buku_3` (`kode_buku`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD CONSTRAINT `tb_kembali_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `tb_buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_kembali_ibfk_3` FOREIGN KEY (`kode_pinjam`) REFERENCES `tb_pinjam` (`kode_pinjam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_kembali_ibfk_4` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD CONSTRAINT `tb_pinjam_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `tb_buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pinjam_ibfk_2` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
