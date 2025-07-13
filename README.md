# 🏨 Hotel Management Backend

A brief description of what this project does and who it's for.

## ✨ Features
- 🛏️ Room Booking
- 🔐 JWT Authentication
- 👤 User Login/Register

## 🛠️ Technologies Used
- ☕ Java 17
- 🌱 Spring Boot
- 🐬 MySQL
- 🔑 JWT

## ⚙️ Setup Instructions
1. 📥 Clone the repo
2. ▶️ Run `mvn spring-boot:run`
3. 🌐 Visit `http://localhost:8080`

---
 ### 📡 API Endpoints
---

 ### 🔐 Authentication

#### 1. 📝 Register a User
- **URL**: `/api/auth/register`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "name": "Example",
    "email": "example@gmail.com",
    "password": "yourpassword"
  }
``
  #### 2. 🔑 Log In
  - **URL**: `/api/auth/login`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "email": "example@gmail.com",
    "password": "yourpassword"
  }
  ```
  #### 3. 👥 Get All Users 
- **URL**: `/api/auth/users`
- **Method**: `GET`
---
### 🏨 Room & Booking Management
---
  #### 4. 📃 Get All Bookings
- **URL**: `/api/bookings`
- **Method**: `GET`
- Authorization: Bearer `<JWT_TOKEN>`
  #### 5. 🛎️ Book A Room
- **URL**: `/api/bookings/book`
- **Method**: `POST`
- Authorization: Bearer `<JWT_TOKEN>`
- **Request Body**:
  ```json
  {
    "userId":12,
    "roomId": 10,
    "date": "2025-07-12"
    }
  ```
 #### 6. 🏘️ Get All Rooms
- URL: `/api/rooms`
- Method: `GET`
- Authorization: Bearer `<JWT_TOKEN>`
 #### 7. 🟢 Get All Available Rooms
- URL: `/api/rooms/available-rooms`
- Method: `GET`
- Authorization: Bearer <JWT_TOKEN>
 #### 8. 🔍 Get Room by ID
- URL: `/api/rooms/{id}`
- Method: `GET`
- Authorization: Bearer `<JWT_TOKEN>`
#### 9. ➕ Add A Room  
- **URL**: `/api/rooms/add-room`
- **Method**: `POST`
- Authorization: Bearer `<JWT_TOKEN>`
- **Request Body**:
  ```json
  {
  "roomNumber": "101",
  "type": "SINGLE",
  "price": 5000,
  }
  ```


  ---

📦This is a Spring Boot backend application for managing user registration, login, room management, and bookings.
---
## 👨‍💻 Author
---
**Nihar Ranjan Biswal** 
👨‍💻
