docker-build:
	docker build -f docker/Dockerfile . -t avshatokhin/msa:hw03-crud

docker-push:
	docker push avshatokhin/msa:hw03-crud

docker-start:
	cd docker && docker-compose up -d

docker-stop:
	cd docker && docker-compose down

k8s-deploy-sh:
	helm/deploy.sh

k8s-remove-sh:
	helm/remove.sh

k8s-deploy:
	kubectl create ns otus && helm install nginx --namespace otus nginx-stable/nginx-ingress --set controller.service.httpPort.port=80 --set controller.enableSnippets=True && helm upgrade --install -n otus hw03-crud helm/chart

k8s-remove:
	helm uninstall -n otus nginx && kubectl delete ns otus
