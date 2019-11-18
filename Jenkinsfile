pipeline {
  stage('compile'){
      sh label: '', script: 'sbt clean compile'
  }
  stage('test'){
      sh label: '', script: 'sbt test'
  }
  stage('making artifact'){
      sh label: '', script: 'sbt assembly'
  }
  stage("docker build"){
     sh label: '', script: 'docker build -t assignment .'
     sh label: '', script: 'docker tag assignment mukesh236/assignment'
  }
  stage("docker push"){
      sh label: '', script: 'docker push mukesh236/assignment'
  }
  stage("ssh congfigure"){
         sh label: '', script:'ssh ec2-user@18.191.18.209 docker run -d -p 8090:8000 mukesh236/assignment:latest'
  }
}
}
