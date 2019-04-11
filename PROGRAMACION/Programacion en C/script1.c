main()
{
    char  saxon[1024];
    printf("Introduce el nombre del fichero saxon a buscar: \n");
    scanf("%s", &saxon);
    system("dir /s/b saxon .jar");
    printf("Elige que fichero saxon quieres usar %s \n", saxon);

    system("pause");
    return 0;
}