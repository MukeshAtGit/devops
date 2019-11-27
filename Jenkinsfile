pipeline {
    agent {label 'master'} 
  stages {
  stage('making artifact'){
  when { branch 'master' } 
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
      agent {label 'slave_ubuntu'
 steps {
    sh '''if [ "$(docker ps -q -f name=mukesh-devops)" ]; then
                                              if [ $(docker inspect -f '{{.State.Running}}' mukesh-devops) = "true" ]; then
                                                  docker rm -f mukesh-devops
                                              fi
                                                  docker run -d -p 8000:8000 --name mukesh-devops mukesh236/devops
                                              fi'''
 
}
  }

}
}
