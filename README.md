# CI-CD-with-Dockers-and-Jenkins

### Cloud formation

https://youtu.be/yrCZs0FNP58

### AWS CI/CD

https://youtu.be/KfWyK_PbECs

### Jenkins Local Deployment
start Jenkins using docker compose
```
docker-compose -f docker-compose.yml up --build
```
start sonar
```
docker run -d --name sonarqube -p 9000:9000 sonarqube
```
1. https://youtu.be/2SY8mvsJ66I

### Cucumber
1. https://youtu.be/uZ1Zvvty9jI

### Azure devops
```
brew update && brew install azure-cli
az login
az group create --name kubetutrg --location westeurope
az aks create --resource-group kubetutrg --name kubetutcluster --node-count 2 --enable-addons monitoring --generate-ssh-keys
az aks get-credentials --resource-group kubetutrg --name kubetutcluster
```
1. https://youtu.be/XfViBcEUXb8
2. https://youtu.be/Ufvp0fAsVkk

### Jenkins on Google cloud Kubernetes
1. https://youtu.be/Q5jk5CBGFIQ

1. Create a project in Google cloud. I used the name in28minutes-2
2. Follow the instructions here to create kubernetes cluster & install Jenkins on that cluster using Helm(https://cloud.google.com/solutions/jenkins-on-kubernetes-engine-tutorial)
```
gcloud config set compute/zone us-east1-d
git clone https://github.com/GoogleCloudPlatform/continuous-deployment-on-kubernetes.git
cd continuous-deployment-on-kubernetes
gcloud container clusters create jenkins-cd \
  --machine-type n1-standard-2 --num-nodes 2 \
  --scopes "https://www.googleapis.com/auth/source.read_write,cloud-platform" \
  --cluster-version 1.12
gcloud container clusters list

wget https://storage.googleapis.com/kubernetes-helm/helm-v2.14.1-linux-amd64.tar.gz
tar zxfv helm-v2.14.1-linux-amd64.tar.gz
cp linux-amd64/helm .
kubectl create clusterrolebinding cluster-admin-binding --clusterrole=cluster-admin \
        --user=$(gcloud config get-value account)
kubectl create serviceaccount tiller --namespace kube-system
kubectl create clusterrolebinding tiller-admin-binding --clusterrole=cluster-admin \
    --serviceaccount=kube-system:tiller
./helm init --service-account=tiller
./helm repo update
./helm version

./helm install -n cd stable/jenkins -f jenkins/values.yaml --version 1.2.2 --wait
kubectl get pods
export POD_NAME=$(kubectl get pods --namespace default -l "app.kubernetes.io/component=jenkins-master" -l "app.kubernetes.io/instance=cd" -o jsonpath="{.items[0].metadata.name}")
kubectl port-forward $POD_NAME 8080:8080 >> /dev/null &
kubectl get svc

printf $(kubectl get secret cd-jenkins -o jsonpath="{.data.jenkins-admin-password}" | base64 --decode);echo
```
3. Run the below command to give access for jenkins service account to use Google API's
```
gcloud set config project in28minutes-3
gcloud auth configure-docker
gcloud container clusters get-credentials jenkins-cd --zone=us-east1-d

kubectl create clusterrolebinding jenkins-deploy \
    --clusterrole=cluster-admin --serviceaccount=default:cd-jenkins
kubectl apply -f jenkins-volume-persistentvolumeclaim.yaml
```



