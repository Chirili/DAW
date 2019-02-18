#!/bin/bash

read -p "Elige el archivo a comprimir " archivo

tar -cvf $archivo $archivo.tar $archivo