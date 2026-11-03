import java.util.Stack;

public class SyntaxChecker {

    // Checks if parentheses, brackets, and braces are balanced
    public static boolean isBalanced(String line) {

        // Create a stack to store opening symbols
        Stack<Character> buffer = new Stack<>();

        // Go through each character
        for (int i = 0; i < line.length(); i++) {

            char current = line.charAt(i);

            // Add opening symbols to the stack
            if (current == '(' || current == '{' || current == '[') {
                buffer.push(current);
            }

            // Check closing symbols
            else if (current == ')' || current == '}' || current == ']') {

                // Check if stack is empty
                if (buffer.isEmpty()) {
                    return false;
                }

                // Remove the last opening symbol
                char opening = buffer.pop();

                // Check if symbols match
                if (current == ')' && opening != '(') {
                    return false;
                }

                if (current == '}' && opening != '{') {
                    return false;
                }

                if (current == ']' && opening != '[') {
                    return false;
                }
            }
        }

        // If stack is empty, everything matched
        return buffer.isEmpty();
    }

    public static void main(String[] args) {

        String line1 = "public static void main(String[] args) { ... }";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println('Hello');)";
        String line4 = "List list = new ArrayList<{String>();";
        String line5 = "if (x > 0) {";

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}