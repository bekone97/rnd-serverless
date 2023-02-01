#
# Step 1: Build jars
#
FROM maven:3.8.7-amazoncorretto-17 AS build
WORKDIR /home/rnd-serverless
COPY ./pom.xml ./
COPY ./api ./api
COPY ./factorial ./factorial
COPY ./fibonacci ./fibonacci
COPY ./rsa ./rsa
COPY ./app ./app
RUN mvn clean install

#
# Step 2: Final image
#
FROM amazoncorretto:17-al2-full
WORKDIR /home/rnd-serverless
COPY --from=build /home/rnd-serverless/api/target/api-1.0.jar /home/rnd-serverless/api/api-1.0.jar
COPY --from=build /home/rnd-serverless/factorial/target/factorial-1.0.jar /home/rnd-serverless/factorial/factorial-1.0.jar
COPY --from=build /home/rnd-serverless/fibonacci/target/fibonacci-1.0.jar /home/rnd-serverless/fibonacci/fibonacci-1.0.jar
COPY --from=build /home/rnd-serverless/rsa/target/rsa-1.0.jar /home/rnd-serverless/rsa/rsa-1.0.jar
COPY --from=build /home/rnd-serverless/app/target/app-1.0.jar /home/rnd-serverless/app/app-1.0.jar
COPY --from=build /root/.m2/repository/com/amazonaws/aws-lambda-java-core/1.2.2/aws-lambda-java-core-1.2.2.jar /home/rnd-serverless/aws-lambda-java-core/aws-lambda-java-core-1.2.2.jar
# To control which functions will be executed, add the appropriate jar to the --module-path
ENTRYPOINT ["java", \
"--upgrade-module-path", "./app;./api;./aws-lambda-java-core;./factorial;./fibonacci;./rsa", \
"-m", "app/rnd.serverless.Handler"]
# todo fix: module app isn't resolved inside container; but same command locally works