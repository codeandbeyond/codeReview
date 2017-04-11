import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class BinaryCode {
    public static String[] decode(String message) {
        int[] p = new int[message.length()];
        String[] answers = new String[2];
        answers[0] = getMeEncrypted(message, p, 0);
        answers[1] = getMeEncrypted(message, p, 1);
        return answers;
    }

    private static String getMeEncrypted(String message, int[] p, int pvalue) {
        p[0] = pvalue;
        int val;
        String result = String.valueOf(pvalue);
        for (int i = 0; i < message.length(); i++) {
            if (i == 0) {
                val = Character.digit(message.charAt(i), 10) - p[i];
            } else {
                val = Character.digit(message.charAt(i), 10) - p[i] - p[i - 1];
            }
            if (val == 0 || val == 1) {
                if (i < p.length-1) {
                    p[i + 1] = val;
                    result = result.concat(String.valueOf(val));
                }
            } else {
                result = "NONE";
                break;
            }
        }
        return result;
    }
}
