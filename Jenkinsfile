pipeline {
    agent any 
  stages {
  stage('making artifact'){
  when { changeRequest branch 'master' } 
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
    sh '''if [ "$(ssh ec2-user@18.191.18.209 docker ps -q -f name=mukesh-devops)" ]; then
                                              if [ $(ssh ec2-user@18.191.18.209 docker inspect -f '{{.State.Running}}' mukesh-devops) = "true" ]; then
                                                  ssh ec2-user@18.191.18.209 docker rm -f mukesh-devops
                                              fi
                                                  ssh ec2-user@18.191.18.209 docker run -d -p 8000:8000 --name mukesh-devops mukesh236/devops
                                              fi'''
 
}
  }

}
}
