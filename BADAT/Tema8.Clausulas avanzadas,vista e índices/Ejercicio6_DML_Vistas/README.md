<style>
    summary {
    text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;}
  summary:hover{
    color: #1883ba;
    background-color: #ffffff;
  }
    .imagen {
    text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;
    width: 230px;}
  .imagen:hover{
    color: #1883ba;
    background-color: #ffffff;
  }
  </style>

# Tema 8 Clausulas avanzadas, vista e índices

## Un club dicta cursos de distintos deportes. Almacena la información en CHARias tablas

### Elimine las tabla "inscriptos", "socios" y "cursos"

```js
    DROP TABLE inscriptos;
    DROP TABLE socios;
    DROP TABLE cursos;
```

### Cree las tablas

<details>
  <summary>Código SQL para la creación de las tablas de este ejercicio</summary>

  ```js
   RCREATE TABLE socios(
    documento CHAR(8) NOT NULL,
    nombre VARCHAR2(40),
    domicilio VARCHAR2(30),
    CONSTRAINT PK_socios_documento
     PRIMARY KEY (documento)
   );

   RCREATE TABLE cursos(
    numero NUMBER(2),
    deporte VARCHAR2(20),
    dia VARCHAR2(15),
    CONSTRAINT CK_inscriptos_dia check (dia in('lunes','martes','miercoles',  'jueves','viernes','sabado')),
    profesor VARCHAR2(20),
    CONSTRAINT PK_cursos_numero
     PRIMARY KEY (numero)
   );

   RCREATE TABLE inscriptos(
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
</details>

### Ingrese algunos registros para todas las tablas

<details>
  <summary>Codigo SQL para la insercion de los registros</summary>
  
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
</details>

### Ejercicio 1

1. Realice un join para mostrar todos los datos de todas las tablas, sin repetirlos (7 registros).

```js
SELECT * FROM socios 
  INNER JOIN inscriptos ON socios.documento=inscriptos.documentosocio 
    INNER JOIN cursos ON cursos.numero=inscriptos.numero;
```

### Ejercicio 3

1. Elimine la vista "vista_cursos"

```js
DROP VIEW vista_cursos;
```

### Ejercicio 4

Cree la vista "vista_cursos" que muestre el número, deporte y día de todos los cursos.

```js
CREATE VIEW vista_cursos 
  AS SELECT numero,deporte,dia FROM cursos;
```

### Ejercicio 5

1. Consulte la vista ordenada por deporte (7 registros).

```js
SELECT deporte FROM vista_cursos; 
```

### Ejercicio 6

1.  Ingrese un registro mediante la vista "vista_cursos" y vea si afecta a "cursos".

```js
  INSERT INTO vista_cursos (numero,deporte,dia)
  VALUES (8,'padel','lunes');
```
Si que afecta a cursos el insertar registros en una vista.

![imagen](https://user-images.githubusercontent.com/23047899/54626485-85ea5e80-4a71-11e9-8a6b-b491a9823f8b.png)

### Ejercicio 7

1. Actualice un registro sobre la vista y vea si afecta a la tabla "cursos".

```js
  UPDATE vista_cursos SET deporte='golf' WHERE deporte LIKE 'tenis';
```
Si que afecta a la tabla cursos:
![imagen](https://user-images.githubusercontent.com/23047899/54628084-14141400-4a75-11e9-9d7c-494b5c2ca9ce.png)

### Ejercicio 8

1.  Elimine un registro de la vista para el cual no haya inscriptos y vea si afecta a "cursos"

```js
  DELETE FROM vista_cursos WHERE numero=8;
```
Si que afecta a la tabla cursos:
![imagen](https://user-images.githubusercontent.com/23047899/54628528-0743f000-4a76-11e9-9515-b96c5a578663.png)
### Ejercicio 9

1. Intente eliminar un registro de la vista para el cual haya inscriptos.

```js
  DELETE FROM vista_cursos WHERE numero=7;
```
No puedo eliminar el registro dado que ese registro es la foreign key de esa tabla es decir la clave que viene de otra tabla por lo tanto salta error diciendo como que hemos violado ese vinculo:

<details>
  <summary class="imagen">Imagen del ejercicio 9</summary>

  ![imagen](https://user-images.githubusercontent.com/23047899/54628886-b41e6d00-4a76-11e9-9b71-330f5312a626.png)
</details>

### Ejercicio 10

1. Elimine la vista "vista_inscriptos" y creela para que muestre el documento y nombre del socio, el numero de curso, el deporte y dia de los cursos en los cuales esta inscripto.

```js
CREATE VIEW vista_inscriptos AS
SELECT i.documentosocio,s.nombre,i.numero,c.deporte,dia FROM inscriptos i
    JOIN socios s ON s.documento=documentosocio
        JOIN cursos c ON c.numero=i.numero;
```

### Ejercicio 11
 1. Intente ingresar el siguiente registro en la vista:

```js
INSERT INTO vista_inscriptos 
  VALUES('32222222','Hector Huerta',6,'futbol','lunes');
```
No lo permite porque la modificación afecta a más de una tabla base.

<details>
  <summary class="imagen">Imagen Ejercicio 11</summary>
  <div>

  ![imagen](https://user-images.githubusercontent.com/23047899/54631245-e5e60280-4a7b-11e9-8722-9b1f13322fec.png)
  <div>
</details>

### Ejercicio 12

1. Intente actualizar el documento de un socio (no lo permite).

```js
UPDATE socios SET documento=34444444
    WHERE documento=30000000;
```
<details>
  
  <summary class="imagen">Imagen Ejercicio 12</summary>

  
![imagen](https://user-images.githubusercontent.com/23047899/54635460-7e808080-4a84-11e9-978c-5dcf607a7d6e.png)
</details>

### Ejercicio 13

1. Elimine un registro mediante la vista.

```js
DELETE FROM vista_inscriptos 
    WHERE numero=4;
```

### Ejercicio 14

1. Verifique que el registro se ha eliminado de "inscriptos".


<details>
  
  <summary class="imagen">Imagen Ejercicio 14</summary>

  
![imagen](https://user-images.githubusercontent.com/23047899/54635794-40d02780-4a85-11e9-9162-b69fa9cadd06.png)
</details>