Cash Compass 🧭: Personal Financial Tracker
Cash Compass is a full-stack personal finance application designed for clarity and ease of use. It allows users to securely track income, log expenses, manage shared bills, and visualize their financial health through interactive dashboards.

📂 Detailed Folder Structure
The project uses the standard Spring Boot structure, where the complete web UI is served from the static directory.

CashCompass/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/demo/Cash_Compass/
│   │   │       ├── CashCompassApplication.java   # Main entry point
│   │   │       ├── controller/                   # REST API endpoints (Auth, Trans., Cat.)
│   │   │       ├── service/                      # Business logic layer
│   │   │       ├── repository/                   # Spring Data JPA interfaces
│   │   │       ├── entity/                       # JPA entities (User, Transaction, Category)
│   │   │       └── security/                     # JWT and Security configuration
│   │   │
│   │   └── resources/
│   │       ├── static/                           # ⬅️ FRONTEND FILES ARE HERE
│   │       │   ├── index.html                    # Main Application Layout
│   │       │   ├── style.css                     # Custom CSS styles
│   │       │   └── script.js                     # Vanilla JavaScript application logic & API calls
│   │       │
│   │       └── application.properties/yml        # Database and server configuration
│   │
│   └── test/                                     # Unit and Integration Tests
│
├── .gitignore
├── pom.xml                                     # Maven build file (Dependencies)
└── README.md
✨ Key Features
Financial Dashboard: A responsive dashboard featuring a real-time balance summary, expense category breakdown (Doughnut Chart), and income vs. expense trends (Spline Chart).

Secure Authentication: Utilizes JWT (JSON Web Tokens) for secure registration and API access.

CRUD for Transactions & Categories: Full control over personal income and expense records, linked to custom categories.

Shared Expense Module: Manage group expenditures by creating shared transactions and tracking ownership/debt.

Modern UI: Clean, spacious, and responsive design built using HTML/CSS/JavaScript with Tailwind-like styling principles.

💻 Technology Stack
Component	Technology	Description
Backend/API	Java / Spring Boot	Core REST API layer handling persistence and security.
Data Access	Spring Data JPA	Robust ORM solution for database operations.
Frontend Core	HTML5 / Vanilla JS	Application structure and dynamic logic.
Styling	Custom CSS	Hand-crafted stylesheet optimized for modern, responsive aesthetics.
Data Vis	Chart.js	Library for rendering interactive financial graphs.
Build Tool	Maven (pom.xml)	Dependency management and build automation.

Export to Sheets
🚀 Local Setup Guide
To get a local copy up and running, you only need to build and run the single Spring Boot application.

Prerequisites
Java Development Kit (JDK 17 or higher)

Maven 3.6+

A database system (e.g., MySQL, PostgreSQL, or an embedded H2 for development)

Git

Step 1: Clone the Repository
Bash

git clone https://github.com/MrRajKumar07/CashCompass.git
cd CashCompass
Step 2: Configure and Run the Application
Configure Database: Edit the application settings in src/main/resources/application.properties (or .yml) to connect to your preferred database.

Build and Run: Use Maven to compile and start the Spring Boot application.

Bash

mvn clean install
mvn spring-boot:run
The application will typically start on http://localhost:8080 (or the port specified in your application.properties).

Step 3: Access the Frontend
Once the Spring Boot server is running, the embedded frontend will be available at the root URL.

Open your web browser and navigate to:

http://localhost:8080/
