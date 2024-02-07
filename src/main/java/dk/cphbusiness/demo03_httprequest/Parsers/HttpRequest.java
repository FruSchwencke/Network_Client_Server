package dk.cphbusiness.demo03_httprequest.Parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HttpRequest {

   // String firstLine = "GET /pages/index.html HTTP/1.1";
    HashMap<String, String> headers = new HashMap<>();
    StringTokenizer firstLineHeader;

    public HttpRequest() {
    }

    public void parse(String payload)
    {
        String[] a = payload.split(System.lineSeparator());
        firstLineHeader = new StringTokenizer(a[0] , " ");

    }

}
