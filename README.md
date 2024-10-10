Automation Project for ATID Demo Store

This project is an automation framework designed for the ATID Demo Store using Selenium and JUnit5. The framework follows the Page Object Model (POM), adheres to SOLID principles, and implements Clean Code practices.

 Project Overview
The automation framework aims to facilitate the testing of various functionalities of the ATID Demo Store. The framework is structured to enable easy maintenance and scalability, focusing on modular design and reusability.

Page Object Model (POM)
The Page Object Model (POM) is a design pattern that enhances test maintenance and reduces code duplication. In this project:
- Each page of the application has a corresponding class that encapsulates the functionality and elements of that page.
- Page classes include methods for interactions and navigation, making test cases more readable and easier to understand.

For example, the `HomePage`, `ProductSelector`, and `CartManager` classes represent distinct parts of the application, providing a clear separation of concerns.

 SOLID Principles
The project adheres to SOLID principles, ensuring that the design is robust and maintainable:

- **Single Responsibility Principle (SRP):** Each class is responsible for a single part of the functionality. For instance, the `CartManager` class handles cart operations, while the `FormFilling` class is responsible for filling out forms.
  
- **Open/Closed Principle (OCP):** Classes are open for extension but closed for modification. New functionality can be added by creating new classes without altering existing code.

- **Liskov Substitution Principle (LSP):** Subtypes can be substituted for their base types without affecting the correctness of the program. This is achieved by using interfaces like `Navigatable` and `BrowserDriver`.

- **Interface Segregation Principle (ISP):** Clients should not be forced to depend on interfaces they do not use. The interfaces are designed to be specific to their purpose.

- **Dependency Inversion Principle (DIP):** High-level modules do not depend on low-level modules but rather on abstractions. This is evident in the use of the `BrowserDriver` interface, allowing for different browser implementations.

## Clean Code Practices
Clean Code principles are followed to improve readability and maintainability:
- Meaningful names are used for classes, methods, and variables, making the code self-documenting.
- Functions are kept small and focused on a single task.
- Proper error handling is implemented to avoid unexpected behaviors during test execution.

## Installation
To set up the project, clone the repository and install the required dependencies:
```bash
git clone https://github.com/yourusername/your-repo.git
cd your-repo
# Install dependencies (e.g., using Maven)




