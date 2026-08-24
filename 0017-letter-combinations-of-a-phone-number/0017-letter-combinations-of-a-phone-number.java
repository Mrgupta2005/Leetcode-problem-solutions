class Solution {

    String[] keypad = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        StringBuilder current = new StringBuilder();

        backtrack(digits, 0, current, result);

        return result;
    }

    void backtrack(String digits, int index,
                    StringBuilder current,
                    List<String> result) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to current digit
        String letters = keypad[digits.charAt(index) - '0'];

        // Try every possible letter
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            current.append(letters.charAt(i));

            // Explore
            backtrack(digits, index + 1, current, result);

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}