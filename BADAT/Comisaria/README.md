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
