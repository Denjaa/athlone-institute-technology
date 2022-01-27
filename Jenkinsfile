pipeline {
    agent any

    stages {
//         stage('SonarQube Analysis') {
//             steps {
//                 withSonarQubeEnv('SonarQube') {
//                     sh ('''
//                         chmod +x gradlew
//                         ./gradlew sonarqube
//                     ''')
//                 }
//             }
//         }
//
//         stage('Build') {
//             steps {
//
//                 sh ('''
//                     chmod +x gradlew
//                     ./gradlew assemble
//                 ''')
//             }
//         }
//
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }

        stage('Docker Image') {
                    steps {
                        sh ('''
                            chmod +x gradlew
                            ./gradlew build
                            ./gradlew docker
                        ''')
                    }
                }
    }
}