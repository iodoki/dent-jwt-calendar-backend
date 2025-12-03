Write-Host "Logging in..."

$body = @{
    username = "mdoklea"
    password = "Spirtozi84!!"
} | ConvertTo-Json

$response = Invoke-RestMethod `
    -Uri "http://localhost:8080/auth/login" `
    -Method Post `
    -ContentType "application/json" `
    -Body $body

Write-Host "Raw Response:"
$response | ConvertTo-Json -Depth 5

$access = $response.accessToken
$refresh = $response.refreshToken

Set-Content -Path "access.txt" -Value $access
Set-Content -Path "refresh.txt" -Value $refresh

Write-Host "Tokens saved to access.txt and refresh.txt"