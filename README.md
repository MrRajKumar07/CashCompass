# Cash Compass 🧭: Personal Financial Tracker

**Cash Compass** is a full-stack personal finance application designed for clarity and ease of use. It allows users to securely track income, log expenses, manage shared bills, and visualize their financial health through interactive dashboards.

---

## ✨ Key Features

* **Financial Dashboard:** A responsive dashboard featuring a real-time balance summary, expense category breakdown (Doughnut Chart), and income vs. expense trends (Spline Chart).
* **Secure Authentication:** Utilizes **JWT (JSON Web Tokens)** for secure registration and API access.
* **CRUD for Transactions & Categories:** Full control over personal income and expense records, linked to custom categories.
* **Shared Expense Module:** Manage group expenditures by creating shared transactions and tracking ownership/debt.
* **Modern UI:** Clean, spacious, and responsive design built using HTML/CSS/JavaScript with Tailwind-like styling principles.

---

## 💻 Technology Stack

| Component | Technology | Description |
| :--- | :--- | :--- |
| **Backend/API** | **Java / Spring Boot** | Core REST API layer handling persistence and security. |
| **Data Access** | **Spring Data JPA** | Robust ORM solution for database operations. |
| **Frontend Core** | **HTML5 / Vanilla JS** | Application structure and dynamic logic. |
| **Styling** | **Custom CSS** | Hand-crafted stylesheet optimized for modern, responsive aesthetics. |
| **Data Vis** | **Chart.js** | Library for rendering interactive financial graphs. |
| **Build Tool** | **Maven (pom.xml)** | Dependency management and build automation. |

---

## 📂 Detailed Folder Structure
```text
CashCompass/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/demo/Cash_Compass/
│   │   │       ├── CashCompassApplication.java        # Main entry point
│   │   │       ├── controller/                        # REST API endpoints (Auth, Transactions, Category)
│   │   │       ├── service/                           # Business logic layer
│   │   │       ├── repository/                        # Spring Data JPA interfaces
│   │   │       ├── entity/                            # JPA entities (User, Transaction, Category)
│   │   │       └── security/                          # JWT & Security configuration
│   │   └── resources/
│   │       ├── static/                                # ⬅️ Frontend files
│   │       │   ├── index.html                         # Main layout
│   │       │   ├── style.css                          # Custom CSS
│   │       │   └── script.js                          # Vanilla JS & API calls
│   │       ├── application.properties or .yml        # DB & server config
│   │       └── test/                                  # Unit & integration tests
├── .gitignore
├── pom.xml                                           # Maven build file
└── README.md
```
## 📸 Screenshots / Demo

<p align="left">
  <img src="https://github.com/user-attachments/assets/0610adad-151f-43c0-aefd-85a411358b21" alt="Screenshot 1" width="800"/>
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/25103ac0-eeb2-4b2b-a12e-5e3a1d17206b" alt="Screenshot 2" width="800"/>
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/c0e912f6-3c43-4d19-94cf-b4e4c0861967" alt="Screenshot 3" width="800"/>
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/3dfb03fe-9456-4a94-b8e0-1d3737d92a75" alt="Screenshot 4" width="800"/>
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/1f353b47-7bd2-46b4-9861-3f75eb920322" alt="Screenshot 5" width="800"/>
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/aa7874b5-b276-4419-878a-d9ac57fd7d1b" alt="Screenshot 6" width="800"/>
</p>

<p align="left">
  <img src="https://github.com/user-attachments/assets/3cdd5fdd-71cb-49ab-81e1-17a710aca3c5" alt="Screenshot 7" width="800"/>
</p>

## 🚀 Local Setup Guide

To get a local copy up and running, you only need to build and run the single Spring Boot application.

### Prerequisites

* **Java Development Kit (JDK 17** or higher)
* **Maven** 3.6+
* A database system (e.g., MySQL, PostgreSQL, or an embedded H2 for development)
* **Git**

### Step 1: Clone the Repository

```bash
git clone [https://github.com/MrRajKumar07/CashCompass.git](https://github.com/MrRajKumar07/CashCompass.git)
cd CashCompass
```
The project uses the standard Spring Boot structure, with the entire web UI served directly from the `static` resource directory.

### Step 2: Configure and Run the Application
**Configure Database** : Edit the application settings in src/main/resources/application.properties (or .yml) to connect to your preferred database.

**Build and Run** : Use Maven to compile and start the Spring Boot application.

Bash

```bash
mvn clean install
mvn spring-boot:run
```

### Step 3: Access the Frontend
Once the Spring Boot server is running (typically on port 8080), the embedded frontend is available at the root URL.

Open your web browser and navigate to:
```bash
http://localhost:8080/
```

### 📝 Usage
**Auth** : Use the Login and Create one links to register and authenticate.

**Dashboard** : On login, view your balance and summary charts (requires data).

**Transaction** : Use the form to record new income (+ve) or expenses (-ve).
