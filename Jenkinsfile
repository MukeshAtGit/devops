pipeline {
  stages {
  stage('compile'){
      script: 'sbt clean compile'
  }
  stage('test'){
      script: 'sbt test'
  }
  stage('making artifact'){
       script: 'sbt assembly'
  }
  stage("docker build"){
      script: 'docker build -t assignment .'
      script: 'docker tag assignment mukesh236/assignment'
  }
  stage("docker push"){
       script: 'docker push mukesh236/assignment'
  }
  stage("ssh congfigure"){
        script:'ssh ec2-user@18.191.18.209 docker run -d -p 8090:8000 mukesh236/assignment:latest'
  }
}
}
