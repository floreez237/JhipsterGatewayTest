pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x mvnw;
./mvnw clean install -Dlicense.skip=true -DskipTests=true'''
        echo 'Project Build Build ID ${BUILD_ID}'
      }
    }

    stage('Testing') {
      parallel {
        stage('SonarQube Test') {
          steps {
            sh '''mvn sonar:sonar \\
  -Dsonar.projectKey=jhipster-myAppOauth \\
  -Dsonar.host.url=http://server:9000 \\
  -Dsonar.login=2461104211032049b123c879869de47a29c4dc54'''
          }
        }

        stage('print Tester Credentials') {
          steps {
            echo 'The tester is ${TESTER}'
            sleep 10
          }
        }

        stage('Print Build Number') {
          steps {
            echo 'This is build number ${BUILD_ID}'
          }
        }

      }
    }

  }
}