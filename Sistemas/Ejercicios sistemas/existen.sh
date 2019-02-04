#! /bin/bash
read -p "Escribe el nombre del $fichero a renombrar"
if [-f $fichero]; then
read -p "Escribe el nuevo nombre del $fichero2"
mv $fichero $fichero2
else
echo "Error al cambiar el nombre"
fi

