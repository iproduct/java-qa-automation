pipeline {
    agent any
    tools {
        maven 'apache-maven-3.8.4'
    }
    stages {
        stage('Build and test') {
            steps {
                bat 'cd 03-junit5-lab\nmvn package test'
                bat 'cd 05-selenium-lab\nmvn package test'
            }
        }
    }
}