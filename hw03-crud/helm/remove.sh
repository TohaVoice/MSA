#!/usr/bin/env sh

helm uninstall -n otus nginx
kubectl delete ns otus