import javax.swing.*;
import java.awt.*;

public class DataWidgetGeneratorFrame extends JFrame
{
    public static void main(String[] args)
    {
        DataWidgetGeneratorFrame frame = new DataWidgetGeneratorFrame();
    }

    // Declare the Swing JComponents for the GUI
    // These are for the Object Variables we will get by reflection
    private JLabel[] fieldLabels;
    private JCheckBox[] fieldBoxes;
    private JFileChooser chooser; // use to pick the java class file to reflect
    private JPanel fieldPnl;  // will use a grid layout to hold the fieldLabels and fieldNames
    private JPanel mainPnl;  // will use a border layout to hold the fieldPnl and the chooser
    private JPanel  buttonPnl;  // will use a flow layout to hold the buttons
    private JButton quitBtn;  // will close the program
    private JButton generateBtn;  // will generate the code for the DataWidget
    private JButton cancelBtn; // will null all the field display and relaunch the file chooser
    private JButton pickFileBtn;
    // pickFileBtn will use the fileChoser to pick the file to reflect
    // and then reflect the fields of the class file
    // and then create the fieldLabels and fieldBoxes for each field
    // and then add the fieldLabels and fieldBoxes to the fieldPnl using gridlayout
    // so there is a label for each field and a checkbox for each field in each row
    // and then add the fieldPnl to the mainPnl using borderlayout.center



    public DataWidgetGeneratorFrame()
    {
        super("Data Widget Generator");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        fieldPnl = new JPanel();
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new FlowLayout());
        quitBtn = new JButton("Quit");
        pickFileBtn = new JButton("Pick File");
        buttonPnl.add(pickFileBtn);
        buttonPnl.add(quitBtn);
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);
        mainPnl.add(fieldPnl, BorderLayout.CENTER);
        add(mainPnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
