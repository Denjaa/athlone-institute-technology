pipeline {
    stages {
        
        stage('Run test') {
            steps {
                script {
                    def dockerHome = tool 'myDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    sh 'mvn --version'
                }
            }
        }
    }
}