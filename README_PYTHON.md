# Python Version - Portable Execution Guide

This project includes a portable Python setup mechanism, allowing it to run on Windows computers that do not have Python installed.

## How to Run

Simply double-click **`start.bat`**.

- **First Run**: The script will automatically download a standalone Python runtime (approx. 10MB) into the `python_runtime` folder.
- **Subsequent Runs**: It will execute immediately using the local runtime.

## How to Distribute / Submit

If you need to send this assignment to someone else (e.g., submission):

**Option 1: Send as is (Smallest size)**
- Send the zip file **excluding** the `python_runtime` folder.
- The recipient simply runs `start.bat`, and it will download the environment for them.

**Option 2: Send full package (Offline capable)**
- Run `start.bat` once on your machine to generate the `python_runtime` folder.
- Zip the entire project **including** the `python_runtime` folder.
- The recipient can run `start.bat` immediately without needing an internet connection.

## Project Structure

- `start.bat`: Entry point for Windows.
- `install_env.ps1`: Helper script to download Python if missing.
- `python/`: Source code directory.
  - `Main.py`: Main entry point handling menu and inputs.
  - `Graph.py`: Graph data structure and algorithms (BFS, DFS, Dijkstra, Prim).
  - `BinarySearchTree.py`: BST implementation.
- `input.txt`: Input data file.
