package Calculator;

import javax.swing.JOptionPane;

public class StockCalc {
    private double v1;
    private double v2;
    private double c1;
    private double c2;

    // Initial constructor
    public StockCalc() {
        v1 = 0;
        v2 = 0;
        c1 = 0;
        c2 = 0;
    }

    int calculate() {
        // Error 1: More than one variable is equal to 0.
        if (zeroChecker()) {
            return 1;
        }

        if (v1 == 0) {
            findV1();
        } else if (v2 == 0) {
            findV2();
        } else if (c1 == 0) {
            findC1();
        } else if (c2 == 0) {
            findC2();
        }
        // Error 2: No variable set to 0.
        else {
            return 2;
        }

        // If method runs to the end without encountering an error, return 0.
        return 0;
    }

    // Formulas
    void findV1() {
        v1 = c2 * v2 / c1;
        JOptionPane.showMessageDialog(null, v1);
    }

    void findV2() {
        v2 = c1 * v1 / c2;
        JOptionPane.showMessageDialog(null, v2);
    }

    void findC1() {
        c1 = c2 * v2 / v1;
        JOptionPane.showMessageDialog(null, c1);
    }

    void findC2() {
        c2 = c1 * v1 / v2;
        JOptionPane.showMessageDialog(null, c2);
    }

    // Setters (input)
    // V1
    void setV1(double input) {
        v1 = input;
    }

    // V2
    void setV2(double input) {
        v2 = input;
    }

    // C1
    void setC1(double input) {
        c1 = input;
    }

    // C2
    void setC2(double input) {
        c2 = input;
    }

    // Getters (output)
    // V1
    double getV1() {
        return v1;
    }

    // V2
    double getV2() {
        return v2;
    }

    // C1
    double getC1() {
        return c1;
    }

    // C2
    double getC2() {
        return c2;
    }

    // Error check
    private boolean zeroChecker() {
        if (c1 + v1 == 0 || c1 + v2 == 0 || c2 + v2 == 0 || c2 + v1 == 0 || c1 + c2 == 0 || v1 + v2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
