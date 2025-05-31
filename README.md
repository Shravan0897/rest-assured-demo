# RestAssured API Testing Demo

This project demonstrates API testing using RestAssured framework for testing campaign-related endpoints. The tests cover Android and iOS campaign endpoints, view functionality, and click tracking.

## Prerequisites

- Java JDK 8 or higher
- Maven
- Docker and Docker Compose
- A running instance of the campaign API server (default: http://localhost:8080)

## Project Structure

```
src/test/java/com/restassured/demo/
├── CampaignApiTests.java    # Main test class containing all test cases
```

## Test Cases

The test suite includes the following test cases:

1. `testGetAndroidCampaigns`: Tests the Android campaigns endpoint
2. `testGetIosCampaigns`: Tests the iOS campaigns endpoint
3. `testViewCampaign`: Tests the campaign view functionality
4. `testClickCampaign`: Tests the campaign click tracking

## Setup Instructions

1. Clone the repository:
```bash
git clone <repository-url>
cd restassured-demo
```

2. Start the backend API using Docker Compose:
```bash
docker compose up -d
```

This will start:
- The backend API server at http://localhost:8080
- Swagger documentation at http://localhost:8081

3. Access the API documentation:
- Open your browser and visit http://localhost:8081
- This will show you the Swagger UI with all available API endpoints and their documentation

4. Update the base URL in `CampaignApiTests.java` if your API is running on a different host/port:
```java
RestAssured.baseURI = "http://your-api-host:port";
```

## Running the Tests

### Using Maven

Run all tests:
```bash
mvn clean test
```

Run a specific test class:
```bash
mvn test -Dtest=CampaignApiTests
```

Run a specific test method:
```bash
mvn test -Dtest=CampaignApiTests#testGetAndroidCampaigns
```

### Using IDE

1. Open the project in your preferred IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)
2. Navigate to `src/test/java/com/restassured/demo/CampaignApiTests.java`
3. Right-click on the test class or method and select "Run"

## Test Execution Order

The tests are executed in the following order (based on priority):

1. `testGetAndroidCampaigns` (priority = 1)
2. `testGetIosCampaigns` (priority = 2)
3. `testViewCampaign` (priority = 3)
4. `testClickCampaign` (priority = 4)

## Expected Results

- All tests should pass with a 200 status code.
- The response body for each test should contain the expected fields (AppID, AppName, CreativeID, etc.)
- The click tracking test should return a StoreURL in the response

## Troubleshooting

1. If tests fail with connection errors:
   - Verify that the Docker containers are running (`docker ps`)
   - Check if the API server is accessible at http://localhost:8080
   - Ensure the base URL is correctly configured
   - Check Docker logs if needed (`docker compose logs`)

2. If tests fail with assertion errors:
   - Verify the API response structure matches the expected format
   - Check if the test data (campaigns) exists in the system
   - Review the API documentation at http://localhost:8081 for any changes in the response format

3. Docker-related issues:
   - If containers fail to start, try `docker compose down` followed by `docker compose up -d`
   - Check Docker resource allocation if containers are running slowly
   - Ensure ports 8080 and 8081 are not in use by other applications

## Dependencies

The project uses the following main dependencies:
- RestAssured
- TestNG
- Hamcrest

These dependencies are managed through Maven and are listed in the `pom.xml` file.
