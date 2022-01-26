pipeline {
    agent none
    
    stages {
        agent {
            docker { image 'node:16.13.1-alpine' }
        }

        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}