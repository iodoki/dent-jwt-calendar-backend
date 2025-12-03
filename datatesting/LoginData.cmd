@echo off
echo Logging in...

curl -s -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"email\":\"mdoklea\",\"password\":\"Spirtozi84!!\"}" > login.json

type login.json

for /f "tokens=1* delims=:" %%a in ('findstr /i "accessToken" login.json') do (
    set TOKEN_LINE=%%b
)
set ACCESS=%TOKEN_LINE:~2,-2%

for /f "tokens=1* delims=:" %%a in ('findstr /i "refreshToken" login.json') do (
    set REFRESH_LINE=%%b
)
set REFRESH=%REFRESH_LINE:~2,-2%

echo %ACCESS% > access.txt
echo %REFRESH% > refresh.txt

echo Access Token Saved.
echo Refresh Token Saved.
