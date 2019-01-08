# DAW

## Ejercicios 4 Tema 3 Base de datos.

### Create Tables:

- `CREATE TABLE libro (<br>
    ISBN VARCHAR2(9),<br>
    titulo VARCHAR2(25),<br>
    editorial VARCHAR2(25),<br>
    numero_paginas NUMBER(3),<br>
    CONSTRAINT pk_lib PRIMARY KEY (ISBN,titulo)<br>
  );`
- `CREATE TABLE socio (<br>
    DNI VARCHAR2(9),<br>
    nombre VARCHAR2(25),<br>
    fecha_nacimiento DATE,<br>
    provincia VARCHAR2(25),<br>
    CONSTRAINT pk_soci PRIMARY KEY (DNI)<br>
  );`
-  
### Apuntes:
`TO_DATE('26/04/1982','dd/mm/yyyy');`
