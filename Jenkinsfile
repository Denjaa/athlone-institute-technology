pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                
                sh ('''
                    chmod +x gradlew
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