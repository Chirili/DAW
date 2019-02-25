# DAW

## Prácticas examen BBDD

### Ejercicio1

- Hallar la comisión, el nombre y el salario de los empleados con más de tres hijos, ordenados por comisión y, dentro de comisión, alfabéticamente.

```js
    SELECT comision,nombre,salario FROM empleados WHERE num_hijos IN (SELECT num_hijos FROM empleados WHERE num_hijos > 3) ORDER BY nombre ASC;
```

### Ejercicio2

- Obtener los nombres de los departamentos que no dependen de otros.

```js
    SELECT nombredepart FROM departamentos WHERE dpto_jefe IS null;
```

### Ejercicio3

- Obtener, por orden alfabético, los nombres y los salarios de los empleados cuyo salario esté comprendido entre 1250 y 1300 euros.

```js
    SELECT nombre,salario FROM empleados WHERE salario IN (SELECT salario FROM empleados WHERE salario BETWEEN 1250 AND 1300) ORDER BY nombre,salario ASC;
```

### Ejercicio4

- Datos de los empleados que cumplen la condición anterior o tienen al menos un hijo.

```js
    SELECT nombre,salario,num_hijos FROM empleados 
WHERE salario BETWEEN 1250 AND 1300
    OR num_hijos>=1
ORDER BY nombre,salario ASC;
```

### Ejercicio5

- Obtener, por orden alfabético, los nombres de los departamentos que no contengan la palabra 'Dirección' ni 'Sector'.

```js
    SELECT nombredepart FROM departamentos WHERE nombredepart NOT LIKE '%DIRECCION%' AND nombredepart NOT LIKE '%SECTOR%';
```

### Ejercicio6

- Obtener, por orden alfabético, los nombres de los departamentos que, o bien tienen directores en funciones y su presupuesto no excede los 5 mil euros, o bien no dependen de ningún otro departamento.

```js
    SELECT nombredepart FROM departamentos WHERE tipodirector LIKE '%F%' AND presupuesto <= 5000 OR dpto_jefe IS null ORDER BY nombredepart ASC;

```

### Ejercicio7

- Hallar, por orden de número de empleado, el nombre y el salario total (salario más comisión) de los empleados cuyo salario total supera los 1300 euros mensuales.

```js 
    SELECT cod,nombre,SUM(salario + comision) AS total FROM empleados WHERE total > 1300;
```
