TARGET_PATH := /src/functions/native-function/target
FIBONACCI := $(TARGET_PATH)/fibonacci/fibonacci
RSA := $(TARGET_PATH)/rsa/rsa
FACTORIAL := $(TARGET_PATH)/factorial/factorial
COPY_BOOTSTRAP := copy_bootstrap

build-FibonacciFunctionNative%: $(COPY_BOOTSTRAP)
	cp $(FIBONACCI) $(ARTIFACTS_DIR)/native

build-FactorialFunctionNative%: $(COPY_BOOTSTRAP)
	cp $(FACTORIAL) $(ARTIFACTS_DIR)/native

build-RSAFunctionNative%: $(COPY_BOOTSTRAP)
	cp $(RSA) $(ARTIFACTS_DIR)/native

$(COPY_FIBONACCI):
	echo "rnd.serverless.impl.fibonacci.Fibonacci" >| $(API_PATH)

$(COPY_RSA):
	echo "rnd.serverless.impl.rsa.RSA" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate

$(COPY_FACTORIAL):
	echo "rnd.serverless.impl.factorial.Factorial" >| src/main/resources/META-INF/services/rnd.serverless.api.Calculate

$(COPY_BOOTSTRAP):
	chmod 755 $(TARGET_PATH)/classes/bootstrap
	cp $(TARGET_PATH)/classes/bootstrap $(ARTIFACTS_DIR)