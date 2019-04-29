#include<stdio.h>
#include <string.h>
main()
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
        system("pause");
        user_search();
        break;
        case 2: 
        printf("Has elegido la opcion 2");
        system("pause");
        break;
        case 3:
        printf("Has elegido la opcion 3");
        system("pause");
        break;
        default: 
        printf("Error: try again");
        system("cls");
        goto start;
    }
}

void user_search(){

    char *route_checker = NULL;
    char route[1024];

    printf("Show me the absolute path where the saxon.jar is located. Remember path syntax: C:\\folder\\folder\\saxon.jar\n");
    scanf("%s", &route);

    printf("Route chosen: ");
    printf("%s", route);
    system("pause");

    route_checker = strstr(route, "C:\\");
    if(route_checker == route){

        char dir[9]="dir /s/b ";
        char path[9]="> path.txt";
        printf("Route check: route is correctly writed");
        system(dir,route,path);
        system("pause");


    }else
    {
        printf("Route check: route is incorrectly writed");
        system("pause");
    }
}