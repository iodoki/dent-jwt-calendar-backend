$baseUrl = "http://localhost:8080/api/patient-service-records"

$records = @(
    @{patientId="<PATIENT_UUID1>"; serviceId="<SERVICE_UUID1>"; description="Tooth 11"; date="2025-10-05T10:00:00"},
    @{patientId="<PATIENT_UUID2>"; serviceId="<SERVICE_UUID2>"; description="Tooth 26"; date="2025-10-05T11:30:00"},
    @{patientId="<PATIENT_UUID1>"; serviceId="<SERVICE_UUID3>"; description="Tooth 47"; date="2025-10-05T12:15:00"}
)

foreach ($record in $records) {
    Invoke-RestMethod -Uri $baseUrl -Method POST -Body ($record | ConvertTo-Json) -ContentType "application/json"
}

Write-Host "✅ Patient service records created"
