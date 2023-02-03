### How to start:
1. build image:
    ```
    docker image build rnd-serverless .
    ```
2. run container:
    ```
    docker run rnd-serverless --name rnd-serverless
    ```

### How to control functions:
To control which functions will be executed, add the appropriate path to `--module-path` in `Dockerfile`.
It can be changed later in AWS Lambda, so we can control functions to be executed without recreating lambda.
