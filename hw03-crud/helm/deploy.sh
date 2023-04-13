#!/usr/bin/env sh

kubectl create ns otus
helm install nginx --namespace otus nginx-stable/nginx-ingress --set controller.service.httpPort.port=80 --set controller.enableSnippets=True
helm upgrade --install -n otus hw03-crud chart