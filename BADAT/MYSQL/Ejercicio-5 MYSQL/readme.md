# Relación de ejercicio en MYSQL

## Ejercicio-5 MYSQL

### Create table trabajador

```js
CREATE TABLE trabajador(
	id_t INT,
    nombre VARCHAR(20),
    tarifa DECIMAL(4,2),
    oficio VARCHAR(15),
    CONSTRAINT pk_trabajador PRIMARY KEY(id_t)
);
```

### Alter table trabajador

```js
ALTER TABLE trabajador ADD id_supv INT NULL REFERENCES trabajador;
```

### Create table edificio

```js
CREATE TABLE edificio (
	id_e INT,
    dir VARCHAR(15) NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    nivel_calidad INT NOT NULL,
    categoria INT NOT NULL,
    CONSTRAINT pk_edificio PRIMARY KEY (id_e)
);
```

### Create table asignacion

```js
CREATE TABLE asignacion (
	id_t INT,
    id_e INT,
    fecha_inicio DATETIME NOT NULL,
    num_dias INT,
    CONSTRAINT pk_asignacion PRIMARY KEY (id_t,id_e,fecha_inicio),
    CONSTRAINT fk_asignacion_trabajador FOREIGN KEY (id_t) REFERENCES trabajador (id_t),
    CONSTRAINT fk_asignacion_edificio FOREIGN KEY (id_e) REFERENCES edificio (id_e)
);
```

### Isert into trabajador

```js
INSERT INTO trabajador(id_t,nombre,tarifa,oficio,id_supv) VALUES
(1235,'M.FARADAY',12.5,'ELECTRICISTA',1311),
(1311,'C.COULOMB',15.5,'ELECTRICISTA',1311),
(1412,'C.NEMO',13.75,'FONTANERO',1520),
(1520,'H.RICKOVER',11.75,'FONTANERO',1520),
(2920,'R.GARRET',10.0,'ALBAÑIL',2920),
(3001,'J.BARRISTER',8.2,'CARPINTERO',3231),
(3231,'P.MASON',17.4,'CARPINTERO',3231);
```

### Insert into edificio

```js
INSERT INTO edificio(id_e,dir,tipo,nivel_calidad,categoria) VALUES
(111,'1213 ASPEN','OFICINA',4,1),
(210,'1011 BIRCH','OFICINA',3,1),
(312,'123 ELM','OFICINA',2,2),
(435,'456 MAPLE','COMERCIO',1,1),
(460,'1415 BEACH','ALMACEN',3,3),
(515,'789 OAK','RESIDENCIA',3,2);
```

### Insert into asignacion

```js
INSERT INTO asignacion(id_t,id_e,fecha_inicio,num_dias) VALUES
(1235,312,'2001-10-10',5),
(1235,515,'2001-10-17',22),
(1311,435,'2001-10-08',12),
(1311,460,'2001-10-23',24),
(1412,111,'2001-12-01',4),
(1412,210,'2001-11-15',12),
(1412,312,'2001-10-01',10),
(1412,435,'2001-10-15',15),
(1412,460,'2001-10-08',18),
(1412,515,'2001-11-05',8),
(1520,312,'2001-10-30',17),
(1520,515,'2001-10-09',14),
(2920,210,'2001-11-10',15),
(2920,435,'2001-10-28',10),
(2920,460,'2001-10-05',18),
(3001,111,'2001-10-08',18),
(3001,210,'2001-10-27',14),
(3231,111,'2001-10-10',8),
(3231,312,'2001-10-24',20);
```
### Consultas select

- Nombre de los trabajadores cuya tarifa este entre 10 y 12 euros:

```js
SELECT nombre FROM trabajador WHERE tarifa BETWEEN 10 AND 12;
```

- ¿Cuáles son los oficiones de los trabjadores asignados al edificio 435?

```js
SELECT oficio FROM trabajador WHERE id_t IN(SELECT id_t FROM asignacion WHERE id_e=435);
```

- Indicar el nombre del trabajador y el de su supervisor

```js
SELECT t.nombre,s.nombre FROM trabajador t, trabajador s WHERE t.id_t = s.id_supv;
```

- Nombre de los trabjadores asignados a oficinas

```js
SELECT nombre FROM trabajador WHERE id_t IN(SELECT id_t FROM asignacion);
```

- ¿Qué trabajadores reciben una tarifa por hora mayor que la de su supervisor?

```js
SELECT trabajador.nombre FROM trabajador trabajador WHERE trabajador.id_supv IN (SELECT supervisor.id_supv FROM trabajador supervisor WHERE trabajador.tarifa > supervisor.tarifa) AND trabajador.id_t <> trabajador.id_supv;
```

- ¿Cuál es el número total de días que se han dedicado a fontanería en el edificio 312?

```js
SELECT SUM(num_dias) AS total_dias FROM asignacion WHERE id_t IN(SELECT id_t FROM trabajador WHERE oficio LIKE 'Fontanero') AND id_e = 312;
```

- ¿Cuántos tipos de oficios diferentes hay?

```js
SELECT COUNT(DISTINCT oficio) AS oficio FROM trabajador;
```

- Para cada supervisor, ¿cuál es la tarifa por horas más alta que se paga a un trabajador
que informa a ese supervisor?

```js
SELECT id_supv,MAX(tarifa) FROM trabajador GROUP BY id_supv;
```
Y si queremos el nombre:

```js
SELECT nombre,MAX(tarifa) FROM trabajador GROUP BY id_supv;
```

- Para cada supervisor que supervise a más de un trabajador, ¿cuál es la tarifa más alta que se paga a un trabajor que informa a ese supervisor?

```js
SELECT id_supv,MAX(tarifa) FROM trabajador GROUP BY id_supv HAVING COUNT(id_t) > 1;
```

- Para cada tipo de edificio, ¿cuál es el nivel de calidad medio de los edificios con categoría 1? Considérense solo aquellos tipos de edificios que tienen un nivel de calidad máximo no mayor de 3

```js
SELECT tipo,AVG(nivel_calidad) FROM edificio WHERE categoria=1 AND nivel_calidad < 3;
```

- ¿Qué trabajadores reciben una tarifa por hora menor que la del promedi?

```js
SELECT nombre FROM trabajador WHERE tarifa < (SELECT AVG(tarifa) FROM trabajador);
```

- ¿Qué trabajadores reciben una trarifa por hora menor que la del promedio de los trabajadores que tienen su mismo oficio?

```js
SELECT nombre FROM trabajador WHERE tarifa < (SELECT AVG(tarifa) FROM trabajador) AND oficio IN(SELECT oficio FROM trabajador GROUP BY oficio HAVING COUNT(oficio)>1)

```

- ¿Qué trabajadores reciben una trarifa por hora menor que la del promedio de los trabajadores que dependen del mismo supervisor que él?

```js
SELECT nombre FROM trabajador trabajador WHERE tarifa < (SELECT AVG(tarifa) FROM trabajador) AND oficio IN(SELECT oficio FROM trabajador GROUP BY id_supv HAVING COUNT(oficio)>1)
```

- Seleccione el nombre de los electricistas asignados al edificio 435 y la fecha en la que empezaron a trabajar en el.

```js
SELECT nombre,fecha_inicio FROM asignacion,trabajador WHERE trabajador.id_t=asignacion.id_t AND oficio LIKE 'Electricista' AND id_e = 435
```

- ¿Qué supervisores tiene trabajadores que tienen una tarifa por hora por encima de los 12 euros?

```js

```


