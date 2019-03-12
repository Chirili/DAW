# Tema 8 Clausulas avanzadas, vista e índices

## Un supermercado almacena los datos de sus empleados en una tabla denominada "empleados" y en una tabla llamada "sucursales" los códigos y ciudades de las diferentes sucursales

### Elimine las tablas "empleados" y "sucursales"

```js
 DROP TABLE empleados;
 DROP TABLE sucursales;
```

### Cree la tabla "sucursales"

```js
 CREATE TABLE sucursales(
  codigo NUMBER(4),
  ciudad VARCHAR2(30) not null,
  PRIMARY KEY(codigo)
 );
```

### Cree la tabla "empleados"

```js
 CREATE TABLE empleados(
  documento CHAR(8) not null,
  nombre VARCHAR2(30) not null,
  domicilio VARCHAR2(30),
  seccion VARCHAR2(20),
  sueldo NUMBER(6,2),
  codigosucursal NUMBER(4),
  PRIMARY KEY (documento),
  CONSTRAINT FK_empleados_sucursal
  FOREIGN KEY (codigosucursal)
  REFERENCES sucursales(codigo)
 );
```

### Ingrese algunos registros para ambas tablas

```js
 INSERT INTO sucursales VALUES(1,'Cordoba');
 INSERT INTO sucursales VALUES(2,'Villa Maria');
 INSERT INTO sucursales VALUES(3,'Carlos Paz');
 INSERT INTO sucursales VALUES(4,'Cruz del Eje');

 INSERT INTO empleados VALUES('22222222','Ana Acosta','Avellaneda 111','Secretaria',500,1);
 INSERT INTO empleados VALUES('23333333','Carlos Caseros','Colon 222','Sistemas',800,1);
 INSERT INTO empleados VALUES('24444444','Diana Dominguez','Dinamarca 333','Secretaria',550,2);
 INSERT INTO empleados VALUES('25555555','Fabiola Fuentes','Francia 444','Sistemas',750,2);
 INSERT INTO empleados VALUES('26666666','Gabriela Gonzalez','Guemes 555','Secretaria',580,3);
 INSERT INTO empleados VALUES('27777777','Juan Juarez','Jujuy 777','Secretaria',500,4);
 INSERT INTO empleados VALUES('28888888','Luis Lopez','Lules 888','Sistemas',780,4);
 INSERT INTO empleados VALUES('29999999','Maria Morales','Marina 999','Contaduria',670,4);
```

### Ejercicio 1

1. Realice un join para mostrar todos los datos de "empleados" incluyendo la ciudad de la sucursal.

```js
    SELECT * FROM empleados RIGHT JOIN sucursales ON sucursales.codigo=empleados.codigosucursal;
```

### Ejercicio 2

1. Cree una tabla llamada "secciones" que contenga las secciones de la empresa (primero elimínela).

```js
  DROP TABLE secciones;

 CREATE TABLE secciones AS
  (SELECT DISTINCT seccion AS nombre
   FROM empleados);
```

### Ejercicio 3

1. Recupere la información de "secciones".

```js
    SELECT nombre FROM secciones;
```

### Ejercicio 4

1. Se necesita una nueva tabla llamada "sueldosxseccion" que contenga la suma de los sueldos de los empleados por sección (de todas las sucursales). Primero elimine la tabla.

```js
DROP TABLE sueldosxseccion;

 CREATE TABLE sueldosxseccion AS
  (SELECT seccion, SUM(sueldo) AS total
  FROM empleados
  GROUP BY seccion);

```

### Ejercicio 5

1. Recupere los registros de la nueva tabla.

```js
    SELECT total FROM sueldosxseccion;
```

### Ejercicio 6

1. Se necesita una nueva tabla llamada "sucursalCordoba" que contenga los nombres y sección de los empleados de la ciudad de Córdoba. En primer lugar, eliminamos la tabla. Luego, consulte las tablas "empleados" y "sucursales" y guarde el resultado en la nueva tabla.

```js
DROP TABLE  sucursalCordoba;

CREATE TABLE sucursalCordoba AS
(SELECT nombre,seccion
        FROM empleados
            WHERE codigosucursal IN (SELECT codigo
                                            FROM sucursales
                                                WHERE ciudad LIKE 'Cordoba'));
```

### Ejercicio 7

1. Consulte la nueva tabla.

```js
    SELECT * FROM sucursalCordoba;
```