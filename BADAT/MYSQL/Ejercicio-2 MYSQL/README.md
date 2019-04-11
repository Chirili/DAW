# Relación de ejercicio en MYSQL

## Ejercicio-2 MYSQL

### Create table MARCAS

```sql
CREATE TABLE marcas (
	cifm INT(4),
    nombre VARCHAR(20),
    ciudad VARCHAR(20),
    CONSTRAINT pk_markas PRIMARY KEY(cifm)
)
```
- Datos insertados:

```sql
INSERT INTO marcas VALUES
(0001,'SEAT','MADRID'),
(0002,'RENAULT','BARCELONA'),
(0003,'CITROEN','VALENCIA'),
(0004,'AUDI','MADRID'),
(0005,'OPEL','BILBAO'),
(0006,'BMW','BARCELONA')
```

### Create table COCHES

```sql
CREATE TABLE coches (
	codcoche INT(3),
    nombre VARCHAR(20),
    modelo VARCHAR(20),
    CONSTRAINT pk_coches PRIMARY KEY(codcoche)
)
```

- Datos insertado:

```sql
INSERT INTO coches VALUES
(001,'IBIZA','GLX'),
(002,'IBIZA','GTI'),
(003,'IBIZA','GTD'),
(004,'TOLEDO','GTD'),
(005,'CORDOBA','GTI'),
(006,'MEGANE','1.6'),
(007,'MEGANE','GTI'),
(008,'LAGUNA','GTD'),
(009,'LAGUNA','TD'),
(010,'ZX','16V'),
(011,'ZX','TD'),
(012,'XANTIA','GTD'),
(013,'A4','1.8'),
(014,'A4','2.8'),
(015,'ASTRA','CARAVAN'),
(016,'ASTRA','GTI'),
(017,'CORSA','1.4'),
(018,'300','316i'),
(019,'500','525i'),
(020,'700','750i')
```

### Create table CONCESIONARIOS

```sql
CREATE TABLE concesionarios (
	cifc INT(4),
    nombre VARCHAR(20),
    ciudad VARCHAR(20),
    CONSTRAINT pk_concesionarios PRIMARY KEY(cifc)
)
```

- Datos insertados:

```sql
INSERT INTO concesionarios VALUES
(0001,'ACAR','MADRID'),
(0002,'BCAR','MADRID'),
(0003,'CCAR','BARCELONA'),
(0004,'DCAR','VALENCIA'),
(0005,'ECAR','BILBAO'),
(0006,'FCAR','SEVILLA')
```

### Create table DISTRIBUCION

```sql
CREATE TABLE distribucion (
    cifc INT(4),
	codcoche INT(3),
    cantidad INT(3),
    CONSTRAINT pk_distribucion_concesionario FOREIGN KEY(cifc) REFERENCES concesionarios(cifc) ON UPDATE CASCADE,
    CONSTRAINT pk_distribucion_coche FOREIGN KEY(codcoche) REFERENCES coches(codcoche) ON UPDATE CASCADE
)
```

- Datos insertados:

```sql
INSERT INTO `distribucion`(`cifc`,`codcoche`,`cantidad`) VALUES
(1,1,3),
(1,5,7),
(1,6,7),
(2,6,5),
(2,8,10),
(2,9,10),
(3,10,5),
(3,11,3),
(3,12,5),
(4,13,10),
(4,14,5),
(5,15,10),
(5,16,20),
(5,17,8),
(6,19,3)
```

### Create table MARCO

```sql
CREATE TABLE marco (
    cifm INT(4),
	codcoche INT(3),
    CONSTRAINT pk_marco PRIMARY KEY(codcoche,cifm),
    CONSTRAINT fk_marco_coche FOREIGN KEY(codcoche) REFERENCES coches(codcoche),
    CONSTRAINT fk_marco_cifm FOREIGN KEY(cifm) REFERENCES marcas(cifm)
)
```
- Datos insertados:

```sql
INSERT INTO marco VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(2,6),
(2,7),
(2,8),
(2,9),
(3,10),
(3,11),
(3,12),
(4,13),
(4,14),
(5,15),
(5,16),
(5,17),
(6,18),
(6,19),
(6,20)
```

### Create table CLIENTES

```sql
CREATE TABLE clientes (
	dni INT(4),
	nombre VARCHAR(20),
    apellido VARCHAR(20),
    ciudad VARCHAR(20),
    CONSTRAINT pk_clientes PRIMARY KEY(dni)
)
```

- Datos insertados:

```sql
INSERT INTO clientes VALUES
(0001,'LUIS','GARCIA','MADRID'),
(0002,'ANTONIO','LOPEZ','VALENCIA'),
(0003,'JUAN','MARTIN','MADRID'),
(0004,'MARIA','GARCIA','MADRID'),
(0005,'JAVIER','GONZALEZ','BARCELONA'),
(0006,'ANA','LOPEZ','BARCELONA')
```

### Create table VENTAS

```sql
CREATE TABLE ventas (
    cifc INT(4),
	dni INT(4),
    codcoche INT(3),
	color VARCHAR(10),
    CONSTRAINT pk_clientes PRIMARY KEY(dni,cifc,codcoche),
    CONSTRAINT fk_ventas_clientes FOREIGN KEY(dni) REFERENCES clientes(dni),
    CONSTRAINT fk_ventas_concesionario FOREIGN KEY(cifc) REFERENCES concesionarios(cifc),
    CONSTRAINT fk_ventas_coche FOREIGN KEY(codcoche) REFERENCES coches(codcoche)
)
```

- Datos insertados:

```sql
INSERT INTO ventas VALUES
(1,1,1,'BLANCO'),
(1,2,5,'ROJO'),
(2,3,8,'BLANCO'),
(2,1,6,'ROJO'),
(3,4,11,'ROJO'),
(4,5,14,'VERDE')
```

- Resuelve los siguientes apartados:
    
    1. Obtener todos los campos de todos los clientes de 'MADRID'
    ```sql
    SELECT * 
        FROM clientes
            WHERE ciudad
                LIKE 'MADRID'
    ````

    2. Obtener los nombres de todas las marcas de coches ordenadas alfabéticamente

    ```sql
    SELECT
        nombre
            FROM marcas
                ORDER BY nombre ASC
    ```

    3. Obtener el cifc de todos los concesionarios cuya cantidad en la tabla DISTRIBUCION es mayor que 18

    ```sql
    SELECT cifc
        FROM distribucion
            WHERE cantidad > 18;
    ```

    4. Obtener el cifc de todos los concesionarios cuya cantidad en la tabla de DISTRIBUCION esté comprendida entre 10 y 18 ambos inclusive

    ```sql
    SELECT cifc
        FROM distribucion
            WHERE cantidad
                BETWEEN 9 AND 19
    ```
    5. Resolver el problema anterior de otro modo

    ```sql
    SELECT cifc FROM distribucion
        WHERE cantidad
            IN (SELECT
                cantidad
                    FROM distribucion
                        GROUP BY cifc,cantidad
                            HAVING cantidad
                                BETWEEN 4 AND 10
                                    AND cantidad <> 5)
    ```

    6. Obtener el cifc de todos los concesionarios que han adquirido más de 10 coches o menos de 5

    ```sql
    SELECT cifc
        FROM distribucion
            WHERE cantidad < 5 OR cantidad > 10
    ```

    7. Obtener cuántos modelos de coches hay

    ```sql
    SELECT COUNT(modelo) AS cantidad_modelos
        FROM coches
    ```

    8. Obtener cuántos coches distribuye cada concesionario.

    ```sql
    SELECT c.nombre,SUM(d.cantidad)
        FROM concesionarios c, distribucion d
            WHERE c.cifc=d.cifc
                GROUP BY c.nombre
    ```

    9. Obtener los codcoche suministrados por algún concesionario de ‘BARCELONA’.

    ```sql
    SELECT d.codcoche
        FROM distribucion d
            WHERE d.cifc=(SELECT cifc
                            FROM concesionarios
                                WHERE ciudad
                                    LIKE 'BARCELONA')
    ```

    10. Obtener el codcoche de los coches que han sido adquiridos por un cliente de ‘MADRID’ a un concesionario de ‘MADRID’

    ```sql
    SELECT v.codcoche
        FROM ventas v,concesionarios c,clientes cl
            WHERE v.cifc=c.cifc
                AND v.dni=cl.dni
                    AND c.ciudad=cl.ciudad
                        AND c.ciudad
                            LIKE 'MADRID'
    ```

    11.  Obtener los codcoche de los coches comprados en un concesionario de distinta ciudad que el cliente lo compra.

    ```sql
    SELECT v.codcoche
        FROM ventas v,concesionarios c,clientes cl
            WHERE v.cifc=c.cifc
                AND v.dni=cl.dni
                    AND c.ciudad<>cl.ciudad
    ```

    12.  Obtener las parejas de modelos de coches cuyo nombre es el mismo y cuya marca es de ‘MADRID’.

    ```sql
    SELECT m1.modelo,m2.modelo
        FROM ventas,clientes c, coches m1
            JOIN coches m2
                ON m1.nombre=m2.nombre
                    WHERE ventas.codcoche=m1.codcoche
                        AND ventas.dni=c.dni
                            AND c.ciudad
                                LIKE 'MADRID'
                                    AND m1.modelo=m2.modelo
    ```

    13. Obtener todos los codcoche de los coches cuyo nombre no contiene ninguna ‘A’.

    ```sql
    SELECT codcoche
        FROM coches
            WHERE nombre
                NOT LIKE '%A%'
    ```

    14. Obtener la media de la cantidad de coches que tienen todos los concesionarios.

    ```sql
    SELECT distri.nombre,AVG(suma_cantidad)
        FROM (
            SELECT c.nombre
                AS nombre,SUM(d.cantidad)
                    AS suma_cantidad FROM
                        concesionarios c, distribucion d
                            WHERE d.cifc=c.cifc
                                GROUP BY nombre
            ) AS distri
                GROUP BY distri.nombre
    ```

    15. Obtener el dni con numeración más baja de todos los clientes que han comprado un coche ‘BLANCO’.

    ```sql
    SELECT MIN(dni)
        FROM ventas
            WHERE color
                LIKE 'BLANCO'
    ```

    16. Obtener cifm y nombre de las marcas de coches cuya segunda letra del nombre de la ciudad de origen sea una ‘I’.

    ```sql
    SELECT cifm,nombre
        FROM marcas
            WHERE nombre REGEXP '.I.I*'
    ```

    17. Obtener el NOMBRE y el APELLIDO de los clientes cuyo dni es menor que el de los clientes que son de ‘BARCELONA’.

    ```sql
    SELECT cl1.nombre,cl1.dni
        FROM clientes cl1   
            JOIN clientes cl2
                ON cl1.dni<cl2.dni  
                    WHERE cl1.ciudad<>'BARCELONA'   
                        GROUP BY cl1.nombre,cl1.dni,cl1.ciudad
    ```

    18. Obtener el NOMBRE y el APELLIDO de los clientes cuyo nombre empieza por ‘A’ y cuyo dni es mayor que el de ALGUNO de los clientes que son de ‘MADRID’.

    ```sql
    SELECT cl1.nombre, cl1.apellido
        FROM clientes cl1
        JOIN  clientes cl2
            ON cl2.dni<cl1.dni
                WHERE cl1.nombre
                    LIKE 'A%'
                        AND cl1.ciudad <> 'MADRID'
                            GROUP BY cl1.nombre
    ```