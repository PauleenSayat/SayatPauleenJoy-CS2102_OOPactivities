CREATE DATABASE digital_banking;

USE DIGITAL_BANKING;

CREATE TABLE Users (
	userID INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE Accounts (
	accountID INT PRIMARY KEY AUTO_INCREMENT,
    accountNumber VARCHAR(20) UNIQUE,
    balance DECIMAL(10,0) DEFAULT 0.00,
    userID INT,
    FOREIGN KEY (userID) REFERENCES Users(userID)
    );
    
CREATE TABLE Transactions (
	transactionID INT PRIMARY KEY AUTO_INCREMENT,
    transactionType VARCHAR(20),
    amount DECIMAL(10.2),
    accountID INT,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (accountID) REFERENCES Accounts(accountID)
    );
    