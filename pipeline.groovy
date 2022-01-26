pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }

    stages {
        
        stage('Run test') {
            steps {
                script {
                    def dockerHome = tool 'myDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    sh 'mvn --version'
                }
            }
        }
    }
}