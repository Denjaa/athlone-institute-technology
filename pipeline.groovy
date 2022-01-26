pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-11-slim'
        }
    }
    stages {
        stage('Initialize'){
            steps {
                def dockerHome = tool 'myDocker'
                env.PATH = "${dockerHome}/bin:${env.PATH}"                }
        }

        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}