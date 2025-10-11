$baseUrl = "http://localhost:8080/api/doctors"

$doctors = @(
    @{userId = "a2a3854b-79ba-4572-a633-c840d46b7b04"; specialty = "Dentist"; clinicId ="64b8bb56-426c-4eb8-975e-28c0ca7d7d76" }
)

foreach ($record in $doctors) {
    Invoke-RestMethod -Uri $baseUrl -Method POST -Body ($record | ConvertTo-Json) -ContentType "application/json"
}

Write-Host "✅ Doctors service records created"
