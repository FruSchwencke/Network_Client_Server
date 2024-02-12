package dk.cphbusiness.demo03_httprequest.Parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HttpRequest {

   // String firstLine = "GET /pages/index.html HTTP/1.1";
//    HashMap<String, String> headers = new HashMap<>();
//    StringTokenizer firstLineHeader;



    // attribute
    private String HttpRequest;
    private String HttpMethod;
    private String url;
    private String httpVersion;


    //Constructor
    public HttpRequest(String HttpRequest) {

        this.HttpRequest = HttpRequest;
        parse();
    }


    private void parse()
    {

    }

    public String getHttpRequest() {
        return HttpRequest;
    }

    public String getHttpMethod() {
        return HttpMethod;
    }

    public String getUrl() {
        return url;
    }

    public String getHttpVersion() {
        return httpVersion;
    }




    //    public void parse(String payload)
//    {
//        String[] a = payload.split(System.lineSeparator());
//        mfirstLineHeader = new StringTokenizer(a[0] , " ");
//
//    }

}
