import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.swing.*;

public class JSONRead {

    public void readFile(JComboBox repoSelector) throws Exception{
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("D:\\IntelliJ Projects\\VulinOSS\\data\\python_output\\" + repoSelector.getSelectedItem() + "_vuln.json"));
        // typecasting obj to JSONObject
        JSONObject jsonObj = (JSONObject) obj;
        // only interested in the results part of the json file
        JSONArray results = (JSONArray) jsonObj.get("results");
        //loop through the results
        if (results.size() > 0) {
            for (Object result : results) {
                System.out.println(result);
            }
        } else System.out.println("No Vulnerabilities Found in " + repoSelector.getSelectedItem());
    }
}