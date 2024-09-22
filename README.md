# URL Shortener Service

## Overview
The URL Shortener Service is a web application that enables users to input long URLs and receive shortened versions. This service allows for easy sharing of lengthy URLs while providing efficient redirection back to the original URLs.

## Key Features
- **Short URL Generation**:
    - Accepts long URLs and generates unique, shortened URLs.
    - Shortened URLs are significantly shorter than the originals.

- **URL Redirection**:
    - Redirects users to the original URL when they access a shortened URL.
    - Provides efficient and minimal-delay redirection.

- **Data Storage**:
    - Stores mappings of shortened URLs to their original URLs in a database.
    - Utilizes a key-value store for fast URL retrieval.
    - Database options:
        - **H2**: For development (in-memory).
        - **MySQL**: For production (robust and scalable).

## Technologies Used
- **Java 17**: Primary programming language for backend logic.
- **Spring Boot**: Framework to simplify the setup and development of the application.
- **Database**:
    - **H2**: Lightweight, in-memory database for development.
    - **MySQL**: For production, providing durability and scalability.
    - **FLYWAY**: For Database Migration.
- **Maven**: For dependency management and build automation.

## Getting Started

### Prerequisites
- **Java 17**: Ensure you have Java 17 installed on your machine.
- **Maven**: Make sure Maven is installed for dependency management and build automation.

### Steps to Run the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/engrveju/url-shortener-service.git
   
2. **Navigate to app directory**:
   ```bash
   cd url-shortener-service
   
   
3. **Run the following commands**:
   ```bash
   mvn clean install
   mvn spring-boot:run

### Steps to Use The API

1. **To Shorten Url, Make  A POST Request with RequestBody as Shown in Sample below**:
   ```bash
   curl -X POST http://localhost:8087/shorten \
                  -H "Content-Type: application/json" \
                  -d '{"url": "https://zeero.us/contact/client"}'



   Sample ResponseBody: {
                            "code": "200",
                            "message": "Request Successful",
                            "data": "http://localhost:8087/de650cf6"
                        }
   
2. **To Use the Short URL, Send the request below**:
```bash
    curl -X GET http://localhost:8087/de650cf6
