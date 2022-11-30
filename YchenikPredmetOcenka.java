import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

public class YchenikPredmetOcenka {
    public static void main(String[] args) throws IOException, ParseException {
        FileReader read = new FileReader("YchenikPredmetOcenka.json");
        JSONParser jsonP = new JSONParser();
        JSONArray stud = (JSONArray) jsonP.parse(read);

        for (Object obj: stud) {
            JSONObject per = (JSONObject) obj;

            StringBuilder res = new StringBuilder();

            res.append("Студент ").append(per.get("фамилия")).append(" получил ").append((String) per.get("оценка"))
                .append(" по предмету ").append((String) per.get("предмет")).append(".");
            System.out.println(res.toString());
        }
    }
}