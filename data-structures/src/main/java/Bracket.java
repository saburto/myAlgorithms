import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position + 1;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        System.out.println(checkBrackets(text));
    }

    public static String checkBrackets(String text) {
        Stack<Bracket> openingBracketsStack = new Stack<Bracket>();
        String answer = "Success";
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                openingBracketsStack.add(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                if (openingBracketsStack.isEmpty()) {
                    answer = String.valueOf(position + 1);
                    break;
                } else {
                    Bracket open = openingBracketsStack.pop();
                    if (!open.match(next)) {
                        answer = String.valueOf(position + 1);
                        break;
                    }
                }
            }
        }

        if (answer.equals("Success") && !openingBracketsStack.isEmpty()) {
            answer = String.valueOf(openingBracketsStack.pop().position);
        }

        return answer;

    }
}