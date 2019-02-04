
#!/bin/bash
if [ $# -ne 0 ]; then

   for i in $*
   do
     echo $i
   done

else
   echo "Erro: No hay ningún parámetro"
fi
