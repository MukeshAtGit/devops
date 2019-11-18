pipeline {
    agent any 
  stages {
  stage('making artifact'){
 steps {
     sh "sbt assembly"
  }
}
  stage("docker build"){
 steps {
     sh "docker build -t assignment ."
}
         }
stage("docker tag"){
 steps {
     sh "docker tag assignment mukesh236/assignment"
}
  }
  stage("docker push"){
 steps {
     sh "docker push mukesh236/assignment"
}
  }
  stage("check for running container"){
 steps {def names=sh "ssh ec2-user@18.191.18.209 docker ps --format '{{.Image}}'"
  { echo "goood"
}
}
  }
}
}
