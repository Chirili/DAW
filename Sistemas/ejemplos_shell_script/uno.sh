#!/bin/bash
if [ $# -ge 1 -a $# -le 4 ]
then
	echo $#
else
   echo "Error número de parámetros"
fi
