#!/bin/bash
if [ $# -ne 0 ]; then

   while [ $# -ne 0 ]
   do
     echo $1
     shift
   done
else
   echo "Erro: No hay ningún parámetro"
fi
