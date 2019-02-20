#!/bin/bash
# Andrés Carmona Lozano

if [ $# -eq 3 ] || [ -f $# ]; then

tar -cvf andres.tar .
gzip -9 andres.tar
else
echo "Error: debe haber 3 parámetros"
ls -l 
fi
