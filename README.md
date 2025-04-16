# ClickHouse Data Ingestion

This project is a bidirectional data ingestion tool for [ClickHouse](https://clickhouse.com/) and Flat Files (e.g. `csv`).
It includes a web based application with simple user interface that that facilitates data ingestion between a ClickHouse database and the Flat File platform.

## Modules

This project is broken down into three different modules:

1. **clickhouse-docker**: A self-contained setup for ClickHouse server using Docker. It uses NGINX as a reverse proxy to allow JWT based access to the database. 
2. **frontend**: The web UI for data ingestion. It provides a simple interface to facilitate data ingestion between a ClickHouse database and the Flat File platform.
3. **backend**: A Java SpringBoot application which acts as a bridge between ClickHouse database and the client. The client provides the host, port and token to connect to the ClickHouse database service and can perform queries as required.


## Quick Start

1. Run the clickhouse-docker container. [Learn more](clickhouse-docker/README.md)
2. Run the frontend application. [Learn more](frontend/README.md)
3. Run the backend application. [Learn more](backend/README.md)

