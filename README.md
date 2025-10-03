
# Dental Calendar Backend (JWT) - Spring Boot Skeleton

Features:
- Java 17, Spring Boot 3.x
- PostgreSQL (Docker Compose)
- Flyway migrations (initial schema)
- JWT authentication (login endpoint + filter)
- BCrypt password encoding
- CommandLineRunner to create default roles and admin user at startup
- Example protected appointment endpoint

Quickstart:
1. Start Postgres:
   docker compose up -d
2. Build & run:
   ./mvnw spring-boot:run
3. Default admin credentials created at startup:
   username: admin
   password: password
   (change in production)

Configuration:
- JWT secret and other sensitive values should be provided via environment variables in production.
  The app reads JWT secret from `JWT_SECRET` env var or uses a default from application.yml.
