pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                mvn clean install
                echo Building done
            }
        }
    }
}