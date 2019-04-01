# Proyecto Pre-Semana Santa

## 1. Creacion de las tablas

### Tabla RUTA

```js
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

### Tabla avion

```js
CREATE TABLE avion(
    mat VARCHAR2(3),
    modelo VARCHAR2(10) NOT NULL,
    plazas NUMBER(3),
    fechaa_rev DATE,
    CONSTRAINT pk_mar PRIMARY KEY(mat)
);
ALTER TABLE avion ADD CONSTRAINT ck_avion CHECK(plazas >=5 AND plazas <=300);
```

### Tabla vuelo

```js
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

```js
ALTER TABLE vuelo ADD fecha DATE;
```

### 2.2 Añade el atributo FECHA, anteriormente introducido, la restricción de integridad correspondiente para que no admita valores nulos.

```js
ALTER TABLE vuelo MODIFY fecha DATE NOT NULL;
```

### 2.3 Establece el atributo COD de la tabla VUELO como llave externa respecto de RUTA

```js
ALTER TABLE vuelo ADD CONSTRAINT fk_vuelo_ruta FOREIGN KEY(cod) REFERENCES ruta(cod);
```

### 2.4  Establece el conjunto de atributos formado por COD, MAT y FECHA como llave primaria de la tabla VUELO.

```js
ALTER TABLE vuelo DROP CONSTRAINT pk_vuelo;
ALTER TABLE vuelo ADD CONSTRAINT pk_vuelo PRIMARY KEY(cod,mat,fecha);
```

## 3. Inserción de datos

### 3.1 Realiza la inserció de valores de forma que las tablas queden como se muestra a continuación. Realiza la inserción de tuplas para cada tabla de manera independiente, ya que de esta forma es más sencillo detectar errores

### Inserción tabla RUTA

Filas a insertar:

<details>
  <summary class="imagen">Tabla RUTA filas a insertar</summary>

 ![image](https://user-images.githubusercontent.com/23047899/54935552-d30e7a80-4f20-11e9-880e-46da923dc3f7.png)
</details>

- Codigo:
```js
INSERT INTO ruta VALUES (111,'IBE','MADRID','LONDRES',3);
INSERT INTO ruta VALUES (222,'IBE','MADRID','PARIS',1);
INSERT INTO ruta VALUES (333,'SPA','MADRID','BARCELONA',1);
INSERT INTO ruta VALUES (444,'AIR','MADRID','BARCELONA',1);
```

Filas ya insertadas:

<details>
  <summary class="imagen">Tabla RUTA filas ya insertadas</summary>

![image](https://user-images.githubusercontent.com/23047899/54935823-66e04680-4f21-11e9-8c79-f57e3e49aa50.png)
</details>

### Inserción tabla AVION

Filas a inserta:

<details>
  <summary class="imagen">Tabla AVION filas a insertar</summary>

![image](https://user-images.githubusercontent.com/23047899/54937613-08b56280-4f25-11e9-9e29-e76d50011d93.png)
</details>

- Código:

```js
INSERT INTO avion VALUES ('AAA','ABUS-200',280,'10-JUN-2018');
INSERT INTO avion VALUES ('BBB','ABUS-280',300,'');
INSERT INTO avion VALUES ('CCC','B-747',250,'');
INSERT INTO avion VALUES ('DDD','B-777',200,'10-OCT-2019');
```

Filas ya insertadas:

<details>
  <summary class="imagen">Tabla AVION filas ya insertadas</summary>

![image](https://user-images.githubusercontent.com/23047899/55026006-5ce24480-5002-11e9-8557-74b1a5077263.png)
</details>

### Inserción tala VUELO

Filas a insertar:

<details>
  <summary class="imagen">Tabla VUELO filas a insertar</summary>

![image](https://user-images.githubusercontent.com/23047899/55026939-5654cc80-5004-11e9-9de3-936973742bc5.png)
</details>

- Codigo:
```js
INSERT INTO vuelo VALUES(111,'BBB',250,'10-FEB-2018');
INSERT INTO vuelo VALUES(222,'CCC',200,'10-FEB-2018');
INSERT INTO vuelo VALUES(333,'AAA',200,'10-FEB-2018');
INSERT INTO vuelo VALUES(444,'DDD',250,'10-FEB-2018');
INSERT INTO vuelo VALUES(333,'AAA',100,'10-MAY-2018');
INSERT INTO vuelo VALUES(444,'DDD',150,'10-MAY-2018');
INSERT INTO vuelo VALUES(333,'AAA',50,'10-JUN-2018');
INSERT INTO vuelo VALUES(444,'DDD',75,'10-JUN-2018');
```

Filas ya insertadas:

<details>
  <summary class="imagen">Tabla VUELO filas ya insertadas</summary>

![image](https://user-images.githubusercontent.com/23047899/55027186-f90d4b00-5004-11e9-9918-511480182368.png)
</details>

## Modificaciones en las tablas

### Realiza de una en una las siguientes modificaciones sobre la base de datos. Estudiar los posibles errores que aparezcan, comentando su significado (los comentarios se insertan utilizando /* ...comentario...*/). 