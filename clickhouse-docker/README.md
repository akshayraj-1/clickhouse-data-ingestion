# ClickHouse Docker Setup

Self-Contained Environment for setting up **ClickHouse** and **JWT Authentication** using **Docker**.
This setup uses an **NGINX** reverse proxy to handle JWT based authentication before accessing the ClickHouse database server.


## Quick Start

### Pre-requisites

- Docker
- OpenSSL (Optional)

### Setup

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/akshayraj-1/clickhouse-data-ingestion.git
    cd clickhouse-docker
    ```


2. **Generate JWT Key Pair:**

   Generate an RSA key pair (private and public keys) for the JWT authentication in `src` directory.

   - `Private Key`: The private key will be used to sign JWT tokens.
   - `Public Key`: The public key will be used by ClickHouse to verify the JWT token.

    You can generate the keys using OpenSSL or through online tools like jwt.io. Here's how to generate them with OpenSSL:
   ```bash
   openssl genrsa -out private_key.pem 2048
   openssl rsa -in private_key.pem -pubout -out public_key.pem
   ```

3. **Setup Docker Image:**

   Set up ClickHouse using Docker. Docker simplifies the setup process and provides an isolated environment for ClickHouse. 
   Use the provided `docker-compose.yml` file in `src` directory to start ClickHouse.
   Run the following command to start the Docker container with ClickHouse:
   ```bash
   docker-compose up -d
   ```
   
   Alternatively (Windows), you can use the `run.ps1` to execute the necessary commands.

4. **Generate a JWT Token:**

   You will need to generate a JWT token to authenticate your requests. You can do this using [jwt.io](https://jwt.io/) or by manually creating the token with your private key `(private_key.pem)`. 

   Example Payload:
   ```json
   {
     "sub": "test",
     "iat": 1710000000,
     "exp": 1719999999
   }
   ```

   - Set the algorithm to `RS256`.
   - Sign the token using your private key `(private_key.pem)`.


5. **Test the JWT Authentication:**

   You can now test the JWT authentication using **curl**, **Postman**, or any backend **(Java/Python)**. 
   
   ```bash
   curl -v -H "Authorization: Bearer <toke>" "http://localhost:8123/?query=SELECT+1"
   ```
   If the setup is successful, you should see a valid response from ClickHouse.
## References

- OpenAI (for proxy setup)
- [ClickHouse Docs](https://clickhouse.com/docs/interfaces/cli)