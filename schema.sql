-- 1. Tạo Database
DROP DATABASE IF EXISTS PolyOE;
CREATE DATABASE PolyOE CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE PolyOE;

-- 2. Tạo bảng Users
-- MySQL dùng VARCHAR thay cho NVARCHAR, BIT(1) thay cho BIT
CREATE TABLE Users (
    Username      VARCHAR(50) NOT NULL PRIMARY KEY,
    Password      VARCHAR(50) NOT NULL,
    Phone         VARCHAR(15),
    Fullname      VARCHAR(50),
    Email         VARCHAR(150),
    Admin         BIT(1) DEFAULT 0, -- 0: User, 1: Admin
    Active        BIT(1) DEFAULT 1,
    Images        VARCHAR(500)	
);

-- 3. Tạo bảng Category
-- Thay IDENTITY(1,1) bằng AUTO_INCREMENT
CREATE TABLE Category (
    CategoryId    INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Categoryname  VARCHAR(100),
    Categorycode  VARCHAR(100),
    Images        VARCHAR(500),
    Status        BIT(1) DEFAULT 1
);

-- 4. Tạo bảng Videos
CREATE TABLE Videos (
    VideoId       VARCHAR(50) NOT NULL PRIMARY KEY,
    Title         VARCHAR(200) NOT NULL,
    Poster        VARCHAR(500),
    Views         INT DEFAULT 0,
    Description   VARCHAR(500),
    Active        BIT(1) DEFAULT 1,
    CategoryId    INT NOT NULL,
    FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId)
);

-- 5. Tạo bảng Favorites
-- Thay GETDATE() bằng CURRENT_DATE()
CREATE TABLE Favorites (
    FavoriteId    INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Username      VARCHAR(50) NOT NULL,
    VideoId       VARCHAR(50) NOT NULL,
    LikedDate     DATE DEFAULT (CURRENT_DATE),
    UNIQUE KEY unique_like (Username, VideoId),
    FOREIGN KEY (Username) REFERENCES Users(Username),
    FOREIGN KEY (VideoId) REFERENCES Videos(VideoId)
);

-- 6. Tạo bảng Shares
CREATE TABLE Shares (
    ShareId       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Username      VARCHAR(50) NOT NULL,
    VideoId       VARCHAR(50) NOT NULL,
    Emails        VARCHAR(500),
    SharedDate    DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (Username) REFERENCES Users(Username),
    FOREIGN KEY (VideoId) REFERENCES Videos(VideoId)
);

-- =============================================
-- THÊM DỮ LIỆU MẪU (DUMMY DATA) CHO MYSQL
-- =============================================

INSERT INTO Users (Username, Password, Fullname, Email, Admin) VALUES 
('admin', '123', 'Administrator', 'admin@poly.edu.vn', 1),
('user1', '123', 'Nguyễn Văn A', 'nva@gmail.com', 0),
('user2', '123', 'Trần Thị B', 'ttb@gmail.com', 0),
('tai', '123', 'Tài Dev', 'tai@gmail.com', 1);

INSERT INTO Category (Categoryname, Categorycode) VALUES 
('Âm nhạc', 'MUSIC'),
('Thời sự', 'NEWS'),
('Game', 'GAME'),
('Phim ảnh', 'MOVIE');

INSERT INTO Videos (VideoId, Title, Views, CategoryId, Description) VALUES 
('V001', 'Sơn Tùng M-TP | Lạc Trôi', 1500, 1, 'MV Ca nhạc hot'),
('V002', 'Review Genshin Impact', 2300, 3, 'Game nhập vai thế giới mở'),
('V003', 'Thời sự 19h VTV', 500, 2, 'Tin tức trong ngày'),
('V004', 'Trailer Avengers', 9000, 4, 'Phim siêu anh hùng'),
('V005', 'Furina Demo', 5000, 3, 'Nhân vật Furina Genshin Impact');

INSERT INTO Favorites (Username, VideoId, LikedDate) VALUES 
('user1', 'V001', '2025-01-10'),
('user1', 'V002', '2025-01-11'),
('tai', 'V005', '2025-10-09');

INSERT INTO Shares (Username, VideoId, Emails, SharedDate) VALUES 
('user1', 'V001', 'ban1@gmail.com', '2025-01-15'),
('tai', 'V005', 'nhan@gmail.com', '2025-10-23');videos