# Hospital Management System

A Hibernate-based Java application developed to manage hospital operations. The system handles data for hospitals, patients, doctors, and prescriptions. CRUD operations are implemented for seamless addition, deletion, updating, and searching of data in a MySQL database. The application utilizes **Hibernate ORM** for efficient data management and **one-to-many** and **many-to-many** relationships for effective entity mapping, ensuring a robust and scalable solution.

## Features

- **CRUD Operations**:
  - Add, update, delete, and search hospital, patient, doctor, and prescription records.
- **Entity Relationships**:
  - Utilizes one-to-many and many-to-many relationships between entities such as doctors and patients.
- **Hibernate ORM**:
  - Efficient database interaction and optimization through Hibernate.
- **Database Integration**:
  - MySQL database for persistent storage.

## Technologies Used

- **Backend**:
  - Java
  - Hibernate ORM (for object-relational mapping)
  - MySQL (for database)
- **Tools**:
  - Maven (for dependency management)
  - Apache Tomcat or standalone Java application
- **Database Design**:
  - One-to-many and many-to-many relationships for doctor-patient and hospital-doctor mappings.

## Database Schema

### Entities

- **Hospital**: Contains hospital-related details like name, location, etc.
- **Doctor**: Contains doctor details and their association with hospitals.
- **Patient**: Contains patient details and their association with doctors.
- **Prescription**: Contains prescriptions given to patients by doctors.

### Relationships

- **One-to-Many**: 
  - A hospital has many doctors.
  - A doctor can treat many patients.
  
- **Many-to-Many**: 
  - A patient can be treated by multiple doctors.

## Installation

### Prerequisites

- Java 8 or higher
- Maven
- MySQL database (or other relational database)

