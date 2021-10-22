package io.confluent.cse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

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
                }*/

            }

          List ltm = (List) map.get("districts");
            for (Object ltm2 : ltm){
                JsonObject jsonObject = gson.toJsonTree(ltm2).getAsJsonObject();
                System.out.println(jsonObject);
                //ltm2.
            }
         /*   for (Map.Entry<?, ?> entry : ltm.entrySet()){
System.out.println("here")
            }*/
            // close reader
            System.out.println("here");
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
