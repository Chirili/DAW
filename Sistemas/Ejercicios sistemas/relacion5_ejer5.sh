#!/bin/bash

read -p "Escribe el nombre de un shell script " script

if [ -e $script ]; then
    nano $script
else
    cat > $script
    echo "#!/bin/bash" >> $script
    chmod -x $script
    nano $script
fi