SRC_PATH := /src/functions/quarkus-function
TARGET_PATH := $(SRC_PATH)/target

build-FibonacciFunctionQuarkusNative%:
	@unzip $(TARGET_PATH)/function.zip -d $(ARTIFACTS_DIR)

build-RSAFunctionQuarkusNative%:
	@unzip $(TARGET_PATH)/function.zip -d $(ARTIFACTS_DIR)

build-FactorialFunctionQuarkusNative%:
	@unzip $(TARGET_PATH)/function.zip -d $(ARTIFACTS_DIR)

build-%:
	mvn clean package
	@unzip ./target/function.zip -d $(ARTIFACTS_DIR)