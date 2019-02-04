#!/bin/bash
op=0
while [ $op -ne 4 ]
do
echo "1. Muestra la fecha del sistema"
echo "2. Nombre de usuario"
echo "3. Procesos"
echo "4. Salir"
echo -n "Elige una opción "  
read op
case $op in
  1) date;;
  2) whoami;;
  3) top;;
  4) echo "Has elegido salir";;
  *) echo "No has elegido nada";;
esac
done
