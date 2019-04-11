## DAW Ejercicios y apuntes del Ciclo Superior de Desarrollo de Aplicaciones Web

## Tema 8 Clausulas avanzadas, vistas e índices

### Indice
1. [La sentencia SELECT:](#La-sentencia-SELECT) 

  1.1 [Concepto](#1.1)
    1.2 [Sintaxis sentencia SELECT básica](#1.2)
    1.3 [Ejemplos de uso sentencia SELECT](#1.3)
    1.4 [Reglas de nomenclatura sentencia SELECT](#1.4)
    1.5 [Operadores aritméticos](#1.5)
    1.6 [Alias](#1.6)
    1.7 [Operador de concatenación](#1.7)
    1.8 [Concatenación con cadenas de caracteres](#1.8)
    1.9 [Filas duplicada](#1.9)


#### La sentencia SELECT

#### Concepto {#1.1}
La sentencia **SELECT** recupera información de la base de datos.
La sentencia **SELECT** a grandes rasgos que luego se irán detallando, puede realizar las siguientes funciones: 
 - **Proyección:** selecciona unas determinadas columnas de la tabla o tablas de las que se desea extraer datos.

A continuación se muestra un ejemplo de una tabla genérica, en la mediante proyección se han elegido varias columnas de la tabla para ser consultadas.
 ![Proyeccion](https://user-images.githubusercontent.com/23047899/54551415-57f01600-49ae-11e9-81b1-295132fd23a7.PNG)

 - **Selección:** selecciona unas determinadas filas de la tabla o tablas de las que se desea extraer datos, especificando distintos criterios de búsqueda para restringir las filas recuperadas. 
A continuación se muestra un ejemplo de una tabla genérica, en la que mediante selección se han escogido varias filas de la tabla para ser consultadas.

 ![Seleccion](https://user-images.githubusercontent.com/23047899/54551462-735b2100-49ae-11e9-932e-98a993cbd37a.PNG)

- **Unión:** reúne los datos almacenados en diferentes tablas especificando un enlace entre ellas. Las uniones se estudiarán con amplio detalle en unidades siguiente.
![union](https://user-images.githubusercontent.com/23047899/54551523-8f5ec280-49ae-11e9-9064-5e15eb33dc35.PNG)

####Sintaxis sentencia SELECT básica {#1.2}
La sintaxis de la sentencia **SELECT** básica es la siguiente:
```js
SELECT nombre_columna [, nombre_columna] FROM nombre_tabla;
``` 
Donde sí se analizan los elementos de la sentencia tenemos:
- **SELECT: SELECT** seguida por varios nombres de columnas, lo que permite elegir que columnas queremos que aparezcan en la consulta de datos. 
- **FROM:** La palabra reservada FROM seguida por el nombre de una tabla, que permite indicar sobre que tabla se va a realizar la consulta. 

#### Ejemplos de uso sentencia SELECT {#1.3} 
A continuación, se van a ver varios ejemplos de uso de la sentencia **SELECT** en los que se pretende que el alumno se familiarice con la sentencia **SELECT** y su funcionamiento. Todas las consultas se refieren a la base de datos HR de Oracle.

- **Ejemplo:** 
    - Seleccionar todos los datos de la tabla países:
        ```js
        SELECT * FROM Countries;
        ``` 
El carácter * hace las veces de carácter comodín, y permite seleccionar todas las columnas de la tabla indicada en la cláusula **FROM**, en este caso devolvería todos los datos de la tabla Countries. 
- **La salida:** 
    
![ejemplo1](https://user-images.githubusercontent.com/23047899/54552040-7e628100-49af-11e9-8262-78a82e8de472.PNG)
- **Ejemplo:**
Seleccionar el nombre, apellido, salario y fecha de contratación de cada empleado. 
```js 
SELECT first_name, last_name, salary, hire_date FROM employees; 
```
 
- **Salida:**
![ejemplo2](https://user-images.githubusercontent.com/23047899/54552127-a9e56b80-49af-11e9-9fe1-2f4eccb1c92f.png)

En los ejemplos anteriores, se puede ver como si se desea seleccionar todas las columnas de una determinada tabla, se utilizará el carácter comodín *. 

Y sin embargo, si lo que se desea es elegir unas columnas concretas de la tabla, lo que se hará es especificar nombres de columna separados por comas, en el orden en el que se dese que aparezcan en la salida justo detrás de la palabra reservada **SELECT**. 
#### Reglas de nomenclatura sentencia SELECT {1.4}

La sentencia **SELECT**, al igual que el nombre usado para identificar las tablas y las columnas, está sujeta a ciertas reglas de nomenclatura que son las siguientes: 
- **Las sentencias SELECT no son sensibles a mayúsculas/minúsculas (a menos que se indique).**
- **Las sentencias SELECT se pueden introducir en una o más líneas.**
- **Las palabras clave no se pueden dividir entre líneas o abreviar.**
- **Las cláusulas se suelen colocar en líneas independientes para que resulte más fácil su lectura o edición.**
- **El sangrado se debe utilizar para que sea más fácil de leer el código.** 

Normalmente, las palabras clave se introducen en mayúsculas, y el resto de palabras como pueden ser nombres de tablas y de columnas, se introducen en minúsculas.
