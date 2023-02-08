build-FibonacciFunctionNative:
	echo "rnd.serverless.impl.fibonacci.Fibonacci" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate
	mvn package -Pnative
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)
build-FactorialFunctionNative:
	echo "rnd.serverless.impl.factorial.Factorial" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate
	mvn package -Pnative
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)
build-FibonacciFunctionNative:
	echo "rnd.serverless.impl.rsa.RSA" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate
	mvn package -Pnative
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)