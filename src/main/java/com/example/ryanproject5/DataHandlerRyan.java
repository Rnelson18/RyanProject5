package com.example.ryanproject5;

import java.util.ArrayList;{

private HttpClient grabData;
private String locationWeb;
        String[]category;

public DateHandlerRyan(String siteToSearch) {
        grabData = HttpClient.newHttpClient();
        locationWeb = siteToSearch;
        category = new String[]{"animal", "career", "celebrity", "dev", "explicit", "fashion", "food", "history",
        "money", "movie", "music", "political", "religion", "science", "sport", "travel"};
        }

public ChuckNorrisJoke getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var curURI = URI.create(locationWeb);
        var dataRequest = requestBuilder.uri(curURI).build();
        HttpResponse<String> response = null;
        try {
        response = grabData.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
        System.out.println("Error with connecting to Server");
        }
        catch(InterruptedException exception){
        System.out.println("Lost connection to server");
        }
        if(response == null){
        System.out.println("Unable to get data from network ... giving up");
        System.exit(-1);
        }
        var responseBody = response.body();
        var jsonParser = new Gson();
        var JokeData = jsonParser.fromJson(responseBody, ChuckNorrisJoke.class);
        return JokeData;
        }

class ChuckNorrisJoke{
    ArrayList<String> category;
    String created_at;
    String icon_url;
    String id;
    String updated_at;
    String url;
    String value;
}
}
