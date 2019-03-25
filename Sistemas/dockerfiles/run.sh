docker run -it --rm -p 3000:80 --name site-web site-web
docker run -it --rm -p 4000:80 --name site-web-dev --volume C:\Users\Andres\Downloads\dockerfiles:/usr/share/nginx/html nginx:1.14.2-alpine