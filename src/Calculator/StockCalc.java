package Calculator;

import javax.swing.JOptionPane;

public class StockCalc {
    private double v1, v2, c1, c2;
    private int MINIMUM_SIG_DIG;

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
            JOptionPane.showMessageDialog(null, "Error 1: More than one variable is equal to 0.");
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
            JOptionPane.showMessageDialog(null, "Error 2: No variable set to 0.");
            return 2;
        }

        // Determine significant digits.
        sigDigFinder();


        // If method runs to the end without encountering an error, return 0.
        return 0;
    }

    // Formulas
    private void findV1() {
        v1 = c2 * v2 / c1;
        JOptionPane.showMessageDialog(null, "V1: " + v1);
    }

    private void findV2() {
        v2 = c1 * v1 / c2;
        JOptionPane.showMessageDialog(null, "V2: " + v2);
    }

    private void findC1() {
        c1 = c2 * v2 / v1;
        JOptionPane.showMessageDialog(null, "C1: " + c1);
    }

    private void findC2() {
        c2 = c1 * v1 / v2;
        JOptionPane.showMessageDialog(null, "C2: " + c2);
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

    // Determine lowest significant digit of the factors involved.
    private void sigDigFinder() {
        // Initialize arrays.
        String[] nums = new String[4];
        int[] sigDigs = new int[4];

        // Convert doubles to strings for counting.
        nums[0] = String.valueOf(c1);
        nums[1] = String.valueOf(c2);
        nums[2] = String.valueOf(v1);
        nums[3] = String.valueOf(v2);

        // Find the significant digits of each factor.
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            // If it has decimal digits:
            if (nums[i].contains(".")) {
                // Add up the digits left and right of "."
                count += (nums[i].substring(0, nums[i].indexOf("."))).length() + (nums[i].substring(nums[i].indexOf(".") + 1)).length();
                sigDigs[i] = count;
            } else {
                String choppedNum = nums[i];
                // Ensure choppedNum is not 0 (has a length of 1).
                while (choppedNum.endsWith("0") && choppedNum.length() != 1) {
                    // Create a substring with the last 0 cut off.
                    choppedNum = choppedNum.substring(0, choppedNum.lastIndexOf("0"));

                    // Count all digits that are left of the last 0.
                    if (!choppedNum.endsWith("0")) {
                        count += choppedNum.length();
                    }
                }
                // If it's 0, count will be 0 as well. choppedNum count will be added to array after cutting off all trailing 0's.
                sigDigs[i] = count;
            }
        }
        int min = 100;
        for (int sigDig : sigDigs) {
            if (sigDig <= min && sigDig != 0) {
                min = sigDig;
            }
        }

        // Assign minimum significant digits.
        MINIMUM_SIG_DIG = min;
    }
}
