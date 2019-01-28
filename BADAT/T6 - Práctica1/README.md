# DAW

## Práctica 1 Tema 6 Base de datos.

### Consultas SQL
#### Ejercicio1
1. 1.a  Obtén todos los datos del alumno:
  - SELECT * FROM alum0405;
2. 1.b Obtén los siguientes datos del alumno: dni, nombre, apellidos, curso, nivel y clase.
  - SELECT dni,nombre,apellidos,curso,nivel,clase FROM alum0405;
3. 1.c Obtén todos los datos del alumno cuya población sea ‘GUADALAJARA’.
  - SELECT * FROM alum0405 WHERE poblacion='GUADALAJARA';
4. 1.d Obtén el nombre y apellidos de todos los alumnos cuya población sea ‘GUADALAJARA’.
  - SELECT nombre,apellidos FROM alum0405 WHERE poblacion='GUADALAJARA';
5. 1.e Consulta el dni, nombre, apellidos, curso, nivel y clase de todos los alumnos ordenados por apellido y nombre ascendente.
  - SELECT dni,nombre,apellidos,curso,nivel,clase FROM alum0405 ORDER BY nombre,apellidos ASC;

#### Ejercicio2
2. Muestra los datos (apellido, oficio, salario y fecha de alta) de aquellos empleados que desempeñen el mismo oficio que ‘JIMENEZ’ o que tengan un salario mayor o igual que ‘FERNANDEZ’.
  - SELECT apellido,oficio,salario,fecha_alt FROM emple WHERE oficio LIKE 'DIRECTOR' OR salario >= '3000';
3. Presenta los apellidos y oficios de los empleados que tienen el mismo trabajo que ‘JIMENEZ’.
  - SELECT apellido,oficio FROM emple WHERE oficio LIKE 'DIRECTOR';
4. Muestra en pantalla el APELLIDO, OFICIO y SALARIO de los empleados del departamento de ‘FERNANDEZ’ que tengan su mismo salario.
  - SELECT apellido,oficio,salario FROM emple WHERE salario LIKE '3000';
5. Visualiza los nombres de alumnos que tengan una nota entre 7 y 8 en la asignatura de ‘FOL’.
  - SELECT apenom FROM notas,alumnos,asignaturas
  WHERE nota between 7 AND 8
  AND asignaturas.cod = notas.cod and
  alumnos.dni = notas.dni


