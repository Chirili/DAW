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


3. 

4. Indica cuáles de las siguientes llamadas son correctas y cuáles incorrectas. En el caso de que sean incorrectas, escribe la llamada correcta usando la notación posicional, siempre que sea posible:

crear_depart; 
crear_depart (50) ;
crear_depart (‘COMPRAS’) ;
crear-depart (50,’ COMPRAS’ ) ;
crear_depart (‘COMPRAS’, 50) ;
crear-depart (‘COMPRAS’,’VALENCIA’ ) ;
crear-depart (50,’COMPRAS’,’VALENCIA’ ) ;
crear-depart ( ‘COMPRAS’ , 50, ‘VALENCIA’ ) ;
crear_depart (‘VALENCIA’,’COMPRAS’) ;
crear_depart (‘VALENCIA’, 50);
