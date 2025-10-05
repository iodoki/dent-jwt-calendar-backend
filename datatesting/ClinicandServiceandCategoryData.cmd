@echo off
setlocal enabledelayedexpansion

:: ----------------------------
:: Step 1: Create 3 Clinics
:: ----------------------------
echo Creating clinics...

curl -X POST http://localhost:8080/api/clinics -H "Content-Type: application/json" -d "{\"name\":\"Sunshine Dental\",\"address\":\"123 Main St\",\"phone\":\"1234567890\",\"email\":\"contact@sunshine.com\",\"nipt\":\"NIPT001\"}"
curl -X POST http://localhost:8080/api/clinics -H "Content-Type: application/json" -d "{\"name\":\"Happy Smiles\",\"address\":\"456 Oak Ave\",\"phone\":\"0987654321\",\"email\":\"contact@happysmiles.com\",\"nipt\":\"NIPT002\"}"
curl -X POST http://localhost:8080/api/clinics -H "Content-Type: application/json" -d "{\"name\":\"Bright Teeth\",\"address\":\"789 Pine Rd\",\"phone\":\"5555555555\",\"email\":\"contact@brightteeth.com\",\"nipt\":\"NIPT003\"}"

:: ----------------------------
:: Step 2: Create 3 Service Categories
:: ----------------------------
echo Creating service categories...

curl -X POST http://localhost:8080/api/service-categories -H "Content-Type: application/json" -d "{\"name\":\"Cleaning\",\"description\":\"Basic dental cleaning services\"}"
curl -X POST http://localhost:8080/api/service-categories -H "Content-Type: application/json" -d "{\"name\":\"Whitening\",\"description\":\"Teeth whitening procedures\"}"
curl -X POST http://localhost:8080/api/service-categories -H "Content-Type: application/json" -d "{\"name\":\"Orthodontics\",\"description\":\"Braces and aligners\"}"

:: ----------------------------
:: Step 3: Create 5 Services
:: ----------------------------
echo Creating services...

:: NOTE: Replace <clinicId> and <categoryId> with actual UUIDs from your DB if needed
:: Example uses placeholders; you may fetch them via GET /api/clinics and /api/service-categories

curl -X POST http://localhost:8080/api/services -H "Content-Type: application/json" -d "{\"name\":\"Basic Cleaning\",\"price\":50.0,\"clinicId\":\"<clinic1Id>\",\"categoryId\":\"<category1Id>\"}"
curl -X POST http://localhost:8080/api/services -H "Content-Type: application/json" -d "{\"name\":\"Deep Cleaning\",\"price\":120.0,\"clinicId\":\"<clinic1Id>\",\"categoryId\":\"<category1Id>\"}"
curl -X POST http://localhost:8080/api/services -H "Content-Type: application/json" -d "{\"name\":\"Teeth Whitening\",\"price\":200.0,\"clinicId\":\"<clinic2Id>\",\"categoryId\":\"<category2Id>\"}"
curl -X POST http://localhost:8080/api/services -H "Content-Type: application/json" -d "{\"name\":\"Braces Consultation\",\"price\":100.0,\"clinicId\":\"<clinic3Id>\",\"categoryId\":\"<category3Id>\"}"
curl -X POST http://localhost:8080/api/services -H "Content-Type: application/json" -d "{\"name\":\"Aligner Fitting\",\"price\":300.0,\"clinicId\":\"<clinic3Id>\",\"categoryId\":\"<category3Id>\"}"

echo Done creating test data.
pause
