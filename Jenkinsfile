pipeline {
    agent any 
  stages {
  stage('compile'){
     sbt clean compile
  }
  stage('test'){
     sbt test
  }
  stage('making artifact'){
       sbt assembly
  }
  stage("docker build"){
      docker build -t assignment .
      docker tag assignment mukesh236{ \ }assignment
  }
  stage("docker push"){
      docker push mukesh236/assignment
  }
  stage("ssh congfigure"){
       ssh ec2-user@18.191.18.209 docker run -d -p 8090:8000 mukesh236/assignment:latest
  }
}
}
