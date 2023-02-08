build-FibonacciFunctionNative:
#	native-image --module-path /artifacts:/artifacts/fib --module app -H:Name=native
#	chmod 755 bootstrap
#	cp bootstrap $(ARTIFACTS_DIR)
#	cp native $(ARTIFACTS_DIR)
	mvn package -Pnative
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)