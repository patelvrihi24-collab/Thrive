import java.util.Stack;
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> idx = new Stack<>();
        idx.push(-1);
        int result = 0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                idx.push(i);
            }else{
                idx.pop();
                if(idx.empty()){
                    idx.push(i);
                }else{
                    result = Math.max(i - idx.peek(), result);
                }
            }

        }
        return result;
    }
    public static void main(String[] args){
        Solution s1 = new Solution();
        System.out.print(s1.longestValidParentheses(""));
    }

}