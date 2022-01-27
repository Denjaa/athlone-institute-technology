pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh ('''
                        chmod +x gradlew
                        ./gradlew sonarqube
                    ''')
                }
            }
        }

        stage('Quality Gate') {
                    steps {
                        waitForQualityGate abortPipeline: true
                    }
        }

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