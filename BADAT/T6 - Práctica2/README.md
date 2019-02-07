# DAW

## Práctica 1 Tema 6 BBDD.

### Consultas SQL
### Actividades Propuestas 2
#### Ejercicio 1
1. ¿Cual sería la salida de ejecutar estas funciones?

| ABS(146)=146     | ABS(-30)=30     | POWER(3,-1)=0.33        | ROUND(33.67)= 34      |
| ---------------- | --------------- | ----------------------- | --------------------- |
| CEIL(2)= 2       | CEILT (1.3)= 2  | ROUND(-33.67,2)= -33.67 | ROUND(-33.67, -2)= 0  |
| ---------------- | --------------- | ----------------------- | --------------------- |
| CEILT (-2.3)= -2 | CEILT(-2)= -2   | ROUND(-33.27,1)= -33.3  | ROUND(-33.27,-1)= -30 |
| ---------------- | --------------- | ----------------------- | --------------------- |
| FLOOR(-2)= -2    | FLOOR(-2.3)= -3 | TRUNC(67.232)= 67       | TRUNC(67.232,-2)= 67  |
| ---------------- | --------------- | ----------------------- | --------------------- |
| FLOOR(2)= 2      | FLOOR(1.3)= 1   | TRUNC(67.232,2)= 67.23  | TRUNC(67.58,-1)= 60   |
| ---------------- | --------------- | ----------------------- | --------------------- |
| MOD(22,23)=      | MOD(10,3)=      | TRUNC(67.58,1)= 67.5    | --------------------- |
| ---------------- | --------------- | ----------------------- | --------------------- |
| POWER(10,0)= 1   | POWER(3,2)= 9   | ----------------------- | --------------------- |

#### Ejercicio 2
2. Realiza las dos siguientes consultas:
    - A partir de la tabla EMPLE, visualiza cuántos apellidos empiezan por la letra ‘A’:
    ``` js
    SELECT apellido,CHR('65') FROM emple;
    ```
    - Obtén el apellido o apellidos de empleados que empiezan por la letra ‘A’ y que tengan máximo salario (de los que empiezan por la letra ‘A’)
    ```js
    SELECT apellido FROM emple WHERE apellido LIKE 'A%' AND salario = (SELECT MAX (salario) FROM emple WHERE apellido LIKE 'A%');
    ```
### TABLAS EMPLE, LIBRERIA, MISTEXTOS,LIBROS y NACIMIENTOS
#### Ejercicio 4
4. Dada la tabla EMPLE, obtén el sueldo medio, el número de comisiones no nulas, el máximo sueldo y el mínimo sueldo de los empleados del departamento 30. Emplea el formato adecuado para la salida de las cantidades numéricas.
    ```js
    SELECT AVG(salario),COUNT(comision),MAX(salario),MIN(salario) FROM emple WHERE dept_no=30;
    ```
5. Visualiza los temas con mayor número de ejemplares de la tabla LIBRERÍA y que tenga, al menos, una ‘E’ (pueden ser un tema o varios).
    ```js
    SELECT tema FROM libreria WHERE ejemplares =(SELECT MAX(ejemplares) FROM libreria) AND tema LIKE('%E%');
    ```
6. Dada la table MISTEXTOS, ¿qué sentencia SELECT se debe ejecutar para tener este resultado?
    ```js
    
    ```