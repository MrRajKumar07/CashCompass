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
The project uses the standard Spring Boot structure, with the entire web UI served directly from the `static` resource directory.
