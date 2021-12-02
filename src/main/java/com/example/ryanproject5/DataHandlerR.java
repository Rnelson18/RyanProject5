package com.example.ryanproject5;

import java.net.http.HttpClient;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class DataHandlerR {

    private HttpClient grabData;
    private String locationWeb;

    public DataHandlerR(String siteToSearch){
            grabData = HttpClient.newHttpClient();
            locationWeb = siteToSearch;
        }
}
