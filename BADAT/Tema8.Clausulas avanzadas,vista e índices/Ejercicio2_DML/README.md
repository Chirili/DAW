# Tema 8 Clausulas avanzadas, vista e índices

## Ejercicio 1

- Realice una combinación mostrando todos los datos de "socios", el deporte y la matr�cula de todos los socios (se encuentren o no en "inscriptos")

```js
    SELECT soci.*,ins.* FROM socios soci,inscriptos ins WHERE soci.numero=ins.numerosocio;
```

## Ejercicio 2

- Actualizamos la cuota ('s') de todas las inscripciones de un socio determinado (por documento) empleando subconsulta (3 registros)

```js

```

## Ejercicio 3

- Elimine todas las inscripciones de los socios que deben alguna matr�cula empleando subconsulta.

```js

```