package io.confluent.cse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class GsonTest {
    public static void main(String[] args) {

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/sourcedata/uk_districts.json"));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);
/*
            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                //
                /*
                System.out.println(entry.getKey() + "=" + entry.getKey());
                System.out.println(entry.getKey());
                if (entry.getKey().equals("districts")){
                    System.out.println("got a district");
                    for (Map.Entry<?, ?> entry2 : entry.get("districts")){
                        System.out.println(entry2.getKey() + "=" + entry2.getKey());
                    }
                }

            }
*/
            List ltm = (List) map.get("districts");
            for (Object ltm2 : ltm) {
                JsonObject jsonObject = gson.toJsonTree(ltm2).getAsJsonObject();
                System.out.println(jsonObject);
            }

            // close reader
            reader.close();


            Gson gson2 = new Gson();
            // create a reader
            Reader reader2 = Files.newBufferedReader(Paths.get("src/main/resources/sourcedata/uk_locations.json"));
            // convert JSON file to map
            Map<?, ?> map2 = gson.fromJson(reader2, Map.class);
            System.out.println("here2");

            for (Map.Entry<?, ?> entry : map2.entrySet()) {
                System.out.println(entry.getKey());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
