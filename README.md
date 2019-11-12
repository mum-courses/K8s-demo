# K8s-demo
Demo showing using Spring cloud Framework with Kubernetes. 


## You need 
- install zsh 
- install minikube
- install kubectl 
- openJDK-11

## hints:
- allocate more resources to your cluster : minikube start --cpus=4  --memory='4000mb'
- Disableing swapp might improve speed
	```console
	    foo@bar:~$ minikube ssh
		$ sudo swapoff -a
	``` 
## steps 
1- run createService.sh to create the new service folder with the correct template 
2- run generateservice.sh to populate the template with the needed information
3- start coding :D 
4- hopfully your code will work :P 


An account on: https://hub.docker.com


## optional 
check : https://kubernetes.io/docs/reference/kubectl/cheatsheet/#kubectl-autocomplete


## notes:
services are exposed as NodePort
check services : kubectl get services
get IP of the Node : kubectl cluster-info
Then call your service <NODE IP>:<NODE PORT>

to store secrets, pass them first thourgh base64: check  https://kubernetes.io/docs/concepts/configuration/secret/
