pipeline {
    agent any 
  stages {
  stage('Compiling'){

   steps {
       sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt compile"
    }
  }
   stage('Testing'){

     steps {
         sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt test"
      }
    }
  stage('making artifact'){
  when { anyOf { branch 'master'; branch 'devlop' } }
 steps {
     sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt assembly"
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
     sh "docker tag assignment mukesh236/assignment:latest"
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
