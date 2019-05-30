# Tema8.Clausulas avanzadas,vista e índices


### Relacion complementaria de ejemplos resueltos

- Visualiza a partir de la tabla EMPLE el número de empleados que hay en cada departamento:
    - Parar hacer esta consulta, tenemos que agrupar las filas de la tabla EMPLE por departamento (GROUP BY dept_no) y contarlas (COUNT(*)):
        ```sql
        SELECT dept_no, COUNT(*)
            FROM emple
                GROUP BY dept_no;
        ```
    - COUNT es una función de grupo y da información sobre un grupo de filas, no sobre filas individuales de la tabla. La cláusula GROUP BY dept_no obliga a COUNT a contar las filas que se han agrupado por cada departamento:
    > Si en la consulta anterior solo queremos visualizar los departamento con más de 4 empleados.
        ```sql
        SELECT dept_no, COUNT(*)
            FROM emple
                GROUP BY dept_no HAVING COUNT(*) > 4;
        ```
    