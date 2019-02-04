#!/bin/bash
read -p "Quiere salir " op
case $op in
    "Si"|s*|y*) echo "has elegido sí";;
    *) echo "no";;
esac
