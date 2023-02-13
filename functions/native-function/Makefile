TARGET_PATH := /src/functions/native-function/target
COPY_BOOTSTRAP := copy_bootstrap

build-%: $(COPY_BOOTSTRAP)
	cp $(TARGET_PATH)/native $(ARTIFACTS_DIR)

$(COPY_BOOTSTRAP):
	chmod 755 $(TARGET_PATH)/classes/bootstrap
	cp $(TARGET_PATH)/classes/bootstrap $(ARTIFACTS_DIR)