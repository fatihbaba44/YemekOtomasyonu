-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.2.32-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- uygulama2 için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `uygulama2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `uygulama2`;

-- tablo yapısı dökülüyor uygulama2.anayemek
CREATE TABLE IF NOT EXISTS `anayemek` (
  `anayemekid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `anayemekismi` varchar(250) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL DEFAULT '',
  `anayemekkalori` int(11) NOT NULL,
  `anayemekfiyat` int(11) NOT NULL,
  PRIMARY KEY (`anayemekid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- uygulama2.anayemek: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `anayemek` DISABLE KEYS */;
INSERT INTO `anayemek` (`anayemekid`, `anayemekismi`, `anayemekkalori`, `anayemekfiyat`) VALUES
	(8, 'pizza', 1000, 100),
	(9, 'makarna', 33, 22);
/*!40000 ALTER TABLE `anayemek` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.arayemek
CREATE TABLE IF NOT EXISTS `arayemek` (
  `arayemekid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `arayemekismi` varchar(250) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `arayemekkalori` int(11) NOT NULL,
  `arayemekfiyat` int(11) NOT NULL,
  PRIMARY KEY (`arayemekid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- uygulama2.arayemek: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `arayemek` DISABLE KEYS */;
INSERT INTO `arayemek` (`arayemekid`, `arayemekismi`, `arayemekkalori`, `arayemekfiyat`) VALUES
	(9, 'tavuk', 134, 15),
	(10, 'pizza', 2000, 20);
/*!40000 ALTER TABLE `arayemek` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.fastfood
CREATE TABLE IF NOT EXISTS `fastfood` (
  `fastfoodid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fastfoodismi` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `fastfoodkalori` int(11) NOT NULL,
  `fastfoodfiyat` int(11) NOT NULL,
  PRIMARY KEY (`fastfoodid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- uygulama2.fastfood: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `fastfood` DISABLE KEYS */;
INSERT INTO `fastfood` (`fastfoodid`, `fastfoodismi`, `fastfoodkalori`, `fastfoodfiyat`) VALUES
	(1, 'sucuklu pizza kola', 1250, 40),
	(2, 'Orta Boy Pizza', 1560, 54),
	(3, 'Büyük Boy Pizza', 2467, 60);
/*!40000 ALTER TABLE `fastfood` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.içecek
CREATE TABLE IF NOT EXISTS `içecek` (
  `içecekid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `içecekismi` varchar(50) NOT NULL,
  `içecekkalori` int(11) NOT NULL,
  `içecekboyut` varchar(50) NOT NULL,
  `içecekfiyat` int(11) NOT NULL,
  PRIMARY KEY (`içecekid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- uygulama2.içecek: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `içecek` DISABLE KEYS */;
INSERT INTO `içecek` (`içecekid`, `içecekismi`, `içecekkalori`, `içecekboyut`, `içecekfiyat`) VALUES
	(1, 'kola', 250, '250 mL ', 4),
	(2, 'ayran', 100, '300 mL', 6),
	(3, 'salgam', 120, '400 mL', 10);
/*!40000 ALTER TABLE `içecek` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.malzeme
CREATE TABLE IF NOT EXISTS `malzeme` (
  `malzemeid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `malzemeismi` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL DEFAULT '',
  `malzemekalori` int(11) NOT NULL,
  `malzemefiyat` int(11) NOT NULL,
  PRIMARY KEY (`malzemeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- uygulama2.malzeme: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `malzeme` DISABLE KEYS */;
INSERT INTO `malzeme` (`malzemeid`, `malzemeismi`, `malzemekalori`, `malzemefiyat`) VALUES
	(1, 'yumurta', 50, 1),
	(2, 'un', 100, 2),
	(3, 'süt', 250, 15);
/*!40000 ALTER TABLE `malzeme` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.restaurant
CREATE TABLE IF NOT EXISTS `restaurant` (
  `restaurantid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `restaurantismi` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `restaurantadres` varchar(250) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  PRIMARY KEY (`restaurantid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- uygulama2.restaurant: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` (`restaurantid`, `restaurantismi`, `restaurantadres`) VALUES
	(1, 'Çamlıca Restaurant', 'Manolya Sokak Faruk Eczne Karşısı'),
	(2, 'Özdemirler Restaurant', 'Yavuz Sultan Selim Sokak İşkur Karşısı'),
	(3, 'Öz Çakı Kebap Salonu', 'Kenan Işık Caddesi Esenlik Market Karşısı');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.sağlıklı
CREATE TABLE IF NOT EXISTS `sağlıklı` (
  `saglikliid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saglikliismi` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `sagliklikalori` int(11) NOT NULL,
  `sagliklifiyat` int(11) NOT NULL,
  PRIMARY KEY (`saglikliid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- uygulama2.sağlıklı: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `sağlıklı` DISABLE KEYS */;
INSERT INTO `sağlıklı` (`saglikliid`, `saglikliismi`, `sagliklikalori`, `sagliklifiyat`) VALUES
	(1, 'Roka Salatası', 140, 25),
	(2, 'Yulaf Ezmesi', 145, 45),
	(3, 'Sebzeli Salata', 45, 23),
	(4, 'Çoban Salata', 100, 34);
/*!40000 ALTER TABLE `sağlıklı` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.sipariş
CREATE TABLE IF NOT EXISTS `sipariş` (
  `siparisid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `siparisverenkisiad` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `siparisverenkisisoyad` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `siparisalınmatarihi` date NOT NULL,
  `siparisverilmetarihi` date NOT NULL,
  `siparisverentelno` int(50) NOT NULL,
  PRIMARY KEY (`siparisid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- uygulama2.sipariş: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `sipariş` DISABLE KEYS */;
INSERT INTO `sipariş` (`siparisid`, `siparisverenkisiad`, `siparisverenkisisoyad`, `siparisalınmatarihi`, `siparisverilmetarihi`, `siparisverentelno`) VALUES
	(1, 'Fatih', 'ULUÇAY', '2020-06-04', '2020-06-05', 434324234),
	(2, 'Gökhan', 'DEMİRAL', '2020-06-06', '2020-06-07', 12313132),
	(3, 'Abbas', 'JİLETÇİ', '2020-06-02', '2020-06-08', 223123123),
	(4, 'Abdi', 'FAÇA', '2020-06-01', '2020-06-06', 23115141),
	(5, 'Bahattin', 'ÖRÜMCEK', '2020-05-27', '2020-05-29', 231231231);
/*!40000 ALTER TABLE `sipariş` ENABLE KEYS */;

-- tablo yapısı dökülüyor uygulama2.tatlı
CREATE TABLE IF NOT EXISTS `tatlı` (
  `tatlıid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tatlıismi` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_unicode_ci NOT NULL,
  `tatlıkalori` int(11) NOT NULL,
  `tatlıfiyat` int(11) NOT NULL,
  PRIMARY KEY (`tatlıid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- uygulama2.tatlı: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `tatlı` DISABLE KEYS */;
INSERT INTO `tatlı` (`tatlıid`, `tatlıismi`, `tatlıkalori`, `tatlıfiyat`) VALUES
	(1, 'Kazandibi', 1456, 56),
	(2, 'Tulumba', 2323, 14),
	(3, 'Havuçlu Baklava', 2323, 45),
	(4, 'İmamBayıldı', 2323, 45),
	(5, 'İrmik Helvası', 500, 25);
/*!40000 ALTER TABLE `tatlı` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
