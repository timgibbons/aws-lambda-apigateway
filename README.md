# AWS Lambda + API Gateway

##  Toolbox library for AWS Lambda functions + AWS API Gateway

<p align="center">
    <a href="https://github.com/timgibbons/aws-lambda-apigateway/tags">
      <img alt="Tag" src="https://img.shields.io/github/v/tag/timgibbons/aws-lambda-apigateway" />
    </a>
    <a href="https://github.com/timgibbons/aws-lambda-apigateway">
      <img alt="Commit Activity" src="https://img.shields.io/github/commit-activity/m/timgibbons/aws-lambda-apigateway" />
    </a>
    <a href="https://github.com/timgibbons/aws-lambda-apigateway/issues">
      <img alt="Issues" src="https://img.shields.io/github/issues-pr/timgibbons/aws-lambda-apigateway?color=0088ff" />
    </a>
    <br/>
    <a href="https://github.com/timgibbons">
      <img alt="User Stars" src="https://img.shields.io/github/stars/timgibbons?style=social" />
    </a>
    <a href="https://github.com/timgibbons/aws-lambda-apigateway">
      <img alt="Repo Stars" src="https://img.shields.io/github/stars/timgibbons/aws-lambda-apigateway?label=Repo Stars" />
    </a>
    <a href="https://github.com/timgibbons/aws-lambda-apigateway">
      <img alt="Repo Forks" src="https://img.shields.io/github/forks/timgibbons/aws-lambda-apigateway?label=Repo Forks" />
    </a>

  </p>

This short library is designed as a toolkit to simply/quickly create or extend from the functionality of AWS Lambda Functions called through the AWS API Gateway. This was created as a learning project and will hopefully be used as a template when creating an AWS lambda function. 
The function accessed through the API Gateway will take in a json body containing the tag "name". The output of the function will be "Hello {name}". 

* Implemented RequestHandler
* Main method LambdaHandlerAPIGateway.handleRequest
  * Receive APIGatewayProxyRequestEvent event
  * Extract simple json structure from body
  * Print the tag "name" provided in the body prefixed with "Hello "
  * Final result "Hello {name}"
* Function can then be called through any RESTFul application i.e. Postman

## Basic setup
![Basic flow](images/AWS_Functions_HelloWorld.png?raw=true "Basic flow")
### Runtime settings
![Basic flow](images/AWS_function_runtimeSettings.png?raw=true "Basic flow")


## Installation Instructions
* Setup or login to your AWS account
  * Import attached deployment package (HelloWorld-AWS_Deployment_package.zip)
  * OR manually set up the Lambda functions and API Gateway on AWS.
    * Create Function
    * Create Author from scratch
      * Enter Function name
      * Runtime: select Java 11 (Corretto)
      * Architecture
        * x86_64
        * This has not been tested on arm64
      * Create function
    * Inside your new function
      * Upload Code source
        * Upload your jar file created through maven install
      * Edit the Runtime settings from default
        * Set the handler to point to your class and handler method: net.niaax.currency.LambdaHandlerApiGateway::handleRequest
      * Test can be performed using the test tab
        * Input json body: {"name": "yourname"}
        * Run Test
        * This will fail execution as the input is designed to receive the API proxy event
      * Add trigger API Gateway
        * Create new API
        * API Type: HTTP API
        * Security: Open (for demo purposes)
      * You can now test this through Postman or similar by calling the link provided in the API Gateway with the json body {"name": "yourname"}
        ![Basic flow](images/AWS_function_trigger.png?raw=true "Basic flow")

## Technical setup
Set up the application settings in a yml file in the resources folder
* spring:
  * application:
    * name: aws-lambda-apigateway
* server:
  * port: 8080

## Find a bug?
If you found an issue or would like to submit an improvement to this project, please submit an issue using the tab above. If you would like to submit a PR with a fix:
* Reference the issue you created!
* Squash all your commits!




## Known Issues
* No current know issues

<br/>
<br/>

<a href="https://twitter.com/TimGibbons0">
  <img alt="Twitter" src="https://img.shields.io/twitter/url?style=social&url=https%3A%2F%2Ftwitter.com%2FTimGibbons0" />
</a>
<a href="https://www.buymeacoffee.com/timgibbons" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>