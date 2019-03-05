# Tema 8 Clausulas avanzadas, vista e índices

## Ejercicio 1

- El supermercado necesita incrementar en un 10% el sueldo de los empleados de la sucursal de "Cruz del Eje". Actualice el campo "sueldo" de la tabla "empleados" de todos los empleados de dicha sucursal empleando subconsulta.

```js
    UPDATE empleados SET sueldo=sueldo + (sueldo*0.1)
        WHERE codigosucursal=(SELECT codigo
                                    FROM sucursales WHERE ciudad LIKE 'Cruz del Eje');
```

## Ejercicio 2

- El supermercado quiere incrementar en un 20% el sueldo de los empleados de las sucursales de la provincia de Córdoba. Actualice el campo "sueldo" de la tabla "empleados" de todos los empleados de tales sucursales empleando subconsulta.

```js
    UPDATE empleados SET sueldo=sueldo + (sueldo*0.2)
        WHERE codigosucursal=(SELECT codigo
                                    FROM sucursales WHERE ciudad LIKE 'Cordoba');
```

## Ejercicio 3

- La empleada "Ana Acosta" es trasladada a la sucursal de Carlos Paz. Se necesita actualizar el sueldo y la sucursal de tal empleada empleando subconsultas, debe tener el mismo sueldo que la empleada "Maria Morales".

```js
    UPDATE empleados SET sueldo=(SELECT sueldo
                                        FROM empleados WHERE nombre LIKE 'Maria Morales'),codigosucursal=(SELECT codigo
                                                FROM sucursales WHERE ciudad LIKE 'Carlos Paz') WHERE nombre LIKE 'Ana Acosta';

```