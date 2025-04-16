# [WIP]ClickHouse Data Ingestion Tool (Backend)

> [!WARNING]
> This is a work in progress project. Ingestion and query has not been implemented.

It's a backend service for the [ClickHouse Data Ingestion Tool (Frontend)](../frontend).

## Features

- **Data Ingestion**: Ingest data from flat file source into ClickHouse and vice versa.
- **Data Transformation**: Transform data using SQL queries.
- **Data Validation**: Validate data using SQL queries.

## Quick Start

### Prerequisites

- [Java 21+](https://www.java.com/en/download/manual.jsp)
- [Gradle](https://gradle.org/install/)

1. **Clone the repository:**

    ```bash
    git clone https://github.com/akshayraj-1/clickhouse-data-ingestion.git
   cd backend
    ```

2. **Install dependencies:**

   ```bash
   gradlew build
   ```
   
3. **Run the application:**
    
    ```bash
   gradlew bootRun
    ```
   
    This will run the server on `http://localhost:8080`


### Endpoints

- **GET /**: Get the root route.
- **POST /api/auth/login**: Login and get a JWT token.
- **POST /api/auth/signup**: Signup and get a JWT token.
- **POST /api/clickhouse/connect**: Connect to ClickHouse database server.


### Note

- It's a work in progress project. Ingestion and query has not been implemented.
- Tests are not implemented yet.
- The frontend is available at [ClickHouse Data Ingestion Tool](../frontend).
- The backend is available at [ClickHouse Data Ingestion Tool (Backend)](https://github.com/akshayraj-1/clickhouse-data-ingestion/tree/main/backend).