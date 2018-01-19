import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class RPN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mathExpression = input.nextLine();
        String[] allNumbers = mathExpression.split("\\+|\\-|\\*|\\/");
        System.out.println(Arrays.toString(allNumbers));
        String rpnExpression = getRPN(mathExpression);
        System.out.println(rpnExpression);
        double result = getFinalResult(rpnExpression, allNumbers);
        if (result == Math.floor(result)) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }
    }

    private static String getRPN(String expression) {
        String rpn = "";
        Stack<Character> symbols = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) != ' ') {
                rpn += expression.charAt(i);
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                    if (symbols.empty() || symbols.peek() != '*' && symbols.peek() != '/') {
                        symbols.push(expression.charAt(i));
                    } else if (!symbols.empty()) {
                        while (!symbols.empty()) {
                            rpn += symbols.pop();
                        }
                        symbols.push(expression.charAt(i));
                    }
                } else {
                    symbols.push(expression.charAt(i));
                }
            }
        }
        while (!symbols.empty()) {
            rpn += symbols.pop();
        }
        return rpn;
    }

    private static double getFinalResult(String expression, String[] numbers) {
        Stack<Double> numbersRPN = new Stack<>();
        double tempResult, a, b;
        byte counter = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/') {
                numbersRPN.push(Double.parseDouble(numbers[counter].trim()));
                if ((numbers[counter].trim()).length() > 1) {
                    i += numbers[counter].length() - 1;
                }
                counter++;
            } else {
                switch (expression.charAt(i)) {
                    case '+':
                        a = numbersRPN.pop();
                        b = numbersRPN.pop();
                        tempResult = b + a;
                        numbersRPN.push(tempResult);
                        break;
                    case '-':
                        a = numbersRPN.pop();
                        b = numbersRPN.pop();
                        tempResult = b - a;
                        numbersRPN.push(tempResult);
                        break;
                    case '*':
                        a = numbersRPN.pop();
                        b = numbersRPN.pop();
                        tempResult = b * a;
                        numbersRPN.push(tempResult);
                        break;
                    case '/':
                        a = numbersRPN.pop();
                        b = numbersRPN.pop();
                        tempResult = b / a;
                        numbersRPN.push(tempResult);
                        break;
                }
            }
        }
        return numbersRPN.pop();
    }
}
