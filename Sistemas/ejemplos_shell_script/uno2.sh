#!/bin/bash
if [ $# -ge 1 ]; then
   if [ $# -le 4 ]; then
     echo "$# correcto"
   else 
      echo "incorrecto"
   fi
else 
   echo "incorrecto"
fi
