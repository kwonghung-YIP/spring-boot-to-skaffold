# spring-boot-to-skaffold
Deploy dead simple spring boot project to local kubernetes with skaffold

# to start skaffold
```bash
skaffold dev \
  --port-forward=true \
  --skip-tests=true
```

# mount maven cache in RUN in Dockerfile
```
RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests
...
DOCKER_BUILDKIT=1 docker build --no-cache -t kwonghung/springboot-to-skaffold .
```
[Docker - Build image with BuildKit](https://docs.docker.com/develop/develop-images/build_enhancements/)

# testing
```
curl localhost:8080/ping
pong
...
curl --user john:passw0rd localhost:8080/greeting
Hello john
```

# grep container process id (with docker daemon)
```
ps -ef | grep `docker inspect -f '{{.State.Pid}}' hung-test`
```
