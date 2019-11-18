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
         }
stage("docker tag"){
     sh 'docker tag assignment mukesh236/assignment'
  }
  stage("docker push"){
     sh 'docker push mukesh236/assignment'
  }
}
}
