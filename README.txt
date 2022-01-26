# Spin up docker
docker container run -d -p 8082:8080 -v jenkinsvol1:/var/jenkins_home --name jenkins-local jenkins/jenkins:lts

# Retrieve the password from switching on jenkins
docker container exec 1615aaf0e834bbd8df5d9155ebe967a3a00458220e2d2b2de7b886a10792e700 sh -c "cat /var/jenkins_home/secrets/initialAdminPassword" 


https://rangle.io/blog/running-jenkins-and-persisting-state-locally-using-docker-2/`

https://github.com/Denjaa/athlone-institute-technology.git
git@github.com:Denjaa/athlone-institute-technology.git


https://webhookrelay.com/blog/2017/11/23/github-jenkins-guide/
http://7176-84-203-37-251.ngrok.io 

New token created
Key:
80f62863-3d6a-4dbd-9041-500abe4f4f0f
Secret:
qnkIiThvg3F5
To configure relay CLI, run the following command:
relay login -k 80f62863-3d6a-4dbd-9041-500abe4f4f0f -s qnkIiThvg3F5
To use credentials as an environment variables:
            
export RELAY_KEY=80f62863-3d6a-4dbd-9041-500abe4f4f0f
export RELAY_SECRET=qnkIiThvg3F5

            
To create Kubernetes Secret:
              
kubectl create secret generic whr-credentials \
    --from-literal=key=80f62863-3d6a-4dbd-9041-500abe4f4f0f \
    --from-literal=secret=qnkIiThvg3F5