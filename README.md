# User Management Console Application

A simple Java console application for managing user accounts with balance operations. Users can be created, deposit/withdraw funds, check balance, and list all users. The data is automatically persisted to a local file (`users.user`) using Java serialization, so the user list is preserved between program runs.

## Features

- **Create a new user** – with a name and initial balance.
- **Deposit money** – add funds to an existing user's account.
- **Withdraw money** – subtract funds if sufficient balance exists.
- **Check balance** – view the current balance of a specific user.
- **List all users** – display all registered users and their balances.
- **Persistent storage** – user data is saved to `users.user` in the working directory upon exit and loaded on startup.

## Requirements

- No external libraries – uses only standard JDK classes.

## Project Structure

```
.
├── Main.java          – Console menu and user interaction
├── User.java          – Data model (name, balance, deposit/withdraw logic)
├── UserService.java   – Business logic, in‑memory storage, persistence
├── users.user         – Serialized data file (auto‑generated)
└── README.md
```

## Usage

After starting the program, you will see a menu:

```
***************
MENU
***************
1. Create user
2. Deposit
3. Withdraw
4. Show balance
5. List all users
6. Exit
Choose option:
```

- Enter the number corresponding to the action and follow the prompts.
- The application will save all data automatically when you choose **Exit** (option 6) or when the program terminates.

## Persistence Details

- The `UserService` class uses Java `ObjectOutputStream`/`ObjectInputStream` to serialize the `HashMap<String, User>`.
- The file `users.user` is created in the same directory as the application.
- If the file exists, data is loaded automatically when the application starts.
- If the file is missing, a new empty user list is created.

## Design Notes

- **Separation of concerns**:  
  - `User` – pure data model with business rules (validation of deposit/withdraw).  
  - `UserService` – manages the collection and persistence.  
  - `Main` – handles console I/O and user interaction.
- **Error handling**: Basic validation is performed (e.g., duplicate names, negative amounts, insufficient funds).

## License

This project is for educational purposes. You are free to use and modify it as needed.
