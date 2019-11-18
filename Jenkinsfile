pipeline {
    agent any 
  stages {
  stage('compile'){
 steps {
    sh  "sbt clean compile"
}
  }
  stage('test'){
 steps {
    sh "sbt test"
}
  }
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
  stage("docker run"){
 steps {
sh "ssh ec2-user@18.191.18.209 docker run -d -p 8000:8000 mukesh236/devops"
}
  }

}
}
