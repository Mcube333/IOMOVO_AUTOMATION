# 🚀 IOMOVO Automation Framework

## 📌 Overview

The **IOMOVO Automation Framework** is a **Selenium-based automation framework** designed to streamline the testing process for the IOMOVO application. Built using **Java, TestNG, and Maven**, it ensures a robust, scalable, and efficient test automation strategy.

---

## 📂 Project Structure

```
IOMOVO_AUTOMATION
│── src/main/java
│   ├── com.iomovo.basepackage                  # Base classes and utilities
│   ├── com.iomovo.pagespackage                 # Page Object Model (POM) classes
│   │   ├── ConvertFunctionality
│   │   ├── CopyFunctionality
│   │   ├── DashboardFunctionality
│   │   ├── EncodeFunctionality
│   │   ├── InsightsFunctionality
│   │   ├── IoPortalFunctionality
│   │   ├── MoveFunctionality
│   │   ├── ScheduleCopyFunctionality
│   ├── com.iomovo.utilspackage                 # Utility functions
│
│── src/test/java
│   ├── com.iomovo.basetest                     # Base test classes
│   ├── com.iomovo.converttests                 # Test cases for Convert Functionality
│   ├── com.iomovo.copytests                    # Test cases for Copy Functionality
│   ├── com.iomovo.dashboardtests               # Test cases for Dashboard
│   ├── com.iomovo.encode                       # Test cases for Encode Functionality
│   ├── com.iomovo.ioportaltests                # Test cases for IoPortal
│   ├── com.iomovo.movetests                    # Test cases for Move Functionality
│
│── src/test/resources                          # Test data and configurations
│── 🖥️ Drivers                                  # WebDriver executables
│── 📊 ExtentReports                            # Test execution reports
│── 📁 FilesToUpload                            # Sample files for testing uploads
│── ⚙️ PropertyFiles                            # Configuration properties
│── 📸 ScreenShots                              # Failure screenshots
│── 📜 pom.xml                                  # Maven dependencies and configurations
│── 🔁 RegressionSuite.xml                      # TestNG regression suite
│── 🧪 testng.xml                               # TestNG suite file
```

---

## ⚙️ Prerequisites

Ensure you have the following installed:

✅ **Java** (JDK 1.8 or higher)

✅ **Maven** (Latest version)

✅ **TestNG**

✅ **Selenium WebDriver**

✅ **Browser Drivers** (ChromeDriver, GeckoDriver, etc.)

---

## 🚀 Installation & Setup

1️⃣ Clone the repository:

```sh
git clone <repository-url>
```

2️⃣ Navigate to the project directory:

```sh
cd IOMOVO_AUTOMATION
```

3️⃣ Install dependencies:

```sh
mvn clean install
```

---

## 🏃 Running Tests

🔹 To execute all tests:

```sh
mvn test
```

🔹 To execute tests using TestNG XML:

```sh
mvn test -DsuiteXmlFile=testng.xml
```

🔹 To run regression tests:

```sh
mvn test -DsuiteXmlFile=RegressionSuite.xml
```

---

## 📊 Reporting

✅ **Extent Reports**: Located in the `ExtentReports/` folder after test execution.

✅ **Screenshots**: Captured for failed test cases and stored in `ScreenShots/`.

---

## 📁 Folder Descriptions

- ``: Core framework code, including base classes, Page Object classes, and utilities.
- ``: Test cases for various modules.
- ``: Holds browser driver executables.
- ``: Stores execution reports.
- ``: Contains test data files for upload tests.
- ``: Holds configuration files for test execution.
- ``: Stores failure screenshots.

---

## 🛠️ Technologies Used

🚀 **Selenium WebDriver** - For UI Automation

🚀 **Java** - Programming language

🚀 **TestNG** - Test execution and reporting

🚀 **Maven** - Build automation and dependency management

---

## 🤝 Contributing

Want to contribute? Follow these steps:

1️⃣ Fork the repository.

2️⃣ Create a feature branch (`git checkout -b feature-branch`).

3️⃣ Commit your changes (`git commit -m 'Add new feature'`).

4️⃣ Push to the branch (`git push origin feature-branch`).

5️⃣ Open a Pull Request.

---

✨ Author: Mohammed Mudassir Maniyar

---



