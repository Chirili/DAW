#!/bin/bash

ps -a

read -p "Elige un numero de proceso" proceso

if [ $proceso -eq 0 ]; then

read -p "¿Quieres matar el proceso" resultado
    if [ resultado -e Si ]; then
    kill $proceso
    echo "Proceso acabado"
    else "Error al matar al proceso"
    fi
fi