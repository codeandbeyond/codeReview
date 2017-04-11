import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class ImageDithering {
    public static int count(String dithered, String[] screen) {
        Map<String, Integer> countMap = new HashMap<>();
        int count[] = new int[screen.length];
        int k = 0;
        for (String screenElement : screen) {
            if (countMap.containsKey(screenElement)) {
                count[k] = countMap.get(screenElement);
                k++;
            } else {
                int tempcount = 0;
                for (int i = 0; i < dithered.length(); i++) {

                    for (int j = 0; j < screenElement.length(); j++) {
                        if (dithered.charAt(i) == screenElement.charAt(j)) {
                            tempcount = tempcount + 1;
                        }
                    }
                }
                countMap.put(screenElement, tempcount);
                count[k] = tempcount;
                k++;
            }
        }
        int ditheredCount = 0;
        for (int countOfCharacter = 0; countOfCharacter < count.length; countOfCharacter++) {
            ditheredCount = count[countOfCharacter] + ditheredCount;
        }
        return ditheredCount;
    }
}
