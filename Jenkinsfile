pipeline {
    agent any
    tools {
        maven 'apache-maven-3.8.4'
    }
    stages {
        stage('Build and test 03-junit5-lab') {
            steps {
                bat 'cd 03-junit5-lab\nmvn package'
            }
        }
        stage('Build and test 05-selenium-lab') {
            steps {
                bat 'cd 05-selenium-lab\nmvn package'
            }
        }
    }
}