import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private JButton analyseRepoButton;
    private JPanel rootPanel;
    private JComboBox languageSelector;

    public MainGUI()
    {
        //This uses the designer form
        add(rootPanel);

        setTitle("Repo Analyser");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        analyseRepoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try{
                    if (languageSelector.getSelectedItem().equals("Python")){
                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ..\\VulinOSS\\vulinoss && pylint binutils\"");
                    }
                } catch (Exception ex)
                {
                    System.out.println(ex);
                    ex.printStackTrace();
                }

            }
        });
    }
}
