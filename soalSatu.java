
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
 public class soalSatu {

     public static void main(String[] args) {

        System.out.println("Infix : 4 * ( 20 + 100 ) / 2 * 5");
        System.out.print("Menjadi Postfix : "); 
        System.out.println(infixToPostfix("4 * ( 20 + 100 ) / 2 * 5"));
 
        System.out.println("==========================================");

        System.out.println("Menghitung hasil Postfix : ");
 
        System.out.println(evaluatePostfix("4 20 100 + 2 5 * / *"));
 
     }

    public static String infixToPostfix(String infix) {
        Stack<String> operators = new Stack<>();
        List<String> postfix = new ArrayList<>();

        for (String current : infix.split(" ")) {
            if (isOperator(current)) {
                while (!operators.empty() && hasLowertingkatan(current, operators.peek())) {
                    postfix.add(operators.pop());
                }
                operators.push(current);
            } else if (current.equals("(")) {
                operators.push(current);
            } else if (current.equals(")")) {
                while (!operators.peek().equals("(")) {
                    postfix.add(operators.pop());
                }
                operators.pop(); // Discard the "("
            } else {
                postfix.add(current);
            }
        }
        while (!operators.empty()) {
            postfix.add(operators.pop());
        }
        return String.join(" ", postfix);
    }
    
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String component : postfix.split(" ")) {
            if (!isOperator(component)) {
                stack.push(Integer.parseInt(component));
            } else {
                int nbr1 = stack.pop();
                int nbr2 = stack.pop();
                switch (component) {
                    case "+" -> stack.push(nbr2 + nbr1);
                    case "-" -> stack.push(nbr2 - nbr1);
                    case "/" -> stack.push(nbr2 / nbr1);
                    case "*" -> stack.push(nbr2 * nbr1);
                    case "%" -> stack.push(nbr2 % nbr1);
                }
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(String operator) {
        return List.of("+", "-", "*", "/", "%").contains(operator);
    }

    public static boolean hasLowertingkatan(String op1, String op2) {
        return tingkatan(op1) < tingkatan(op2);
    }

    public static int tingkatan(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }
        return 0;
    }
 
 }