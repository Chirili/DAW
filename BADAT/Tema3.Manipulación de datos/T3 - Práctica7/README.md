# DAW
## Tema 3 Practica 7
### Create tables
1. Tabla libros:
- CREATE TABLE libros (<br>
    signatura NUMBER(4),<br>
    titulo VARCHAR2(30) NOT NULL,<br>
    autores VARCHAR2(30) NOT NULL,<br>
    en_prestamo VARCHAR2(2) NOT NULL,<br>
    CONSTRAINT pk_libros PRIMARY KEY (signatura)<br>
);
2. Tabla lectores:
- CREATE TABLE lectores (<br>
    nombre VARCHAR2(20),<br>
    apellido1 VARCHAR(20) NOT NULL,<br>
    apellido2 VARCHAR2(20),<br>
    dni VARCHAR2(9),<br>
    domicilio VARCHAR2(20),<br>
    tlfn NUMBER(9),<br>
    CONSTRAINT pk_lectores PRIMARY KEY (dni)<br>
);
3. Tabla prestamos: 
- CREATE TABLE prestamos (<br>
    signatura NUMBER(4),<br>
    dni VARCHAR2(9),<br>
    CONSTRAINT pk_prestamos PRIMARY KEY (signatura, dni),<br>
    CONSTRAINT fk_presta_libros FOREIGN KEY (signatura) REFERENCES libros (signatura),<br>
    CONSTRAINT fk_presta_lectores FOREIGN KEY (dni) REFERENCES lectores (dni)<br>
);
### Alter table
- ALTER TABLE libros ADD CONSTRAINT ck_presta CHECK (en_prestamo IN('SI','NO'));