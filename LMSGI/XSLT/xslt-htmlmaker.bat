echo on

chdir > ./route.txt
cls
set /p route= < route.txt
cls

set saxon="C:\Users\usuario\workspace\DAW\LMSGI\XSLT\Saxon\saxon9he.jar"
cls
set /p html= Write a name for your html without the extension .html: 
set /p xml= Write the name of you xml file just the name without the extension: 
set /p xslt= Write the name of you xslt file just the name without the extension: 

: And this is the command who makes the conversion of the xml and xslt into a html file :
java -jar "%saxon%" -o:%route%\%html%.html -s:%xml%.xml -xsl:%xslt%.xslt


: Here we start the chrome with the name of our environment variable called html :
start chrome %html%.html

: Here we removed the .txt files :
del route.txt
pause
