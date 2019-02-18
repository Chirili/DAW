#!/bin/bash

read -p "Escribe el nombre de un usuario: " usuario

if [ grep -qi "^$usuario:" /etc/password ];

id $usuario
gid $usuario

else 
echo "No existe el usuario"
fi