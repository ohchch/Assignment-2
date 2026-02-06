# Script to setup a portable Python environment
Write-Host "Setting up Portable Python Environment..."

$pythonUrl = "https://www.python.org/ftp/python/3.11.5/python-3.11.5-embed-amd64.zip"
$zipPath = "python-embed.zip"
$destDir = "python_runtime"

if (Test-Path $destDir) {
    Write-Host "Environment already exists in '$destDir'. Skipping download."
} else {
    Write-Host "Downloading Python 3.11 Embeddable Package..."
    try {
        Invoke-WebRequest -Uri $pythonUrl -OutFile $zipPath
    } catch {
        Write-Error "Failed to download Python. Please check internet connection."
        exit 1
    }

    Write-Host "Extracting to '$destDir'..."
    Expand-Archive -Path $zipPath -DestinationPath $destDir
    
    # Cleanup zip
    Remove-Item $zipPath
    
    # Configure python to allow importing from current directory if needed
    # (Usually embedded python ignores site-packages, but works for local relative imports)
    
    Write-Host "Portable Python installed successfully."
}

Write-Host "Setup Complete. You can now use 'start.bat' to run the program."
