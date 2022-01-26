
JENKINS_USER = "srvAP143212dev"
JENKINS_NODE_LABEL = "RE_UBUNTU_DEV"

pipeline {
    agent {
        label "${JENKINS_NODE_LABEL}"
    }

    environment {
 
    }

    parameters {
        choice(choices: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10'], name: 'NUMBER_SERVERS')
        choice(choices: ['Activate', 'De-Activate'], name: 'SERVICE_TYPE')
    }

    stages {

        stage("Checkout Git") {
            
        }

        stage("Switching Off Servers") {
            
        }

        stage("Switching On Servers") {

        }
    }
}