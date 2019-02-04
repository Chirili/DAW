#!/bin/bash
if [ $# -eq 2 ]; then
   if [ ! -s $1 ]; then
       echo "$1 es un fcihero vacío"
       file $1 
   fi
   if [ ! -s $2 ]; then
       echo "$2 es un fichero vacíos"
       file $2
   fi
else
  echo "Error: no hay 2 parámetros"
fi
