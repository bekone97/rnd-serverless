FROM al2-graalvm:11

# native functions
WORKDIR /src
COPY ../pom.xml ./
COPY ../api ./api
COPY ../factorial ./factorial
COPY ../fibonacci ./fibonacci
COPY ../rsa ./rsa
COPY ../app ./app
COPY ../functions ./functions

RUN mvn clean install
RUN mvn -Pnative -pl functions/native-function package