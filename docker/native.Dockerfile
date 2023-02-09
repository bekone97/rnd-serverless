FROM al2-graalvm:maven

# native functions
RUN echo "rnd.serverless.impl.fibonacci.Fibonacci" >| functions/native-function/src/main/resources/META-INF/services/rnd.serverless.api.Calculate
RUN mvn -Pnative -DimageName=fibonacci -DoutputDirectory=target/fibonacci -pl functions/native-function package

RUN echo "rnd.serverless.impl.factorial.Factorial" >| functions/native-function/src/main/resources/META-INF/services/rnd.serverless.api.Calculate
RUN mvn -Pnative -DimageName=factorial -DoutputDirectory=target/factorial -pl functions/native-function package

RUN echo "rnd.serverless.impl.rsa.RSA" >| functions/native-function/src/main/resources/META-INF/services/rnd.serverless.api.Calculate
RUN mvn -Pnative -DimageName=rsa -DoutputDirectory=target/rsa -pl functions/native-function package