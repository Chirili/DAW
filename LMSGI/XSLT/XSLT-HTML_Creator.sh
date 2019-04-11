#!/bin/bash
dir= pwd
echo $pwd
read -p "Escribe el nombre que deseas darle al documento html: " documentohtml
read -p "Escriba el nombre del documento xml: " documentoxml

read -p "Escriba el nombre del documento xslt: " documentoxslt

echo $documentohtml
echo $documentoxml
echo $documentoxslt

java -jar "C:\Users\usuario\workspace\DAW\LMSGI\XSLT\Saxon\saxon9he.jar" -o:$dir/$documentohtml -s:$dir/$documentoxml -xslt:$dir/$documentoxslt
