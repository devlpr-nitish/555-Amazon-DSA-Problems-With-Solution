public class Sk{
    public char slowestKey(int[] rt, String keypress) {
        int maxTime = rt[0];
        char result = keypress.charAt(0);

        for (int i = 1; i < rt.length; i++) {
            int current = rt[i] - rt[i - 1];
            if (current > maxTime || current == maxTime && keypress.charAt(i) > result) {
                maxTime = current;
                result = keypress.charAt(i);
            }
        }

        return result;
    }
}