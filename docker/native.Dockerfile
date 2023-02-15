FROM al2-graalvm:11

# native functions
WORKDIR /src
COPY ../bom.xml ./
COPY ../pom.xml ./
COPY ../api ./api
COPY ../factorial ./factorial
COPY ../fibonacci ./fibonacci
COPY ../rsa ./rsa
COPY ../app ./app
COPY ../functions/native-function ./functions/native-function

RUN mvn clean install -f bom.xml
RUN mvn clean install
RUN mvn -Pnative package -f functions/native-function/pom.xml