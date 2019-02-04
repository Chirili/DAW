#!/bin/bash
read -p "Escribe una opción " op
case $op in
  ls) ls -l;;
   "clear") clear;;
   *) echo "Has puesto otra cosa";;
esac

