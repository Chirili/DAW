#!/bin/bash
# Andrés Carmona Lozano

echo "1. Copia de seguridad."
echo "2. Procesos."
echo "3. Salir."

read opcion

case $opcion in
    1) usuario=`whoami`
       tar -cvf $usuario.tar /home/$usuario
       gzip -9 $usuario.tar;;
    2) ps;;
    3) read -p "¿Realmente quieres salir?";;
    "Si"|s*|S*|si|y*|Y*) exit 0;;
    *) ./andres3.sh
esac