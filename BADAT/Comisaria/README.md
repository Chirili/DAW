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