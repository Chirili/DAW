FROM nginx:1.14.2-alpine
## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*
## From 'builder' stage copy over the artifacts in dist folder to default nginx public folder
COPY index.html /usr/share/nginx/html/index.html

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

# Define it as the entrypoint script together with the path or directory that should be searched and substituted with the environment variables
# entrypoint.sh $PATH $CMD
ENTRYPOINT ["/usr/local/bin/entrypoint.sh", "/usr/share/nginx/html/index.html"]

# Define the command that should be executed at the container startup
CMD ["nginx", "-g", "daemon off;"]