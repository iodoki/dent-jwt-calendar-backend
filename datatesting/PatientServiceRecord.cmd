REM Create record
curl -X POST http://localhost:8080/api/patient-service-records -H "Content-Type: application/json" -d "{\"patientId\":\"<PATIENT_UUID>\",\"serviceId\":\"<SERVICE_UUID>\",\"description\":\"Tooth 11\",\"date\":\"2025-10-05T12:00:00\"}"

REM Get all records
curl http://localhost:8080/api/patient-service-records

REM Get record by ID
curl http://localhost:8080/api/patient-service-records/<ID>

REM Update record
curl -X PUT http://localhost:8080/api/patient-service-records/<ID> -H "Content-Type: application/json" -d "{\"patientId\":\"<PATIENT_UUID>\",\"serviceId\":\"<SERVICE_UUID>\",\"description\":\"Tooth 26\",\"date\":\"2025-10-05T15:00:00\"}"

REM Delete record
curl -X DELETE http://localhost:8080/api/patient-service-records/<ID>
