# Expense Tracker (Java Swing)

A lightweight desktop app to **track daily expenses** with simple file-based storage.  
Built using **Java Swing** — no database required.

---

## ✨ Features
- Add, edit, and view expenses
- Organize by categories
- User login & signup (file-based auth)
- Simple dashboard
- Data saved in text files under `repositories/data/`

---

## 🖥️ Run the Project

### Easiest Way (Windows)
1. Download the project  
2. Unzip it  
3. **Double-click `run_project.bat`**  
   - It compiles and launches automatically 🎉

### Other Way (Manual Compile)
From project root **(CMD)**:

```bash
# Compile all Java files
javac */*.java *.java
# Run the app
java Start
````

---

## 🔐 Default Login

```
User ID: 101
Password: 1234
```

---

## 📂 Project Structure

```
Expense Tracker/
  Start.java
  run_project.bat
  entities/        # Models
  frames/          # Swing UI
  interfaces/      # Repo interfaces
  repositories/    # File-based repos + data files
```

---

## 📸 Screenshots (add yours here)

* ![Dashboard](docs/screenshots/dashboard.png)
* ![Add Expense](docs/screenshots/add-expense.png)
* ![Login](docs/screenshots/login.png)

---

## ⚠️ Notes

* Works best on **Windows (with .bat file)**
* Cross-platform via manual `javac` + `java Start`
* Stores data in plain text files (no DB)

---

## 📄 License

No Rights Reserved.
```

