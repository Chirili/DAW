# DAW
## Tema 3 Practica 5
### Create tables
1. Crear tabla ALUMNO
- CREATE TABLE alumno (<br>
    dni VARCHAR2(9),<br>
    nombre VARCHAR2(25),<br>
    nota number(2),<br>
    opción VARCHAR2(1),<br>
    CONSTRAINT pk_alum PRIMARY KEY (dni)<br>
);
2. Crear tabla ESTUDIO
- CREATE TABLE estudio (<br>
    codigo NUMBER(9),<br>
    nombre VARCHAR2(25),<br>
    nota_corte NUMBER(2),<br>
    CONSTRAINT pk_estudi PRIMARY KEY (codigo)<br>
);
3. Crear tabla PREINSCRIPCION
- CREATE TABLE preinscripcion (<br>
    codigo NUMBER(9),<br>
    dni VARCHAR2(25),<br>
    orden VARCHAR2(25),<br>
    admitido VARCHAR2(1),<br>
    CONSTRAINT pk_preins PRIMARY KEY (dni, codigo),<br>
    CONSTRAINT fk_preins_alumno FOREIGN KEY (dni) REFERENCES alumno (dni),<br>
    CONSTRAINT fk_preins_codigo FOREIGN KEY (codigo) REFERENCES estudio (codigo)<br>
);
### Alter tables
1. Opción tomará los valores A, B, C ó D.
ALTER TABLE alumno ADD CONSTRAINT ck_opci CHECK (opción IN('A','B','C','D'));
2. La nota de corte ha de ser mayor que 5.
ALTER TABLE estudio ADD CONSTRAINT ck_corte CHECK (nota_corte >= 5 );
3. El atributo admitido tomará los valores S ó N.
ALTER TABLE preinscripcion ADD CONSTRAINT ck_admi CHECK (admitido IN('S','N'));