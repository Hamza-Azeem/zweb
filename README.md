# Project API Documentation

This document provides an overview of the available APIs, their usage, request/response formats, and features such as validation, JWT security, and search functionalities.

The APIs are categorized into **Auth Controller**, **Job Controller**, and **Admin Controller**.

---

## Table of Contents
1. [Auth Controller](#auth-controller)
    - [POST /admin-api/register](#post-admin-apiregister)
    - [POST /admin-api/login](#post-admin-apilogin)
2. [Job Controller](#job-controller)
    - [GET /web-api/jobs](#get-web-apijobs)
    - [GET /web-api/jobs/{id}](#get-web-apijobsid)
    - [POST /web-api/jobs/{id}/apply](#post-web-apijobsidapply)
3. [Admin Controller](#admin-controller)
    - [GET /admin-api/admins](#get-admin-apiadmins)
    - [GET /admin-api/admins/{id}](#get-admin-apiadminsid)
    - [PUT /admin-api/admins/{id}](#put-admin-apiadminsid)
    - [DELETE /admin-api/admins/{id}](#delete-admin-apiadminsid)
    - [GET /admin-api/admins/jobs](#get-admin-apiadminsjobs)
    - [GET /admin-api/admins/jobs/{id}](#get-admin-apiadminsjobsid)
    - [POST /admin-api/jobs](#post-admin-apijobs)
    - [PUT /admin-api/jobs/{id}](#put-admin-apijobsid)
    - [DELETE /admin-api/jobs/{id}](#delete-admin-apijobsid)
    - [GET /admin-api/jobs/{id}/apps](#get-admin-apijobsidapps)

---

## Features
- **JWT Security**: All endpoints require a valid JWT token for authorization.
- **Validation**: Proper request body validation ensures data integrity.
- **Search Functionality**: Searching is enabled for fields like job titles or admin emails.
- **Pagination**: Supports page-based data retrieval.
- **Exception Handling**: Handles validation errors and unexpected exceptions gracefully.

---

## Auth Controller

### POST /admin-api/register
**Description**: Registers a new user.

**Request Body**:
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com",
  "password": "Password123",
  "phoneNumber": "+1234567890"
}
```

**Response**:
```json
{
  "Account created successfully"
}
```

---

### POST /admin-api/login
**Description**: Logs in a user and returns a JWT token.

**Request Body**:
```json
{
  "email": "johndoe@example.com",
  "password": "Password123"
}
```

**Response**:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

## Job Controller

### GET /web-api/jobs
**Description**: Retrieves a list of jobs with optional search and pagination.

**Query Parameters**:
- `title` (optional): Filters jobs by title.
- `pageNum` (default: 0): Page number.
- `pageSize` (default: 10): Number of records per page.

**Example Request**:
```
GET /web-api/jobs?title=developer&pageNum=0&pageSize=10
```

**Response**:
```json
{
  "content": [
    {
      "id": "1",
      "title": "Java Developer",
      "type": "Full-time",
      "description": "Develop enterprise applications",
      "location": "New York",
      "salary": 70000,
      "commission": 5000
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10
  }
}
```

---

### GET /web-api/jobs/{id}
**Description**: Retrieves details of a job by ID.

**Example Request**:
```
GET /web-api/jobs/1
```

**Response**:
```json
{
    "id": "6754f05d6a648c71d3096d5f",
    "title": "Project Manager",
    "type": "CONTRACT",
    "description": "Leading project teams and ensuring successful project delivery.",
    "openDate": "2025-12-01T08:00:00",
    "deadline": "2026-01-15T17:00:00",
    "requirements": [
        {
            "no": 1,
            "title": "Project Management Certification (PMP)"
        },
        {
            "no": 2,
            "title": "Experience with Agile Methodologies"
        },
        {
            "no": 3,
            "title": "Excellent Communication Skills"
        }
    ],
    "salary": 3000,
    "commission": 700,
    "workTimeFrom": "09:00:00",
    "workTimeTo": "18:00:00",
    "workDayFrom": "MON",
    "workDayTo": "FRI",
    "location": "22 Al-Mokattam St, Cairo, Egypt"
}
```

---

### POST /web-api/jobs/{id}/apply
**Description**: Submits an application for a specific job.

**Request Body**:
```json
{
  "name": "Jane Smith",
  "email": "janesmith@example.com",
  "phoneNumber": "+9876543210",
  "description": "I am very interested in this role."
}
```

**Response**:
```json
{
    "message": "Application submitted successfully.",
    "applicationId": "6759ddc7c33ba25b716d8bd2"
}
```

---

## Admin Controller

### GET /admin-api/admins
**Description**: Retrieves a list of admins with optional search and pagination.

**Query Parameters**:
- `txt` (optional): Search keyword.
- `pageNum` (default: 0): Page number.
- `pageSize` (default: 10): Number of records per page.

**Example Request**:
```
GET /admin-api/admins?txt=John&pageNum=0&pageSize=10
```

**Response**:
```json
{
  "content": [
    {
      "id": "1",
      "firstName": "John",
      "lastName": "Doe",
      "email": "johndoe@example.com"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10
  }
}
```

---

### GET /admin-api/admins/{id}
**Description**: Retrieves an admin's details by ID.

**Example Request**:
```
GET /admin-api/admins/1
```

**Response**:
```json
{
  "id": "1",
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

---

### PUT /admin-api/admins/{id}
**Description**: Updates admin details.

**Request Body**:
```json
{
  "firstName": "Johnny",
  "lastName": "D",
  "email": "johnnyd@example.com",
  "phoneNumber": "+1234567890"
}
```

**Response**:
```json
{
  "id": "1",
  "firstName": "Johnny",
  "lastName": "D",
  "email": "johnnyd@example.com"
}
```

---

### DELETE /admin-api/admins/{id}
**Description**: Deletes an admin by ID.

**Example Request**:
```
DELETE /admin-api/admins/1
```

**Response**: HTTP 204 No Content

---

### POST /admin-api/jobs
**Description**: Creates a new job.

**Request Body**:
```json
{
    "id": "6754f05d6a648c71d3096d5f",
    "title": "Project Manager",
    "type": "CONTRACT",
    "description": "Leading project teams and ensuring successful project delivery.",
    "openDate": "2025-12-01T08:00:00",
    "deadline": "2026-01-15T17:00:00",
    "requirements": [
        {
            "title": "Project Management Certification (PMP)"
        },
        {
            "title": "Experience with Agile Methodologies"
        },
        {
            "title": "Excellent Communication Skills"
        }
    ],
    "salary": 3000,
    "commission": 700,
    "workTimeFrom": "09:00:00",
    "workTimeTo": "18:00:00",
    "workDayFrom": "MON",
    "workDayTo": "FRI",
    "location": "22 Al-Mokattam St, Cairo, Egypt"
}
```

**Response**:
```json
{
  "message": "Job created successfully",
  "jobId": "2"
}
```

---

### DELETE /admin-api/jobs/{id}
**Description**: Deletes a job by ID.

**Example Request**:
```
DELETE /admin-api/jobs/2
```

**Response**: HTTP 204 No Content

### GET /admin-api/admins/jobs
**Description**: Retrieves a list of jobs, with optional filtering by job title and paginated results.

**Parameters**:
- `title` (optional): A search text to filter jobs by title.
- `pageNum` (optional): The page number for pagination. Default is `0`.
- `pageSize` (optional): The number of jobs per page. Default is `10`.

**Example Request**:

**Response**: 
```json
{
  "content": [
    {
      "id": "1",
      "title": "Software Engineer",
      "description": "Develop and maintain software applications.",
      "company": "Tech Corp",
      "location": "New York, NY",
      "opendDate": "2024-12-01T00:00:00"
    }
  ],
  "pageable": {
    "pageSize": 5,
    "pageNumber": 1
  }
}
```


### GET /admin-api/admins/jobs/{id}
**Description**: Retrieves job details.

**Parameters**:
- `id` (required): An id to filter jobs by.

**Example Request**:

**Response**: 
```json
{
    "id": "6754f05d6a648c71d3096d5f",
    "title": "Project Manager",
    "type": "CONTRACT",
    "description": "Leading project teams and ensuring successful project delivery.",
    "openDate": "2025-12-01T08:00:00",
    "deadline": "2026-01-15T17:00:00",
    "requirements": [
        {
            "no": 1,
            "title": "Project Management Certification (PMP)"
        },
        {
            "no": 2,
            "title": "Experience with Agile Methodologies"
        },
        {
            "no": 3,
            "title": "Excellent Communication Skills"
        }
    ],
    "salary": 3000,
    "commission": 700,
    "workTimeFrom": "09:00:00",
    "workTimeTo": "18:00:00",
    "workDayFrom": "MON",
    "workDayTo": "FRI",
    "location": "22 Al-Mokattam St, Cairo, Egypt"
}
```
**Response**: HTTP 200 Ok


### PUT /admin-api/jobs/{id}
**Description**: Updates a job.

**Parameters**:
- `id` (required): An id to filter jobs by.

**Example Request**:
```json
{
    "title": "Developer Updated",
    "type": "FULL_TIME",
    "description": "updated description .... ",
    "openDate": "2025-10-15T10:10:10",
    "deadline": "2026-10-25T10:10:10",
    "requirements": [
        {
            "text": "Updated Requirement"
        }
    ],
    "salary": 16000,
    "commission": 2000,
    "workTimeFrom": "10:00:00",
    "workTimeTo": "17:00:00",
    "workDayFrom": "MON",
    "workDayTo": "FRI",
    "location": "15 Tahrir Square, Cairo, Egypt"
}
```
**Response**: 
```json
{
  Job updated successfully
}
```
**Response**: HTTP 204 Created

### PUT /admin-api/{id}/apps
**Description**: find all applications in general, all applications of a job or all applications by a user.

**Parameters**:
- `txt` (optional): A search text to filter applications by job id or user email .
- `pageNum` (optional): The page number for pagination. Default is `0`.
- `pageSize` (optional): The number of jobs per page. Default is `10`.

**Response**: 
```json
{
    "content": [
        {
            "applicationId": "6754f5326a648c71d3096d63",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "amr@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        },
        {
            "applicationId": "6754f53a6a648c71d3096d65",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "haz@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        },
        {
            "applicationId": "6754f53c6a648c71d3096d67",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "medo@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        },
        {
            "applicationId": "6754f53f6a648c71d3096d69",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "test@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        },
        {
            "applicationId": "6754f5486a648c71d3096d6b",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "woho@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        },
        {
            "applicationId": "6754f5eb6a648c71d3096d6c",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "amr@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        },
        {
            "applicationId": "6754f5f96a648c71d3096d6d",
            "name": "hamz",
            "date": "2024-12-08",
            "email": "amr@gmail.com",
            "phoneNumber": "+0201006369857",
            "description": "wasup wasup"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 7,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 7,
    "first": true,
    "empty": false
}
```
**Response**: HTTP 200 Ok




