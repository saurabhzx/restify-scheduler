package com.rest.scheduler.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

public class HttpClientUtility {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> executeGetRequest(Map<String , String> headerMap, MediaType mediaType, String uri){
//        final String uri = "http://test.f5refreshment.com:9009/health";

//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpHeaders headers = generateHeader(headerMap, mediaType);
        HttpEntity<String> entity = generateHttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response;
    }

    private HttpHeaders generateHeader(Map<String , String> headerMap, MediaType mediaType){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(mediaType));

        if(headerMap != null && headerMap.size() != 0) {
            headerMap.entrySet().stream().forEach(e ->
                    headers.set(e.getKey(), e.getValue())
            );
        }
        return headers;
    }

    private HttpEntity<String> generateHttpEntity(HttpHeaders headers){
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }
}
