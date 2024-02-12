package dk.cphbusiness.demo03_httprequest.Parsers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpRequestTest {

    static String HttpRequestString;
    static HttpRequest httpRequest;
    @BeforeAll
    void initialize ()
    {
        HttpRequestString = "GET /pages/index.html HTTP/1.1\n" +
                "Host: www.example.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1";

        httpRequest = new HttpRequest(HttpRequestString);

    }

    @Test
    void getHttpMethod()
    {
        assertEquals("GET", httpRequest.getHttpRequest());
    }

    @Test
    void getUrl()
    {
        assertEquals("/pages/index.html", httpRequest.getUrl());
    }

    @Test
    void getHttpVersion()
    {
        assertEquals("HTTP/1.1", httpRequest.getHttpVersion());
    }
}