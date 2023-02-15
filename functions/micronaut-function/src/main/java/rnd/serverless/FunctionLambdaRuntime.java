package rnd.serverless;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;
public class FunctionLambdaRuntime extends AbstractMicronautLambdaRuntime<Object, String, Object, String>
{
    public static void main(String[] args) {
        try {
            new FunctionLambdaRuntime().run(args);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<Object, String> createRequestHandler(String... args) {
        return new FunctionRequestHandler();
    }
}
