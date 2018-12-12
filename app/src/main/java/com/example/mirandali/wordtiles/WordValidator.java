package com.example.mirandali.wordtiles;
import android.os.AsyncTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

// we used this dictionary api: https://developer.oxforddictionaries.com/documentation#!/Dictionary32entries/get_entries_source_lang_word_id
public class WordValidator {
    public String baseUrl = "https://od-api.oxforddictionaries.com:443/api/v1/search/en?q=";


    public boolean validateWord(String word) {
        if (word == null || word.length() <= 1) {
            return false;
        }

        OkHttpHandler handler = new OkHttpHandler();
        try {
            Object result = handler.execute(baseUrl + word + "&prefix=false&limit=1").get();

            JsonParser jsonParser = new JsonParser();
            JsonElement jsonTree = jsonParser.parse((String) result);
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            JsonElement results = jsonObject.get("results");
            JsonArray jsonArray = results.getAsJsonArray();
            if (jsonArray.size() > 0) {
                JsonElement jsonElement = jsonArray.get(0);
                JsonObject firstResult = jsonElement.getAsJsonObject();
                final JsonElement score = firstResult.get("score");
                if (score != null) {
                    System.out.println(score.getAsDouble());
                    return score.getAsDouble() > 8.0;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private class OkHttpHandler extends AsyncTask {
        OkHttpClient client = new OkHttpClient();
        private String result;

        @Override
        protected Object doInBackground(Object[] params) {
            Request.Builder builder = new Request.Builder();
            builder.url((String)params[0]);
            builder.addHeader("app_id", "75344231");
            builder.addHeader("app_key", "9136f7b85dbc06e1211d084f28e6d16c");
            System.out.println((String)params[0]);

            Request request = builder.build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
