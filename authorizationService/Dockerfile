FROM openjdk:11
EXPOSE 8084
ADD "target/*.jar" "auth.jar"
ENTRYPOINT [ "java", "-jar", "/auth.jar" ]