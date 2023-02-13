package rnd.serverless;

import rnd.serverless.api.Calculate;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class Handler {
    private final static String IMPL = "IMPL";
    private final static String NULL = "NULL";

    public static void main(String[] args) {
        System.out.println(new Handler().handleRequest());
    }

    public String handleRequest() {
        String impl = System.getenv().getOrDefault(IMPL, NULL);
        ServiceLoader<Calculate> services = ServiceLoader.load(Calculate.class);
        return services.stream()
                .filter(calculateProvider -> impl.equals(calculateProvider.type().getName()))
                .map(service -> service.get().calculate())
                .collect(Collectors.joining("\n----------\n"));
    }
}