import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.swing.*;

public class JSON {

    public void readFile(JComboBox repoSelector) throws Exception{
        // parsing the json file
        Object obj = new JSONParser().parse(new FileReader("D:\\IntelliJ Projects\\VulinOSS\\data\\python_output\\" + repoSelector.getSelectedItem() + "_vuln.json"));
        // casting obj to JSONObject
        JSONObject jsonObj = (JSONObject) obj;
        // only interested in the results part of the json file
        JSONArray results = (JSONArray) jsonObj.get("results");
        //loop through the results
        if (results.size() > 0) {
            for (Object result : results) {
                System.out.println(result);
                writeFile(result, repoSelector);
            }
        } else System.out.println("No Vulnerabilities Found in " + repoSelector.getSelectedItem());
    }

    public void writeFile(Object data, JComboBox repoSelector) throws IOException {
        // creating JSONObject
        JSONObject jsonObj = new JSONObject();
        // creating a JSONArray
        JSONArray jsonArray = new JSONArray();
        ArrayList list = new ArrayList();
        list.add(data);
        jsonArray.add(list);
        // adding data to JSONObject
        jsonObj.put(repoSelector.getSelectedItem(), jsonArray);
        // writing JSON to the file repos_analysis.json
        FileWriter fileWriter = new FileWriter("D:\\IntelliJ Projects\\VulinOSS\\data\\repos_analysis.json", true); //true to allow append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(jsonObj.toJSONString()); //Add a new line
        printWriter.close();
    }
}