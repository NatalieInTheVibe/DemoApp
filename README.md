# DemoApp by Natalie
Java application | React | Spring boot | Hibernate | Maven | SQL

## Getting Started

### 1. Clone the repository and install dependencies

```bash
git clone git@github.com/NatalieInTheVibe/DemoApp.git
cd frontend/demoapp
npm install
```

## 2. Local DB Setup

Create a new database:
```sql
CREATE DATABASE demoApp;
```

create a new user with a password:
```sql
CREATE USER '<YOUR USERNAME HERE>'@'localhost' IDENTIFIED BY '<YOUR PASSWORD HERE>';
```

Then update in `\DemoApp\backend\demoApp\src\main\resources\application.properties`:
```bash
spring.datasource.username='<YOUR USERNAME HERE>'
spring.datasource.password='<YOUR PASSWORD HERE>'
```

### 3. Starting the application

To run the app locally, in `\DemoApp\frontend\demoapp>` use:

```
npm run start
```

To run it in production mode, use:

```
npm run build
npm run start
```

To run the backend, run 'demoAppApplication' in Intellij IDEA.
