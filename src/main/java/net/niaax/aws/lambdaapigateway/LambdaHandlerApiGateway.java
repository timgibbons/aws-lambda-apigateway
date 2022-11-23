package net.niaax.aws.lambdaapigateway;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.niaax.aws.lambdaapigateway.custom.SimpleNameJSON;

import java.util.Map;

public class LambdaHandlerApiGateway implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Integer SUCCESS_STATUS_CODE = 200;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("START: handleRequest");

        if(event == null)
            throw new UnsupportedOperationException("APIGatewayProxyRequestEvent required to process the event");

        logger.log("ToString: " + event);

        String body = event.getBody();
        if (body == null)
            throw new IllegalArgumentException("Request body not provided");

        Map<String, String> headers = event.getHeaders();
        if (headers == null)
            throw new IllegalArgumentException("Request headers not provided");


        SimpleNameJSON nameType = gson.fromJson(event.getBody(), SimpleNameJSON.class);

        logger.log("Actor name: " + nameType.getName());

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(SUCCESS_STATUS_CODE)
                .withBody("Hello " + nameType.getName());
    }
}