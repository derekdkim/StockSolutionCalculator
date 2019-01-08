package Calculator;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.*;
import java.awt.*;

public class CalcGUI extends JFrame {

    private JLabel C1Label, C2Label, V1Label, V2Label;
    private JTextField C1Field, C2Field, V1Field, V2Field;
    private JPanel IniPanel, FinPanel, ButtonPanel;
    private JButton CalcButton, ResetButton;

    // Constructor
    public CalcGUI() {

        // Set title
        setTitle("Stock Calculator");

        // Set action on pressing exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // C1
        C1Label = new JLabel("Initial Concentration (C1): ");
        C1Field = new JTextField("0", 15);

        // V1
        V1Label = new JLabel("Initial Volume (C1): ");
        V1Field = new JTextField("0", 15);

        // C2
        C2Label = new JLabel("Final Concentration (C2): ");
        C2Field = new JTextField("0", 15);

        // V2
        V2Label = new JLabel("Final Volume (C1): ");
        V2Field = new JTextField("0", 15);


        // Initial Panel
        IniPanel = new JPanel();
        IniPanel.setLayout(new GridLayout(2, 2));
        IniPanel.add(C1Label);
        IniPanel.add(C1Field);
        IniPanel.add(V1Label);
        IniPanel.add(V1Field);
        IniPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        // Final Panel
        FinPanel = new JPanel();
        FinPanel.setLayout(new GridLayout(2, 2));
        FinPanel.add(C2Label);
        FinPanel.add(C2Field);
        FinPanel.add(V2Label);
        FinPanel.add(V2Field);
        FinPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        // Create buttons
        JButton CalcButton = new JButton("Calculate");
        JButton ResetButton = new JButton("Reset");

        // Button Panel
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(CalcButton);
        ButtonPanel.add(ResetButton);

        // Set Layout to 2 x 2
        setLayout(new BorderLayout());

        // Add contents on grid
        add(IniPanel, BorderLayout.WEST);
        add(FinPanel, BorderLayout.EAST);
        add(ButtonPanel, BorderLayout.SOUTH);

        // Start
        pack();
        setVisible(true);
    }
}
