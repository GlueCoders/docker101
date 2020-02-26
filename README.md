## Docker

Docker helps to deliver software in a container which can be deployed on any OS machine having docker. This removes the dependency on system requirements as those are captured in the container itself.  


### Terminology  

- Image: This is the output of docker build and has all the information about what all software components goes into the package.
- Container: This is the output of docker run and is built out of image.

### Build Images
```
docker image build -t imagename .
```
Dockerfile is needed to build the docker image.

### Searching Images  
```
docker search alpine
```  

### Listing images  
```
docker image ls
```   

### Image history
```
docker image history image_name
```  

### Removing image
```
docker image rm image_name
```  

### Run Containers

```
docker container run -itd -p 80:80 --name demo alpine ash
```

i stands for interactive mode( to have stdin connected to terminal of container)
d for detached mode
t for virtual terminal linked to container
name gives the container name
alpine is the image name 
ash is the command run within the container

### See Logs
```
docker logs container_name
```

### Inspect
```
docker container inspect container_name
```

### Stopping Container
```
docker container stop container_name
```

### Removing Container
```
docker container rm container_name
```

### Removing all stopped containers
```
docker container prune
```

### Run something inside a container
```
docker container exec -it container_name /bin/bash
```

## Networking
### Creating a network
```
docker network create network_name
```


###
