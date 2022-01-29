JENKINS_AGENT = 'any'

pipeline {
    agent ${JENKINS_AGENT}

    environment {
        ENV.SONAR = 'true'
        ENV.BRANCH = 'main'
        ENV.GIT = 'https://github.com/Denjaa/athlone-institute-technology.git'
    }

    stages {
        stage('Build') {
                    steps {
                       // pulling down the latest changes from remote repository
                       git branch: '${ENV.BRANCH}', url: '${ENV.GIT}'

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