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
2. 
