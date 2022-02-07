pipeline {
    agent {
        dockerfile {
            filename 'Dockerfile.build'
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