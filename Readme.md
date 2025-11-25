# ESG Item API 

## Getting Started

### 1. Clone the repository

```bash
git clone git@github.com:KristianTan/csv-api.git
cd csv-api
```

### 2. Create a .env file
The .env file contains environment variables for the PostgreSQL database. Create it in the root of the project with the followiong variables:

POSTGRES_USER=your_db_username \
POSTGRES_PASSWORD=your_db_password \
POSTGRES_DB=your_db_name

**NOTE: There is an example env file included at .env.example**


### 3. Build the application

To build the docker image use the command:

```bash
docker compose build
```

### 4. Run the docker image

Run the docker image using the command:

```bash
docker compose up
```

By default, the PostgreSQL instance runs on port 5432 and the spring application runs on port 8080

