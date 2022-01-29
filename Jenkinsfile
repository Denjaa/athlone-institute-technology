
pipeline {
    agent any

    environment {
        SONAR = "true"
        GIT_BRANCH = "main"
        GIT_HTTP_CLONE_URL= "https://github.com/Denjaa/athlone-institute-technology.git"
        GIT_CREDENTIAL_ID = "ait-pipeline"
    }

    stages {
        stage("Source Code Checkout") {
            steps {
                deleteDir()
                git branch: 'main', url: 'https://github.com/Denjaa/athlone-institute-technology.git'
        }
        stage('Build') {
                    steps {

                        // setting up the running mode on the application of Gradle
                        // running the gradle clean mode to identify a new application
                        // running the gradle build mode to build the application
                        sh ('''
                            chmod +x gradlew
                            ./gradlew clean
                            ./gradlew build
                        ''')
                    }
                }

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