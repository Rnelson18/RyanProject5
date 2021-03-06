package com.example.ryanproject5;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

public class DataHandlerN {
    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandlerN(String wholeSite) {
    }


    public void DataHandler(String siteToSearch){
        dataGrabber = HttpClient.newHttpClient();
        webLocation = siteToSearch;
    }
    public StarWarsAPI getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var ourURI = URI.create(webLocation);
        var dataRequest = requestBuilder.uri(ourURI).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e) {
            System.out.println("Error with connecting to server");
        }
        catch (InterruptedException exception) {
            System.out.println("Lost connection to server");
        }
        if(response == null) {
            System.out.println("Unable to get data from network");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonParser = new Gson();
        var StarData = jsonParser.fromJson(responseBody, StarWarsAPI.class);
        return StarData;
        }

    class StarWarsAPI{
    String name;
    String height;
    String year;
    String planet;
    String movie;
    @Override
        public String toString(){
        return name;
    }

}
}

