# Tema6. Consultas Básicas y Avanzadas

## [Documentacion](Documentacion)

### Relacion complementaria de ejemplos resueltos

1. Selecciona de la tabla EMPLE a todos los empleados del departamento 20 (dept_no=20). Además, la consulta debe aparecer ordenada por la columna apellido. Los campos que hay que consultar son: número de empleado,  apellido, oficio  y número de departamento.

```sql
SELECT emp_no, apellido, oficio, dept_no
    FROM emple
        WHERE dept_no= 20
            ORDER BY apellido;
```

2. Consulta a los empleados cuyo oficio sea ‘ANALISTA’ ordenado por número de empleado (columna emp_no).

```sql
SELECT *
    FROM emple
        WHERE oficio = ‘ANALISTA’
            ORDER BY emp_no;
```

3. Selecciona de la tabla EMPLE aquellas filas del departamento 10 y cuyo oficio sea ‘ANALISTA’. La consulta se ha de obtener de modo descendente por apellido y también  descendente por número de empleado (emp_no).
```sql
SELECT *
    FROM emple
        WHERE dept_no=10 AND oficio= ‘ANALISTA’
            ORDER BY apellido DESC, emp_no DESC;
```
4. Utiliza alias para las columnas dept_no y dnombre:

```sql
SELECT dnombre “Departamento”, dept_no “Número Departamento”
    FROM depart;
```
### Tabla notas_alumnos
-  Disponemos de las tabla NOTAS_Alumnos , que contiene las notas de los alumnos de primer curso de un ciclo de informática obtenidas en tres módulos. Las descripción de la tabla es la siguiente:

    | Notas_alumnos| | |
    |-----|----|-----|
    | nombre_alumno | VARCHAR2(25) | PK |
    | nota1 | NUMBER(2)| |
    | nota2 | NUMBER(2)| |
    | nota3 | NUMBER(2)| |



1. Se trata de obtener la nota media de cada alumno. Visualiza por cada uno de ellos su nombre y su nota media (suma de las tres notas dividida entre tres).

```sql
SELECT nombre_alumno “Nombre Alumno”, (nota1+nota2+nota3)/3 “Nota Media”
    FROM notas_alumnos;
```
2. A partir de la tabla NOTAS_ALUMNOS, deseamos obtener aquellos nombres de alumnos que tengan un 7 en NOTA1 y cuya media sea mayor que 6:

```sql
SELECT nombre_alumno
    FROM notas_alumnos
        WHERE nota1=7 AND (nota1+nota2+nota3)/3>6;
```

- A continuación se muestran ejemplos del uso de la clausala LIKE:

    | Clausula LIKE | Salida |
    | -----| -----|
    | LIKE 'Director'| La cadena 'Director' |
    | LIKE 'M%' | Cualquier cadena que empieze por 'M'|
    |LIKE '%X%'|Cualquier cadena que contenga la 'X'|
    |LIKE '__M'|Cualquier cadena de 3 caracteres terminada en M|
    |LIKE 'N_'|Cualquier cadena de 2 caracteres que empiece en N|
    |LIKE '_R%'|Cualquier cadena cuyo segundo caracter sea una R|

 > Hemos de tener en cuenta que las mayúsculas y minúsculas son significativas (‘m’ no es lo mismo que ‘M’) y que las consonantes alfanuméricas deben encerrarse siempre entre comillas simples.

 ### Tabla EMPLE

1. A partir de la tabla EMPLE, obtén aquellos apellidos que empiecen por una ‘J’.

```sql
SELECT apellido
    FROM emple
        WHERE apellido LIKE ‘J%’
```
2. Obtén aquellos apellidos que tengan una ‘R’ en la segunda posición.

```sql
SELECT apellido
    FROM emple
        WHERE apellido LIKE ‘_R%’
```

3.  Obtén aquellos apellidos que empiecen por ‘A’ y tengan una ‘O’ en su interior.

```sql
SELECT apellido
    FROM emple
        WHERE apellido LIKE ‘A%O%’
```
### Tabla libreria
- A continuación consideramos la tabla LIBRERÍA, cuya descripción es la siguiente:

||Libreria||
|----|----|----|
|tema|VARCHAR2(15)|PK|
|estante|VARCHAR2(15)||
|ejemplares|NUMBER(2)||

1. Consultamos las filas de la tabla LIBRERÍA cuyo tema sea ‘LABORES’; usamos el operador ‘=’.
```sql
SELECT *
    FROM libreria
        WHERE tema=’LABORES’;
```

2. Hacemos lo mismo, pero ahora manejando el operador LIKE:
```sql
SELECT *
    FROM libreria
        WHERE tema LIKE ’LABORES’;
```
> Nota: la consulta devuelve vacío porque está definido como CHAR y no como VARCHA2, y este tipo rellena en blanco a la derecha hasta los 15 caracteres. Para que funcione tendrás que usar el comodín %

```sql
SELECT *
    FROM libreria
        WHERE tema=’LABORES%’;
```
### Tabla EMPLE
 **Para los dos primero ejercicios, la lista de valores está formada por números, y para los restantes estará formada por cadenas.**

 1. Consulta los apellidos de la tabla EMPLE cuyo número de departamento sea 10 ó 30.
 ```sql
 SELECT apellido
    FROM emple
        WHERE dept_no IN (10,30);
 ```
2. Consulta los apellidos de la tabla EMPLE cuyo número de departamento no sea  10 ni 30.
```sql
SELECT apellido
    FROM emple
        WHERE dept_no NOT IN (10,30);
```

3. Consulta los apellidos de la tabla EMPLE cuyo oficio sea ‘VENDEDOR’,’ANALISTA’ o ‘EMPLEADO’.
```sql
SELECT apellido
    FROM emple
        WHERE oficio IN (‘VENDEDOR’,’ANALISTA’,’EMPLEADO’);
```

4. Consulta los apellidos de la tabla EMPLE cuyo oficio no sea ‘VENDEDOR’, ni  ANALISTA’ ni ‘EMPLEADO’.

```sql
SELECT apellido
    FROM emple
        WHERE oficio IN (‘VENDEDOR’,’ANALISTA’,’EMPLEADO’);
```

- **A partir de la tabla EMPLE, obtén el apellido y el salario de los empleados cuyo  salario esté comprendido entre 1500 y 2000. ¿Y si se pidiesen el salario de los empleado cuyo salario no esté comprendido entre 1500 y 2000?**

```sql
/*Salario comprendido entre 1500 y 2000*/
SELECT apellido, salario
    FROM emple
        WHERE salario BETWEEN 1500 AND 2000;
/*Salario no comprendido entre 1500 y 2000*/
SELECT apellido, salario
    FROM emple WHERE
        salario NOT BETWEEN 1500 AND 2000;
```

- **A partir de la tabla EMPLE, obtén el APELLIDO, SALARIO y DEPT_NO de los empleados cuyo salario sea mayor de 2000 en los departamentos 10 o 20. ¿Qué ocurre si no usas paréntesis?**

```sql
/*
* apellido,salario y dept_no de la tabla emple, cuando el salario sea mayor a 2000 y dept_no sea igual a 10 o 20
*/
SELECT apellido, salario, dept_no
    FROM emple
        WHERE salario > 2000 AND (dept_no=10 AND dept_no=20)

SELECT apellido, salario, dept_no
    FROM emple
        WHERE salario > 2000 AND dept_no IN (10,20)
```
-  **Con la tabla EMPLE, obtén el APELLIDO de los empleados con el mismo OFICIO que ‘GIL’. Para ello, descomponemos el enunciado en dos consultas, que se pueden resumir en una consulta anidada.**

```sql
SELECT apellido
    FROM emple
        WHERE oficio = (SELECT oficio
                            FROM emple
                                WHERE apellido = ‘GIL’);
```
- **Usamos las tablas EMPLE y DEPART.**

1.  Queremos consultar los datos de los empleados que trabajen en ‘MADRID’ o ‘BARCELONA’. La localidad de los departamentos se obtiene de la tabla DEPART. Hemos de relacionar las tablas EMPLE y DEPART por el número de departamento.
```sql
SELECT emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no
    FROM emple
        WHERE dept_no IN (SELECT dept_no
                            FROM depart
                                WHERE loc in (‘MADRID’,’BARCELONA’))
```

2. Consulta los apellidos y oficio de todos los empleados del departamento 20 cuyo trabajo sea idéntico al de cualquiera de los empleados del departamento ‘VENTAS’.
```sql
SELECT apellido, oficio
    FROM emple
        WHERE dept_no=20 AND oficio IN (SELECT oficio
            FROM emple
                WHERE dept_no = (SELECT dept_no
                    FROM depart
                        WHERE dnombre = ‘VENTAS’));
```
3. Obtén el apellido de los empleados con el mismo oficio y salario que ‘GIL’. En esta consulta se introduce una variante: hasta ahora las subconsultas nos devolvían una columna, aunque pueden devolver más de una. En este caso la subconsulta ha de devolver dos columnas.
```sql
SELECT apellido, salario
    FROM emple
        WHERE (oficio, salario) = (SELECT oficio, salario
            FROM emple
                WHERE apellido = ‘GIL’);
```
- **A partir de la tabla EMPLE y DEPART obtener los siguientes datos de los empleados: APELLIDO, OFICIO, EMP_NO(número de empleado), DNOMBRE, LOC. Estas tablas tienen en común el DEPT_NO, por el que se combinan dichas tablas.**
```sql
SELECT apellido, oficio, emp_no, dnombre, loc
    FROM emple, depart
        WHERE emple.dept_no=depart.dept_no;
```
- **Dadas las siguientes tablas:**
    - **ALUMNOS**: contiene los datos de los alumnos:
        ||ALUMNOS||
        |---|----|---|
        |Dni|VARCHAR2(10)|pk|
        |Apenom|VARCHAR2(30)||
        |Direc|VARCHAR2(30)||
        |Pobla|VARCHAR2(15)||
        |Telef|VARCHAR2(10)||
    - **ASIGNATURAS:** contiene los nombres de las asignaturas y sus códigos:
        ||NOTAS||
        |----|-----|-----|
        |Cod|NUMBER(2)|pk|
        |Nombre|VARCHAR2(25)|pk|
    - **NOTAS:** contiene las notas de cada alumno en cada asignatura. Se relaciona con ALUMNO por dni y con ASIGNATURA por cod:
        ||NOTAS||
        |----|-----|-----|
        |Dni|VARCHAR2(10)|pk,fk|
        |Cod|NUMBER(2)|pk,fk|
        |Nota|NUMBER(2)||
1. Realiza una consulta para obtener el nombre del alumno, su asignatura y su nota:
```sql
SELECT apenom, nombre, nota
    FROM alumnos, asignaturas, notas
        WHERE alumnos.dni = notas.dni AND notas.cod = asignaturas.cod;
```
2. Obtén los nombres de los alumnos matriculados en ‘FOL’:

```sql
SELECT apenom
    FROM alumnos, asignaturas, notas
        WHERE alumnos.dni=notas.dni and notas.cod=asignaturas.cod AND nombre=’FOL’;
```
