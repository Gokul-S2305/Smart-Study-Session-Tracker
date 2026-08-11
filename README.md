# 📚 Smart Study Session Tracker

A simple Java-based console application that helps students record, analyze, and manage their study sessions.

The application allows users to track their study time, focus level, and notes, then generates useful productivity and subject-wise statistics.

---

## 🎯 Project Overview

Students often study for long hours without knowing how effectively they are using their time.

**Smart Study Session Tracker** solves this problem by allowing users to record each study session and analyze their study habits.

The application provides:

* Study session tracking
* Productivity analysis
* Subject-wise statistics
* Persistent data storage
* Input validation
* Personalized productivity recommendations

---

## ✨ Features

### 📝 Add Study Session

Record:

* Subject
* Duration in minutes
* Focus level from 1–10
* Study notes

### 📋 View All Sessions

View all previously recorded study sessions in an organized format.

### 📊 Productivity Report

The application calculates:

* Total study time
* Number of study sessions
* Average focus level
* Overall productivity level
* Productivity recommendation

Productivity is categorized as:

| Focus Level | Productivity |
| ----------- | ------------ |
| 9–10        | Excellent    |
| 7–8         | High         |
| 5–6         | Moderate     |
| 1–4         | Low          |

### 📚 Subject Statistics

Analyze study activity for each subject:

* Number of sessions
* Total study time
* Average focus level
* Most studied subject

### 💾 Save & Load

Study sessions are stored locally using Java File I/O.

The application automatically loads previously saved sessions when it starts.

### 🛡️ Input Validation

The application validates user input to prevent invalid data such as:

* Negative study duration
* Focus levels outside 1–10
* Empty subjects or notes
* Invalid numeric input
* Unsupported `|` characters used by the file format

---

## 🛠️ Technologies Used

* **Java**
* **ArrayList**
* **HashMap**
* **Object-Oriented Programming**
* **File I/O**
* **Exception Handling**
* **Scanner**

No external libraries or frameworks are required.

---

## 🧠 Java Concepts Demonstrated

This project demonstrates several core Java concepts:

* Classes and Objects
* Constructors
* Encapsulation
* Private fields
* Getters
* Methods
* ArrayList
* HashMap
* Loops
* Conditional Statements
* Switch Statements
* Exception Handling
* File Handling
* Input Validation

---

## 📂 Project Structure

```text
Smart-Study-Session-Tracker/
│
├── src/
│   ├── Main.java
│   └── StudySession.java
│
├── README.md
└── .gitignore
```

> `study_sessions.txt` is generated locally when the application saves data and is excluded from Git using `.gitignore`.

---

## 🖥️ Application Menu

```text
========================================
      SMART STUDY SESSION TRACKER
========================================

1. Add Study Session
2. View All Sessions
3. Productivity Report
4. Subject Statistics
5. Save Sessions
6. Exit

Enter your choice:
```

---

## 📊 Example Productivity Report

```text
========== PRODUCTIVITY REPORT ==========

Total Study Time : 270 minutes
Total Sessions   : 3
Average Focus    : 8.0 / 10
Productivity     : HIGH

Recommendation:
Great work! Your focus level is strong.
```

---

## 📚 Example Subject Statistics

```text
========== SUBJECT STATISTICS ==========

Java
Sessions      : 2
Total Time    : 210 minutes
Average Focus : 8.5/10

Python
Sessions      : 1
Total Time    : 60 minutes
Average Focus : 7.0/10

Most Studied Subject : Java
Total Study Time     : 210 minutes
```

---

## ⚙️ How to Run

### Prerequisites

Make sure Java is installed:

```bash
java -version
```

A standard JDK installation is sufficient.

### 1. Clone the repository

```bash
git clone https://github.com/Gokul-S2305/Smart-Study-Session-Tracker.git
```

### 2. Navigate to the project

```bash
cd Smart-Study-Session-Tracker
```

### 3. Compile the Java files

```bash
javac src/*.java
```

### 4. Run the application

```bash
java -cp src Main
```

---

## 🔄 How It Works

```text
              Start Application
                     │
                     ↓
             Load Saved Sessions
                     │
                     ↓
                 Main Menu
                     │
        ┌────────────┼────────────┐
        ↓            ↓            ↓
    Add Session   View Data    Generate Reports
        │                         │
        ↓                         ↓
    ArrayList                  Analysis
        │                         │
        └────────────┬────────────┘
                     ↓
                 Save Data
                     │
                     ↓
                    Exit
```

---

## 🔮 Future Improvements

The project can be extended with:

* 📅 Study streak tracking
* 📈 Weekly and monthly reports
* 🖥️ Java Swing/JavaFX GUI
* 🗄️ Database integration using MySQL or SQLite
* ⏱️ Pomodoro study timer
* 📊 Graphical data visualization
* 📄 PDF report generation
* 🎯 Study goals and progress tracking

---

## 👨‍💻 Author

**Gokul S**
