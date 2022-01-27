pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                
                sh ('''
                    sudo chmod +x ./gradlew
                    ./gradlew assemble
                ''')
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}