## Digital Banking Portal

![Digital Banking Portal Logo](https://github.com/PauleenSayat/SayatPauleenJoy-CS2102_OOPactivities/blob/main/Final%20Project/Digital%20Banking%20Portal/Digital%20Banking%20Portal%20logo.webp)

### For OOP:

#### I. Project Overview:
The Digital Banking Portal is a Java-based application designed to simulate a banking system. Users can sign up, log in, deposit, withdraw, check their account balance, and view transaction histories. The system also provides an admin interface to monitor transactions.

#### II. Application of OOP Principles:
1. **Encapsulation**:
   - Classes like `AccountDB`, `UserDB`, and `TransactionDB` encapsulate specific functionalities, such as managing account transactions or user authentication.
   - Fields like `accountNumber` are private and accessed through methods.

2. **Abstraction**:
   - Implementation details, such as database queries, are hidden from the user-facing components.
   - High-level functionalities, such as "Deposit" or "View Transactions," are simplified for the user.

3. **Inheritance**:
   - While inheritance is not prominently used, modularization in classes reflects the logical hierarchy of operations and responsibilities.

4. **Polymorphism**:
   - Methods like `viewTransactions` are designed to handle varied data dynamically.

#### III. Integration of SDG:
**SDG 9: Industry, Innovation, and Infrastructure**
- The Digital Banking Portal addresses SDG 9 by fostering innovation in digital financial systems. The project emphasizes secure and efficient management of financial data, promoting accessible banking solutions and sustainable infrastructure development.

#### IV. Instructions for Running the Program:
1. Ensure you have Java and MySQL installed on your system.
2. Import the MySQL database schema provided (`init.sql`).
3. Update the `DatabaseManager` class with your database credentials.
4. Compile the Java files using `javac`.
5. Run the `DigitalBankingDB` main program using `java`.

---

### For Database:

#### Project Explanation:
The database is an integral part of the Digital Banking Portal. It handles user credentials, account information, and transaction logs, ensuring data integrity and efficient data retrieval.

#### Database Usage:
1. **Users Table**:
   - Stores user credentials (`username`, `password`).
   - Ensures unique usernames.

2. **Accounts Table**:
   - Links each user to a unique account via `userID`.
   - Manages account numbers and balances.

3. **Transactions Table**:
   - Records all transaction activities, including deposits and withdrawals.
   - Provides timestamps and transaction metadata for user and admin references.

The database enables real-time updates and retrievals for account balances and transaction histories, facilitating secure and seamless banking operations.

