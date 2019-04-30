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

3. 

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
