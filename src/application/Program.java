package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class Program {

    public static void main(String[] args) {
        String path = "/home/eduardo/Documents/x.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> map = new LinkedHashMap<>();
            String line = br.readLine();
            String name;
            int votes;

            while (line != null) {

                String[] fields = line.split(",");
                name = fields[0];
                votes = Integer.parseInt((fields[1]));

                if( map.containsKey(name)){
                    int count = map.get(name);
                    map.put(name, votes + count);

                }else {
                    map.put(name, votes);
                }
                line = br.readLine();
            }

            for( String key: map.keySet()){
                System.out.println(key + ", " + map.get(key));
            }

        }
        catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }
    }
}
