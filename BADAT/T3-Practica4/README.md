# DAW

## Ejercicios 4 Tema 3 Base de datos.

### Create Tables:

- `CREATE TABLE libro (
    ISBN VARCHAR2(9),
    titulo VARCHAR2(25),
    editorial VARCHAR2(25),
    numero_paginas NUMBER(3),
    CONSTRAINT pk_lib PRIMARY KEY (ISBN,titulo)
  );`
- `CREATE TABLE socio (
    DNI VARCHAR2(9),
    nombre VARCHAR2(25),
    fecha_nacimiento DATE,
    provincia VARCHAR2(25),
    CONSTRAINT pk_soci PRIMARY KEY (DNI)
  );`
-  
### Apuntes:
`TO_DATE('26/04/1982','dd/mm/yyyy');`
