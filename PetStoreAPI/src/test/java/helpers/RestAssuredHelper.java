package helpers;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class RestAssuredHelper {
    public RestAssuredHelper(){
        String url = System.getProperty("server.url");
        if(url==null) {
            url="http://localhost:8080/api/v3";
        }
        RestAssured.baseURI = url;
    }

    public RequestSpecification requestSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("api_key", "special-key");
        builder.addHeader("Content-Type", "application/json");
        return builder.build();
    }

    public ResponseSpecification responseSpec() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType("application/json");
        return builder.build();
    }
}
