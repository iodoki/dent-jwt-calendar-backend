# PowerShell script to populate test data for Dental App

$baseUrl = "http://localhost:8080/api"

# Helper function to POST JSON and parse response
function Post-Json($url, $body) {
    $response = Invoke-RestMethod -Uri $url -Method Post -Body ($body | ConvertTo-Json -Depth 5) -ContentType "application/json"
    return $response
}

Write-Host "Creating clinics..."
$clinics = @()
$clinics += Post-Json "$baseUrl/clinics" @{
    name = "Sunshine Dental"; address="123 Main St"; phone="1234567890"; email="contact@sunshine.com"; nipt="NIPT001"
}
$clinics += Post-Json "$baseUrl/clinics" @{
    name = "Happy Smiles"; address="456 Oak Ave"; phone="0987654321"; email="contact@happysmiles.com"; nipt="NIPT002"
}
$clinics += Post-Json "$baseUrl/clinics" @{
    name = "Bright Teeth"; address="789 Pine Rd"; phone="5555555555"; email="contact@brightteeth.com"; nipt="NIPT003"
}

Write-Host "Created Clinics:"
$clinics | ForEach-Object { Write-Host " - $($_.id) : $($_.name)" }

Write-Host "`nCreating service categories..."
$categories = @()
$categories += Post-Json "$baseUrl/service-categories" @{ name="Cleaning"; description="Basic dental cleaning services" }
$categories += Post-Json "$baseUrl/service-categories" @{ name="Whitening"; description="Teeth whitening procedures" }
$categories += Post-Json "$baseUrl/service-categories" @{ name="Orthodontics"; description="Braces and aligners" }

Write-Host "Created Service Categories:"
$categories | ForEach-Object { Write-Host " - $($_.id) : $($_.name)" }

Write-Host "`nCreating services..."
$services = @()
$services += Post-Json "$baseUrl/services" @{
    name="Basic Cleaning"; price=50.0; clinicId=$clinics[0].id; categoryId=$categories[0].id
}
$services += Post-Json "$baseUrl/services" @{
    name="Deep Cleaning"; price=120.0; clinicId=$clinics[0].id; categoryId=$categories[0].id
}
$services += Post-Json "$baseUrl/services" @{
    name="Teeth Whitening"; price=200.0; clinicId=$clinics[1].id; categoryId=$categories[1].id
}
$services += Post-Json "$baseUrl/services" @{
    name="Braces Consultation"; price=100.0; clinicId=$clinics[2].id; categoryId=$categories[2].id
}
$services += Post-Json "$baseUrl/services" @{
    name="Aligner Fitting"; price=300.0; clinicId=$clinics[2].id; categoryId=$categories[2].id
}

Write-Host "Created Services:"
$services | ForEach-Object { Write-Host " - $($_.id) : $($_.name)" }

Write-Host "`n✅ Test data population complete!"
