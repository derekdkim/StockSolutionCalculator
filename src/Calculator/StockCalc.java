package Calculator;

import javax.swing.JOptionPane;

public class StockCalc {
    private double v1, v2, c1, c2;
    private String v1s, v2s, c1s, c2s;
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

        // Determine significant digits.
        sigDigFinder();

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

        // If method runs to the end without encountering an error, return 0.
        return 0;
    }

    // Formulas
    private void findV1() {
        v1 = roundToSigDig(c2 * v2 / c1);
    }

    private void findV2() {
        v2 = roundToSigDig(c1 * v1 / c2);
    }

    private void findC1() {
        c1 = roundToSigDig(c2 * v2 / v1);
    }

    private void findC2() {
        c2 = roundToSigDig(c1 * v1 / v2);
    }

    // Setters (input)
    // V1
    void setV1(double input, String inputString) {

        v1 = input;
        v1s = inputString;
    }

    // V2
    void setV2(double input, String inputString) {

        v2 = input;
        v2s = inputString;
    }

    // C1
    void setC1(double input, String inputString) {

        c1 = input;
        c1s = inputString;
    }

    // C2
    void setC2(double input, String inputString) {

        c2 = input;
        c2s = inputString;
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
        nums[0] = c1s;
        nums[1] = c2s;
        nums[2] = v1s;
        nums[3] = v2s;

        // Find the significant digits of each factor.
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            // If it has decimal digits:
            if (nums[i].contains(".")) {
                // Add up the digits left and right of "."
                count = (nums[i].substring(0, nums[i].indexOf("."))).length() + (nums[i].substring(nums[i].indexOf(".") + 1)).length();
                sigDigs[i] = count;
            } else {
                String choppedNum = nums[i];

                // Remove any zeroes not part of the number that the user put in.
                if (choppedNum.startsWith("0") && choppedNum.length() != 1) {
                    while (choppedNum.startsWith("0")) {
                        choppedNum = choppedNum.substring(1);
                    }
                }

                if (choppedNum.endsWith("0")) {

                    if (choppedNum.equals("0")) {
                        count = 1;
                    }

                    // Ensure choppedNum is not 0 (has a length of 1).
                    while (choppedNum.endsWith("0") && choppedNum.length() != 1) {

                        // Create a substring with the last 0 cut off.
                        choppedNum = choppedNum.substring(0, choppedNum.lastIndexOf("0"));

                        // Count all digits that are left of the last 0.
                        if (!choppedNum.endsWith("0")) {
                            count = choppedNum.length();
                        }
                    }

                } else {
                    count = choppedNum.length();
                }

                // If it's 0, count will be 0 as well. choppedNum count will be added to array after cutting off all trailing 0's.
                sigDigs[i] = count;
            }
        }

        int min = 100;
        // Find the minimum.
        for (int sigDig : sigDigs) {
            if (sigDig <= min && sigDig != 1) {
                min = sigDig;
            }
        }

        // Assign minimum significant digits.
        if (min == 100) {
            MINIMUM_SIG_DIG = 1;
        } else {
            MINIMUM_SIG_DIG = min;
        }
    }

    private double roundToSigDig(double num) {

        int power = MINIMUM_SIG_DIG - (int) Math.ceil(Math.log10(num < 0 ? - num : num));

        // Determine how many orders the number should be shifted.
        double magnitude = Math.pow(10, power);

        // Round the number when shifted by set orders of magnitude.
        double tempRound = Math.round (magnitude * num);

        // Shift the number back to its proper order.
        return tempRound / magnitude;


    }
}
