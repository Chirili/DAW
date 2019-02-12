# DAW

## Práctica 1 Tema 6 BBDD

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

1. Realiza las dos siguientes consultas:

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

1. Dada la tabla EMPLE, obtén el sueldo medio, el número de comisiones no nulas, el máximo sueldo y el mínimo sueldo de los empleados del departamento 30. Emplea el formato adecuado para la salida de las cantidades numéricas.

    ```js
    SELECT AVG(salario),COUNT(comision),MAX(salario),MIN(salario) FROM emple WHERE dept_no=30;
    ```

#### Ejercicio 5

1. Visualiza los temas con mayor número de ejemplares de la tabla LIBRERÍA y que tenga, al menos, una ‘E’ (pueden ser un tema o varios).

    ```js
    SELECT tema FROM libreria WHERE ejemplares =(SELECT MAX(ejemplares) FROM libreria) AND tema LIKE('%E%');
    ```

#### Ejercicio 6

1. Dada la table MISTEXTOS, ¿qué sentencia SELECT se debe ejecutar para tener este resultado?

    ```js
    NO RESUELTO
    ```

#### Ejercicio 7

1. Visualiza  los  títulos  de  la  tabla  MISTEXTOS  sin  los  caracteres  punto  y  comillas,  y  en minúscula, de dos formas distintas.

    ```js
    SELECT LOWER (LTRIM(RTRIM(titulo,'.'''''),''''))FROM mistextos;

    ```

#### Ejercicio 8

1. Dada  la  tabla  LIBROS,  escribe  la  sentencia  SELECT  que  visualice  dos  columnas,  una  con  el AUTOR y otra con el apellido del autor.

    ```js
    SELECT autor, SUBSTR (autor,0,INSTR(autor, '.' , 1)-1)FROM libros
    ```

#### Ejercicio 9

1. Escribe  la  sentencia  SELECT  que  visualice  las  columnas  de  AUTOR  y  otra  columna  con el nombre del autor (sin el apellido) de la tabla LIBROS.

    ```js
    SELECT autor,SUBSTR(autor,0,INSTR(autor,'.',1)+1)FROM libros;
    ```

#### Ejercicio 10

1. A  partir  de  la  tabla  LIBROS,  realiza  una  sentencia  SELECT  que  visualice  una  columna, primero el nombre del autor y, luego, su apellido.

    ```js
    SELECT SUBSTR(autor,INSTR(autor,',',1)+1),SUBSTR(autor,0,INSTR(autor,',',1)-1 ) FROM libros;
    ```

#### Ejercicio 11

1. A  partir  de  la  tabla  LIBROS,  realiza  una  sentencia  SELECT  para  que  aparezcan  los  títulos ordenados por su número de caracteres.

    ```js
    SELECT titulo FROM libros ORDER BY LENGTH (titulo);
    ```

#### Ejercicio 12

1. Dada la tabla NACIMIENTOS, realiza una sentencia SELECT que obtenga la siguiente salida: NOMBRE,   FECHANAC,   FECHA_FORMATEADA,   donde   FECHA_FORMATEADA   tiene   el siguiente formato:“Nacido el 26 de abril de 1982”.

    ```js

    SELECT nombre,fechanac,TO_CHAR(fechanac,'"nadio el "dd" de "month" de "yyyy"')FROM nacimientos;
    ```

#### Ejercicio 13

1. Dada la tabla LIBRERÍA, haz una sentencia SELECT que visualice el tema, el último carácter del tema que no se blanco y el número  de caracteres de tema (sin contar los blancos de la derecha) ordenados por tema.

    ```js
    SELECT tema,SUBSTR(tema,INSTR(tema,' ')-1),INSTR(tema,' ')-1 FROM libreria ORDER BY tema;
    ```

#### Ejercicio 14

1. Apartir  de  la  tabla  NACIMIENDOS,  visualiza  en  una  columna  el  NOMBRE  seguido  de  su fecha de nacimiento formateada (quita blancos del nombre).

    ```js
    SELECT nombre,TO_CHAR(fechanac,'"nacio el,"DD" "MONTH" "YYYY"')FROM nacimientos;
    ```

#### Ejercicio 15

1. Convierte la cadena ‘010712’ a fecha y visualiza su nombre de mes en mayúscula.

    ```js
    SELECT TO_CHAR (TO_DATE ('010712','DDMMYY'),'MONTH') FROM DUAL;
    ```

#### Ejercicio 16

1. Visualiza  aquellos  temas  de  la  tabla  LIBRERÍA  cuyos ejemplares  sean  7 con  el  nombre  de tema  de  ‘SEVEN’;el  resto  de  temas  que  no  tengan  7  ejemplares  se  visualizarán  como están.

    ```js
    SELECT tema, DECODE(ejemplares,7,'SEVEN', ejemplares) FROM libreria;
    ```

#### Ejercicio 17

1. A partir de la tabla EMPLE, obtén el apellido de los empleados que lleven más de 15 años trabajando.

    ```js
    SELECT apellido FROM emple WHERE (TO_CHAR (CURRENT_DATE,'YYYY') -TO_CHAR (FECHA_ALT,'YYYY') )> 15;
    ```
