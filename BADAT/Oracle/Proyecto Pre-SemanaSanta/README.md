# Proyecto Pre-Semana Santa
## Indice
* [Creación de las tablas:](#1.-Creación-de-las-tablas)

  * [Creación tabla ruta](#1.1-Create-table-RUTA)

  * [Creación tabla avion](#1.-Create-table-avion)

  * [Creación tabla vuelo](#1.3-Create-table-vuelo)

* [Modificaciones en las tablas](#2.-Modificaciones-en-las-tablas)

  * [Añadir atributo fecha_de_vuelo a la tabla vuelo](#2.1-Añade-a-la-tabla-VUELO-el-atributo:-FECHA:fecha-de-vuelo)

  * [Añadir restricción al atributo fecha anteriormente introducido](2.2-Añade-el-atributo-FECHA,-anteriormente-introducido,-la-restricción-de-integridad-correspondiente-para-que-no-admita-valores-nulos.)
## 1. Creación de las tablas

### 1.1 Create table RUTA

```sql
CREATE TABLE ruta(
    cod NUMBER(3),
    compan VARCHAR2(3) NOT NULL,
    origen VARCHAR2(10) NOT NULL,
    destino VARCHAR2(10) NOT NULL,
    num_horas NUMBER(2) NOT NULL,
    CONSTRAINT pk_ruta PRIMARY KEY (cod)
);
ALTER TABLE ruta ADD CONSTRAINT ck_compan CHECK(compan IN('IBE','SPA','AIR'));
```

### 1.2 Create table avion

```sql
CREATE TABLE avion(
    mat VARCHAR2(3),
    modelo VARCHAR2(10) NOT NULL,
    plazas NUMBER(3),
    fechaa_rev DATE,
    CONSTRAINT pk_mar PRIMARY KEY(mat)
);
ALTER TABLE avion ADD CONSTRAINT ck_avion CHECK(plazas >=5 AND plazas <=300);
```

### 1.3 Create table vuelo

```sql
CREATE TABLE vuelo(
    cod NUMBER(3),
    mat VARCHAR2(3),
    ocupacion NUMBER(3),
    CONSTRAINT pk_vuelo PRIMARY KEY (mat),
    CONSTRAINT fk_vuelo_avion FOREIGN KEY(mat) REFERENCES avion(mat)
);
ALTER TABLE vuelo ADD CONSTRAINT ck_ocupacion CHECK(ocupacion <= 300);
```

## 2. Modificaciones en las tablas

### 2.1 Añade a la tabla VUELO el atributo: FECHA:fecha de vuelo

```sql
ALTER TABLE vuelo 
  ADD fecha DATE;
```

### 2.2 Añade el atributo FECHA, anteriormente introducido, la restricción de integridad correspondiente para que no admita valores nulos.

```sql
ALTER TABLE vuelo
   MODIFY fecha DATE NOT NULL;
```

### 2.3 Establece el atributo COD de la tabla VUELO como llave externa respecto de RUTA

```sql
ALTER TABLE vuelo
   ADD CONSTRAINT fk_vuelo_ruta
     FOREIGN KEY(cod) 
      REFERENCES ruta(cod);
```

### 2.4  Establece el conjunto de atributos formado por COD, MAT y FECHA como llave primaria de la tabla VUELO.

```sql
ALTER TABLE vuelo
   DROP CONSTRAINT pk_vuelo;
ALTER TABLE vuelo
   ADD CONSTRAINT pk_vuelo 
    PRIMARY KEY(cod,mat,fecha);
```

## 3. Inserción de datos

### 3.1 Realiza la inserció de valores de forma que las tablas queden como se muestra a continuación. Realiza la inserción de tuplas para cada tabla de manera independiente, ya que de esta forma es más sencillo detectar errores

### Inserción tabla RUTA

Filas a insertar:

<details>
  <summary>Tabla RUTA filas a insertar</summary>

 ![image](https://user-images.githubusercontent.com/23047899/54935552-d30e7a80-4f20-11e9-880e-46da923dc3f7.png)
</details>

- Codigo:
<details>
  <summary>Insert realizados a la tabla ruta</summary>

```sql
INSERT INTO ruta 
  VALUES (111,'IBE','MADRID','LONDRES',3);
INSERT INTO ruta 
  VALUES (222,'IBE','MADRID','PARIS',1);
INSERT INTO ruta 
  VALUES (333,'SPA','MADRID','BARCELONA',1);
INSERT INTO ruta 
  VALUES (444,'AIR','MADRID','BARCELONA',1);
```
</details>


Filas ya insertadas:

<details>
  <summary>Tabla RUTA filas ya insertadas</summary>

![image](https://user-images.githubusercontent.com/23047899/54935823-66e04680-4f21-11e9-8c79-f57e3e49aa50.png)
</details>

### Inserción tabla AVION

Filas a inserta:

<details>
  <summary>Tabla AVION filas a insertar</summary>

![image](https://user-images.githubusercontent.com/23047899/54937613-08b56280-4f25-11e9-9e29-e76d50011d93.png)
</details>

- Código:

<details>
<summary>Insert realizados a la tabla avion</summary>

```sql
INSERT INTO avion 
  VALUES ('AAA','ABUS-200',200,'10-JUN-2018');
INSERT INTO avion 
  VALUES ('BBB','ABUS-280',280,'');
INSERT INTO avion 
  VALUES ('CCC','B-747',300,'');
INSERT INTO avion 
  VALUES ('DDD','B-777',250,'10-OCT-2019');
```
</details>



Filas ya insertadas:

<details>
  <summary>Tabla AVION filas ya insertadas</summary>

![image](https://user-images.githubusercontent.com/23047899/55026006-5ce24480-5002-11e9-8557-74b1a5077263.png)
</details>

### Inserción tala VUELO

Filas a insertar:

<details>
  <summary >Tabla VUELO filas a insertar</summary>

![image](https://user-images.githubusercontent.com/23047899/55026939-5654cc80-5004-11e9-9de3-936973742bc5.png)
</details>

<details>
<summary>Filas a insertar en la tabla vuelo</summary>

```sql
INSERT INTO vuelo 
  VALUES(111,'BBB',250,'10-FEB-2018');
INSERT INTO vuelo 
  VALUES(222,'CCC',200,'10-FEB-2018');
INSERT INTO vuelo 
  VALUES(333,'AAA',200,'10-FEB-2018');
INSERT INTO vuelo 
  VALUES(444,'DDD',250,'10-FEB-2018');
INSERT INTO vuelo 
  VALUES(333,'AAA',100,'10-MAY-2018');
INSERT INTO vuelo 
  VALUES(444,'DDD',150,'10-MAY-2018');
INSERT INTO vuelo 
  VALUES(333,'AAA',50,'10-JUN-2018');
INSERT INTO vuelo 
  VALUES(444,'DDD',75,'10-JUN-2018');
```
</details>
- Codigo:


Filas ya insertadas:

<details>
  <summary >Tabla VUELO filas ya insertadas</summary>

![image](https://user-images.githubusercontent.com/23047899/55027186-f90d4b00-5004-11e9-9918-511480182368.png)
[ ![image](https://user-images.githubusercontent.com/23047899/55027186-f90d4b00-5004-11e9-9918-511480182368.png) ](https://user-images.githubusercontent.com/23047899/55027186-f90d4b00-5004-11e9-9918-511480182368.png)
</details>

## Modificaciones en las tablas

#### Realiza de una en una las siguientes modificaciones sobre la base de datos. Estudiar los posibles errores que aparezcan, comentando su significado (los comentarios se insertan utilizando /* ...comentario...*/). 

## 4. Update a las tablas

### 4.1 Retrasa un día la fecha de los vuelos del '10-MAY-2018'

```sql
UPDATE vuelo 
  SET fecha = '09-MAY-2018'
    WHERE fecha = '10-MAY-2018';
```

### 4.2 Aumenta en 1 hroa la duración de las rutas con destino 'PARIS'

```sql
UPDATE ruta 
  SET num_horas = num_horas+1
    WHERE destino LIKE 'PARIS';
```

### 4.3 Insert las siguientes tuplas en la tabla VUELO:

- Codigo a introducir:

```sql
INSERT INTO vuelo
  VALUES (111, 'EEE', 220, '10-MAY-2019'); /*No se pueden insertar datos ya que la clave primaria que se está intentando insertar no se encuentra en la tabla avion*/
INSERT INTO vuelo
  VALUES (111, 'BBB', 220, '10-MAY-2019');
```
Comenta que ha sucedido y cual es el motivo

Lo que ha sucecido es que al intentar insertar un valor en la clave primaria de avion y este no existir en dicha tabla ya que está como clave foránea salta un error diciendo que se a violado la **PRIMARY KEY** de avión:

![image](https://user-images.githubusercontent.com/23047899/55558503-82e7a300-56ec-11e9-9ba1-e2f0096d4fe9.png)

## 5. Consultas Select(I)

### 5.1 Muestra todos los aviones

```sql
SELECT * 
  FROM avion;
```
- Salida de la consulta SQL:
![image](https://user-images.githubusercontent.com/23047899/55559916-757fe800-56ef-11e9-8471-aedca0c2a71c.png)

### 5.2 Muestra el origen y destino de todas las rutas

```sql
SELECT origen,destino 
  FROM ruta;
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55560073-bf68ce00-56ef-11e9-8abd-310b20cbd95d.png)

### 5.3 Muestra el origen y el destino de todas las rutas que sean distintas

```sql
SELECT DISTINCT destino, origen
  FROM ruta;
```
- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55561878-35226900-56f3-11e9-9069-ae9799af1883.png)

### 5.4  Muestra la ocupación y la fecha de todos los vuelos. La información debe aparecer tal y como aparece abajo, ordenada por la fecha en orden inverso y con cuatro dígitos para el año.

```sql
SELECT ocupacion,to_char(fecha,'DD-MONTH-YYYY') AS FECHA2
  FROM vuelo
    ORDER BY fecha ASC;
```
- Salida de la consulta SQL:
![image](https://user-images.githubusercontent.com/23047899/55563883-04443300-56f7-11e9-9de3-d0cf84aa6474.png)

### 5.5 Muestra cómo quedarían las plazas de los aviones si fuera posible incrementarlas en un 10%.

```sql
SELECT modelo, plazas, plazas+plazas* 0.1
  AS plazas_definitivas
    FROM avion
      ORDER BY plazas_definitivas ASC;
```
- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55563932-1cb44d80-56f7-11e9-87d1-b5274e0d38f2.png)

### 5.6 ¿Qué compañías tiene como destino BARCELONA?

```sql
SELECT compan
  FROM ruta
    WHERE destino LIKE 'BARCELONA';
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55564194-9f3d0d00-56f7-11e9-851d-336652da8af1.png)

### 5.7 ¿Qué aviones no tienen todavía fecha de revisión?

```sql
SELECT *
  FROM avion
    WHERE fechaa_rev IS NULL;
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55564405-183c6480-56f8-11e9-8571-70d93a64207c.png)

### 5.8 Obtener un listado de los vuelos donde figure el origen y el destino de cada uno.

```sql
SELECT v.cod,mat,ocupacion,r.destino,fecha,r.origen
  FROM vuelo v, ruta r
    WHERE v.cod = r.cod;
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55566934-f5607f00-56fc-11e9-94db-bd97594f2307.png)

### 5.9 Muestra el origen, destino, compañía y ocupación de aquellos vuelos que van llenos.

```sql
SELECT origen,destino,compan,ocupacion,plazas
  FROM ruta r,vuelo v,avion a
    WHERE r.cod=v.cod
      AND a.mat=v.mat
        AND ocupacion=plazas;
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55568764-9997f500-5700-11e9-9c0e-bafe5e2d6d14.png)

### 5.10 Obtener las parejas de compañías aéreas que vuelan al mismo destino

```sql
SELECT compan,destino
  FROM ruta
    WHERE destino=(SELECT destino
                      FROM ruta
                        GROUP BY destino
                          HAVING COUNT(destino)>1);
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55581427-1a64ea00-571d-11e9-88fa-c3faf1fbd090.png)

## 6. Consultas SELECT(II)

### 6.1 ¿Cuál es la ocupación media y la suma total de pasajeros de los vuelos del 10-FEB-2018?

```sql
SELECT AVG(ocupacion) AS ocupacion_media,
  SUM(ocupacion) AS total_pasajeros
    FROM vuelo
      WHERE fecha = '10-FEB-2018';
```
- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55581755-f81f9c00-571d-11e9-937e-cee1528db915.png)
### 6.2  Muestra el número de compañias que vuelan a cada destino:

```sql
SELECT destino,COUNT(compan) AS num_compañias
  FROM ruta
    GROUP BY destino;
```
- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55582834-bcd29c80-5720-11e9-984e-6e9f6d0b2b42.png)

### 6.3  Calcula el número de horas de vuelo de cada compañía

```sql
SELECT compan,SUM(num_horas) AS horas_de_vuelo
  FROM ruta r , vuelo v
    WHERE v.cod=r.cod
      GROUP BY compan;
```
- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55592045-91a77780-5737-11e9-8113-aca80897a1ea.png)

### 6.4 Muestra los aviones que tienen 3 o más horas de vuelo

```sql
SELECT MAX(modelo),SUM(num_horas)
  FROM ruta r, vuelo v, avion a
    WHERE v.cod=r.cod
      AND v.mat=a.mat
        GROUP BY modelo;
```

- Salida de la consulta SQL:

![image](https://user-images.githubusercontent.com/23047899/55593907-e51cc400-573d-11e9-8b63-7fe854649d69.png)

### 6.5 ¿Cuáles son las matrículas de los aviones que vuelan en las mismas fechas que el avión de matrícula AAA? 
```sql
SELECT v.mat,v.fecha
  FROM vuelo v
    JOIN vuelo v2
      ON v.fecha=v2.fecha
        GROUP BY v.mat,v.fecha
          HAVING v.mat<>'AAA'
            ORDER BY mat ASC;
```

### 6.6  ¿Qué devuelve la siguiente consulta? Razona tu respuesta.

- Consulta:

```sql
SELECT modelo
  FROM avion av
    WHERE 3<=(SELECT sum(num_horas)
                FROM vuelo vu, ruta ru
                  WHERE vu.cod = ru.cod and vu.mat = av.mat);
```
- Resultado:

![image](https://user-images.githubusercontent.com/23047899/55613490-17084780-578b-11e9-8b52-73f88bf55cd3.png)

- Razonamiento

```
Esta consulta devuelve el modelo del avion cuando la suma de las horas de dicho avion sea menor o igual que 3
```

### 6.7  ¿Qué pareja de aviones tienen el mismo número de horas de vuelo? (Nivel: Alto) TERMINAR

- Consulta SQL:

```sql
SELECT m1.modelo, m2.modelo
  FROM avion m1, avion m2, vuelo v1
    JOIN vuelo v2
      ON v1.mat<>v2.mat
        JOIN ruta r1
          ON r1.cod=v1.cod
            JOIN ruta r2
              ON r2.cod=v2.cod
                WHERE r1.num_horas=r2.num_horas
                  AND m1.modelo<>m2.modelo
                    AND v1.mat<>v2.mat
                      AND m1.fechaa_revIS NOT NULL
                        AND m2.fechaa_rev IS NOT NULL
                          AND rownum < 2;
```
- Resultado:

![image](https://user-images.githubusercontent.com/23047899/55671223-068cc580-588e-11e9-9be2-c451fff4866f.png)

### 6.8 Inserta en la tabla RUTA la tupla (555,'IBE','MADRID','BARCELONA',1) ¿Qué pareja de compañias tienen en común algún destino?

- Insert a la tabla ruta:
```sql
INSERT INTO ruta
  VALUES(555,'IBE','MADRID','BARCELONA',1);
```
- Fila insertada en la columna:

![image](https://user-images.githubusercontent.com/23047899/55615265-3bfeb980-578f-11e9-9389-16ee3e67528a.png)

- Consulta SQL:

```sql
SELECT c1.compan, c2.compan
  FROM ruta c1
    JOIN ruta c2
      ON c1.destino=c2.destino
        WHERE c1.compan<>c2.compan
          GROUP BY c1.compan, c2.compan
            ORDER BY c1.compan;
```

### 6.9 Muestra aquellas compañías que hacen todas las rutas

- Consulta SQL:
```sql
SELECT c1.compan
  FROM ruta c1
    JOIN ruta
      ON c1.destino=ruta.destino
        GROUP BY c1.compan
          HAVING COUNT(c1.compan)>3;
```

## 7 Subconsultas DDL

### 7.1 Subconsultas en las sentencias INSERT, DELETE y UPDATE

####  7.1.1 Inserta para el día '10-JUL-2019' los mismo vuelos del día '10-FEB-2018' pero con una ocupación inicial de 0 pasajeros. Esta inserción se tiene que realizar con un único comando INSERT INTO e independientemente de los datos que se tengan almacenados en la base de datos, para ello utiliza la clausula subconsulta del comando INSERT INTO. Después de ejecutar la sentencia INSERT INTO, la información que debe mostrar la tabla es:

![image](https://user-images.githubusercontent.com/23047899/55673849-c9383000-58ad-11e9-9b6c-d82575caba23.png)

- Consulta SQL:
```sql
INSERT INTO vuelo(cod,mat,ocupacion,fecha)
  SELECT DISTINCT cod,mat,0,'10/07/2019'
    FROM vuelo
      wHERE fecha='10/02/2018';
```
- Resultado:

![Captura](https://user-images.githubusercontent.com/23047899/55674128-cb4fbe00-58b0-11e9-8ee1-7367cceaf50b.PNG)

#### 7.1.2 Actualiza con un único comando UPDATE e independientemente de los datos que se tengan almacenados en la base de datos, la ocupación de los vuelos realizados por el modelo 'ABUS200', de tal manera que se establezca al máximo permitido por ese avión.

![image](https://user-images.githubusercontent.com/23047899/55674161-0b16a580-58b1-11e9-9284-88152fb48dd8.png)

- Consulta SQL:

```sql
UPDATE vuelo
  SET ocupacion = 200
    WHERE mat=(SELECT mat
                  FROM avion
                    WHERE avion.modelo
                      LIKE 'ABUS-200');
```

- Resultado:

![Captura](https://user-images.githubusercontent.com/23047899/55674392-65fdcc00-58b4-11e9-8862-e846f71387a3.PNG)

#### 7.1.3  Actualiza con un único comando UPDATE e independientemente de los datos que se tengan almacenados, la ocupación de todos los vuelos, de tal manera que seestablezca al máximo permitido por el avión que los realiza. Ten en cuenta que en la subconsulta se puede utilizar como variable de tupla el alias de la tabla que aparece en la cláusula UPDATE. Tras la actualización la tabla debe quedar:

![image](https://user-images.githubusercontent.com/23047899/55674411-9f363c00-58b4-11e9-9738-5dc3abe8505e.png)

- Consulta SQL:

```sql

```