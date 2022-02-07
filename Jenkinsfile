pipeline {
    agent { 
        docker { 
            image 'maven:3.8.4-openjdk-11-slim' 
            args '-w /root/.jenkins/workspace/My-Pipeline_main/ -v C:/ProgramData/Jenkins/.jenkins/workspace/My-Pipeline_main/:/root/.jenkins/workspace/My-Pipeline_main/ -v C:/ProgramData/Jenkins/.jenkins/workspace/My-Pipeline_main@tmp/:/root/.jenkins/workspace/My-Pipeline_main@tmp/' 
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