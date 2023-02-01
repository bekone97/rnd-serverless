import rnd.serverless.impl.factorial.Factorial;

module factorial {
    requires api;
    provides rnd.serverless.api.Calculate with Factorial;
}
