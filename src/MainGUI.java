import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import org.rosuda.JRI.Rengine;
import org.rosuda.JRI.REXP;

public class MainGUI extends JFrame{
    private JButton analyseRepoButton;
    private JPanel rootPanel;
    private JComboBox languageSelector;
    private JComboBox repoSelector;
    private JButton analyseResultButton;
    String[] dirnames; //this array stores the names of directories
    File f = new File("D:\\IntelliJ Projects\\VulinOSS\\vulinoss"); //path of where the directories

    public MainGUI()
    {
        //This uses the designer form
        add(rootPanel);

        //for each directory name, add it to the repoSelector JComboBox
        for (String s : dirnames = f.list()) {
            repoSelector.addItem(s);
        }

        setTitle("Python Repo Analyser");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        analyseRepoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try{
                    if (languageSelector.getSelectedItem().equals("Python")){
//                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ..\\VulinOSS\\vulinoss && pylint " + repoSelector.getSelectedItem() + " -f json >> ..\\data\\python_output\\" + repoSelector.getSelectedItem() + "_report.json");
//                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ..\\VulinOSS\\vulinoss && bandit -r -ll -ii " + repoSelector.getSelectedItem() + " -f json -o ..\\data\\python_output\\" + repoSelector.getSelectedItem() + "_vuln.json");
                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ..\\VulinOSS\\vulinoss && bandit -r " + repoSelector.getSelectedItem() + " -f json -o ..\\data\\python_output\\" + repoSelector.getSelectedItem() + "_vuln.json");
                    }
                    else if (languageSelector.getSelectedItem().equals("C")){
                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ..\\VulinOSS\\vulinoss && cpplint --recursive " + repoSelector.getSelectedItem());
                    }
                    else if (languageSelector.getSelectedItem().equals("JavaScript")){
                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ..\\VulinOSS\\vulinoss && retire --path " + repoSelector.getSelectedItem() + " --outputformat json --outputpath ..\\data\\js_output\\" + repoSelector.getSelectedItem() + ".json");
                    }
                } catch (Exception ex)
                {
                    System.out.println(ex);
                    ex.printStackTrace();
                }

            }
        });

        analyseResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //No longer needed code - can be explained in the report
//                JSON json = new JSON();
//                try {
//                    json.readFile(repoSelector);
//                } catch (Exception exception) {
//                    //Print the stack trace if the file doesn't exist
//                    exception.printStackTrace();
//                }
//
                // when the library was found in one of the locations
                // this call should not throw an exception
                System.loadLibrary("jri");

                //System.out.println("java library path: "+System.getProperty("java.library.path"));
                Rengine re = new Rengine(new String[] { "-no-save" }, false, null);
                re.eval(String.format("g <- '%s'", "Hello R..."));
                REXP result = re.eval("g");
                System.out.println("Greeting R test...: "+result);

                try {
                    Runtime.getRuntime().exec("");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }
}
