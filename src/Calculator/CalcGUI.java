package Calculator;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        V1Label = new JLabel("Initial Volume (V1): ");
        V1Field = new JTextField("0", 15);

        // C2
        C2Label = new JLabel("Final Concentration (C2): ");
        C2Field = new JTextField("0", 15);

        // V2
        V2Label = new JLabel("Final Volume (V2): ");
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
        CalcButton = new JButton("Calculate");
        ResetButton = new JButton("Reset");

        // Add action listeners to buttons.
        CalcButton.addActionListener(new CalcButtonListener());
        ResetButton.addActionListener(new ResetButtonListener());

        // Button Panel
        ButtonPanel = new JPanel();
        ButtonPanel.add(CalcButton);
        ButtonPanel.add(ResetButton);

        // Set Layout of frame.
        setLayout(new BorderLayout());

        // Add contents on grid
        add(IniPanel, BorderLayout.WEST);
        add(FinPanel, BorderLayout.EAST);
        add(ButtonPanel, BorderLayout.SOUTH);

        // Start
        pack();
        setVisible(true);
    }

    private class CalcButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // Calculator object resides within local scope to ensure that CalcButton can be used multiple times without error.
            {
                // Create new instance of calculator.
                StockCalc Calculator = new StockCalc();

                // Enter values of fields into corresponding StockCalc variables.
                Calculator.setC1(Double.parseDouble(C1Field.getText()));
                Calculator.setC2(Double.parseDouble(C2Field.getText()));
                Calculator.setV1(Double.parseDouble(V1Field.getText()));
                Calculator.setV2(Double.parseDouble(V2Field.getText()));

                // Call calculate method
                Calculator.calculate();

                // Enter values of the 4 variables in fields.
                C1Field.setText(String.valueOf(Calculator.getC1()));
                C2Field.setText(String.valueOf(Calculator.getC2()));
                V1Field.setText(String.valueOf(Calculator.getV1()));
                V2Field.setText(String.valueOf(Calculator.getV2()));
            }

        }

    }

    private class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // Set all values of text fields to 0.
            C1Field.setText("0");
            C2Field.setText("0");
            V1Field.setText("0");
            V2Field.setText("0");
        }
    }

}
