FROM al2-graalvm:17

# spring native functions
WORKDIR /src
COPY ../bom.xml ./
COPY ../pom.xml ./
COPY ../api ./api
COPY ../factorial ./factorial
COPY ../fibonacci ./fibonacci
COPY ../rsa ./rsa
COPY ../app ./app
COPY ../functions/spring-function ./functions/spring-function

RUN mvn clean install -f bom.xml
RUN mvn clean install
RUN mvn  \
    -Pnative  \
    native:compile \
    -f functions/spring-function/pom.xml
