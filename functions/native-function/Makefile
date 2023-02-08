BUILD_NATIVE := build_native
COPY_FIBONACCI := copy_fibonacci
COPY_RSA := copy_rsa
COPY_FACTORIAL := copy_factorial
API_PATH := src/main/resources/META-INF/services/rnd.serverless.api.Calculate

build-FibonacciFunctionNative: $(COPY_FIBONACCI) $(BUILD_NATIVE)
build-FactorialFunctionNative: $(COPY_FACTORIAL) $(BUILD_NATIVE)
build-RSAFunctionNative: $(COPY_RSA) $(BUILD_NATIVE)

$(COPY_FIBONACCI):
	echo "rnd.serverless.impl.fibonacci.Fibonacci" >| $(API_PATH)

$(COPY_RSA):
	echo "rnd.serverless.impl.rsa.RSA" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate

$(COPY_FACTORIAL):
	echo "rnd.serverless.impl.factorial.Factorial" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate

$(BUILD_NATIVE):
	mvn package -Pnative
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)