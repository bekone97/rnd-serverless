package rnd.serverless;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionRequestHandlerTest {

    private static FunctionRequestHandler functionRequestHandler;
    private static Handler handler;

    @BeforeAll
    public static void setupServer() {
        functionRequestHandler = new FunctionRequestHandler();
        handler = new Handler();
    }

    @AfterAll
    public static void stopServer() {
        if (functionRequestHandler != null) {
            functionRequestHandler.getApplicationContext().close();
        }
    }

    @Test
    public void testHandler() {
        String response = functionRequestHandler.execute(null);
        assertEquals(handler.handleRequest(), response);
    }
}
