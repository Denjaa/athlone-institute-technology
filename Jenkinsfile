
pipeline {
    agent any

    environment {
        SONAR = "true"
        DOCKER_HOST = "tcp://host.docker.internal:2375"
        DOCKER_HUB_LOGIN = credentials('docker-hub')
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
                    // if trigger is setup as true on top then analysis of code will be performed
                    // otherwise the step will be skipped
                    SONAR == 'true'
                  }
            }
            steps {
                withSonarQubeEnv('SonarQube') {
                    // run the plugin of SonarQube on the code and do the analysis
                    sh ('./gradlew sonarqube')
                }
            }
        }

        stage('Test') {
            steps {
                // running the tests that are written for the microservice to make sure everything passes
                // if tests fail then this stage will fail
                sh ('./gradlew test')
            }
        }

        stage('Build Docker Image') {
            steps {
                sh ('docker build .')
            }
        }

        stage('Push Docker Image') {
                    steps {
                        sh ('
                            docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW
                            docker push morozovd/continious-integration-and-development-assessment:0.1.0-SNAPSHOT
                        ')
                    }
                }
    }
}