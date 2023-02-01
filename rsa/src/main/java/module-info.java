import rnd.serverless.rsa.RSA;

module rsa {
    requires api;
    provides rnd.serverless.api.Calculate with RSA;
}
