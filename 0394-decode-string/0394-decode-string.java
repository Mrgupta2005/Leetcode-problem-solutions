class Solution {
    int i = 0;

    public String decodeString(String s) {
        return solve(s);
    }

    public String solve(String s) {
        StringBuilder ans = new StringBuilder();

        while (i < s.length() && s.charAt(i) != ']') {

            if (Character.isLetter(s.charAt(i))) {
                ans.append(s.charAt(i));
                i++;
            } 
            else {
                int num = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i++; // skip '['

                String temp = solve(s);

                i++; // skip ']'

                for (int j = 0; j < num; j++) {
                    ans.append(temp);
                }
            }
        }

        return ans.toString();
    }
}