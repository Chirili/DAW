# DAW
## Ejercicio de Comisaria
### Modelo Entidad-Relación
![comisaria2](https://user-images.githubusercontent.com/23047899/50920117-db3c3b00-1444-11e9-85ae-f75e51c72961.png)
### Modelo relacional
![comisaria1](https://user-images.githubusercontent.com/23047899/50920058-ad56f680-1444-11e9-91c9-8a4f8d86a47a.png)
### Codigo SQL
#### Create tables

- CREATE TABLE calabozo ( <br>
    codigo_cala NUMBER(9), <br>
    ubicacion VARCHAR2(50), <br>
    CONSTRAINT pk_cala  PRIMARY KEY (codigo_cala) <br>
);
- CREATE TABLE caso ( <br>
    cod_caso NUMBER(9),<br>
    juzgado VARCHAR2(25),<br>
    cargo VARCHAR2(25),<br>
    CONSTRAINT pk_cas  PRIMARY KEY (cod_caso)<br>
);
- CREATE TABLE delincuente (<br>
    dni_deli VARCHAR2(9),<br>
    codigo_cala NUMBER(9),<br>
    cod_caso NUMBER(9),<br>
    nombre VARCHAR2(25),<br>
    telefono NUMBER(9),<br>
    CONSTRAINT pk_deli PRIMARY KEY (dni_deli),<br>
    CONSTRAINT fk_deli_cala FOREIGN KEY (codigo_cala) REFERENCES calabozo (codigo_cala),<br>
    CONSTRAINT fk_deli_caso FOREIGN KEY (cod_caso) REFERENCES caso (cod_caso)<br>
);
- CREATE TABLE policia ( <br>
    dni_poli VARCHAR2(9),<br>
    dni_deli VARCHAR2(9),<br>
    cod_caso NUMBER(9),<br>
    nombre VARCHAR2(25),<br>
    funcion VARCHAR2(30),<br>
    jefe VARCHAR2(2),<br>
    CONSTRAINT pk_poli PRIMARY KEY (dni_poli),<br>
    CONSTRAINT fk_poli_deli FOREIGN KEY (dni_deli) REFERENCES delincuente (dni_deli),<br>
    CONSTRAINT fk_poli_caso FOREIGN KEY (cod_caso) REFERENCES caso (cod_caso)<br>
);
- CREATE TABLE arma (<br>
    dni_poli VARCHAR2(9),<br>
    cod_arma NUMBER(9),<br>
    clase_pertenece VARCHAR2(30),<br>
    nombre VARCHAR2(25),<br>
    grado_habilidad VARCHAR2(30),<br>
    CONSTRAINT pk_arma PRIMARY KEY (cod_arma),<br>
    CONSTRAINT fk_arma_poli FOREIGN KEY (dni_poli) REFERENCES policia (dni_poli)<br>
);
#### Alter tables
1. ALTER TABLE calabozo ADD CONSTRAINT ck_ubic CHECK (ubicacion NOT IN('Huelva','Malaga'));
2. ALTER TABLE caso MODIFY juzgado VARCHAR2(25) DEFAULT ('Sevilla');
3. ALTER TABLE arma ADD CONSTRAINT ck_arma CHECK (clase_pertenece  IN('Subfusil','Fusil','Fusil de asalto','Francotirador','Rifle','Escopeta','Pistola'));
4. ALTER TABLE policia ADD CONSTRAINT ck_poli CHECK (jefe  IN('Si','No'));
#### Inserts
1. INSERT INTO calabozo (codigo_cala, ubicacion)
    VALUES ('763452134','Almeria').
2. INSERT INTO casos (cod_caso, juzgado, cargo)
    VALUES ('623456654','Almeria','Asesinato')
3. INSERT INTO delincuente (dni_deli,nombre, telefono)
    VALUES ('72345267W','Antonio','662351235')