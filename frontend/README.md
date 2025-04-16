# ClickHouse Data Ingestion Tool (Frontend)

This project is a frontend tool for bidirectional data ingestion using ClickHouse and flat files. It interfaces with a custom Java backend that manages connections to the ClickHouse database servers.

## Quick Start

### Prerequisites

- Node.js and npm installed
- Java runtime environment for the backend

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/akshayraj-1/clickhouse-data-ingestion.git
   cd frontend
   ```

2. **Install the dependencies:**
   ```bash
   npm install
   ```

### Running the Frontend

Start the development server:
```bash
npm run dev
```

This will launch the frontend application and you can view it in your browser at `http://localhost:3000`.

### Connecting to the Backend

Ensure that your custom Java backend is running and properly configured to connect to the database servers.
For more information, refer to the [backend documentation](https://github.com/akshayraj-1/clickhouse-data-ingestion/blob/main/README.md).
