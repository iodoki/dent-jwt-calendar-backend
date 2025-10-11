$baseUrl = "http://localhost:8080/api/appointments"

$appointments = @(
    @{doctorId="8ef9f175-8936-452a-9ec8-2d9fc1d2b80c"; patientId="550e8400-e29b-41d4-a716-446655440000"; serviceId="2f1c63b7-4c41-45a5-8f11-2a1d4b582010"; startTime="2025-10-05T09:00:00+02:00"; endTime="2025-10-05T10:00:00+02:00"; status="SCHEDULED"; notes="First appointment"; clinicId="64b8bb56-426c-4eb8-975e-28c0ca7d7d76"},
    @{doctorId="8ef9f175-8936-452a-9ec8-2d9fc1d2b80c"; patientId="9f8c62a7-5c31-4a5f-91d4-8a2a4b582001"; serviceId="2f1c63b7-4c41-45a5-8f11-2a1d4b582010"; startTime="2025-10-05T09:00:00+02:00"; endTime="2025-10-05T10:00:00+02:00"; status="SCHEDULED"; notes="First appointment"; clinicId="64b8bb56-426c-4eb8-975e-28c0ca7d7d76"}
)
    foreach ($record in $appointments) {
    Invoke-RestMethod -Uri $baseUrl -Method POST -Body ($record | ConvertTo-Json) -ContentType "application/json"
}

Write-Host "✅ Patient service records created"

