
pipeline {
    agent any

    environment {
        SONAR = "true"
    }

    stages {

        stage("Clone Source Code") {
            steps {
                // deleting and cleaning up the working directory and preparation for new pull
                deleteDir()

                // fetching the latest source and and application code from repository
                git branch: 'main', url: 'https://github.com/Denjaa/athlone-institute-technology.git'

                // setting up the running mode on the application of Gradle and all required permissions (executable)
                sh ('chmod +x gradlew')
            }
        }

        stage('Build') {
                    steps {
                        // Gradle clean the previous builds and build new project
                        sh ('./gradlew clean build')
                    }
                }

        stage('SonarQube Analysis') {
            when {
                  expression {
                    SONAR == 'true'
                  }
            }
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh ('''
                        chmod +x gradlew
                        ./gradlew sonarqube
                    ''')
                }
            }
        }

        stage('SonarQube Quality Gate')  {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }



        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Docker Image') {
                    steps {
                        sh ('''
                        export DOCKER_HOST="tcp://host.docker.internal:2375"
                        docker build .
                        ''')
                    }
                }
    }
}