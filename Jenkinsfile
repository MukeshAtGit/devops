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
 steps {
    sh ''' if("ssh ec2-user@18.191.18.209 docker ps --format '{{.Image}}'"==gallant_elgamal) then
          echo "goood"''''''if [ "$(ssh ec2-user@18.191.18.209 docker ps -q -f name=gallant_elgamal)" ]; then
                                              if [ $(docker inspect -f '{{.State.Running}}' gallant_elgamal) = "true" ]; then
                                                  docker rm -f gallant_elgamal
                                              fi
                                                  docker run -d -p 8000:8000 --name mukesh-devops mukesh236/devops
                                              fi'''
 
}
  }
}
}
