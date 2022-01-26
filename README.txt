# Spin up docker
docker container run -d -p 8082:8080 -v jenkinsvol1:/var/jenkins_home --name jenkins-local jenkins/jenkins:lts

# Retrieve the password from switching on jenkins
docker container exec [DOCKER ID HERE] sh -c "cat /var/jenkins_home/secrets/initialAdminPassword" 


https://rangle.io/blog/running-jenkins-and-persisting-state-locally-using-docker-2/