import rnd.serverless.impl.fibonacci.Fibonacci;

module fibonacci {
    requires api;
    provides rnd.serverless.api.Calculate with Fibonacci;
}
