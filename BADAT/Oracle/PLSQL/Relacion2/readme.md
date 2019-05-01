# Relacion 2 de ejercicio de PL/SQL

1. Indica que errores aparecen en las siguientes instrucciones y la forma de corregirlos

```sql
DECLARE
    Num1 NUMBER(8,2) := 0
    Num2 NUMBER(8,2) NOT NULL
    Num3 NUMBER(8,2) NOT NULL;
    Cantidad INTEGER(3);
    Precio, Descuento NUMBER(6) ;
    Num4 Num1%ROWTYPE;
    Dto CONSTANT INTEGER;
BEGIN
. . .
END;
```

- Errores encontrados:

    - Las variables al final de cada una tiene que finalizar con **punto y coma.**

    - Las variables también se declaran de una en una y si se quiere poner como NOT NULL se tiene que inicializar con := y asinarle un valor o con DEFAULT y tambien asginandole un valor.

    - En el %ROWTYPE tiene que existir la tabla de antes del % para que pueda almacenar una fila de esa tabla. Tambien se puede poner %TYPE para que la variable tome el valor de otra variable anteriormente declarada

    - A DTO se le tiene que asignar un valor ya que se ha declarado como constante es decir que tiene que tener un valor preasginado el cual no se puede modificar.
    
    - Integer no lleva ningun tamaño

- Codigo corregido:
```sql
DECLARE
    Num1 NUMBER(8,2) := 0;
    Num2 NUMBER(8,2) NOT NULL := 20.3;
    Num3 NUMBER(8,2) NOT NULL := 30.7;
    Cantidad INTEGER(3);
    Precio NUMBER(6);
    Descuento NUMBER(6);
    Num4 Num1%TYPE;
    Dto CONSTANT INTEGER := 5;
BEGIN
    DBMS_OUTPUT.PUT_LINE(num1 || num2);
END;
```

2. Escribe un bloque PL/SQL que realice la misma  función del ejemplo 4 de la relación complementaria pero usando un bucle ITERAR.


3. - Escribe un procedimiento con funcionalidad similar al ejercicio complementario 7, que recibirá un número de empleado y un número de departamento y asignará al empleado el departamento indicado en el segundo parámetro.

> No realizado

4. Indica cuáles de las siguientes llamadas son correctas y cuáles incorrectas.

    1. crear_depart; -> Incorrecta ya que hay que   pasarle el numero del departamento
    2. crear_depart (50) ; -> Correcta
    3. crear_depart (‘COMPRAS’) ; -> Incorrecta ya  que tambien hay que pasarle el numero de     departamento
    4. crear-depart (50,’ COMPRAS’ ) ; -> Correcta 
    5. crear_depart (‘COMPRAS’, 50) ; -> El orden no    es correcto primero tiene que ser el numero de     departamento
    6. crear-depart (‘COMPRAS’,’VALENCIA’ ) ; -> Hay    que poner el numero de departamento
    7. crear-depart (50,’COMPRAS’,’VALENCIA’ ) ; ->     Correcta
    8. crear-depart ( ‘COMPRAS’ , 50, ‘VALENCIA’ ) ;    -> El orden es incorrecto primero numero   departamento, despues nombre del departamento y   ultimo localidad.
    9. crear_depart (‘VALENCIA’,’COMPRAS’) ; ->     Necesita el numero de departamento
    10. crear_depart (‘VALENCIA’, 50); -> Lo argumento
- Corrección:

    1. crear_depart(50,NULL,NULL);
    2. crear_depart (50) ;
    3. crear_depart (50,‘COMPRAS’,NULL) ;
    4. crear-depart (50,’ COMPRAS’) ;
    5. crear_depart (50,‘COMPRAS’) ;
    6. crear-depart (50,‘COMPRAS’,’VALENCIA’ ) ;
    7. crear-depart (50,’COMPRAS’,’VALENCIA’ ) ;
    8. crear-depart ( 50,‘COMPRAS’, ‘VALENCIA’ ) ;
    9. crear_depart (50,‘VALENCIA’,’COMPRAS’) ;
    10. crear_depart (50,NULL,‘VALENCIA’);

5. Escribe un procedimiento que reciba dos números y visualice su suma.

```sql
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE SUMA_NUMEROS(
    NUM1 NUMBER,
    NUM2 NUMBER
)
AS
    SUMA NUMBER(6);
BEGIN
    SUMA := NUM1+NUM2;
    DBMS_OUTPUT.PUT_LINE('LA SUMA ES: ' || SUMA);
END SUMA_NUMEROS;
```

6. Codifica un procedimiento que reciba una cadena y la visualice al revés.

```sql
CREATE OR REPLACE PROCEDURE REVES(
    CADENA VARCHAR2
)
AS
    CADENA_REVES VARCHAR2(50); 
BEGIN 
    FOR i IN REVERSE 1..LENGTH(CADENA) LOOP
        CADENA_REVES := CADENA_REVES || SUBSTR(CADENA,i,1);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(CADENA_REVES);
END REVES;
```

7. Reescribe el código de los dos ejercicios anteriores para convertirlos en funciones que retomen los valores que mostraban los procedimientos.

- Cadena al revés:

```sql
DECLARE 
    CADENA VARCHAR2(50);
    CADENA_REVES VARCHAR2(50);
BEGIN 
    CADENA:='&VALORCADENA';
    FOR i IN REVERSE 1..LENGTH(CADENA) LOOP
        CADENA_REVES := CADENA_REVES || SUBSTR(CADENA,i,1);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(CADENA_REVES);
END;
```

8. Escribir una función que reciba una fecha y devuelva el año, en número, correspondiente a esa fecha.

```SQL
CREATE OR REPLACE FUNCTION ANIO	(DATA DATE)
RETURN NUMBER
AS
	ANIO NUMBER(4);
BEGIN
	ANIO := TO_NUMBER(TO_CHAR(data, 'YYYY'));
	RETURN ANIO;
END ANIO;
```

9. Escribe un bloque PL/SQL que haga uso de la función anterior

```SQL
DECLARE
 	n NUMBER(4);
BEGIN
 	n := ANIO(SYSDATE);
 	DBMS_OUTPUT.PUT_LINE('ANY : '|| n);
END;
```

10. Codifica un procedimiento que reciba una lista de hasta cinco números y visualice su suma.

```SQL
CREATE OR REPLACE PROCEDURE SUMA_5 (
	NUM1 NUMBER := 100,
	NUM2 NUMBER := 40,
	NUM3 NUMBER := 30,
	NUM4 NUMBER := 20,
	NUM5 NUMBER := 15)
AS
BEGIN
	DBMS_OUTPUT.PUT_LINE(NUM1 + NUM2 + NUM3 + NUM4 + NUM5);
    
END SUMA_5;
```

11. Escribe una función que devuelva solamente caracteres alfabéticos sustituyendo cualquier
otro carácter por blancos a partir de una cadena que se pasará en la llamada.

```SQL
CREATE OR REPLACE FUNCTION C_ALFABETO (CADENA VARCHAR2) RETURN VARCHAR2
AS
	NUEVA_CADENA VARCHAR2(30);
	CARACTER CHARACTER;
BEGIN
	FOR i IN 1..LENGTH(CADENA) LOOP
	  	CARACTER:=SUBSTR(CADENA,i,1);
 	  	IF (ASCII(CARACTER) NOT BETWEEN 65 AND 90) AND (ASCII(CARACTER) NOT BETWEEN 97 AND 122) THEN
		  	CARACTER :=' ';
  		END IF;
	     NUEVA_CADENA := NUEVA_CADENA || CARACTER;	
	END LOOP;
	RETURN NUEVA_CADENA;
END C_ALFABETO;
```

12. Codifica un procedimiento que permita borrar un empleado cuyo número se pasará en la llamada

    >NO REALIZADO


13. Visualiza todos los procedimientos y funciones del usuario almacenados en la base de datos y situación (valid o invalid)

```SQL
SELECT OBJECT_NAME, OBJECT_TYPE, STATUS 
    FROM USER_OBJECTS 
        WHERE OBJECT_TYPE IN ('PROCEDURE','FUNCTION');
```