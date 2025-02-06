# VentaPro

## Description
This project was developed as the final assignment for the **Fundamentals of Software Development** course. The goal is to create a **complete sales system** for an online store, handling **product management, inventory control, budget generation, and sales analysis**. The system is designed with **scalability, maintainability, and adaptability** in mind, incorporating **design patterns and clean architecture principles**.

## Features
- **Product Management**: Add, update, and delete products with detailed attributes (code, description, price, and stock levels).
- **Budget Generation**: Create custom budgets for customers, including items, costs, taxes, discounts, and final amounts.
- **Discount Strategies**: Implement discount policies based on customers' purchase history and seasonal periods.
- **Budget Validity**: Define specific expiration dates for budgets.
- **Statistical Analysis**: Provide insights into sales trends using a statistical module.
- **Inventory Control**: Efficiently manage stock across multiple storage locations.

## System Architecture
The system follows the **Clean Architecture** principles to ensure modularity and maintainability. It consists of the following layers:

1. **Domain Layer**: Contains entities and interfaces representing the core business logic.
2. **Application Layer**: Manages system requests and orchestrates business operations.
3. **Infrastructure Layer**: Handles database access and external dependencies.
4. **Interface Layer (Controllers)**: Manages user interaction and API endpoints.

Additionally, the system implements the **Strategy Pattern** for flexible discount calculations, allowing easy modifications without altering the core logic.

## Technologies Used
- **Backend**:
  - Language: Java
  - Framework: Spring Boot
  - Dependency Management: Maven
  - Database: [Specify database, e.g., PostgreSQL, MySQL]

- **Frontend**:
  - Language: JavaScript
  - Framework/Library: Vue.JS
  - Package Management: npm

## Installation & Execution
### Backend
1. Clone the repository:
   ```sh
   git clone https://github.com/LGMarques9963/FDS-TF-Sistema-de-Vendas.git
   cd FDS-TF-Sistema-de-Vendas/backend
   ```
2. Build and run the backend:
   ```sh
   mvn install
   mvn spring-boot:run
   ```
   The backend will be available at `http://localhost:8080`.

### Frontend
1. Navigate to the frontend directory:
   ```sh
   cd ../frontend/fds-tf-sistema-de-venda
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the frontend:
   ```sh
   npm run serve
   ```
   The frontend will be available at `http://localhost:8081`.

## Usage
Once both the backend and frontend are running, users can access the system to:
- Manage products and stock levels.
- Generate and manage customer budgets.
- Apply dynamic discount policies.
- View statistical insights on sales performance.

## Contributors
- Eduardo Kumiechick
- Lavinia Winter
- Lorran Marques
- Pedro Henrique Reis

## License
This project is for educational purposes and does not include a specific license.
