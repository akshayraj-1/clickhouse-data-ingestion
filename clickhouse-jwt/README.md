# ClickHouse JWT Setup

Self-Contained Environment for setup **ClickHouse** and **JWT Authentication** using **Docker**.
Uses proxy for JWT based authentication before accessing the database server.

## Quick Start

**1. Generate JWT Key Pair (Private & Public Keys)** \
You’ll need to generate an RSA key pair (private and public keys) for the JWT authentication in `src` directory.

- `Private Key`: The private key will be used to sign JWT tokens.
- `Public Key`: The public key will be used by ClickHouse to verify the JWT token.


You can generate the keys using OpenSSL or through online tools like jwt.io. Here's how to generate them with OpenSSL:
```bash
openssl genrsa -out private_key.pem 2048
openssl rsa -in private_key.pem -pubout -out public_key.pem
```

**2. Setup Docker with ClickHouse**

You’ll now set up ClickHouse using Docker. Docker simplifies the setup process and provides an isolated environment for ClickHouse.

Now, Use the provided `docker-compose.yml` file in `src` directory to start ClickHouse.
Run the following command to start the Docker container with ClickHouse:
```bash
docker-compose up -d
```

Alternatively (Windows), you can use the `run.ps1` to execute the necessary commands.

**3. Generate a JWT Token** \
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

**5. Test the JWT Authentication** 

You can now test the JWT authentication using **curl**, **Postman**, or any backend **(Java/Python)**. 

```bash
curl -v -H "Authorization: Bearer <toke>" "http://localhost:8123/?query=SELECT+1"
```
If the setup is successful, you should see a valid response from ClickHouse.


## References

- OpenAI (for proxy setup)
- [ClickHouse Docs](https://clickhouse.com/docs/interfaces/cli)