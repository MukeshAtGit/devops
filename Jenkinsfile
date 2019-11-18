pipeline {
    agent any 
  stages {
  stage('compile'){
    sh  'sbt clean compile'
  }
  stage('test'){
    sh 'sbt test'
  }
  stage('making artifact'){
     sh 'sbt assembly'
  }
  stage("docker build"){
     sh 'docker build -t assignment .'
     sh 'docker tag assignment mukesh236\assignment'
  }
  stage("docker push"){
     sh 'docker push mukesh236/assignment'
  }
  stage("ssh congfigure"){
      sh 'ssh ec2-user@18.191.18.209 'docker run -d -p 8090:8000 mukesh236/assignment:latest''
  }
}
}
