@echo off
REM ---------------------------
REM Step 1: Delete all old .class files
REM ---------------------------
echo 🔄 Deleting old .class files...
for /R %%f in (*.class) do del "%%f"

REM ---------------------------
REM Step 2: Compile all .java files recursively
REM ---------------------------
echo 🧠 Compiling all Java files...
for /R %%f in (*.java) do (
    echo Compiling %%f
    javac "%%f"
)

IF %ERRORLEVEL% NEQ 0 (
    echo ❌ Compilation failed.
    pause
    exit /b
)

REM ---------------------------
REM Step 3: Run the program
REM ---------------------------
echo ▶️ Running the program...
java Start

REM ---------------------------
REM Step 4: Delete all .class files after execution
REM ---------------------------
echo 🧹 Cleaning up .class files...
for /R %%f in (*.class) do del "%%f"

echo ✅ Done. Press any key to exit.
pause
