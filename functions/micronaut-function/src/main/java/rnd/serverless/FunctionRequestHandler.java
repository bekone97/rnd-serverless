package rnd.serverless;
import io.micronaut.function.aws.MicronautRequestHandler;

public class FunctionRequestHandler extends MicronautRequestHandler<Object, String> {

    private final static Handler HANDLER = new Handler();
    @Override
    public String execute(Object input) {
        return HANDLER.handleRequest();
    }
}
