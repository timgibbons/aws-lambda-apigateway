package net.niaax.aws.lambdaapigateway;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class TestContext implements Context{

  public TestContext() {}
  public String getAwsRequestId(){
    return new String("495b12a8-demo-4eca-exmp-160484123499");
  }
  public String getLogGroupName(){
    return new String("/aws/lambda/HelloWorld");
  }
  public String getLogStreamName(){
    return new String("2022/11/22/[$LATEST]704f8demoapplication4246b8438f1a");
  }
  public String getFunctionName(){
    return new String("HelloWorld");
  }
  public String getFunctionVersion(){
    return new String("$LATEST");
  }
  public String getInvokedFunctionArn(){
    return new String("arn:aws:lambda:us-east-1:428125477634:function:HelloWorld");
  }
  public CognitoIdentity getIdentity(){
    return null;
  }
  public ClientContext getClientContext(){
    return null;
  }
  public int getRemainingTimeInMillis(){
    return 300000;
  }
  public int getMemoryLimitInMB(){
    return 512;
  }
  public LambdaLogger getLogger(){
    return new TestLogger();
  }

}