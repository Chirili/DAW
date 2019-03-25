#!/bin/bash
# Andrés Carmona Lozano
read -p "Escribe una letra: " letra

maximo=aa
if [ $letra \< $maximo ];then
    resultado=`grep -c "^$letra" /etc/group  resultado`
    echo "Hay $resultado grupos que empiecen por la letra $letra"
else
echo "Error: solo se permite una letra"
fi