# 🏥 MediCare — Hospital Management System REST API

A production-ready **REST API** built with Spring Boot for managing hospital operations, doctor scheduling, and patient appointments with role-based access control.

## 🚀 Tech Stack
- **Java 17 / 21** · **Spring Boot 3.x**
- **Spring Security + JWT** (4 roles: ADMIN, DOCTOR, PATIENT, RECEPTIONIST)
- **Spring Data JPA** + **PostgreSQL**
- **Swagger/OpenAPI** documentation
- **Maven** build system

## ✨ Key Features
- 🔐 **JWT Authentication**: Secure login and registration with role-based access.
- 👨‍⚕️ **Doctor Management**: Admin can manage doctors, specializations, and consultation fees.
- 🧑‍💼 **Patient Profiles**: Patients can view their medical details.
- 📅 **Smart Appointment Booking**: Prevents double-booking (conflict detection) for doctors.
- 📊 **Appointment Status**: Doctors can mark appointments as COMPLETED, CANCELLED, etc.
- ⚡ **Global Exception Handling**: Clean error responses.

## 🛠️ How to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/Diliki31/medicare-hospital-system.git

2. Create a PostgreSQL database named medicare_db.

3. Update src/main/resources/application.properties with your database credentials.

4. Run the application:
   ./mvnw spring-boot:

5. Access the API at http://localhost:8081/api/

📂 Project Structure
src/main/java/com/dilki/medicare/
├── config/       # Security & Data Initialization
├── controller/   # REST API Endpoints
├── dto/          # Data Transfer Objects
├── entity/       # Database Models (User, Doctor, Patient, Appointment)
├── repository/   # Spring Data JPA Interfaces
├── security/     # JWT Filter & Services
└── service/      # Business Logic

👨‍💻 Author
Dilki Nanayakkara
GitHub: @Dilki31