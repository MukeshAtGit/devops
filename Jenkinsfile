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
    sh "docker run -d -p 8000:8000 --name mukesh-devops mukesh236/devops"
 
}
  }

}
}
