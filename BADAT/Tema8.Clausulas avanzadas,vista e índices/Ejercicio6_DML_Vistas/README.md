# Tema 8 Clausulas avanzadas, vista e índices

## Un club dicta cursos de distintos deportes. Almacena la información en CHARias tablas

### Elimine las tabla "inscriptos", "socios" y "cursos"

```js
    DROP TABLE inscriptos;
    DROP TABLE socios;
    DROP TABLE cursos;
```

### Cree las tablas

```js
 DRCREATE TABLE socios(
  documento CHAR(8) NOT NULL,
  nombre VARCHAR2(40),
  domicilio VARCHAR2(30),
  CONSTRAINT PK_socios_documento
   PRIMARY KEY (documento)
 );

 DRCREATE TABLE cursos(
  numero NUMBER(2),
  deporte VARCHAR2(20),
  dia VARCHAR2(15),
  CONSTRAINT CK_inscriptos_dia check (dia in('lunes','martes','miercoles','jueves','viernes','sabado')),
  profesor VARCHAR2(20),
  CONSTRAINT PK_cursos_numero
   PRIMARY KEY (numero)
 );

 DRCREATE TABLE inscriptos(
  documentosocio CHAR(8) NOT NULL,
  numero NUMBER(2) NOT NULL,
  matricula CHAR(1),
  CONSTRAINT PK_inscriptos_documento_numero
   PRIMARY KEY (documentosocio,numero),
  CONSTRAINT FK_inscriptos_documento
   FOREIGN KEY (documentosocio)
   REFERENCES socios(documento),
  CONSTRAINT FK_inscriptos_numero
   FOREIGN KEY (numero)
   REFERENCES cursos(numero)
  );
```

### Ingrese algunos registros para todas las tablas

```js
 INSERT INTO socios VALUES('30000000','Fabian Fuentes','Caseros 987');
 INSERT INTO socios VALUES('31111111','Gaston Garcia','Guemes 65');
 INSERT INTO socios VALUES('32222222','Hector Huerta','Sucre 534');
 INSERT INTO socios VALUES('33333333','Ines Irala','Bulnes 345');

 INSERT INTO cursos VALUES(1,'tenis','lunes','Ana Acosta');
 INSERT INTO cursos VALUES(2,'tenis','martes','Ana Acosta');
 INSERT INTO cursos VALUES(3,'natacion','miercoles','Ana Acosta');
 INSERT INTO cursos VALUES(4,'natacion','jueves','Carlos Caseres');
 INSERT INTO cursos VALUES(5,'futbol','sabado','Pedro Perez');
 INSERT INTO cursos VALUES(6,'futbol','lunes','Pedro Perez');
 INSERT INTO cursos VALUES(7,'basquet','viernes','Pedro Perez');

 INSERT INTO inscriptos VALUES('30000000',1,'s');
 INSERT INTO inscriptos VALUES('30000000',3,'n');
 INSERT INTO inscriptos VALUES('30000000',6,NULL);
 INSERT INTO inscriptos VALUES('31111111',1,'s');
 INSERT INTO inscriptos VALUES('31111111',4,'s');
 INSERT INTO inscriptos VALUES('32222222',1,'s');
 INSERT INTO inscriptos VALUES('32222222',7,'s');
```

### Ejercicio 1

1. Realice un join para mostrar todos los datos de todas las tablas, sin repetirlos (7 registros).

```js
    SELECT * FROM socios INNER JOIN inscriptos ON socios.documento=inscriptos.documentosocio INNER JOIN cursos ON cursos.numero=inscriptos.numero;
```

### Ejercicio 3

```js

```

### Ejercicio 4

```js

```

### Ejercicio 5

```js

```

### Ejercicio 6

```js

```

### Ejercicio 7

```js

```

### Ejercicio 8

```js

```

### Ejercicio 9

```js

```
