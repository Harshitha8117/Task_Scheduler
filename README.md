
# Task Scheduler CLI

A lightweight, multithreaded command-line tool built in Java to schedule and execute tasks after delays or at intervals. Includes dynamic task creation, editing, and deletion, demonstrating low-level system control and efficient time-based logic.

---

## Features

- Schedule tasks with custom delays and repeat options  
- Multithreaded task execution using Java concurrency  
- Dynamic task management via an intuitive CLI menu  
- Task status tracking: Pending, Running, Completed  
- Minimal HTML/CSS dashboard & real-time log viewer (optional)  

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher installed  
- Git (optional, for version control)  

### Running the Project

1. Clone this repo:

   ```bash
   git clone https://github.com/<your-username>/task-scheduler-cli.git
   cd task-scheduler-cli/src
````

2. Compile Java files:

   ```bash
   javac *.java
   ```

3. Run the CLI app:

   ```bash
   java Main
   ```

4. (Optional) Open `html/index.html` or `html/logviewer.html` in a browser for dashboard and logs.

---

## Usage

* Use the CLI menu to add, view, or delete tasks.
* Tasks can be one-time or repeating.
* Task execution logs print to the console and optionally to `logs.txt`.

---

## Project Structure

```
/
├── src/                   # Java source files
│   ├── Main.java
│   ├── Task.java
│   ├── TaskScheduler.java
│   ├── TaskWorker.java
│   └── Utils.java
├── html/                  # Static HTML/CSS dashboard and log viewer
│   ├── index.html
│   ├── style.css
│   └── logviewer.html
├── logs.txt               # Task execution logs (generated at runtime)
└── README.md              # This file
```

---

## Future Enhancements

* GUI frontend with JavaFX or Electron
* REST API for remote task scheduling
* Persist tasks using a lightweight database
* Enhanced input validation and error handling

---

## License

MIT License © 2025 Harshitha

---

Made with 🚀 for efficient task scheduling and innovation.

```

