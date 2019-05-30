# Tema6. Consultas Básicas y Avanzadas

### Relacion complementaria de ejemplos resueltos

#### Funciones aritméticas de valores simples

- ABS(n): obtén el valor absoluto del SALARIO – 1000 para todas las filas de la tabla EMPLE.
```sql
SELECT apellido, salario, ABS(salario-1000)
    FROM emple;
```
- CEIL(n) Prueba con números positivos y negativos:

```sql
SELECT CEIL(20.3), CEIL(16), CEIL(-20.3), CEIL(-16)
    FROM DUAL;
```
- FLOOR(n) Prueba con números positivos y negativos:
```sql
SELECT FLOOR(20.3), FLOOR(16), FLOOR(-20.3), FLOOR(-16)
    FROM DUAL;
```
- MOD(m,n) Prueba con números positivos y negativos:
```sql
SELECT MOD(11,4), MOD(10,-15), MOD(-10,-3), MOD(10.4,4.5)
    FROM DUAL;
```
- NVL(valor, expresion). A partir de la table EMPLE obtenemos el salario, la comisión y la suma de ambos:
```sql
SELECT salario, comision, salario + comision
    FROM emple; (si la comisión es nula la tercera columna será nula también)
SELECT salario, comision, salario + NLV(comision,0)
    FROM emple;
```
- POWER(m, exponente) Prueba con números positivos y negativos:
```sql
SELECT POWER(2,4), POWER(2,-4), POWER(3.5,2.4), POWER(4.5,2)
    FROM DUAL;
```
- ROUND(número[,m]) Prueba con redondeos positivos y luego negativos:
```sql
SELECT ROUND(1.56,1), ROUND(1.56), ROUND(1.2234,2),  ROUND(1.2676,3)
    FROM DUAL;
SELECT ROUND(145.5,-1), ROUND(145.5.-2), ROUND(145.,-3),  ROUND(141,-1), ROUND(145,-1)
    FROM DUAL;
```
- SIGN(valor) Prueba con numeros positivos y negativos:

```sql
SELECT SIGN(-10), SIGN(10)
    FROM DUAL;
SQRT(n) SELECT SQRT(25), SQRT(25.6)
    FROM DUAL;
```
- TRUNC(número, [m]).
    - Con truncamiento positive:
        ```sql
        SELECT TRUNC(1.5634,1), TRUNC (1.1684,2), TRUNC(1.662)
            FROM DUAL;
        ```
    - Con truncamiento negativo:
        ```sql
        SELECT TRUNC(187.98,-1), TRUNC (187.98,-2), TRUNC(187.98,-3)
            FROM DUAL;
        ```
#### Funciones de grupos de valores

- AVG(n) Cálculo del salario medio de los empleados del departamento 10 de la tabla EMPLE:
```sql
SELECT AVG(salario)
    FROM emple
        WHERE dept_no=10;
```

- COUNT(* | expresion) Cálculo del número de filas de la tabla EMPLE:
```sql
SELECT COUNT(*)
    FROM emple;
```
- Cálculo de filas de la tabla EMPLE donde la COMISION no es nula:
```sql
SELECT COUNT(comision)
    FROM emple;
```
- MAX(expresion) Cálculo del máximo salario de la tabla EMPLE:
```sql
SELECT MAX(salario)
    FROM emple;
```
- Obtén el apellido máximo (alfabéticamente) de la tabla EMPLE:
```sql
SELECT MAX(apellido)
    FROM emple;
```
- Obtén el apellido del empleado que tiene el mayor salario:
```sql
SELECT apellido, salario
    FROM emple
        WHERE salario =(SELECT MAX(salario)
                            FROM emple);
```
- MIN(expresion) Obtén el mínimo salario de la tabla EMPLE:
```sql
SELECT MIN(salario)
    FROM emple;
```
- Obtén el apellido del empleado que tiene mínimo salario:
```sql
SELECT apellido, salario
    FROM emple
        WHERE salario = (SELECT MIN(salario)
                            FROM emple);
```
- SUM(expresion) Consigue la suma de todos los salario de la tabla EMPLE:
```sql
SELECT SUM(salario)
    FROM emple;
```
- VARIANCE(expresion) Obtén la varianza de todos los salario de la tabla EMPLE:
```sql
SELECT VARIANCE(salario)
    FROM emple;
```

- **Calcula el número de oficios que hay en la tabla EMPLE:**
```sql
SELECT COUNT(oficio) “Oficios”
    FROM emple;
```
> **Si a diferencia de todos queremos solo los que sean distintos tendremos que incluir DISTINCT:**


```sql
SELECT COUNT(DISTINCT oficio) “Oficios”
    FROM emple;
```

-  **Partiendo de la tabla NOTAS_ALUMNOS:**
    - Obtén por cada alumno la mayor nota y la menor nota de las tres que tiene: (nota: en la última columna obtendrás valor nulo ya que una nota es nula y estas funciones no permiten comparar nulos con valores):
        ```sql
        SELECT nombre_alumno, GREATEST(nota1, nota2, nota2) “Mayor”, LEAST(nota1, nota2, nota3) “Menor”
            FROM notas_alumnos;
        ```
    - Obtén el mayor nombre alfabético de la lista:
        ```sql
        SELECT GREATEST(‘Benito’,’Jorge’,’Andrés’,’Isabel’)
            FROM DUAL;
        ```

- **Funciones de cadenas de caracteres que devuelven valores carácter**

    > CHR(n) Devuelve las letras cuyo valor ASCII es 75 y 65
```sql
SELECT CHR(75), CHR(65)
    FROM dual;
```
- CONCAT(cad1,cad2) Obtén el apellido de los empleados de la tabla EMPLE de la siguiente manera: concatena la cadena ‘El apellido es:’ con la columna APELLIDO de la tabla EMPLE:

```sql
SELECT CONCAT(‘El apellido es:’, apellido)
    FROM emple;
```
- LOWER(cad), UPPER(cad) e INITCAP(cad) Visualiza en mayúscula, minúscula y tipo título la cadena: ‘oRACLe Y sqL’
```sql
SELECT LOWER(‘oRACLe Y sqL’) “Minúscula”, UPPER(‘oRACLe Y sqL’) “Mayúscula”,INITCAP(‘oRACLe Y sqL’) “Tipo Título”
    FROM dual;
```
- LPAD(cad1, n [,cad2])y RPAD(cad1, n [,cad2]) Para cada fila de la tabla NOTA_ALUMNOS, obtenemos en una columna el nombre del alumno con una longitud de 30 caracteres y rellenando por la izquierda con puntos y en otra columna lo mismo pero rellenando por la derecha:

```sql
SELECT LPAD(nombre_alumno,30,’.’) “Izquierda”, RPAD(nombre_alumno, 30, ‘.’) “Derecha”
    FROM notas_alumnos;
```
- LTRIM(cad [,set]) y RTRIM(cad [,set]) Usamos la función LTRIM y RTRIM sin el segundo parámetro y con una cadena con blancos a la izquierda y a la derecha que, por defecto, eliminará:
```sql
SELECT LTRIM(‘        hola’) || RTRIM(‘    adios   ’)|| ‘*’
    FROM dual;
```
- A partir de la tabla MISTEXTOS:
    - Quita los caracteres punto y comilla de la derecha de la columna TITULO:
        ```sql
        SELECT RTRIM (titulo, ‘ .” ’)
            FROM mistextos;
        ```
    - Quita las comillas de la izquierda de la columna TITULO:
        ```sql
        SELECT LTRIM(titulo ’ “ ’)
            FROM mistextos;
        ```
- REPLACE(cad, cadena_buscada[, cadena_sustitución]) Sustituye ‘O’ por ‘AS’ en la cadena ‘BLANCO Y NEGRO’. Nota: Si no ponemos nada en la cadena sustitución se sustituye por nada (null).

```sql
SELECT REPLACE(‘BLANCO Y NEGRO’,’O’,’AS’ )
    FROM dual;
```
- SUBSTR(cad,m [,n]). Partiendo de la cadena ‘ABCDEF’, obtenemos en una columna dos caracteres a partir de la tercera posición, en otra columna otros dos caracteres a partir de la tercera posición empezando por el final de la cadena y en una última columna a partir de su cuarta posición:

```sql
SELECT SUBSTR (‘ABCDEF’, 3,2) “s1”, SUBSTR (‘ABCDEF’, -3,2) “s2”, SUBSTR(‘ABCDEF’,4) “s3”
    FROM dual;
```

- Visualiza el apellido y su primera letra por los empleados del departamento 10 de la tabla EMPLE:

```sql
SELECT apellido, SUBSTR (apellido, 1, 1)
    FROM emple
        WHERE dept_no = 10;
```
- TRANSLATE(cad1,cad2,cad3) A partir de la cadena ‘LOS PILARES DE LA TIERRA’, sustituye la ‘A’ por ‘a’, la ‘E’ por ‘e’, la ‘I’ por ‘i’, la ‘O’ por ‘o’ y la ‘U’ por ‘u’:

```sql
SELECT TRANSLATE (‘LOS PILARES DE LA TIERRA’, ‘AEIOU’, ‘aeiou’)
    FROM dual;
```

- **Funciones que devuelven valores numéricos:**
> ASCII(cad) Obtén el valor ASCII de ‘A’

```sql
SELECT ASCII(‘A’)
    FROM dual;
```

- INSTR(cad1, cad2[,comienzo[,m] ] ) A partir de la cadena ‘II VUELTA CICLISTA A TALAVERA’ encuentra la segunda ocurrencia ‘TA’ desde la posición 3.

```sql
SELECT INSTR (‘II VUELTA CICLISTA A TALAVERA’,’TA’, 3, 2) “Ejemplo”
    FROM dual;
```
> Si “comienzo” es negativo (-1), se comienza la búsqueda en la posición final y se va de derecha a izquierda en la cadena. Devuelve la posción contando desde la izquierda, es decir, la primera A que encuentra desde la primera posición empezando por el final.

```sql
SELECT INSTR (‘II VUELTA CICLISTA A TALAVERA’, ‘A’, -1) “Ejemplo”
    FROM dual;
```
> Si en el ejemplo anterior empezamos en -2, haría que la función empezase desde la segunda posición empezando por el final; un -3 desde la tercera y así sucesivamente.

> A partir de la tabla MISTREXTOS, encuentra la posición de la segunda ocurrencia de la letra ‘A’ en la columna AUTOR a partir del comienzo.(NOTA: Si en la función INSTR, “cad2” es un conjunto de caracteres, entonces la función devuelve la posición donde comienza el primer carácter de ese conjunto.)

```sql
SELECT autor, INSTR (autor, ‘A’, 1, 2)
    FROM mistextos;
```

- LENGTH(cad) Calcula el número de caracteres de las columnas TITULO y AUTOR para todas las filas de la tabla MISTEXTOS:
```sql
SELECT titulo, LENGTH(titulo), autor, LENGTH(autor)
    FROM mistextos;
```
- **Funciones para el manejo de fechas:**
> SYSDATE. Esta función devuelve la fecha del sistema
```sql
SELECT SYSDATE
    FROM dual;
```

- ADD_MONTHS(fecha,n) A partir de la tabla EMPLE, suma doce meses a la fecha de alta para los empleados del departamento 10:

```sql
SELECT fecha_alt, ADD_MONTHS(fecha_alt, 12)
    FROM emple
        WHERE dept_no;
```

- LAST_DAY(fecha).Obtén de la tabla EMPLE el último día del mes para cada una de las fechas de alta de los empleaos del departamento 10:

```sql
SELECT fecha_alt, LAST_DAY(fecha_alt)
    FROM emple
        WHERE dept_no=10;
```
- MONTHS_BETWEEN(fecha1,fecha2).Cálculo de la edad: necesitamos la función “SYSDATE”, que devuelva la fecha actual (fecha del sistema) y calculamos los meses transcurridos entre la fecha de hoy y la fecha de nacimiento. Dividimos entre 12 ese resultado y aplicamos la función TRUNC para suprimir decimales:
```sql
SELECT TRUNC (MONTHS_BERWEEN (SYSDATE, ‘18/11/1964’)/12) “Edad actual”
    FROM dual;
```
- NEXT_DAY(fecha, cad). Si hoy es jueves 26 de enero de 2017 (fecha del sistema SYSDATE), ¿qué fecha será el próximo jueves?:
```sql
SELECT NEXT_DAY(SYSDATE, ‘JUEVES’) “SIG. Jueves”
    FROM dual;
```
- **A partir de la tabla EMPLE, obtén la fecha de alta (columna FECHA_ALT) formateada, de manera que aparezca el nombre del mes con todas sus letras (month), el número de día de mes (dd) y el año (yyyy), para aquellos empleados del departamento 10.**
    ```sql
    SELECT TO_CHAR(fecha_alt, ‘month DD, YYYY’) “NUEVA FECHA” FROM emple WHERE dept_no=10;
    ```
    - Ahora repite el ejercicio anterior de manera que aparezca el nombre del mes con tres letras (mon), el número del día del año (ddd), el último dígito del año (y) y los tres último dígitos del año:
        ```sql
        SELECT TO_CHAR (fecha_alt, ‘mon ddd y yyy’) “FECHA”
            FROM emple
                WHERE dept_no=10;
        ```
- **Al iniciar nuestra sesión el idioma definido para la fecha es el español. Podemos definir otro idioma, por ejemplo el francés, de la siguiente manera:**

    ```sql
    ALTER SESSION SET NLS_DATE_LANGUAGE=French;
    ```
    - Si queremos visualizar el nombre del mes y el día de la semana, éstos aparecerán en francés, con lo que la fecha de hoy será:
        ```sql
        SELECT TO_CHAR (sysdate, ‘”Hoy es:” day “ ,” dd “ de ” month “ de “ yyyy ’) “FECHA”
            FROM dual;
        ```
- **Sea la table EMPLE:**
    - Selecciona todas la filas y codifica el OFICIO. Si el OFICIO es PRESIDENTE, codificar con 1; si es EMPLEADO, con un 2, en cualquier otro caso, codificar con un 5:
        ```sql
        SELECT apellido, oficio, DECODE(UPPER(oficio) , ‘PRESIDENTE’, 1 , ‘EMPLEADO’, 2 , 5) “Codigo”
            FROM emple;
        ```
    - Calculamos el número de bytes que tiene la columna APELLIDO de la tabla EMPLE para aquellos del departamento 10:
        ```sql
        SELECT apellido, VSIZE(apellido) BYTES
            FROM emple
                WHERE dept_no=10;
        ```
    - Representamos en hexadecimal el caracteres 1 al 4 del APELLIDO ‘SALA’ de la tabla EMPLE:
        ```sql
        SELECT apellido, DUMP(apellido,16,1,4)
            FROM emple
                WHERE apellido LIKE ‘SALA’;
        ```
    - Visualiza el usuario que está conectado y su identificador:
        ```sql
        SELECT USER, UID
            FROM dual;
        ```
    - La orden SHOW USER muestra el nombre de usuario que está conectado:
        ```sql
        SHOW USER;
        ```