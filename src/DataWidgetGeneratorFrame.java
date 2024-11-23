import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import java.lang.reflect.Field;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataWidgetGeneratorFrame extends JFrame
{
    public static void main(String[] args)
    {
        DataWidgetGeneratorFrame frame = new DataWidgetGeneratorFrame();
    }


    private File sourceFile;  // the file to reflect
    private FileReader reader;  // the reader for the file to reflect
    private FileWriter writer;  // the writer for the file to write the generated code
    private Class sourceClass;  // the class to reflect
    private Field[] fields;  // the fields of the class to reflect
    private String[] fieldNames;  // the names of the fields of the class to reflect
    private String[] fieldTypes;  // the types of the fields of the class to reflect
    private String[] fieldModifiers;  // the modifiers of the fields of the class to reflect
    private String newClassName;  // the name of the new class to generate pattern classname + "DataWidget.java"
    private boolean hasSourceFile;  // true if the sourceFile is not null
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
        quitBtn.addActionListener(e -> {
            String response = JOptionPane.showInputDialog(this, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
             if(response.equals("yes"))
                 System.exit(0);
        });
        pickFileBtn = new JButton("Pick File");
        cancelBtn = new JButton("Cancel");
        generateBtn = new JButton("Generate");


        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser = new JFileChooser(workingDirectory);

        pickFileBtn.addActionListener(e -> {
            int result = chooser.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION)
            {
                sourceFile = chooser.getSelectedFile();
                Path file = sourceFile.toPath();

                hasSourceFile = true;
                try
                {


                    try
                    {
                        String className = sourceFile.getName().substring(0, sourceFile.getName().indexOf("."));
                        System.out.println("Class: " + className);
                        sourceClass = Class.forName(sourceFile.getName().substring(0, sourceFile.getName().indexOf(".")));
                    }
                    catch (ClassNotFoundException ex)
                    {
                        ex.printStackTrace();
                    }

                    fields = sourceClass.getDeclaredFields();
                    fieldNames = new String[fields.length];
                    fieldTypes = new String[fields.length];
                    fieldModifiers = new String[fields.length];
                    fieldLabels = new JLabel[fields.length];
                    fieldBoxes = new JCheckBox[fields.length];
                    fieldPnl.setLayout(new GridLayout(fields.length + 1, 2));
                    for(int i = 0; i < fields.length; i++)
                    {
                        fieldNames[i] = fields[i].getName();
                        fieldTypes[i] = fields[i].getType().getName();
                        fieldModifiers[i] = fields[i].getModifiers() + "";
                        fieldLabels[i] = new JLabel(fieldNames[i]);
                        fieldBoxes[i] = new JCheckBox();
                        fieldPnl.add(fieldLabels[i]);
                        fieldPnl.add(fieldBoxes[i]);
                    }
                    fieldPnl.add(cancelBtn);
                    fieldPnl.add(generateBtn);
                    mainPnl.add(fieldPnl, BorderLayout.CENTER);
                    pack();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
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
