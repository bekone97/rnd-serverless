package rnd.serverless.quarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import rnd.serverless.Handler;

public class QuarkusHandler implements RequestHandler<Object, String> {

    private final static Handler HANDLER = new Handler();

    @Override
    public String handleRequest(Object o, Context context) {
        return HANDLER.handleRequest();
    }
}
