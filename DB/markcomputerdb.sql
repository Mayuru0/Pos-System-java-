-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2023 at 02:44 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `markcomputerdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Bill_ID` int(244) NOT NULL,
  `Product_Name` varchar(244) NOT NULL,
  `Unit_Price` double NOT NULL,
  `Quantity` double NOT NULL,
  `Value` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Bill_ID`, `Product_Name`, `Unit_Price`, `Quantity`, `Value`) VALUES
(1, 'MSI B365 ', 30000, 2, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Category_ID` int(20) NOT NULL,
  `Category_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Category_ID`, `Category_Name`) VALUES
(1, 'Processors'),
(2, 'Graphic Cards'),
(3, 'Ram'),
(4, 'Motherboard'),
(5, 'Storage Device'),
(6, 'Headphone');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_ID` varchar(20) NOT NULL,
  `Customer_Name` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Number` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_ID`, `Customer_Name`, `Gender`, `Number`) VALUES
('1', 'Nethu', 'Female', 716595621),
('2', 'Mayuru', 'Male', 774366459),
('3', 'nija', 'Male', 754789547),
('4', 'Chathu', 'Female', 74569875),
('5', 'Gihan', 'Male', 789865478),
('6', 'Pathum', 'Male', 774366987),
('7', 'Dilshan', 'Male', 754787954),
('8', 'Chalana', 'Male', 754787954);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `Invoice_ID` int(50) NOT NULL,
  `Customer_Name` varchar(50) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `Unit_Price` varchar(244) NOT NULL,
  `Quantity` int(244) NOT NULL,
  `Total` varchar(244) NOT NULL,
  `Payment` varchar(244) NOT NULL,
  `Balance` varchar(244) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`Invoice_ID`, `Customer_Name`, `Product_Name`, `Unit_Price`, `Quantity`, `Total`, `Payment`, `Balance`) VALUES
(1, 'Nethu', 'CPU', '1000', 2, '2000', '5000', '3000'),
(2, 'Mayuru', 'i3 9gen', '3500', 1, '3500', '4000', '500');

-- --------------------------------------------------------

--
-- Table structure for table `manageproducts`
--

CREATE TABLE `manageproducts` (
  `Company` varchar(50) NOT NULL,
  `Product_ID` int(20) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `Product_Category` varchar(50) NOT NULL,
  `Quantity` int(20) NOT NULL,
  `Entry_Date` varchar(50) NOT NULL,
  `Bying_Price` float NOT NULL,
  `Selling_Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manageproducts`
--

INSERT INTO `manageproducts` (`Company`, `Product_ID`, `Product_Name`, `Product_Category`, `Quantity`, `Entry_Date`, `Bying_Price`, `Selling_Price`) VALUES
('MSK (PVT)', 1, 'i3 9gen', 'Processors', 3, 'Jul 6, 2023', 20000, 25000),
('Nethara (PVT)', 2, 'GTX 1060 6GB', 'Graphic Cards', 4, 'Jul 6, 2023', 50000, 60000),
('Newline(PVT)', 3, '16GB', 'Ram', 4, 'Jul 6, 2023', 10000, 12000),
('Chalana(PVT)', 4, 'MSI B365 ', 'Motherboard', 5, 'Jul 6, 2023', 20000, 30000),
('Nidushan(PVT)', 5, '1TB HDD', 'Storage Device', 3, 'Jul 6, 2023', 5000, 6000),
('MSK (PVT)', 6, 'i5', 'Processors', 8, 'Jul 6, 2023', 10000, 12000),
('MSK (PVT)', 7, 'MSI', 'Headphone', 8, 'Jul 6, 2023', 5000, 6000),
('Newline(PVT)', 8, 'GTX 660', 'Graphic Cards', 15, 'Jul 6, 2023', 15000, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `registation`
--

CREATE TABLE `registation` (
  `UserId` varchar(20) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `NIC` varchar(12) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Birthday` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Number` int(10) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `AccountType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registation`
--

INSERT INTO `registation` (`UserId`, `UserName`, `FirstName`, `LastName`, `NIC`, `Gender`, `Birthday`, `Address`, `Number`, `Email`, `Password`, `AccountType`) VALUES
('001', 'MARSH', 'Mayuru', 'Madhuranga', '200019002348', 'Male', 'Jul 8, 2000', '79,Marylnd,Wathurugama', 774366459, 'Mayurumaduranga@gmail.com', '1234', 'Admin'),
('002', 'Pathum', 'Pathum', 'Lakshan', '200017003568', 'Male', '2000/10/20', '79,Maryland,Wathurugama', 758568987, 'pathumlakshan@gmail.com', '1234', 'User'),
('003', 'Nija', 'Mohomad', 'Nijadth', '2170045887', 'Male', '2000/08/05', '69\\29 Thihariya,Kalagedihena', 754187654, 'nijath123@gmail.com', '1234', 'User'),
('004', 'Nethu', 'Nethmini', 'Praboda', '200017003658', 'Female', '2000/09/06', 'ehaliyagoda', 748565257, 'Nethmini@gmail.com', 'nethu', 'Admin'),
('005', 'Chathu', 'Chathurika', 'wijeerathna', '200015005879', 'Female', '2000/03/14', 'Mirigama', 757858965, 'chathu@gmail.com', '2134', 'User'),
('006', 'Dila', 'Dilshan', 'Rathnayaka', '200015002365', 'Male', 'Dec 2, 2001', 'Anuradapura', 778565987, 'dila@gmail.com', '1234', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_ID` varchar(20) NOT NULL,
  `Supplier_Name` varchar(50) NOT NULL,
  `Contact_Number` int(10) NOT NULL,
  `Company` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_ID`, `Supplier_Name`, `Contact_Number`, `Company`) VALUES
('001', 'Mayuru', 774366459, 'MSK (PVT)'),
('002', 'Nethmini', 716595621, 'Nethara (PVT)'),
('003', 'Nija', 754787895, 'Newline(PVT)'),
('004', 'Chathurika', 745896478, 'Chathushop(PVT)'),
('005', 'Chalana', 758965214, 'Chalana(PVT)'),
('006', 'Nidushan', 1125689871, 'Nidushan(PVT)');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Category_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_ID`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`Invoice_ID`);

--
-- Indexes for table `manageproducts`
--
ALTER TABLE `manageproducts`
  ADD PRIMARY KEY (`Product_ID`);

--
-- Indexes for table `registation`
--
ALTER TABLE `registation`
  ADD PRIMARY KEY (`UserId`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
