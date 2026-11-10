# 🏥 MediCare — Hospital Management System REST API

A production-ready **REST API** built with Spring Boot for managing hospital operations, doctor scheduling, and patient appointments with role-based access control.

## 🚀 Tech Stack
- **Java 17 / 21** · **Spring Boot 3.x**
- **Spring Security + JWT** (4 roles: ADMIN, DOCTOR, PATIENT, RECEPTIONIST)
- **Spring Data JPA** + **PostgreSQL**
- **Swagger/OpenAPI** documentation
- **Maven** build system

## ✨ Key Features
- 🔐 **JWT Authentication**: Secure login and registration. Public sign-up creates PATIENT accounts only; other roles are seeded by the application.
- 🛡️ **Role-based access**: Endpoints are restricted with `@PreAuthorize` (for example, only DOCTOR, RECEPTIONIST or ADMIN can update an appointment status).
- 👨‍⚕️ **Doctor Management**: Admin can manage doctors, specializations, and consultation fees.
- 🧑‍💼 **Patient Profiles**: Patients can view their medical details.
- 📅 **Smart Appointment Booking**: Prevents double-booking (conflict detection) for doctors.
- 📊 **Appointment Status**: Doctors can mark appointments as COMPLETED, CANCELLED, etc.
- ⚡ **Global Exception Handling**: Clean error responses.

## 🛠️ How to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/Dilki31/medicare-hospital-system.git

2. Create a PostgreSQL database named medicare_db.

3. Update src/main/resources/application.properties with your database credentials.

4. Run the application:
   ./mvnw spring-boot:run

5. Access the API at http://localhost:8081/api/

## 📂 Project Structure
- `config/` - Security & Data Initialization
- `controller/` - REST API Endpoints
- `dto/` - Data Transfer Objects
- `entity/` - Database Models (User, Doctor, Patient, Appointment)
- `repository/` - Spring Data JPA Interfaces
- `security/` - JWT Filter & Services
- `service/` - Business Logic

## ⚙️ Configuration
Secrets are **not** stored in this repository. Set these environment variables before starting the app:

| Variable | Description |
|---|---|
| `DB_PASSWORD` | Password of your local PostgreSQL user |
| `JWT_SECRET` | Base64-encoded secret key, at least 256 bits (32 bytes) |

Generate a key: `openssl rand -base64 32` (macOS/Linux/Git Bash).

Run on Windows PowerShell:
```powershell
$env:DB_PASSWORD="your-db-password"
$env:JWT_SECRET="your-generated-base64-key"
./mvnw spring-boot:run
```

👨‍💻 Author
Dilki Nanayakkara
GitHub: @Dilki31