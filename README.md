# Hotel Management Backend

A brief description of what this project does and who it's for.

## Features
- Room Booking
- JWT Authentication
- User Login/Register

## Technologies Used
- Java 17
- Spring Boot
- MySQL
- JWT

## Setup Instructions
1. Clone the repo
2. Run `mvn spring-boot:run`
3. Visit `http://localhost:8080`

## 📡 API Endpoints

### 🔐 Authentication

#### 1. Register a User
- **URL**: `/api/auth/register`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "name": "Example",
    "email": "example@gmail.com",
    "password": "yourpassword"
  }
  ```
  #### 2. LogIn
  - **URL**: `/api/auth/login`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "email": "example@gmail.com",
    "password": "yourpassword"
  }
  ```
   #### 3. Get All Users
- **URL**: `/api/auth/users`
- **Method**: `GET`

This is a Spring Boot backend application for managing user registration, login, room management, and bookings.

## Author
Nihar Ranjan Biswal
