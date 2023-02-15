FROM al2-graalvm:11

# quarkus native functions
WORKDIR /src
COPY ../bom.xml ./
COPY ../pom.xml ./
COPY ../api ./api
COPY ../factorial ./factorial
COPY ../fibonacci ./fibonacci
COPY ../rsa ./rsa
COPY ../app ./app
COPY ../functions/quarkus-function ./functions/quarkus-function

RUN mvn clean install -f bom.xml
RUN mvn clean install
RUN mvn  \
    -Pnative  \
    -Dquarkus.native.auto-service-loader-registration=true  \
    package \
    -f functions/quarkus-function/pom.xml