pipeline {
    agent any

     options {
            // This is required if you want to clean before build
            skipDefaultCheckout(true)
     }

    stages {
        stage('Build') {
                    steps {

                        sh ('''
                            git branch: 'main', url: 'https://github.com/Denjaa/athlone-institute-technology.git'
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