
# 💰 Expense Tracker (Java Swing)

Lightweight desktop app to **track daily expenses** with a clean Swing UI and simple **file-based storage** (no database).

---

## ✨ Features
- User Sign Up & Login (file-based auth)
- Add expenses with category, amount, description, date
- Filter expense list by **category** or **date (dd-mm-yyyy)**
- Update profile (email & password)
- Simple dashboard navigation
- Data saved in `repositories/data/` (`users.txt`, `expenses.txt`, `categories.txt`)

---

## 🖥️ Run the Project

### ✅ Easiest (Windows)
1. Download ZIP → Unzip  
2. **Double-click `run_project.bat`** 🚀  
   - Compiles & launches the app automatically

### ➕ Other (cross-platform manual)
```bash
javac */*.java *.java
java Start
````

---

## 🔐 Default Login

```
User ID: 101
Password: 1234
```

---

## 📂 Project Structure (short)

```
Expense Tracker/
  README.md
  Start.java
  run_project.bat
  entities/        # User, Expense, Category
  frames/          # Entry, Login, SignUp, Dashboard, AddExpense, ExpenseList, UpdateProfile
  interfaces/      # Repo interfaces
  repositories/    # FileIO + repos
  repositories/data/
    users.txt
    expenses.txt
    categories.txt
  (screenshots are in the repo root, see filenames below)
```

---

## 📸 Screenshots (with exact file names)

> All images are stored in the **repo root** next to `README.md`.

**File list**

* `Signin-Signup.png`
* `Screenshot 2025-10-01 004325.png`
* `Screenshot 2025-10-01 004338.png`
* `Screenshot 2025-10-01 004359.png`
* `Screenshot 2025-10-01 004437.png`
* `Screenshot 2025-10-01 004445.png`
* `Screenshot 2025-10-01 004504.png`
* `Screenshot 2025-10-01 004519.png`

### Gallery (2-column)

<!-- Using HTML for a neat responsive grid; spaces in filenames are URL-encoded as %20 -->

<div style="display:grid;grid-template-columns:repeat(auto-fill,minmax(320px,1fr));gap:12px;">

  <!-- Welcome -->

  <figure>
    <img src="Signin-Signup.png" alt="Welcome - Daily Expense Tracker (Signin-Signup.png)" />
    <figcaption>Welcome — <code>Signin-Signup.png</code></figcaption>
  </figure>

  <!-- Login -->

  <figure>
    <img src="Screenshot%202025-10-01%20004325.png" alt="Login - Daily Expense Tracker (Screenshot 2025-10-01 004325.png)" />
    <figcaption>Login — <code>Screenshot 2025-10-01 004325.png</code></figcaption>
  </figure>

  <!-- Sign Up -->

  <figure>
    <img src="Screenshot%202025-10-01%20004338.png" alt="Sign Up - Daily Expense Tracker (Screenshot 2025-10-01 004338.png)" />
    <figcaption>Sign Up — <code>Screenshot 2025-10-01 004338.png</code></figcaption>
  </figure>

  <!-- Dashboard -->

  <figure>
    <img src="Screenshot%202025-10-01%20004359.png" alt="Dashboard - Daily Expense Tracker (Screenshot 2025-10-01 004359.png)" />
    <figcaption>Dashboard — <code>Screenshot 2025-10-01 004359.png</code></figcaption>
  </figure>

  <!-- Add Expense -->

  <figure>
    <img src="Screenshot%202025-10-01%20004437.png" alt="Add Expense - Daily Expense Tracker (Screenshot 2025-10-01 004437.png)" />
    <figcaption>Add Expense — <code>Screenshot 2025-10-01 004437.png</code></figcaption>
  </figure>

  <!-- Expense Added dialog -->

  <figure>
    <img src="Screenshot%202025-10-01%20004445.png" alt="Expense Added - Daily Expense Tracker (Screenshot 2025-10-01 004445.png)" />
    <figcaption>Expense Added — <code>Screenshot 2025-10-01 004445.png</code></figcaption>
  </figure>

  <!-- Expense List -->

  <figure>
    <img src="Screenshot%202025-10-01%20004504.png" alt="Expense List - Daily Expense Tracker (Screenshot 2025-10-01 004504.png)" />
    <figcaption>Expense List — <code>Screenshot 2025-10-01 004504.png</code></figcaption>
  </figure>

  <!-- Update Profile -->

  <figure>
    <img src="Screenshot%202025-10-01%20004519.png" alt="Update Profile - Daily Expense Tracker (Screenshot 2025-10-01 004519.png)" />
    <figcaption>Update Profile — <code>Screenshot 2025-10-01 004519.png</code></figcaption>
  </figure>

</div>

---

## ⚠️ Notes

* Best on **Windows** via `.bat`; Linux/macOS use manual `javac` + `java Start`
* Plain-text storage → not for concurrent multi-user use

---

## 📄 License

All Rights Reserved (or switch to MIT if open-source).

```

If you later move the images into a folder (e.g., `docs/screenshots/`), tell me and I’ll update every path in one go.
```
