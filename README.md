```text
███████╗████████╗██╗   ██╗██████╗ ███████╗███╗   ██╗████████╗   ██████╗  ██████╗  ██████╗ ██╗  ██╗
██╔════╝╚══██╔══╝██║   ██║██╔══██╗██╔════╝████╗  ██║╚══██╔══╝   ██╔══██╗██╔═══██╗██╔═══██╗██║ ██╔╝
╚█████╗    ██║   ██║   ██║██║  ██║█████╗  ██╔██╗ ██║   ██║      ██████╔╝██║   ██║██║   ██║█████╔╝
 ╚═══██╗   ██║   ██║   ██║██║  ██║██╔══╝  ██║╚██╗██║   ██║      ██╔══██╗██║   ██║██║   ██║██╔═██╗
██████╔╝   ██║   ╚██████╔╝██████╔╝███████╗██║ ╚████║   ██║      ██████╔╝╚██████╔╝╚██████╔╝██║  ██╗
╚═════╝    ╚═╝    ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝      ╚═════╝  ╚═════╝  ╚═════╝ ╚═╝  ╚═╝
```

Student Book is a CLI application for managing student records.

## Features

- Add student records with a name, NIM, and grade
- Display all saved student records
- Search for a student by NIM
- View student grade statistics
- Delete a student record by NIM
- Evaluate passing status based on the grade threshold
- Save and load records through `mahasiswa.txt`

**Passing threshold:** A grade of **60 or higher** is considered passing.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Application logic and object-oriented programming |
| Java standard library | Terminal input and file handling |
| TXT file | Local storage for student records |
| Git and GitHub | Version control and source-code hosting |

## Project Structure

```text
StudentBook/
├── Main.java          # Main menu and application flow
├── Mahasiswa.java     # Student data and related methods
├── mahasiswa.txt      # Student records (created/updated by the app)
└── README.md          # Project documentation
```

The `mahasiswa.txt` file may be created when the application saves data. If it does not exist, the application follows its startup logic to initialize data.

## Requirements

- Java Development Kit (JDK)
- Terminal application
- Git (optional, if downloading the source as a ZIP)

### RUN

```text
javac Main.java Mahasiswa.java
java Main
```

Run these commands from the project directory so the application can find and update `mahasiswa.txt` in the expected location.

## Usage

Start the application with `java Main` and choose an option from the terminal menu.

| Menu option | Action |
|---|---|
| Add student | Enter a student's name, NIM, and grade |
| Display students | View saved student records |
| Search by NIM | Find a student using their NIM |
| Statistics | View a summary of student grades |
| Delete by NIM | Remove a student record |
| Exit | Close the application |

## Java Concepts Demonstrated

- **Classes and objects**    : represent student records using the `Mahasiswa` class
- **Methods**                : organize student-related operations
- **Conditional statements** : handle menu choices and passing status
- **Loops**                  : keep the menu running and process records
- **Input handling**         : receive data from the terminal
- **File handling**          : read and write student records in a TXT file

## Limitations

```text
</>  Data is stored locally in a text file; no database server is used.
</>  The application runs in the terminal and does not provide a graphical interface.
</>  The project is intended for learning and demonstration, not as a production student information system.
```


---

<div align="center">

**Student Book** · Java CLI Project

</div>
