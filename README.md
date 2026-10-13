# Student Book 📚

A Java-based command-line application for managing student records. This project demonstrates Object-Oriented Programming (OOP), basic control flow, and TXT file handling for persistent data storage.

## 📌 Application Identity

- **Project name:** Student Book
- **Repository name:** `StudentBook`
- **Application type:** Command-Line Interface (CLI)
- **Language:** Java
- **Data storage:** Plain-text file (`mahasiswa.txt`)

## 🎯 Purpose

Student Book is designed to make basic student data management simple through a terminal menu. It was developed as a learning project to practice Java fundamentals, including classes and objects, methods, conditional statements, loops, input handling, and file I/O.

## ✨ Features

- **Add student records** — enter a student's name, NIM, and grade.
- **Display student records** — view the students currently stored in the application.
- **Search by NIM** — find a student using their student identification number.
- **View statistics** — see a summary of student grades.
- **Delete student records** — remove a record using its NIM.
- **Evaluate passing status** — determine whether a student passes based on the application's grade threshold.
- **Persistent storage** — load records from and save records to `mahasiswa.txt`, so valid records can remain available after the application closes.

> Passing threshold: a grade of **60 or higher** is considered passing.

## 🧰 Technologies Used

- **Java** — application logic and object-oriented programming.
- **Java standard library** — `Scanner` for terminal input and file I/O classes such as `FileReader`, `BufferedReader`, `FileWriter`, and `BufferedWriter`.
- **TXT file** — simple local storage for student records.
- **Git and GitHub** — source-code version control and repository hosting.

## 📁 Project Structure

```text
StudentBook/
├── Main.java          # Main menu and application flow
├── Mahasiswa.java     # Student data and related methods
├── mahasiswa.txt      # Student records (created/updated by the app)
└── README.md          # Project documentation
```

`mahasiswa.txt` may be created when the application saves data. If the file does not exist, the application can initialize its starting data according to the program logic.

## ⚙️ Requirements

- Java Development Kit (JDK) installed.
- A terminal application.
- Git is optional if you download the source code as a ZIP file.

Check that Java is available:

```bash
java -version
javac -version
```

If either command is unavailable, install a JDK and configure it for your operating system.

## 🚀 Installation and Setup

### 1. Clone the repository

Replace `YOUR_USERNAME` with your GitHub username:

```bash
git clone https://github.com/YOUR_USERNAME/student-book.git
```

### 2. Enter the project directory

```bash
cd student-book
```

### 3. Compile the source files

```bash
javac Main.java Mahasiswa.java
```

### 4. Run the application

```bash
java Main
```

Run the commands from the project directory so the application reads and writes `mahasiswa.txt` in the expected location.

## 💻 Example Usage

After running `java Main`, follow the menu displayed in the terminal. The available menu options include:

1. Add a student.
2. Display all students.
3. Search for a student by NIM.
4. View grade statistics.
5. Delete a student by NIM.
6. Exit the application.

### Example student data

```text
Name : Andi Pratama
NIM  : 2301001
Grade: 85.5
```

A record is stored in `mahasiswa.txt` using this format:

```text
Andi Pratama|2301001|85.5
```

The fields are separated by the `|` character: `name|NIM|grade`. Use the application's menu to add, search for, display, or delete records.

## 🧠 Concepts Demonstrated

- **Class and object:** student records are represented by the `Mahasiswa` class and its objects.
- **Encapsulation and methods:** student data and related operations are organized in a class.
- **Conditional statements:** used to evaluate passing status and handle menu choices.
- **Loops:** used to keep the menu running and process records.
- **Input validation:** user input is checked where implemented in the program.
- **File handling:** records are read from and written to a local TXT file.

## 📝 Notes and Limitations

- This is a local CLI application; it does not use a database server.
- The TXT file is stored relative to the directory from which the application is run.
- Avoid manually changing the file format. Each record should use `name|NIM|grade`, with one student per line.
- This project is intended for learning and demonstration, not as a production student information system.

## 👨‍💻 Author

Created as a Java programming and Object-Oriented Programming learning project.

---

If you find this project useful for learning Java fundamentals, feel free to explore the source code and adapt it for practice.
