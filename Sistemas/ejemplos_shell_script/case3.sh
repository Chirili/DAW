#!/bin/bash
for i in *
do
  e=`ls -ld $i`
  case $e in
   -*) echo "$i es un archivo regular";;
   d*) echo "$i es un directorio";;
   *) echo "$i es otra cosa";;  
  esac
done
