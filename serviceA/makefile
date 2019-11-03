docker-user=mumcourses

image=${docker-user}/service-a

containerID := $(shell docker ps -a -q --filter ancestor=${image})

k8sDeployment=service-a-deployment


#===================  gradle  ===========================
clean:
	./gradlew clean
build: clean
	./gradlew  bootJar
run-local: build
	java -jar build/libs/ServiceA-*.jar

#===================  docker  ===========================
docker-build: build
	docker build -t ${image} .


docker-run: docker-build
	docker run -p 8080:8080 ${image}


docker-login:
	docker login

docker-push: docker-login docker-build
	docker push ${image}:latest

docker-bash:
	docker exec -ti ${image} /bin/sh

docker-containerID:
	@echo running: $(containerID)

docker-stop:
	docker stop $(containerID)

docker-remove:
	docker rm $(containerID)

#remove all unused images
docker-prune:
	docker image prune -a -f


#===================  minikube  ===========================

#Use Docker of your host to communicate with the Docker daemon inside the Minikube VM:
k8s-use-minikube-docker:
	eval $(minikube docker-env)

k8s-deployment-create: k8s-use-minikube-docker docker-push
	kubectl apply -f deployment-service-a.yaml

k8s-deployment-delete:
	kubectl delete deployment ${k8sDeployment}

k8s-service-create:
	kubectl apply -f service-service-a.yaml

k8s-service-delete:
	kubectl delete svc service-a

k8s-service:
	kubectl describe services/${k8sDeployment}







