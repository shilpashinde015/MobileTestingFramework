package Mock;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class getCustomerdata {

    public static void main(String [] args) {
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("http://localhost:3000/customer");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();

        System.out.println("body" + bodyStringValue);

        JsonPath jsonPathEvaluator = response.jsonPath();
      ArrayList<String> arr = jsonPathEvaluator.get("username");
        for(int i = 0;i<arr.size();i++) {
            System.out.println("username : " + arr.get(i));
        }


        JsonPath jsonPathEvaluatorpass = response.jsonPath();
        ArrayList<String> ar = jsonPathEvaluator.get("password");
        for(int i = 0;i<ar.size();i++) {
            System.out.println("password : " + ar.get(i));
        }
    }
}
