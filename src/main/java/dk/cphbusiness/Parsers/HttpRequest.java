package dk.cphbusiness.Parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HttpRequest {

    private Map<String, String> headerMap = new HashMap<>();


    // attributes
    private String httpRequest;
    private String httpMethod;
    private String url;
    private String httpVersion;


    //Constructor
    public HttpRequest(String HttpRequest) {

        this.httpRequest = HttpRequest;
        parse();
    }


    private void parse()
    {
        String[] lines = httpRequest.split(System.lineSeparator());
        if (lines.length > 0)
        {
            parseRequestLine(lines[0]);
            parseHeaderLines(lines);

        }
    }




    private void parseHeaderLines(String[] lines) {
        for (int i = 1; i < lines.length; i++)
        {
            String[] headerLine = lines[i].split(":");
            if (headerLine.length == 2)
            {
                headerMap.put(headerLine[0].trim(), headerLine[1].trim());
            }
        }
    }

    private void parseRequestLine(String line) {
        // parsin request line
        String [] requestLine = line.split(" ");
        if (requestLine.length == 3)
        {
            httpMethod = requestLine[0];
            url = requestLine[1];
            httpVersion = requestLine[2];
        }
    }







    public String getHttpRequest() {
        return httpRequest;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }
    
    public String getHost()
    {
        return headerMap.getOrDefault("Host", "");
    }
}
