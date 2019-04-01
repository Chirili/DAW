# Relación de ejercicio en MYSQL

## Ejercicio-5 MYSQL

### Create table trabajador

```js
CREATE TABLE trabajador(
	id_t INT,
    nombre VARCHAR(20),
    tarifa DECIMAL(4),
    oficio VARCHAR(15),
    CONSTRAINT pk_trabajador PRIMARY KEY(id_t)
) ALTER TABLE trabajador ADD id_supv INT NULL REFERENCES trabajador
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
)
```

### Create table asignacion
