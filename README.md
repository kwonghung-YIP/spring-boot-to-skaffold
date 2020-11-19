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
DOCKER_BUILDKIT=1 docker build -t kwonghung/springboot-to-skaffold .
```
[Docker - Build image with BuildKit](https://docs.docker.com/develop/develop-images/build_enhancements/)
