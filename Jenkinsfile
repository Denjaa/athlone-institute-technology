
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
                script {
                    echo "trying to checkout branch  : ${env.GIT_BRANCH}"
                    def scmVars = checkout (
                        changelog: true, poll: true,
                        scm: [
                            branches: [[name: "main"]],
                            userRemoteConfigs: [[credentialsId: "${env.GIT_CREDENTIAL_ID}", url: "https://github.com/Denjaa/athlone-institute-technology.git"]]
                        ]
                    )
                    env.CAPTURE_GIT_SHA = scmVars.GIT_COMMIT
                    echo "${env.CAPTURE_GIT_SHA}"
                }
            }
        }
        stage('Build') {
                    steps {
                        deleteDir()
                       // pulling down the latest changes from remote repository
                       git branch: 'main', url: '${GIT}'

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