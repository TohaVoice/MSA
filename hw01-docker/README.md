# App in Docker

### Run App:
1. Build image 
```
docker build --platform linux/amd64 -t hw01-docker . 
```
2. Run docker container on port 8000
```
docker run --publish 8000:8000 hw01-docker
```

### Additional cmd
- Clean docker build cache
```
docker builder prune
```
- Change docker tag
```
docker tag latest avshatokhin/msa:hw01-docker
```
- Push to docker hub
```
docker push avshatokhin/msa:hw01-docker
```