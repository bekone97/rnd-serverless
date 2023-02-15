FROM al2-graalvm:17

# micronaut native functions
WORKDIR /src
COPY ../bom.xml ./
COPY ../pom.xml ./
COPY ../api ./api
COPY ../factorial ./factorial
COPY ../fibonacci ./fibonacci
COPY ../rsa ./rsa
COPY ../app ./app
COPY ../functions/micronaut-function ./functions/micronaut-function

RUN mvn clean install -f bom.xml
RUN mvn clean install
RUN mvn \
   -Dpackaging=native-image  \
    package \
    -f functions/micronaut-function/pom.xml
