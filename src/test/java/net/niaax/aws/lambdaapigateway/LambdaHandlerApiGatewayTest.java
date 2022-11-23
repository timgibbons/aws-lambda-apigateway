package net.niaax.aws.lambdaapigateway;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LambdaHandlerApiGatewayTest {

    @Test
    public void testHandleRequest() {
        // Given
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setHttpMethod("GET");
        requestEvent.setIsBase64Encoded(false);
        Map<String, String> headers = new HashMap<>();
        headers.put("Test", "TestingHeader");
        requestEvent.setHeaders(headers);
        String name = "Scarlett Johnson";
        requestEvent.setBody("{\"name\": \"" + name + "\"}");


        // When
        LambdaHandlerApiGateway handler = new LambdaHandlerApiGateway();
        Context context = new TestContext();
        APIGatewayProxyResponseEvent responseEvent = handler.handleRequest(requestEvent, context);


        // Then
        assertThat(responseEvent.getBody()).isEqualTo("Hello " + name);
    }

    @Test
    public void testHandleRequest_bodyNotProvided() {
        // Given
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setHttpMethod("GET");
        requestEvent.setIsBase64Encoded(false);
        Map<String, String> headers = new HashMap<>();
        headers.put("Test", "TestingHeader");
        requestEvent.setHeaders(headers);


        // When / Then
        LambdaHandlerApiGateway handler = new LambdaHandlerApiGateway();
        Context context = new TestContext();

        assertThatThrownBy(() -> handler.handleRequest(requestEvent, context))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Request body not provided");

    }

    @Test
    public void testHandleRequest_headersNotProvided() {
        // Given
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setHttpMethod("GET");
        requestEvent.setIsBase64Encoded(false);
        String name = "Scarlett Johnson";
        requestEvent.setBody("{\"name\": \"" + name + "\"}");


        // When
        LambdaHandlerApiGateway handler = new LambdaHandlerApiGateway();
        Context context = new TestContext();

        // Then
        assertThatThrownBy(() -> handler.handleRequest(requestEvent, context))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Request headers not provided");

    }

    @Test
    public void testHandleRequest_nameNotProvided() {
        // Given
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setHttpMethod("GET");
        requestEvent.setIsBase64Encoded(false);
        Map<String, String> headers = new HashMap<>();
        headers.put("Test", "TestingHeader");
        requestEvent.setHeaders(headers);
        requestEvent.setBody("");


        // When
        LambdaHandlerApiGateway handler = new LambdaHandlerApiGateway();
        Context context = new TestContext();

        // Then
        assertThatThrownBy(() -> handler.handleRequest(requestEvent, context))
                .isInstanceOf(NullPointerException.class);

    }

    @Test
    public void testHandleRequest_jsonSyntaxError() {
        // Given
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setHttpMethod("GET");
        requestEvent.setIsBase64Encoded(false);
        Map<String, String> headers = new HashMap<>();
        headers.put("Test", "TestingHeader");
        requestEvent.setHeaders(headers);
        String name = "Scarlett Johnson";
        requestEvent.setBody("{\"name\": \"" + name + "\"}}}}}}}"); // Note here the brackets invalidate teh JSON


        // When
        LambdaHandlerApiGateway handler = new LambdaHandlerApiGateway();
        Context context = new TestContext();

        // Then
        assertThatThrownBy(() -> handler.handleRequest(requestEvent, context))
                .isInstanceOf(JsonSyntaxException.class);

    }

    @Test
    public void testHandleRequest_nullEvent() {
        // Given / When
        LambdaHandlerApiGateway handler = new LambdaHandlerApiGateway();
        Context context = new TestContext();

        // Then
        assertThatThrownBy(() -> handler.handleRequest(null, context))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessageContaining("APIGatewayProxyRequestEvent required to process the event");

    }
}