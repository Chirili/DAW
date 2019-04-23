# Relacion de ejercicio de PL/SQL

1. Construye un bloque PL/SQL que escriba el texto ‘Hola’

```sql
SET SERVEROUTPUT ON
DECLARE 
    saludo VARCHAR(4) := 'Hola';
BEGIN
    dbms_output.put_line('Hola');
    dbms_output.put_line(saludo);
END;
```

2. ¿Qué hace el siguiente bloque PL/SQL?

```sql
SET SERVEROUTPUT ON
DECLARE
    v_num NUMBER;
BEGIN
    SELECT count(*) INTO v_num
        FROM emple;
    DBMS_OUTPUT.PUT_LINE(v_num);
END;
```

> Primero lo que se hace es declarar la variable v_num de tipo number y en el begin lo que se hace es la cuenta de todas las filas de la tabla emple se meten en la variable v_num que despues se muestra por pantalla.