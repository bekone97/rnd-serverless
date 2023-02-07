package rnd.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import rnd.serverless.api.Calculate;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class Handler implements RequestHandler<Object, String> {

    // for test purposes
    public static void main(String[] args) {
        System.out.println(new Handler().handleRequest("", null));
    }

    @Override
    public String handleRequest(Object input, Context context) {
        ServiceLoader<Calculate> services = ServiceLoader.load(Calculate.class);
        return services.stream()
                .map(service -> service.get().calculate())
                .collect(Collectors.joining("\n----------\n"));
    }
}