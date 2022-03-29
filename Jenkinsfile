pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x mvnw;
./mvnw clean install -Dlicense.skip=true -DskipTests=true'''
        echo 'Project Build Build ID $BUILD_ID'
      }
    }

  }
}