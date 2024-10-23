package Solution;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.HashMap;

public class MusicLessonCostApp extends JFrame 
{
    // Declare components
    private final JComboBox<String> instrumentComboBox;
    private final JComboBox<String> levelComboBox;
    private final JButton submitButton;
    private final JButton reportButton;
    private final JMenuBar menuBar;
    private final JMenu fileMenu;
    private final JMenu toolsMenu;
    private final JMenuItem exitMenuItem;
    private final JMenuItem submitMenuItem;
    private final JMenuItem reportMenuItem;
    
    // HashMap to store the cost data for different instruments and levels
    private final HashMap<String, Integer> lessonCosts;

    // Constructor for the MusicLessonCostApp class
    public MusicLessonCostApp() 
    {
        // Set up the frame
        setTitle("Music Lesson Cost Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // Initialize the instrument costs for each level
        lessonCosts = new HashMap<>();
        lessonCosts.put("Guitar_Beginner", 150);
        lessonCosts.put("Guitar_Intermediate", 215);
        lessonCosts.put("Guitar_Advanced", 130);
        lessonCosts.put("Piano_Beginner", 250);
        lessonCosts.put("Piano_Intermediate", 232);
        lessonCosts.put("Piano_Advanced", 185);
        lessonCosts.put("Violin_Beginner", 280);
        lessonCosts.put("Violin_Intermediate", 280);
        lessonCosts.put("Violin_Advanced", 310);

        // Create and populate the instrument combo box
        instrumentComboBox = new JComboBox<>(new String[]{"Guitar", "Piano", "Violin"});
        add(new JLabel("Instruments:"));
        add(instrumentComboBox);

        // Create and populate the level combo box
        levelComboBox = new JComboBox<>(new String[]{"Beginner", "Intermediate", "Advanced"});
        add(new JLabel("Level:"));
        add(levelComboBox);

        // Create the submit button
        submitButton = new JButton("Submit");
        styleButton(submitButton);
        add(submitButton);

        // Create the report button
        reportButton = new JButton("Report");
        styleButton(reportButton);
        add(reportButton);

        // Set up the menu bar
        menuBar = new JMenuBar();
        menuBar.setBorderPainted(false); // Minimalist menu bar style
        
        // Create File menu and Exit item
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");
        styleMenuItem(exitMenuItem);
        fileMenu.add(exitMenuItem);
        
        // Create Tools menu and its items
        toolsMenu = new JMenu("Tools");
        submitMenuItem = new JMenuItem("Submit");
        styleMenuItem(submitMenuItem);
        reportMenuItem = new JMenuItem("Report");
        styleMenuItem(reportMenuItem);
        toolsMenu.add(submitMenuItem);
        toolsMenu.add(reportMenuItem);
        
        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Add action listeners to buttons and menu items
        submitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                calculateCost();
            }
        });

        reportButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                showAverageCost();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });

        submitMenuItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                calculateCost();
            }
        });

        reportMenuItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                showAverageCost();
            }
        });
    }

    // Method to calculate the lesson cost based on the selected instrument and level
    private void calculateCost() 
    {
        // Get selected instrument and level
        String instrument = (String) instrumentComboBox.getSelectedItem();
        String level = (String) levelComboBox.getSelectedItem();

        // Generate key to find the cost
        String key = instrument + "_" + level;
        Integer cost = lessonCosts.get(key);

        // Display the instrument, level, and lesson price in a JOptionPane
        if (cost != null) 
        {
            JOptionPane.showMessageDialog(this, 
                "Instrument: " + instrument + "\n"
                + "Level: " + level + "\n"
                + "Lesson Price: R " + cost, 
                "Lesson Details", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, 
                "Lesson Price not available", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to calculate and display the average cost for each level
    private void showAverageCost() 
    {
        // Calculate the total cost for each level
        int beginnerTotal = lessonCosts.get("Guitar_Beginner")
                          + lessonCosts.get("Piano_Beginner")
                          + lessonCosts.get("Violin_Beginner");

        int intermediateTotal = lessonCosts.get("Guitar_Intermediate")
                             + lessonCosts.get("Piano_Intermediate")
                             + lessonCosts.get("Violin_Intermediate");

        int advancedTotal = lessonCosts.get("Guitar_Advanced")
                         + lessonCosts.get("Piano_Advanced")
                         + lessonCosts.get("Violin_Advanced");

        // Calculate averages
        int beginnerAverage = beginnerTotal / 3;
        int intermediateAverage = intermediateTotal / 3;
        int advancedAverage = advancedTotal / 3;

        // Display the averages in a message dialog
        String report = "Average lesson price for Beginner: R " + beginnerAverage + "\n"
                      + "Average lesson price for Intermediate: R " + intermediateAverage + "\n"
                      + "Average lesson price for Advanced: R " + advancedAverage;

        JOptionPane.showMessageDialog(this, report, "Average Lesson Prices", JOptionPane.INFORMATION_MESSAGE);
    }

    // Style buttons
    private void styleButton(JButton button) 
    {
        button.setFont(new Font("San Francisco", Font.PLAIN, 14));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setBackground(new Color(224, 224, 224));
        button.setFocusPainted(false);
    }

    // Style menu items
    private void styleMenuItem(JMenuItem item) 
    {
        item.setFont(new Font("San Francisco", Font.PLAIN, 14));
        item.setBackground(new Color(255, 255, 255));
        item.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
    }

    // Main method to run the application
    public static void main(String[] args) 
    {
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // Create the application instance and make it visible
        MusicLessonCostApp app = new MusicLessonCostApp();
        app.setVisible(true);
    }
}
