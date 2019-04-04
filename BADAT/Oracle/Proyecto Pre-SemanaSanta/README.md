# Proyecto Pre-Semana Santa
## Indice
1. [Creación de las tablas:](#1)

    1.1 [Creación tabla ruta](#1.1)

    1.1 [Creación tabla avion](#1.2)
    
    1.1 [Creación tabla vuelo](#1.3)
## 1. Creación de las tablas {#1}

### 1.1 Create table RUTA {#1.1}

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

### 1.2 Create table avion {#1.2}

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

### 1.3 Create table vuelo {#1.3}

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
  VALUES ('AAA','ABUS-200',280,'10-JUN-2018');
INSERT INTO avion 
  VALUES ('BBB','ABUS-280',300,'');
INSERT INTO avion 
  VALUES ('CCC','B-747',250,'');
INSERT INTO avion 
  VALUES ('DDD','B-777',200,'10-OCT-2019');
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

## 5. Consultas Select

### Muestra todos los aviones

```sql

```
