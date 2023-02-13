package rnd.serverless;

import rnd.serverless.api.Calculate;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class Handler {

    private final static String IMPL = Optional.ofNullable(System.getenv("IMPL")).orElse("NULL");

    public static void main(String[] args) {
        System.out.println(new Handler().handleRequest());
    }

    public String handleRequest() {
        ServiceLoader<Calculate> services = ServiceLoader.load(Calculate.class);
        return services.stream()
                .filter(calculateProvider -> IMPL.equals(calculateProvider.type().getName()))
                .map(service -> service.get().calculate())
                .collect(Collectors.joining("\n----------\n"));
    }
}