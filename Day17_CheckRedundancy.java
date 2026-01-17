import java.util.Stack;

class Day17_CheckRedundancy{
    public static boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push everything except closing bracket
            if (ch != ')') {
                st.push(ch);
            } else {
                // Encountered ')'
                boolean hasOperator = false;

                // Check contents inside brackets
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Pop the opening '('
                if (!st.isEmpty()) st.pop();

                // If no operator found → redundant
                if (!hasOperator) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "(a+b)";
        System.out.println(checkRedundancy(s));
    }
}
