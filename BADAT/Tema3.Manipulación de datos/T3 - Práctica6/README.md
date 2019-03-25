# DAW
## Tema 3 Practica 6
### Create tables
1. Tabla provincias:
- CREATE TABLE provincias (<br>
    codprov VARCHAR2(2),<br>
    nombrep VARCHAR2(30),<br>
    comunidad VARCHAR2(20),<br>
    CONSTRAINT pk_provincias PRIMARY KEY (codprov)<br>
);
2. Tabla localidades:
- CREATE TABLE localidades (<br>
    codloc VARCHAR2(3),<br>
    codprov VARCHAR2(2),<br>
    nombrel VARCHAR2(30),<br>
    censo INTEGER,<br>
    habitantes INTEGER,<br>
    CONSTRAINT pk_codloc PRIMARY KEY (codloc),<br>
    CONSTRAINT fk_codloc_provi FOREIGN KEY (codprov) REFERENCES provincias (codprov)<br>
);
3. Tabla tramos:
- CREATE TABLE tramos (<br>
    codlocA VARCHAR2(3),<br>
    codlocB VARCHAR2(3),<br>
    distancia DECIMAL(3,2),<br>
    CONSTRAINT pk_tramos PRIMARY KEY (codlocA, codlocB),<br>
    CONSTRAINT fk_tram_loc FOREIGN KEY (codlocA) REFERENCES localidades (codloc),<br>
    CONSTRAINT fk_tram2_loc FOREIGN KEY (codlocB) REFERENCES localidades (codloc)<br>
);

