#include <stdio.h>

main()
{
    int c;
FILE *file;
file = fopen("ruta.txt", "r");
if (file) {
    while ((c = getc(file)) != EOF)
        putchar(c);
    fclose(file);
}
}