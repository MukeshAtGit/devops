ARG CODE_VERSION=8
FROM openjdk:${CODE_VERSION}-jre-alpine
COPY target/scala-2.12/devops-assembly-0.1.jar /
CMD java -jar devops-assembly-0.1.jar

