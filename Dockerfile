
FROM tomcat:8.5.50-jdk8-openjdk


# ao criar build da imagem tem que usar a tag --build--arg  {nome do arg} = Valordo arg
# docker build --build-arg PATH_WAR='deploy-front/target/tasks.war' --build-arg CONTEXT='tasks'  -t image-teste . 
COPY target/tasks-backend.war /usr/local/tomcat/webapps/tasks-backend.war

ENV DATABASE_HOST=192.168.18.132

ENV DATABASE_PORT=5433

ENV DATABASE_USER=postgres

ENV DATABASE_PASSWD=password

EXPOSE 8003:8080
