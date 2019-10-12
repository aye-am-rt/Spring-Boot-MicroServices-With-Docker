FROM openjdk:11
#WORKDIR usr/src
#ENV MYSQL_DATABASE=demo
#ENV MYSQL_USER=root
#ENV MYSQL_PASSWORD=Root@123
#ENV MYSQL_CI_URL=jdbc:mysql://localhost:33060/demo
ADD target/Eureka-Server-For-Docker.jar Eureka-Server-For-Docker.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","Eureka-Server-For-Docker.jar"]