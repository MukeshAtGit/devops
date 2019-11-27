pipeline {
    agent any 
  stages {
  stage('Compiling'){

   steps {
       sh "sbt compile"
    }
  }
   stage('Testing'){

     steps {
         sh "sbt test"
      }
    }
  stage('making artifact'){
  when { anyOf { branch 'master'; branch 'devlop' } }
 steps {
     sh "sbt assembly"
  }
}
  stage("docker build"){
  when { anyOf { branch 'master'; branch 'devlop' } }
 steps {
     sh "docker build -t assignment ."
}
         }
stage("docker tag"){
when { anyOf { branch 'master'; branch 'devlop' } }
 steps {
     sh "docker tag assignment mukesh236/assignment"
}
  }
  stage("docker push"){
  when { anyOf { branch 'master'; branch 'devlop' } }
 steps {
     sh "docker push mukesh236/assignment"
}
  }
  stage("check for running container"){
  when { branch 'master' }
 steps { agent { label 'slave_ubuntu' }
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
