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
DECLARE
    c_dep NUMBER(2);
    CURSOR empleados IS
        SELECT NOMBRE,APELLIDO FROM EMPLE WHERE DEPT_NO=c_dep;
    empleado VARCHAR2(10);
BEGIN 
    c_dep:=DEP;
    OPEN empleados;
        FETCH empleados INTO empleado;
            WHILE empleados%FOUND
                LOOP DBMS_OUTPUT.PUT_LINE(empleado);
        FETCH empleados INTO empleado;
END LOOP;
CLOSE empleados;
END;
```
> Para empezar en el declare, se declaran las siguientes variables: **c_dep** que es el codigo de departamento y **empleado** que es la variable tipo **VARCHAR2** que contendrá los datos de los empleados y aparte de eso el cursor llamado **empleados**, con la consulta que recoge el nombre y apellido de los empleados.

> En el **begin** primero se inicializa la variable **c_dep** con el contenido de DEP, despues se abre el cursor y se inserta en empleado y mientras que haya datos en empleados se va repetir un loop que va ir imprimiendo por pantalla el nombre y apellido de los empleados y cuando no encuentre mas empleados saldrá del loop.

3. Escribe un bloque PL/SQL que visualice el apellido y la fecha de alta de
todos los empleados ordenador por fecha de alta.

    - Mediante una estructura FOR . . . LOOP:
        ```sql
        DECLARE
            CURSOR apellidos IS
        SELECT apellido, fecha_alt FROM emple ORDER BY fecha_alt;
        BEGIN
            FOR empleaf IN apellidos 
        LOOP 
            DBMS_OUTPUT.PUT_LINE(empleaf.apellido||'*'|| empleaf.fecha_alt);
        END LOOP;
        END;
        ```
    > Primero en el declare se declara el cursor de nombre apellidos con la consulta que selecciona los apellidos y la fecha de alta de los empleados ordenados por fecha de alta.
    
    > Despues en el begin empieza con el bucle for y dentro un loop que se encarga de ir recorriendo todas las tuplas del cursor y ir mostrandolas por pantalla.
    - Utilizando un bucle WHILE:
        ```sql
        DECLARE
            CURSOR apellidos IS
            SELECT apellido, fecha_alt FROM emple ORDER BY fecha_alt;
        BEGIN
            WHILE apellidos%FOUND
                LOOP
                    DBMS_OUTPUT.PUT_LINE(empleaf.apellido||'*'|| empleaf.fecha_alt);
        END LOOP;
        END;
        ```
        > Primero antes de nada se declara el cursor con nombre apellidos y despues de eso en el begin se crea un bucle while que hace que mientras que se encuentren tuplas en el cursor va ir imprimiendolas por pantalla.
        
4. (EXCEPCIONES) Recibe un número de empleado y una cantidad que se incrementará al salario del empleado correspondiente. Utilizaremos dos excepciones, una definida por el usuario “salario_nulo” y la otra predefinida NO_DATA_FOUND.