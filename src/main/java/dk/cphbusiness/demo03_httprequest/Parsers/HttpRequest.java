package dk.cphbusiness.demo03_httprequest.Parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HttpRequest {

    String firstLine = "GET /pages/index.html HTTP/1.1";
    String key;
    String value;

    StringTokenizer firstLineHeader = new StringTokenizer(firstLine , " ");


    String header = "Host: www.example.com\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3\n" +
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
            "Accept-Language: en-US,en;q=0.5\n" +
            "Accept-Encoding: gzip, deflate, br\n" +
            "Connection: keep-alive\n" +
            "Upgrade-Insecure-Requests: 1";


    HashMap<String, String> HttpKeyAndValue = new HashMap<>();




}
