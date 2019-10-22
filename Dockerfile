FROM openjdk:8-jre-alpine
COPY /target/scala-2.12/devops-assembly-0.1.jar .
CMD ["java", "-jar", "/target/scala-2.12/devops-assembly-0.1.jar"]
sudo docker build -t assignment1

