
# Perkémon

**Perkémon** is a customer loyalty program that rewards users with points based on their spending. The system classifies customers into different tiers—Beginner, Intermediate, Elite, and Legend—each offering different rewards. The project is implemented in Java, using Swing for the graphical user interface (GUI).

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Customer Tiers and Rewards](#customer-tiers-and-rewards)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Customer Registration**: Register new customers with a name, phone number, and address.
- **Customer Login**: Existing customers can log in using their phone number.
- **Transaction Management**: Add transactions for customers, automatically updating their tier and reward points.
- **Customer Tiers**: Automatically upgrade customer tiers based on their spending history.
- **Previous Transactions**: View a history of a customer’s transactions.
- **GUI**: User-friendly interface built using Java Swing.

## Technologies Used

- **Java**: Core programming language.
- **Java Swing**: Used to build the graphical user interface.
- **Git**: Version control system to manage the project.
- **GitHub**: Platform to host and share the project repository.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or later.
- An IDE like Visual Studio Code or IntelliJ IDEA.
- Git (for version control).

### Steps

1. **Clone the repository**:
   \`\`\`sh
   git clone https://github.com/devangk003/Custome-Reward-Points-System-JAVA-Perkemon.git
   \`\`\`
2. **Navigate to the project directory**:
   \`\`\`sh
   cd Custome-Reward-Points-System-JAVA-Perkemon
   \`\`\`
3. **Compile the project**:
   - If using an IDE, simply open the project and build it.
   - If using the command line:
     \`\`\`sh
     javac -d bin src/com/yourcompany/customerrewardpoints/*.java
     \`\`\`
4. **Run the project**:
   \`\`\`sh
   java -cp bin com.yourcompany.customerrewardpoints.Main
   \`\`\`

## Usage

### Main Menu

- **Register New User**: Allows you to register a new customer.
- **Login (For Existing Users)**: Allows an existing customer to log in.

### Customer Menu (After Login)

- **Add Transaction**: Add a new transaction for the logged-in customer.
- **Show Previous Transactions**: View the transaction history of the logged-in customer.
- **Logout**: Log out of the current session.

## Customer Tiers and Rewards

| Tier        | Spending Threshold (INR) | Reward Percentage | Maximum Points per Transaction |
|-------------|--------------------------|-------------------|--------------------------------|
| Beginner    | 100                       | 5%                | 50                             |
| Intermediate| 399                       | 10%               | 75                             |
| Elite       | 699                       | 15%               | 100                            |
| Legend      | 999                       | 20%               | 150                            |


## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes. Ensure that your code adheres to the coding standards used in this project.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
