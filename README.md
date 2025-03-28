# Job Hunter - RESTful API

## Overview

Job Hunter is a RESTful API developed using Java Spring Boot, offering a comprehensive platform for job seekers and employers to interact efficiently. The API facilitates job posting, application management, and user profile handling, while incorporating secure authentication and authorization protocols.

## Features

- **User Management:** Provides user registration, login, profile management, and role-based access control (RBAC) for both job seekers and employers.
- **Job Management:** Supports CRUD operations for job listings, including search and filtering features.
- **Application Management:** Enables submission, tracking, and management of job applications.
- **Security:** Implements JWT-based authentication, OAuth2 resource server, and validation mechanisms to ensure secure access.
- **Email Notifications:** Automates email notifications for account verification and updates on application status.
- **API Documentation:** API documentation is available via SpringDoc OpenAPI for easy integration and usage.

## Architecture

The project follows a layered architecture design to maintain separation of concerns:

- **Controller Layer:** Handles incoming HTTP requests and routes them to the appropriate service methods.
- **Service Layer:** Contains the business logic and interacts with the data access layer.
- **Repository Layer:** Responsible for data persistence and interacting with the database using Spring Data JPA.
- **Security Layer:** Manages authentication and authorization processes using Spring Security and JWT.

## Tech Stack

- **Java**: Version 17
- **Spring Boot**: Version 3.3.2
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Security
  - Spring Boot Starter Thymeleaf
  - Spring Boot Starter Mail
  - Spring Boot Starter Actuator
- **Database**: MySQL
- **Security**: JWT, OAuth2 Resource Server, Spring Security
- **Documentation**: SpringDoc OpenAPI
- **Additional Libraries**: Lombok, Thymeleaf Extras Spring Security, Turkraft Spring Filter

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/tunguyen1104/job-hunter.git
2. Build the project:
   ```bash
   ./gradlew build
3. Run the application:
   ```bash
   ./gradlew bootRun
