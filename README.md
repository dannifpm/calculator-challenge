# Calculator REST API 

This project is a REST API developed in Java using the Spring Boot framework. The application provides an endpoint for performing simple mathematical operations and uses RabbitMQ for asynchronous message processing.

---

## Project Structure

- **rest**: Main module that manages the REST API and business logic.
- **calculator**: Reusable module for mathematical calculations.

---

## How to Run the Project

### Prerequisites

- **Java 17** or higher
- **RabbitMQ** running
- **Gradle**

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/dannifpm/calculator-challenge.git
   cd calculator-challenge

2. Build and run the project:
    ```bash
    ./gradlew clean build
    ./gradlew :rest:bootRun

---

## Notes

- HTTP traffic logs are stored in rest/logs/http-traffic.log.
- RabbitMQ configurations are located in application.properties.

