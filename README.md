# SECURITY Svcs Java Application

## 🚀 How to Run

### 1. Requirements

- Java 8 or higher
- NetBeans or IntelliJ IDEA
- [`sqlite-jdbc-3.23.1.jar`](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.23.1)

---

### 2. Database Initialization

Before running for the first time, you need to create the database and tables.

1. **Open `Main.java` in your IDE.**
2. **Find and uncomment the commented lines:**
3. **Run the application once.**  
   This will generate `database.db` and all necessary tables.
4. **Comment those lines back after the first run:**


### 3. Adding SQLite JDBC Library (IntelliJ IDEA)

1. In IntelliJ:
    - Go to **File > Project Structure**
    - Go to **Libraries**
    - Click **+** → **Java**
    - Use the sqlite jar found in the project root `sqlite-jdbc-3.23.1.jar`
    - Click **OK/Apply**
2. Make sure the JAR is in your build path or module dependencies.

---

### 4. Viewing & Editing `database.db` in IntelliJ IDEA

1. In the **Project** sidebar, right-click on `database.db` and choose **"Open Database"** or **"Open with DataGrip"** if you have the database tools plugin.
2. If you do not see the option, do this:
    - Go to **View > Tool Windows > Database**
    - Click the **+** (Add) button > **Data Source > SQLite**
    - For **Database file**, browse and select your `database.db`
    - Click **OK**
3. You can now view, browse, and edit tables directly from IntelliJ’s **Database** window.

---

### 5. Running the Program

- Make sure the database initialization code is uncommented **only for the first run**.
- Run `Main.java`.
- Register a user
- If you see errors about duplicate tables or users, **comment out the initialization code and run again**.

---

### 6. Troubleshooting

- **No suitable driver found for jdbc:sqlite:database.db**
  - Make sure you added the `sqlite-jdbc-3.23.1.jar` library to your project.

- **Duplicate entry/user/table errors**
  - Only run the initialization code once. Comment it out for all future runs.

---

### 7. Notes

- All user data is stored in the local `database.db` file.
- Passwords are securely hashed and salted before storage.
- This application currently secures only the Login and Registration features.
- More security features can be added as needed.

---