#!/bin/bash
if [ $# -ne 0 ]; then
for i in $*
do 
 touch $i
done
else 
   echo "Error: No hay ningún parámetro"
fi
