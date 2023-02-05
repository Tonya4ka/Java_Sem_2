// Дана json строка (читать из файла и сохранить в файл) 
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова",
// "оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет]

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
 
public class S2_2 {
    private static final String filePath = "S2_2.json";
    public static void main(String[] args) {
 
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray array = (JSONArray) jsonObject.get("students");

            FileWriter writer = new FileWriter("S2_2.txt");

            for(int i=0; i<array.size(); i++){
                String newstr1 = array.get(i).toString();
                String newstr2 = newstr1.replaceAll("[^а-яА-Я1-5,:]", "");
                String newstr3 = newstr2.replaceAll("[:,]", " ");
                String[] words = newstr3.split(" ");
                StringBuilder str_print = new StringBuilder("Студент " + words[5] + " получил " + words[1] + " по предмету " + words[3] + "\n");
                System.out.print(str_print);
                writer.append(str_print);
            }
            writer.close();
 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } 
    }
}