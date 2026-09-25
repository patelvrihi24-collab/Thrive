import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        // 1. Stack holds Lists of Strings to represent words or structural markers
        Stack<List<String>> stack = new Stack<>();
        
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            
            if (ch == '{') {
                // Push an opening brace marker
                stack.push(List.of("{"));
                i++;
            } 
            else if (ch == ',') {
                // Push a comma marker
                stack.push(List.of(","));
                i++;
            } 
            else if (ch == '}') {
                // 1. POP AND UNION: Get all options inside this brace layer
                List<List<String>> groupsToUnion = new ArrayList<>();
                
                // Pop everything up to the matching '{'
                while (!stack.isEmpty() && !stack.peek().get(0).equals("{")) {
                    List<String> popped = stack.pop();
                    if (!popped.get(0).equals(",")) {
                        groupsToUnion.add(popped);
                    }
                }
                stack.pop(); // Pop the matching "{" marker
                
                // Combine all inner options using a Union operation
                List<String> combinedUnion = mergeUnions(groupsToUnion);
                
                // 2. AUTO-CONCATENATE: Check if this new group needs to be multiplied
                // with a neighbor immediately to its left (e.g., 'a{b,c}' or '{x}{y}')
                while (!stack.isEmpty() && isWordGroup(stack.peek())) {
                    combinedUnion = multiplySets(stack.pop(), combinedUnion);
                }
                
                stack.push(combinedUnion);
                i++;
            } 
            else {
                // It's a lowercase letter. Read the whole word chunk.
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isLowerCase(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                
                List<String> currentWordGroup = List.of(sb.toString());
                
                // AUTO-CONCATENATE: If the previous item on the stack is a word group, 
                // multiply them immediately (handles patterns like '{a,b}c' or 'ab')
                while (!stack.isEmpty() && isWordGroup(stack.peek())) {
                    currentWordGroup = multiplySets(stack.pop(), currentWordGroup);
                }
                
                stack.push(currentWordGroup);
            }
        }
        
        // 2. Final Step: The stack might have trailing items separated by commas at the root level
        List<List<String>> remainingGroups = new ArrayList<>();
        while (!stack.isEmpty()) {
            List<String> popped = stack.pop();
            if (!popped.get(0).equals(",")) {
                remainingGroups.add(popped);
            }
        }
        
        // Final union, deduplication, and sorting
        TreeSet<String> sortedResult = new TreeSet<>(mergeUnions(remainingGroups));
        return new ArrayList<>(sortedResult);
    }
    
    // Helper method to check if a stack element is an actual word list rather than a marker
    private boolean isWordGroup(List<String> list) {
        String first = list.get(0);
        return !first.equals("{") && !first.equals(",");
    }

    // Helper method to implement the MULTIPLICATION (Cartesian product) logic you planned
    private List<String> multiplySets(List<String> set1, List<String> set2) {
        List<String> result = new ArrayList<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }

    // Helper method to implement the UNION logic you planned
    private List<String> mergeUnions(List<List<String>> groups) {
        HashSet<String> unique = new HashSet<>();
        for (List<String> group : groups) {
            unique.addAll(group);
        }
        return new ArrayList<>(unique);
    }
}
