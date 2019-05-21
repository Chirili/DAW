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
```sql
CREATE OR REPLACE PROCEDURE subir_salario(
    num_empleado INTEGER,
    incremento REAL)
IS   
    salario_actual REAL;
    salario_nulo EXCEPTION;
BEGIN
    SELECT salario INTO salario_actual FROM emple WHERE emp_no=num_empleado;
    IF salario_actual IS NULL THEN
        RAISE salario_nulo;
    ELSE
        UPDATE emple SET salario=salario+Incremento WHERE emp_no=num_empleado;
    END IF;
EXCEPTION 
WHEN NO_DATA_FOUND THEN
    DMBS_OUTPUT.PUT_LINE (num_empleado||’* Error. Empleado no encontrado’);
WHEN salario_nulo THEN
    DMBS_OUTPUT.PUT_LINE (num_empleado||’* Error. Salario nulo’);
END subir_salario;
```

> Primero se crea la procedure con las dos variables num_empleado(de tipo INTEGER) y incremento(de tipo REAL), después se declara el salario_actual de tipo REAL también, y la excepción que es el salario_nulo para cuando se introduzca un salario nulo.

> En el begin se empieza metiendo en el salario_actual el salario del empleado que tenga el mismo codigo que el num_empleado que se le pasa a la procedure y si el salario esta vacio entonces se lanza el salario_nulo que es la excepcion sino se actualiza el salario del empleado ese, con el incremento que se le ha pasado a la procedure.

> En las excepciones está la de no_data_found que es para cuando no se encuentran datos del empleado y imprime el error por pantalla y también está la del salario nulo para avisarnos por si hay algun salario_nulo introducido.

5. (OPCIONAL - EXCEPCIONES) Bloque donde se define la excepción err_blancos asociada con un error definido por el programa y la excepción no_hay_espacio asociándola con el error número -1547 de Oracle.

```sql
DECLARE 
	cod_err NUMBER(6);
	vnif VARCHAR2(10);
	vnom VARCHAR2(15);
	err_blancos EXCEPTION;
	no_hay_espacio EXCEPTION;
	PRAGMA EXCEPTION_INIT(no_hay_espacio, -1547);
BEGIN
	SELECT col1, col2 INTO vnif, vnom FROM TEMP2;
	IF SUBSTR(vnom, 1, 1) <= ‘ ‘ THEN
		RAISE err_blancos;
	END;
	UPDATE clients SET nombre = vnom WHERE nif = vnif;
EXCEPTION
	WHEN err_blancos THEN
		INSERT INTO temp2(col1) VALUES (‘ERR blancos’);
	WHEN no_hay_espacio THEN
		INSERT INTO temp2(col1) VALUES (‘ERR tablespace’);
	WHEN NO_DATA_FOUND THEN
		INSERT INTO temp2(col1) VALUES (‘ERR no había datos’);
	WHEN TOO_MANY_ROWS THEN
		INSERT INTO temp2(col1) VALUES (‘ERR demasiados datos’);
	WHEN OTHERS THEN
		cod_err := SQLCODE;
		INSERT INTO temp2(col1) VALUES (cod_err);
END;
```

> Empezando por el declare que se declaran las siguientes variables:
    >> - **cod_err** de tipo **NUMBER**.
    >> - **vnif** de tipo **VARCHAR2**.
    >> - **vnom** de tipo **VARCHAR** también.
    >> - Tambien se declaran las siguientes **excepciones**:
    >> - **err_blancos**
    >> - **no_hay_espacio**
    >> - **PRAGMA EXCEPTION_INIT (no_hay_espacio, -1547)**(esta instrucción se encarga de darle un nombre a un error que salta en ORACLE en este caso es el 1547 que pasará a llamarse no_hay_espacio).

> El begin comienza metiendo la **col1** y la **col2** en las variables **vnif** y **vnom** de la tabla TEMP2, despues comienza una condición if se encarga de sustraer la posición uno y de longitud uno y compararla con lo que hay entre las comillas simples que es un espacio blanco si la condición se cumple salta la exepción **err_blancos** sino se actualiza la tabla clients, el campo **nombre** con lo que hay en la variable **vnom** cuando el **nif** sea igual al contenido de la variable **vnif**

> Las expceciones son las siguientes:
    >> - Cuando **err_blancos** se cumpla entonces inserta en la tabla **temp2(en la col1)** los datos **ERR blancos**.
    >> - Cuando **no_hay_espacio** se cumpla entonces se interta en la tabla **temp2(en la col1)** los datos **ERR tablespace**
    >> - Cuando no se encuentren datos se insertará en la tabla **temp2(en la col1)** los datos **ERR no había datos**.
    >> - Cuando hayan demasiadas filas  entonces se insertará en la tabla **temp2(en la col1)** los datos **ERR demasiados datos**.
    >> - La última excepción es cuando ocurran cualquier otro error entonces se inicializa la variable cod_err con el codigo del error y lo inserta en la tabla **temp2(en la col1)** el contenido de la variable cod_err que será el codigo de error que haya saltado. 
    