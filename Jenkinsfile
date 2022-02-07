pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-11-slim'
            customWorkspace '/workspace/My-Pipeline_main/'
            args '-v C:/ProgramData/Jenkins/.jenkins/workspace/My-Pipeline_main/:/workspace/My-Pipeline_main/ -v C:/ProgramData/Jenkins/.jenkins/workspace/My-Pipeline_main@tmp/:/workspace/My-Pipeline_main@tmp/'
        } 
        
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}