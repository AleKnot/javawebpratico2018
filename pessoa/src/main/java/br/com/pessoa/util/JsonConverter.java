package br.com.pessoa.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import br.com.pessoa.domain.Pessoa;

public class JsonConverter {

private final Gson gson;
    
    public JsonConverter() {
        
        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<Pessoa> pessoas) {
        
        JsonArray jarray = gson.toJsonTree(pessoas).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("pessoas", jarray);

        return jsonObject.toString();
    }
    
}