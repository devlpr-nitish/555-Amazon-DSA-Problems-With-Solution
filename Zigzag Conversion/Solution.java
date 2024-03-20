class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int index = i;
            int deltDown = 2 * (numRows - 1 - i);
            int deltUp = 2 * i;
            boolean goingDown = true;

            while (index < s.length()) {
                sb.append(s.charAt(index));

                if (i == 0) {
                    index += deltDown;
                } else if (i == numRows - 1) {
                    index += deltUp;
                } else {
                    if (goingDown) {
                        index += deltDown;
                    } else {
                        index += deltUp;
                    }
                    goingDown = !goingDown;
                }
            }
        }
        return sb.toString();
    }
}