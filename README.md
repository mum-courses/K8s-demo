# K8s-demo
Demo showing using Spring cloud Framework with Kubernetes. 


#You need 

install minikube
install kubectl 

An account on: https://hub.docker.com


#optional 
check : https://kubernetes.io/docs/reference/kubectl/cheatsheet/#kubectl-autocomplete


#notes:
services are exposed as NodePort
check services : kubectl get services
get IP of the Node : kubectl cluster-info
Then call your service <NODE IP>:<NODE PORT>