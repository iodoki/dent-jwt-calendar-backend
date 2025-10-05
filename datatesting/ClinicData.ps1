$baseUrl = "http://localhost:8080/api/clinics"

$clinics = @(
    @{name="Sunshine Dental"; address="123 Main St"; phone="1234567890"; email="contact@sunshine.com"; nipt="NIPT001"},
    @{name="Happy Smiles"; address="456 Oak Ave"; phone="0987654321"; email="contact@happysmiles.com"; nipt="NIPT002"},
    @{name="Bright Teeth"; address="789 Pine Rd"; phone="5555555555"; email="contact@brightteeth.com"; nipt="NIPT003"}
)

foreach ($clinic in $clinics) {
    Invoke-RestMethod -Uri $baseUrl -Method POST -Body ($clinic | ConvertTo-Json) -ContentType "application/json"
}

Write-Host "✅ Clinics created"
