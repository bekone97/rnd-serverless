module app {
    requires api;
    requires aws.lambda.java.core;
    uses rnd.serverless.api.Calculate;
}
