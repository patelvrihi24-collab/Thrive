class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int rightNeeded = 0; // Tracks how many ')' are currently needed
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                rightNeeded += 2;
                // If we have an odd number of right parentheses needed, 
                // it means the previous '(' didn't get its second ')' yet. Fix it immediately.
                if (rightNeeded % 2 != 0) {
                    insertions++; // Insert one ')'
                    rightNeeded--; // Reduce the requirement
                }
            } else { // ch == ')'
                rightNeeded--;
                // If we encounter a ')' but none were needed, we must insert a missing '('
                if (rightNeeded < 0) {
                    insertions++;     // Insert missing '('
                    rightNeeded += 2; // That new '(' now requires 2 ')', minus the current one = +2
                }
            }
        }
        
        return insertions + rightNeeded;
    }
}
