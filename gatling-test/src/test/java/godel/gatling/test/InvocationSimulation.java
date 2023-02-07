package godel.gatling.test;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class InvocationSimulation extends Simulation {
    private final static String FUNCTION_NAMES_PROPERTY = "functionNames";
    private final static String SIMULATION_NAME = "invocation-simulation";
    private final static List<String> FUNCTION_NAMES;

    static {
        String functionNames = System.getProperty(FUNCTION_NAMES_PROPERTY);
        System.out.println(FUNCTION_NAMES_PROPERTY + ": " + functionNames);
        FUNCTION_NAMES = FunctionHelper.parseArguments(functionNames);
        FUNCTION_NAMES.forEach(System.out::println);
    }

    HttpProtocolBuilder httpProtocol = http;

    List<ScenarioBuilder> scenarioBuilders = FUNCTION_NAMES.stream()
            .map(functionName -> scenario(SIMULATION_NAME + ": " + functionName).exec(http(functionName)
                    .get(FunctionHelper.getFunctionURL(functionName))
                    .sign(FunctionHelper::sign)))
            .collect(Collectors.toList());

    {
        setUp(
                scenarioBuilders.stream().map(scn ->
                                scn.injectOpen(
                                        atOnceUsers(100),
                                        nothingFor(15),
                                        atOnceUsers(100)
                                ))
                        .collect(Collectors.toList())
        ).protocols(httpProtocol);
    }
}
