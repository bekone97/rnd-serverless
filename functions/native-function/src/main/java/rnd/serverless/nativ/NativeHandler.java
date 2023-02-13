package rnd.serverless.nativ;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import rnd.serverless.Handler;

public class NativeHandler implements RequestHandler<Object, String> {

    private final static Handler HANDLER = new Handler();
    public static void main(String[] args) {
        new NativeHandler().handleRequest(null, null);
    }

    @Override
    public String handleRequest(Object o, Context context) {
        return HANDLER.handleRequest();
    }
}
