@echo off
SETLOCAL

REM Check if python_runtime exists
IF NOT EXIST "python_runtime\python.exe" (
    echo Portable Python environment not found.
    echo Attempting to install it now...
    powershell -ExecutionPolicy Bypass -File install_env.ps1
)

IF NOT EXIST "python_runtime\python.exe" (
    echo Error: Python environment setup failed or was not found.
    echo Please ensure you have internet access to download it initially.
    PAUSE
    EXIT /B
)

echo Running Assignment using Portable Python...
echo ----------------------------------------

REM Run the Main.py using the local python.exe
REM We pipe input.txt into it as requested by the assignment flow
"python_runtime\python.exe" python/Main.py < input.txt

echo.
echo ----------------------------------------
echo Execution Complete.
PAUSE
