#
# Step 1: Build jars
#
FROM maven:3.8.7-amazoncorretto-11 AS build
WORKDIR /App
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
FROM amazoncorretto:11-al2022-jdk
WORKDIR /App
COPY --from=build /App/app/target/app-1.0.jar app-1.0.jar
COPY --from=build /App/api/target/api-1.0.jar lib/api-1.0.jar
COPY --from=build /root/.m2/repository/com/amazonaws/aws-lambda-java-core/1.2.2/aws-lambda-java-core-1.2.2.jar lib/aws-lambda-java-core-1.2.2.jar
COPY --from=build /App/factorial/target/factorial-1.0.jar fac/factorial-1.0.jar
COPY --from=build /App/fibonacci/target/fibonacci-1.0.jar fib/fibonacci-1.0.jar
COPY --from=build /App/rsa/target/rsa-1.0.jar rsa/rsa-1.0.jar
# To control which functions will be executed, add the appropriate jar to the --module-path
ENTRYPOINT ["java", \
"--upgrade-module-path", "/App/lib:/App/fac:/App/fib:/App/rsa", \
"--add-modules", "aws.lambda.java.core", \
"-jar", "/App/app-1.0.jar"]