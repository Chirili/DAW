# DAW

## Tema 6 Relación de ejercicio 3 GROUP BY y HAVING

### Ejercicio1

- Visualiza los departamentos en los que el salario medio es mayor o igual que la media de todos los salarios.

```js
```

### Ejercicio2

- Obtén los nombres de departamentos que tengan más de 4 personas trabajando.

```js
```

### Ejercicio3

- Analiza lo que ocurre si en lugar de COUNT(e.emp_no) ponemos COUNT(*) en la sentencia SELECT siguiente. Analiza también que ocurre si a la derecha de SELECT ponemos e.dept_no en lugar de d.dept_no:

```js
SELECT d.dept_no, dnombre, COUNT(e.emp_no)
FROM emple e, depart d
WHERE e.dept_no (+)= d.dept_no
GROUP BY d.dept_no, dnombre;
```

### Ejercicio4

- Obtén los nombres de alumnos que están actualmente en el centro y que estuvieron en el centro hace ya un tiempo, es decir, necesitamos los nombres que están en la tabla ALUM y que, además, aparezcan en la tabla ANTIGUOS. Este es el ejercicio 4 de la relación complementaria pero esta vez debes realizar la consulta usando el operador IN.

```js
```

### Ejercicio5

- Visualiza los nombres de los alumnos de la tabla ALUM que aparezcan en alguna de estas tablas: NUEVOS y ANTIGUOS.

```js
```

## TABLAS EMPLE Y DEPART

### Ejercicio6

- Partiendo de la tabla EMPLE, visualiza por cada oficio de los empleados del departamento ‘VENTAS’ la suma de salarios

```js
```

### Ejercicio7

- Selecciona aquellos apellidos de la tabla EMPLE cuyo salario sea igual a la media del salario en su departamento.

```js
```

### Ejercicio8

- A partir de la tabla EMPLE, visualiza el número de empleados de cada departamento cuyo oficio sea ‘EMPLEADO’.

```js
```

### Ejercicio9

- Desde la tabla EMPLE, visualiza el departamento que tenga más empleados cuyo oficio sea ‘EMPLEADO’.

```js
```

### Ejercicio10

- A partir de la tabla EMPLE y DEPART, visualiza el número de departamento y el nombre de departamento que tenga más empleados cuyo oficio sea ‘EMPLEADO’

```js
```

### Ejercicio11

- Busca los departamentos que tienen más de dos personas trabajando en la misma profesión.

```js
```

## TABLAS ALUM, ANTIGUOS Y NUEVOS

### Ejercicio12

- Visualiza los nombre de los alumnos de la tabla ALUM que aparezcan en estas dos tablas: ANTIGUOS y NUEVOS.

```js
```

### Ejercicio13

- Escribe las distintas formas en las que se puede poner la consulta anterior llegando al mismo resultado.

### Ejercicio14

- Visualiza aquellos nombres de la tabla ALUM que no estén en la tabla antiguos ni en la
tabla nuevos

## TABLA PERSONAL, PROFESORES Y CENTROS(hacer DESC en las tablas)

### Ejercicio15

- Realiza una consulta en la que aparezca por cada centro y en cada especialidad el número de profesores, Si el centro no tiene profesores, debe aparecer un 0 en la columna número de profesores. Las columnas a visualizar son: nombre de centro, especialidad y número de profesores.

### Ejercicio16

- Obtén por cada centro el número de empleados. Si el centro carece de empleados, ha de aparecer un 0 como número de empleados.

### Ejercicio17

- Obtén la especialidad con menos profesores.

## TABLAS BANCOS, SUCURSALES, CUENTAS Y MOVIMIENTOS (hacer DESC de las tablas)

### Ejercicio18

- Obtén los bancos con más sucursales. Los datos a obtener son:
| Nombre de banco|Nº Sucursales|
| Xxxxxx|xx|

### Ejercicio19

### Ejercicio20

### Ejercicio21