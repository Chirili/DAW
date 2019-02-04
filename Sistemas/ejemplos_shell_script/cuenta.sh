#!/bin/bash
for i in *
do

echo -n "El fichero $i tiene  "
valor=`wc -l $i | cut -d" " -f1`
echo "$valor líneas"


done
