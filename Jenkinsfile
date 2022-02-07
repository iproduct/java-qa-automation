pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Stage 1') {
            steps {
                echo 'Hello world!' 
            }
        }
    }
}
