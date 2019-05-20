# Relacion 3 de ejercicio de PL/SQL Cursores

1. Cursor que visualiza los apellidos de los empleados pertenecientes al departamento 20 numerándolos secuencialmente.

```sql
DECLARE 
    CURSOR apellidos IS 
        SELECT APELLIDO FROM EMPLE WHERE DEPT_NO=20;
        apellido VARCHAR2(20);
BEGIN  
    OPEN apellidos;
    LOOP FETCH apellidos INTO apellido;
        EXIT WHEN apellidos%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TO_CHAR(apellidos%ROWCOUNT,'99.')||apellido);
    END LOOP;
CLOSE apellidos;
END;
```
> Primero se declara el cursor en el declare que contendra la seleccion de los apellidos de los empleados del **departamento 20**.
    >> Se declara la variable apellidos de tipo **VARCHAR2**.

> En el begin se abre el cursor y luego mediante un bucle loop se almacena el contenido de cada fila seleccionada en la variable anteriormente declarada llamada **apellidos**, cuando entra en el loop lo primero que se hace es poner una condicion de salida por si en algun punto deja de encontrar datos dentro del cursor y los va imprimiendo por pantalla secuencialmente, despues de eso se cierra el cursor y termina.

2. Visualiza los empleados de un departamento cualquiera usando variables de acoplamiento. Crea un cursor para ello.

```SQL
CREATE OR REPLACE PROCEDURE ver_empleados
AS
    CURSOR c_emple IS 
        SELECT nombre
            FROM emple
                WHERE dept_no=20
                    GROUP BY nombre;
v_nombre emple.nombre%TYPE;
v_num_emple BINARY_INTEGER;
BEGIN
    OPEN c_emple;
        FETCH c_emple into v_nombre, v_num_emple;
    WHILE c_emple%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE(v_nombre||' * '||v_num_emple);
    FETCH c_emple into v_nombre,v_num_emple;
    END LOOP;
    CLOSE c_emple;
END ver_empleados;
```