echo on

: This command save the route where we are executing the .bat in the route.txt :
chdir > ./route.txt
cls
: "Set" assign the route in the route txt into an Environment Variable called route which has the route where we are executing the .bat :
set /p route= < route.txt
cls
: "Dir" find the file needed to make the conversion and put it into the saxonfile.txt  :
dir /b/s saxon9he.jar > ./saxonfile.txt
cls

: Here "set" assign the route of the saxon file into a Environment Variable called saxon which has the route where the saxon file is found :
set /p saxon= < saxonfile.txt
cls
: Here you have 3 keyboard entries where we have the name of the html,xml and xslt which they dont have to use the .extension just the name of the xml,xslt or html and assigned to their respective Environment Variables :
set /p html= Write a name for your html without the extension .html: 
set /p xml= Write the name of you xml file just the name without the extension: 
set /p xslt= Write the name of you xslt file just the name without the extension: 
pause
: This command have to find the name of the xml environment variable and put the output into a .txt :
dir /b/s %xml%.xml > ./xmlfound.txt
: Here we set the xml found into a environment variable :
set /p xmlf= < ./xmlfound.txt
echo xmlf
: This command have to find the name of the xslt environment variable and put the output into a .txt : 
dir /b/s %xslt%.xslt > ./xsltfound.txt

: Here we set the xml found into a environment variable :
set /p xsltf = > xsltfound.txt
echo %xsltf%
pause
: And this is the command who makes the conversion of the xml and xslt into a html file :
java -jar "%saxon%" -o:%route%\%html%.html -s:%xmlf% -xsl:%xsltf%

pause
: Here we start the chrome with the name of our environment variable called html :
start chrome %html%.html

: Here we removed the .txt files :
del route.txt
del saxonfile.txt
del xmlfound.txt
del xslt.txt