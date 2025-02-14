package rnd.serverless.impl;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import rnd.serverless.api.Calculate;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HttpTriggerFunction {
    public static void main(String[] args) {
        System.out.println(new HttpTriggerFunction().handleRequest());
    }
    @FunctionName("HttpExample")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        String s = handleRequest();
        return request.createResponseBuilder(HttpStatus.OK).body(s).build();

    }

    public String handleRequest() {
        ServiceLoader<Calculate> services = ServiceLoader.load(Calculate.class);
        return services.stream()
                .map(service->service.get().calculate())
                .collect(Collectors.joining("\n-----------------------\n"));
    }
}
