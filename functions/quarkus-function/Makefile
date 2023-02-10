SRC_PATH := /src/functions/quarkus-function
CALCULATE_SVC_PATH := src/main/resources/META-INF/services/rnd.serverless.api.Calculate
TARGET_PATH := $(SRC_PATH)/target
BUILD := build
SET_FIBONACCI_IMPL := set_fibonacci_impl
SET_RSA_IMPL := set_rsa_impl
SET_FACTORIAL_IMPL := set_factorial_impl

build-FibonacciFunctionQuarkusNative%:
	cp $(TARGET_PATH)/fibonacci-runner $(ARTIFACTS_DIR)/bootstrap

build-RSAFunctionQuarkusNative%:
	cp $(TARGET_PATH)/rsa-runner $(ARTIFACTS_DIR)/bootstrap

build-FactorialFunctionQuarkusNative%:
	cp $(TARGET_PATH)/factorial-runner $(ARTIFACTS_DIR)/bootstrap

build-FibonacciFunctionQuarkus%: $(SET_FIBONACCI_IMPL) $(BUILD)
	@echo ""

build-RSAFunctionQuarkus%: $(SET_RSA_IMPL) $(BUILD)
	@echo ""

build-FactorialFunctionQuarkus%: $(SET_FACTORIAL_IMPL) $(BUILD)
	@echo ""

$(SET_FIBONACCI_IMPL):
	echo "rnd.serverless.impl.fibonacci.Fibonacci" >| $(CALCULATE_SVC_PATH)

$(SET_FACTORIAL_IMPL):
	echo "rnd.serverless.impl.factorial.Factorial" >| $(CALCULATE_SVC_PATH)

$(SET_RSA_IMPL):
	echo "rnd.serverless.impl.rsa.RSA" >| $(CALCULATE_SVC_PATH)

$(BUILD):
	mvn clean package
	@ unzip ./target/function.zip -d $(ARTIFACTS_DIR)