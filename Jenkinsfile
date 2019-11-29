pipeline {
    agent {label 'master'} 
    environment {
        ISOLATION_ID = sh(returnStdout: true, script: 'printf $BUILD_TAG | sha256sum | cut -c1-64').trim()
    }
  stages {
  stage('Compiling'){

   steps {
       sh "echo Branch Name: ${env.BRANCH_NAME}"
       sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt compile"
    }
  }
   stage('Testing'){
       parallel {
           stage('ControllerSpec Testing'){
     steps {
         sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt 'testOnly ControllerSpec' "
      }
    }
           stage('CubeCalculatorTest Testing'){
       steps {
         sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt 'testOnly CubeCalculatorTest'"
      }
    }
   }
   }
  stage('making artifact'){
 steps {
     sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt assembly"
  }
}
  stage("docker build"){
 steps {
     sh "docker build -t assignment ."
}
         }
stage("docker tag"){
 steps {
     sh "docker tag assignment mukesh236/assignment:$ISOLATION_ID"
}
  }
  stage("docker push"){
 steps {
     sh "docker push mukesh236/assignment:$ISOLATION_ID"
}
  }
  stage("check for running container"){
  when { branch 'devlop' }
      agent {label 'slave_ubuntu'} 
 steps {
    sh '''if [ $(docker inspect -f '{{.State.Running}}' mukesh-devops) = "true" ]; then
                                                  docker rm -f mukesh-devops
                                              fi
                                                 docker run -d -p 8000:8000 --name mukesh-devops mukesh236/assignment:$ISOLATION_ID
                                              '''
}
}
}
}
