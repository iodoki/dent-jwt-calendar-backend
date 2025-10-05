REM Create appointment
curl -X POST http://localhost:8080/api/appointments -H "Content-Type: application/json" -d "{\"doctorId\":\"<DOCTOR_UUID>\",\"patientId\":\"<PATIENT_UUID>\",\"serviceId\":\"<SERVICE_UUID>\",\"startTime\":\"2025-10-05T09:00:00+02:00\",\"endTime\":\"2025-10-05T10:00:00+02:00\",\"status\":\"SCHEDULED\",\"notes\":\"First appointment\",\"clinicId\":\"<CLINIC_UUID>\"}"

REM Get all appointments
curl http://localhost:8080/api/appointments

REM Get appointment by ID
curl http://localhost:8080/api/appointments/<ID>

REM Update appointment
curl -X PUT http://localhost:8080/api/appointments/<ID> -H "Content-Type: application/json" -d "{\"doctorId\":\"<DOCTOR_UUID>\",\"patientId\":\"<PATIENT_UUID>\",\"serviceId\":\"<SERVICE_UUID>\",\"startTime\":\"2025-10-05T11:00:00+02:00\",\"endTime\":\"2025-10-05T12:00:00+02:00\",\"status\":\"COMPLETED\",\"notes\":\"Updated notes\",\"clinicId\":\"<CLINIC_UUID>\"}"

REM Delete appointment
curl -X DELETE http://localhost:8080/api/appointments/<ID>
