# syntax=docker/dockerfile:experimental
FROM maven:3.6.3-openjdk-11 as  build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

#RUN chmod u+x ./mvnw
RUN --mount=type=cache,target=/root/.m2 mvn package -DskipTests
#RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11-jre-slim
RUN useradd -m --uid 10001 --system springboot
USER springboot

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","org.hung.SpringBootToSkaffoldApplication"]
