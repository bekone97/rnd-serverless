package godel.gatling.test;

import com.amazonaws.DefaultRequest;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.TestFunctionRequest;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.GetFunctionUrlConfigRequest;
import com.amazonaws.services.lambda.model.GetFunctionUrlConfigResult;
import io.gatling.http.client.Request;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionHelper {
    private static final String SERVICE = "lambda";
    private static final String REGION = "eu-central-1";
    private static final String SEPARATOR = ";";

    public static String getFunctionURL(String functionName) {
        AWSLambda lambda = AWSLambdaClientBuilder.defaultClient();
        GetFunctionUrlConfigRequest getFunctionUrlConfigRequest = new GetFunctionUrlConfigRequest();
        getFunctionUrlConfigRequest.setFunctionName(functionName);
        GetFunctionUrlConfigResult functionUrlConfig = lambda.getFunctionUrlConfig(getFunctionUrlConfigRequest);
        String functionUrl = functionUrlConfig.getFunctionUrl();
        System.out.println(functionUrl);
        return functionUrl;
    }

    public static void sign(Request request) {
        try {
            AWS4Signer aws4Signer = new AWS4Signer();
            aws4Signer.setRegionName(REGION);
            aws4Signer.setServiceName(SERVICE);
            DefaultRequest<String> defaultRequest = new DefaultRequest<>(new TestFunctionRequest(), SERVICE);
            defaultRequest.setEndpoint(request.getUri().toJavaNetURI());
            defaultRequest.setHttpMethod(HttpMethodName.fromValue(request.getMethod().name()));
            defaultRequest.setResourcePath(request.getVirtualHost());
            defaultRequest.setContent(new ByteArrayInputStream(
                    request.getBody() == null
                            ? "".getBytes()
                            : request.getBody().getBytes()));
            DefaultAWSCredentialsProviderChain credentialsProvider = new DefaultAWSCredentialsProviderChain();
            aws4Signer.sign(defaultRequest, credentialsProvider.getCredentials());
            defaultRequest.getHeaders().forEach((key, val) -> request.getHeaders().add(key, val));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseArguments(String arg) {
        return Arrays.stream(arg.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
