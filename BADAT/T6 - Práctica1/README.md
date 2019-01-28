# DAW

## Práctica 1 Tema 6 Base de datos.

### Consultas SQL
#### Ejercicio 1
1. 1.a  Obtén todos los datos del alumno:
  - ```markdownSELECT * FROM alum0405;```
2. 1.b Obtén los siguientes datos del alumno: dni, nombre, apellidos, curso, nivel y clase.
  - SELECT dni,nombre,apellidos,curso,nivel,clase FROM alum0405;
3. 1.c Obtén todos los datos del alumno cuya población sea ‘GUADALAJARA’.
  - SELECT * FROM alum0405 WHERE poblacion='GUADALAJARA';
4. 1.d Obtén el nombre y apellidos de todos los alumnos cuya población sea ‘GUADALAJARA’.
  - SELECT nombre,apellidos FROM alum0405 WHERE poblacion='GUADALAJARA';
5. 1.e Consulta el dni, nombre, apellidos, curso, nivel y clase de todos los alumnos ordenados por apellido y nombre ascendente.
  - SELECT dni,nombre,apellidos,curso,nivel,clase FROM alum0405 ORDER BY nombre,apellidos ASC;
#### Ejercicio 2
2. Muestra los datos (apellido, oficio, salario y fecha de alta) de aquellos empleados que desempeñen el mismo oficio que ‘JIMENEZ’ o que tengan un salario mayor o igual que ‘FERNANDEZ’.
  - SELECT apellido,oficio,salario,fecha_alt FROM emple WHERE oficio LIKE 'DIRECTOR' OR salario >= '3000';
#### Ejercicio 3
3. Presenta los apellidos y oficios de los empleados que tienen el mismo trabajo que ‘JIMENEZ’.
  - SELECT apellido,oficio FROM emple WHERE oficio LIKE 'DIRECTOR';
#### Ejercicio 4
4. Muestra en pantalla el APELLIDO, OFICIO y SALARIO de los empleados del departamento de ‘FERNANDEZ’ que tengan su mismo salario.
  - SELECT apellido,oficio,salario FROM emple WHERE salario LIKE '3000';
#### Ejercicio 5
5. Visualiza los nombres de alumnos que tengan una nota entre 7 y 8 en la asignatura de ‘FOL’
  - SELECT APENOM FROM ALUMNOS, NOTAS WHERE NOTA IN (SELECT NOTA FROM NOTAS WHERE COD IN (SELECT COD FROM ASIGNATURAS WHERE NOTA BETWEEN 7 AND 8)AND ALUMNOS.DNI=NOTAS.DNI)
#### Ejercicio 6
5. Visualiza los nombres de las asignaturas que no tengan suspensos.
  - SELECT nombre FROM asignaturas, NOTAS WHERE NOTA IN (SELECT NOTA FROM NOTAS WHERE nota>5);
### Tablas EMPLE y DEPART
#### Ejercicio 7
7. Selecciona el apellido, el oficio y la localidad de los departamentos de aquellos empleados cuyo oficio sea “ANALISTA”.
  - SELECT apellido,oficio,loc FROM emple,depart WHERE oficio LIKE 'ANALISTA';
#### Ejercicio 8
8. Obtén los datos de los empleados cuyo director (columna DIR de la tabla EMPLE) sea “CEREZO”.
  -  SELECT * FROM EMPLE WHERE DIR=(SELECT emp_no FROM emple WHERE oficio='DIRECTOR' AND apellido='CEREZO');
#### Ejercicio 9
9. Obtén los datos de los empleados del departamento de “VENTAS”.
  - SELECT*FROM EMPLE WHERE dept_no=(SELECT dept_no FROM depart WHERE dnombre='VENTAS');
#### Ejercicio 10
10. - Obtén los datos de los departamentos que NO tengan empleados.
  - SELECT * FROM depart WHERE dept_no NOT IN(SELECT dept_no FROM emple);
#### Ejercicio 11
11. Obtén los datos de los departamentos que tengan empleados.
  - SELECT * FROM depart WHERE dept_no IN(SELECT DISTINCT dept_no FROM emple);
#### Ejercicio 12
12. Obtén el apellido y el salario de los empleados que superen todos los salarios de los empleados del departamento 20.
  - SELECT apellido, salario FROM EMPLE WHERE salario>(SELECT MAX(salario) FROM EMPLE WHERE dept_no=20)
### Tabla Libreria
#### Ejercicio 13
13. Visualiza el tema, estante y ejemplares de las filas de LIBRERÍA con ejemplares comprendidos entre 8 y 15.
  - SELECT tema,estante FROM libreria WHERE ejemplares BETWEEN 8 AND 15;
#### Ejercicio 14
14. Visualiza  las  columnas  TEMA, ESTANTE  y  EJEMPLARES  de  las  filas  cuyo  ESTANTE  no  esté comprendido entre la “8” y la “0”.
  - SELECT tema,estante,ejemplares FROM libreria WHERE ejemplares NOT IN(1,2,3,4,5,6,7,8);
#### Ejercicio 15
15. Visualizar  con  una  sola  orden  SELECT  todos  los  temas  de  LIBRERÍA  cuyo  número  de ejemplares sea inferior a los que hay en “MEDICINA”.
  - SELECT tema FROM libreria WHERE ejemplares <(SELECT ejemplares FROM libreria WHERE tema='MEDICINA')
#### Ejercicio 16
16. Visualiza los temas de L IBRERÍA cuyo número de ejemplares no esté entre 15 y 20, ambos incluidos.
  - SELECT tema FROM libreria WHERE ejemplares NOT IN(15,16,17,18,19,20);
### TABLAS ALUMNOS, ASIGNATURAS y NOTAS
17. 
