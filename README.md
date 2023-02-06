# Spring Boot Employee Manager Project
The service is employee manager REST service. it uses MySQL relational database to store the data in db_employee. you can call some REST endpoints defined in employee controller and on port 9090 defined in properties. You can perform CRUD operations on employees. You can configurate the port number and db name on application.properties in resources folder.

### Get information about employees.
```
http://localhost:9091/api/employees
http://localhost:9091/api/employees/{id}
http://localhost:9090/api/employees/dob?startDate=1995-01-01&endDate=2000-01-01

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

### Update an employee

```
PUT http://localhost:9091/api/employees/1
Accept: application/json
Content-Type: application/json

{
    "name": "nana",
    "age": 25,
}
```

### Delete an employee

```
Delete http://localhost:9091/api/employees/1
```

### Get employees by date of birth between startDate and endDate with params

```
Get http://localhost:9090/api/employees/dob?startDate=1995-01-01&endDate=2000-01-01
```

