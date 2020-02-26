## Docker

Docker helps to deliver software in a container which can be deployed on any OS machine having docker. This removes the dependency on system requirements as those are captured in the container itself.  


### Terminology  

- Image: This is the output of docker build and has all the information about what all software components goes into the package.
- Container: This is the output of docker run and is built out of image.

### Build Images

docker build 


### Searching Images  
```
docker search alpine
```  
### Run Images - Containers

```
docker container run -itd --name demo alpine ash
```

i stands for interactive mode( to have stdin connected to terminal of container)
d for detached mode
t for virtual terminal linked to container
name gives the container name
alpine is the image name 
ash is the command run within the container

### See Logs


### Inspect

### Run something inside a container
### 
### Networking


###
