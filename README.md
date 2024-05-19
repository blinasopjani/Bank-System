# Bank System Application

## Overview

This is a simple Java-based Bank System application that allows users to perform various banking operations such as creating accounts, performing transactions, checking account balances, listing all accounts, and checking total transaction fee amounts and transfer amounts. The application is console-based and interacts with users via command-line inputs.

## Features

- **Create a new bank account**
- **Perform transactions between accounts with transaction fees**
- **Check the balance of a specific account**
- **List all accounts**
- **Check the total transaction fee amount**
- **Check the total transfer amount**

## Application Structure

- **Main.java**: The entry point of the application. It handles user interaction and invokes methods from the Bank class.
- **Bank.java**: Manages accounts and transactions. Handles the logic for transaction fees and maintains total transaction and transfer amounts.
- **Account.java**: Represents a bank account with an ID, name, and balance. Provides methods to deposit and withdraw funds.
- **Transaction.java**: Represents a transaction with details such as amount, originating account, resulting account, and reason.

## How to Run the Application

1. **Download the application files**: Ensure you have the following Java files in the same directory:
   - `Main.java`
   - `Bank.java`
   - `Account.java`
   - `Transaction.java`

2. **Compile the application**:
   - Open a terminal or command prompt and navigate to the directory containing the Java files. Run the following command to compile the files:
     ```sh
     javac Main.java Bank.java Account.java Transaction.java
     ```

3. **Run the application**:
   - After compiling, run the application using the following command:
     ```sh
     java Main
     ```

## Usage Instructions

When you run the application, you will be greeted with a welcome message and asked to enter the transaction flat fee amount and transaction percent fee value. These fees will be applied to all transactions.

### Menu Options

- **Create Account**: Allows you to create a new account by entering an account ID, account holder name, and initial balance.
- **Perform Transaction**: Enables you to transfer money from one account to another. You need to provide the amount, originating account ID, resulting account ID, and transaction reason. Transaction fees will be applied.
- **Check Account Balance**: Displays the balance of a specific account by entering the account ID.
- **List All Accounts**: Lists all the accounts in the bank with their details.
- **Check Total Transaction Fee Amount**: Shows the total amount of transaction fees collected.
- **Check Total Transfer Amount**: Displays the total amount transferred across all transactions.
- **Exit**: Exits the application.
