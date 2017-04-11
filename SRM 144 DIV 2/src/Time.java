import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class Time {

    public String whatTime(int seconds) {
        String time = "";
        int h = 0, m = 0, s;
        if (seconds == 0) {
            return "0:0:0";
        }
        if (seconds > 3600) {
            h = seconds / 3600;
            seconds = seconds % 3600;
        }
        if (seconds > 60) {
            m = seconds / 60;
            seconds = seconds % 60;
        }
        s = seconds % 60;
        return time + h + ":" + m + ":" + s;
    }
}
