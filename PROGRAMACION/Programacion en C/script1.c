#include<stdio.h>
#include <string.h>
#include<conio.h>
#include <stdlib.h>

void user_search(){

    char *route_checker = NULL;
    char route[1024];

    printf("Show me the absolute path where the saxon.jar is located. Remember path syntax: C:\\folder\\folder\\saxon.jar\n");
    scanf("%s", &route);

    printf("Route chosen: ");
    printf("%s", route);
    //system("pause");

    route_checker = strstr(route, "C:\\");
    if(route_checker == route){
        char command[100];
        char dir_params[50]="dir /s/b";
        char dir_jar[50]="\\*.jar";
        char dir_txt[50]="> path.txt";
        int ch,num_lines,option_numbers,c;
        char line[1024];
        
        printf("Route check: route is correctly writed\n");
        //Concat of the command
        strcpy(command, dir_params);
        printf(command);
        system("pause");
        strcat(command, " ");
        strcat(command, route);
        strcat(command,dir_jar);
        strcat(command, " ");
        strcat(command, dir_txt);
        printf("Comando completo: %s\n", command);


        system("chdir > user_path.txt");
        system(command);
        system("pause");

        FILE *txt = fopen("path.txt", "r");

        system("pause\n");
       while ((c = fgetc(txt)) != EOF){
            putchar(c);
        }

        
        num_lines=0;
        while ((ch= fgetc(txt)) != EOF)
        {
            if(ch == '\n'){
                num_lines++;
            }
        }

        system("pause\n");
        printf("Choose one of the .jar files found in the directory: ");
        scanf("%d", option_numbers);

        int contador = num_lines;
       while(!feof(txt))
    {
        fgets(line, 80, txt);
        for(signed int i = 0; i <= strlen(line); i++)
        {
            if(line[i] == '\n')
            contador++;
        }
        if(contador == option_numbers)
        break;
    }
    system("pause");
        printf("Linea elegida: %s",line);

        system("pause");
        fclose(txt);
    }else
    {
        printf("Route check: route is incorrectly writed");
        system("pause");
    }
}

int main()
{
    int choice;
    start:
    printf("1 Do you want to tell me where is the saxon file that you want to use?\n");
    printf("2. Maybe. I have to find the saxon file for you and, I will use the first one i find\n");
    printf("3. Exit the program\n");
    printf("Selection: ");
    scanf("%d", &choice);
    switch(choice) {
        case 1:
        printf("Has elegido la opcion 1\n");
        
        user_search();
        break;
        case 2: 
        printf("Has elegido la opcion 2");
        
        break;
        case 3:
        printf("Has elegido la opcion 3");
        //system("pause");
        break;
        default: 
        printf("Error: try again");
        //system("cls");
        goto start;
    }
    return 0;
}

