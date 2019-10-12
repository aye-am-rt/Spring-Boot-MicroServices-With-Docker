FROM openjdk:11
#WORKDIR usr/src
#ENV MYSQL_DATABASE=demo
#ENV MYSQL_USER=root
#ENV MYSQL_PASSWORD=Root@123
#ENV MYSQL_CI_URL=jdbc:mysql://localhost:33060/demo
ADD target/movie-service-0.0.1-SNAPSHOT.jar movie-service-0.0.1-SNAPSHOT.jar
EXPOSE 8098
ENTRYPOINT ["java","-jar","movie-service-0.0.1-SNAPSHOT.jar"]