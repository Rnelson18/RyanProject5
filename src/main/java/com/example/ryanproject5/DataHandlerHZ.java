package com.example.harrisonproject5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

public class DataHandlerHZ {
    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandlerHZ(String siteToSearch){
        dataGrabber = HttpClient.newHttpClient();
        webLocation = siteToSearch;
    }

    public IceandFire[] getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var ourURI = URI.create(webLocation);
        var dataRequest = requestBuilder.uri(ourURI).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
            System.out.println("Error with connecting to Server");
        }
        catch (InterruptedException exception){
            System.out.println("Lost connection to server");
        }
        if(response == null){
            System.out.println("Unable to get data from network ... giving up");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonParser = new Gson();
        var IceandFireData = jsonParser.fromJson(responseBody, IceandFire[].class);
        return IceandFireData;
    }

    class IceandFire{
        String alpha_two_code;
        ArrayList<String> web_pages;
        String Book;
        String Character;
        ArrayList<String> domains;

        @Override
        public String toString(){
            String Books;
            return null;
        }
    }
}

