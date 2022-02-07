pipeline {
    agent any
    tools {
        maven 'apache-maven-3.8.4'
    }
    stages {
        stage('Example') {
            steps {
                bat 'cd 03-junit5-lab\nmvn package test'
            }
        }
    }
}