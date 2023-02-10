TARGET_PATH := /src/functions/native-function/target
FIBONACCI := $(TARGET_PATH)/fibonacci/native
RSA := $(TARGET_PATH)/rsa/native
FACTORIAL := $(TARGET_PATH)/factorial/native
COPY_BOOTSTRAP := copy_bootstrap

build-FibonacciFunctionNative%: $(COPY_BOOTSTRAP)
	cp $(FIBONACCI) $(ARTIFACTS_DIR)
	cp $(TARGET_PATH)/fibonacci/native-function-1.0.jar $(ARTIFACTS_DIR)

build-FactorialFunctionNative%: $(COPY_BOOTSTRAP)
	cp $(FACTORIAL) $(ARTIFACTS_DIR)

build-RSAFunctionNative%: $(COPY_BOOTSTRAP)
	cp $(RSA) $(ARTIFACTS_DIR)

$(COPY_BOOTSTRAP):
	chmod 755 $(TARGET_PATH)/classes/bootstrap
	cp $(TARGET_PATH)/classes/bootstrap $(ARTIFACTS_DIR)