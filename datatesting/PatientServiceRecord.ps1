$baseUrl = "http://localhost:8080/api/patient-service-records"

$records = @(
    @{patientId="<PATIENT_UUID1>"; serviceId="2f1c63b7-4c41-45a5-8f11-2a1d4b582010"; description="Tooth 11"; date="2025-10-08T10:00:00"},
    @{patientId="<PATIENT_UUID2>"; serviceId="2f1c63b7-4c41-45a5-8f11-2a1d4b582010"; description="Tooth 26"; date="2025-10-08T11:30:00"},
    @{patientId="<PATIENT_UUID1>"; serviceId="2f1c63b7-4c41-45a5-8f11-2a1d4b582010	"; description="Tooth 47"; date="2025-10-08T12:15:00"}
)

foreach ($record in $records) {
    Invoke-RestMethod -Uri $baseUrl -Method POST -Body ($record | ConvertTo-Json) -ContentType "application/json"
}

Write-Host "✅ Patient service records created"
