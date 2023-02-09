FROM al2-graalvm:maven

# quarkus native functions
RUN echo "rnd.serverless.impl.fibonacci.Fibonacci" >| functions/quarkus-function/src/main/resources/META-INF/services/rnd.serverless.api.Calculate
RUN mvn -Pnative -DimageName=fibonacci -Dquarkus.package.output-name=fibonacci -Dquarkus.native.auto-service-loader-registration=true -pl functions/quarkus-function package

RUN echo "rnd.serverless.impl.factorial.Factorial" >| functions/quarkus-function/src/main/resources/META-INF/services/rnd.serverless.api.Calculate
RUN mvn -Pnative -DimageName=factorial -Dquarkus.package.output-name=factorial -Dquarkus.native.auto-service-loader-registration=true -pl functions/quarkus-function package

RUN echo "rnd.serverless.impl.rsa.RSA" >| functions/quarkus-function/src/main/resources/META-INF/services/rnd.serverless.api.Calculate
RUN mvn -Pnative -DimageName=rsa -Dquarkus.package.output-name=rsexa -Dquarkus.native.auto-service-loader-registration=true -pl functions/quarkus-function package