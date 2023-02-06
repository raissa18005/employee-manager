# Spring Boot Employee Manager Project
The service is employee manager REST service. it uses MySQL relational database to store the data in db_employee. you can call some REST endpoints defined in properties on port 9090. You can perform CRUD operations on employees.

### Get information about employees.
```
http://localhost:9091/api/employees
http://localhost:9091/api/employees/1
localhost:9090/api/employees/dob?startDate=1995-01-01&endDate=2000-01-01

```

### Create an employee

```
POST http://localhost:9091/api/employees
Accept: application/json
Content-Type: application/json

{
    "name": "aan",
    "age": 40,
    "email": "aan@gmail.com",
    "jobTitle": "sales",
    "dateOfBirth": "1980-02-02"
}
```
