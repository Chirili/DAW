# DAW

## Tema 6 Relación de ejercicio 3 GROUP BY y HAVING

### Ejercicio1

- Visualiza los departamentos en los que el salario medio es mayor o igual que la media de todos los salarios.

```js
SELECT dept_no,AVG(salario) FROM emple GROUP BY dept_no HAVING AVG(salario) >= (SELECT AVG(salario) FROM emple);
```

### Ejercicio2

- Obtén los nombres de departamentos que tengan más de 4 personas trabajando.

```js
SELECT dnombre FROM depart WHERE dept_no IN (SELECT dept_no FROM emple  GROUP BY dept_no  HAVING COUNT (*)>4);

```

### Ejercicio3

- Analiza lo que ocurre si en lugar de COUNT(e.emp_no) ponemos COUNT(*) en la sentencia SELECT siguiente.

![Diferencia entre COUNT(e.emp_no) y COUNT(*)](https://user-images.githubusercontent.com/23047899/52965631-9097d200-33a5-11e9-896f-6b07bad2ba31.png)

- Analiza también que ocurre si a la derecha de SELECT ponemos e.dept_no en lugar de d.dept_no:

![Diferencia entre e.dept_no y d.dept_no](https://user-images.githubusercontent.com/23047899/52965958-5e3aa480-33a6-11e9-9cd8-eee710774d02.png)

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
SELECT nombre FROM alum INTERSECT (SELECT nombre FROM nuevos UNION SELECT nombre FROM antiguos);
```

## TABLAS EMPLE Y DEPART

### Ejercicio6

- Partiendo de la tabla EMPLE, visualiza por cada oficio de los empleados del departamento ‘VENTAS’ la suma de salarios

```js
SELECT SUM(salario),oficio FROM emple WHERE dept_no IN (SELECT dept_no FROM depart WHERE dnombre LIKE 'VENTAS') GROUP BY oficio; 
```

### Ejercicio7

- Selecciona aquellos apellidos de la tabla EMPLE cuyo salario sea igual a la media del salario en su departamento.

```js

```

### Ejercicio8

- A partir de la tabla EMPLE, visualiza el número de empleados de cada departamento cuyo oficio sea ‘EMPLEADO’.

```js
SELECT dept_no,COUNT(*) FROM emple WHERE oficio LIKE 'EMPLEADO' GROUP BY dept_no;
```

### Ejercicio9

- Desde la tabla EMPLE, visualiza el departamento que tenga más empleados cuyo oficio sea ‘EMPLEADO’.

```js
SELECT dept_no,COUNT(*) FROM emple WHERE oficio LIKE 'EMPLEADO' GROUP BY dept_no HAVING COUNT(*)=(SELECT MAX(COUNT(*)) FROM emple WHERE oficio LIKE 'EMPLEADO' GROUP BY dept_no);
```

### Ejercicio10

- A partir de la tabla EMPLE y DEPART, visualiza el número de departamento y el nombre de departamento que tenga más empleados cuyo oficio sea ‘EMPLEADO’

```js
SELECT dept_no,dnombre FROM depart WHERE dept_no=(SELECT dept_no FROM emple WHERE oficio= 'EMPLEADO' GROUP BY dept_no HAVING COUNT(*)=(SELECT MAX(COUNT(*)) FROM emple WHERE oficio='EMPLEADO' GROUP BY dept_no));
```

### Ejercicio11

- Busca los departamentos que tienen más de dos personas trabajando en la misma profesión.

```js
SELECT dept_no,COUNT(*) FROM emple GROUP BY dept_no HAVING COUNT(*)>2;
```

## TABLAS ALUM, ANTIGUOS Y NUEVOS

### Ejercicio12

- Visualiza los nombre de los alumnos de la tabla ALUM que aparezcan en estas dos tablas: ANTIGUOS y NUEVOS.

```js
SELECT nombre FROM alum INTERSECT (SELECT nombre FROM nuevos UNION SELECT nombre FROM antiguos);
```

### Ejercicio13

- Escribe las distintas formas en las que se puede poner la consulta anterior llegando al mismo resultado.

```js
SELECT nombre FROM alum WHERE nombre IN (SELECT nombre FROM nuevos) OR nombre IN (SELECT nombre FROM antiguos);
```

### Ejercicio14

- Visualiza aquellos nombres de la tabla ALUM que no estén en la tabla antiguos ni en la
tabla nuevos

```js
SELECT nombre FROM alum INTERSECT SELECT nombre FROM antiguos INTERSECT SELECT nombre FROM nuevos;
```

## TABLA PERSONAL, PROFESORES Y CENTROS(hacer DESC en las tablas)

### Ejercicio15

- Realiza una consulta en la que aparezca por cada centro y en cada especialidad el número de profesores, Si el centro no tiene profesores, debe aparecer un 0 en la columna número de profesores. Las columnas a visualizar son: nombre de centro, especialidad y número de profesores.

```js
SELECT nombre,especialidad,COUNT(dni) FROM centros,profesores WHERE centros.cod_centro =profesores.cod_centro GROUP BY nombre,especialidad ORDER BY COUNT (dni);
```

### Ejercicio16

- Obtén por cada centro el número de empleados. Si el centro carece de empleados, ha de aparecer un 0 como número de empleados.

```js
 SELECT nombre,COUNT(DNI) FROM CENTROS,PERSONAL WHERE centros.cod_centro =personal.cod_centro GROUP BY nombre ORDER BY COUNT (DNI) DESC;
```

### Ejercicio17

- Obtén la especialidad con menos profesores.

```js
SELECT especialidad FROM profesores WHERE apellidos=(SELECT MAX(apellidos) FROM profesores);
```

## TABLAS BANCOS, SUCURSALES, CUENTAS Y MOVIMIENTOS (hacer DESC de las tablas)

### Ejercicio18

- Obtén los bancos con más sucursales. Los datos a obtener son:

```plain
| Nombre de banco|Nº Sucursales|
|     Xxxxxx     |     xx      |
```

```js
 SELECT NOMBRE_BANC,COUNT(*) FROM bancos,sucursales WHERE bancos.cod_banco=sucursales.cod_banco GROUP BY nombre_banc HAVING COUNT(*)=(SELECT MAX(COUNT(*)) FROM bancos,sucursales WHERE bancos.cod_banco=sucursales.cod_banco GROUP BY nombre_banc);
```
### Ejercicio19

- El saldo actual de los bancos de GUADALAJARA, 1 fila por cada banco:

```plain
| Nombre de banco|Saldo debe|Saldo Haber|
|     Xxxxxx     |  xx ,xx  |   xx,xx   |
```

```js
 SELECT nombre_banc,SUM(saldo_debe),SUM(saldo_haber) FROM BANCOS,CUENTAS WHERE bancos.cod_banco=cuentas.cod_banco AND poblacion='GUADALAJARA' GROUP BY bancos.nombre_banc;
```
### Ejercicio20

- Datos de la cuenta o cuentas con más movimientos:

```plain
| Nombre Cta|Nº Movimientos|
|   Xxxxxx  |      xx      |
```

```js

```
### Ejercicio21

- El nombre de la sucursal que haya tenido más suma de reintegros:

```plain
| Nombre Sucursal|Suma Reintegros|
|     Xxxxxx     |         xx,xx |
```

```js
    SELECT nombre_suc,SUM(importe) FROM sucursales,movimientos WHERE sucursales.cod_banco = movimientos.cod_banco AND sucursales.cod_sucur=movimientos.cod_sucur  AND movimientos.tipo_mov='R' GROUP BY nombre_suc HAVING SUM(importe)=(SELECT MAX(SUM(importe)) FROM movimientos WHERE movimientos.tipo_mov='R' GROUP BY cod_banco,cod_sucur);
```