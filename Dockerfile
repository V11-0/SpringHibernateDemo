FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.vinibrenobr11.springhibernatedemo.SpringhibernatedemoApplication"]
