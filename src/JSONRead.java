import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class JSONRead {

    public static void readFile() throws Exception{

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("D:\\IntelliJ Projects\\VulinOSS\\data\\python_output\\asterisk.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // printing the value of the json file
        System.out.println(jo.values());
    }
}