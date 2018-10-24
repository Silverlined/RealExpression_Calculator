import java.util.Stack;


public class RPN extends CalculatorRPN {
    private static int COUNTER_NUMBERS = 0;

    public static void main() {
        String[] allNumbersTemp = mathExpression.split("\\+|\\-|\\*|\\/|\\(|\\)|\\%");
        countNumbers(allNumbersTemp);
        String[] allNumbers = new String[COUNTER_NUMBERS];
        COUNTER_NUMBERS = 0;
        fillWithNumbers(allNumbersTemp, allNumbers);
        String rpnExpression = getRPN(mathExpression);
        double result = getFinalResult(rpnExpression, allNumbers);
        if (result == Math.floor(result)) {
            expressionField.setText("Result: " + (int) result);
        } else {
            expressionField.setText("Result: " + result);
        }
    }

    public static String getRPN(String expression) {
        String rpn = "";
        Stack<Character> symbols = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) != ' ' && expression.charAt(i) != '(' && expression.charAt(i) != ')') {
                rpn += expression.charAt(i);
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '(' || expression.charAt(i) == ')') {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                    if (symbols.empty() || symbols.peek() != '*' && symbols.peek() != '/' && symbols.peek() != '+' && symbols.peek() != '-') {
                        symbols.push(expression.charAt(i));
                    } else if (!symbols.empty()) {
                        while (!symbols.empty()) {
                            rpn += symbols.pop();
                        }
                        symbols.push(expression.charAt(i));
                    }
                } else if (expression.charAt(i) == ')') {
                    while (symbols.peek() != '(') {
                        rpn += symbols.pop();
                    }
                    symbols.pop();
                    continue;
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
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) != '%') {
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
                    case '%':
                        a = numbersRPN.pop();
                        tempResult = a / 100;
                        numbersRPN.push(tempResult);
                        break;
                }
            }
        }
        return numbersRPN.pop();
    }

    private static String[] fillWithNumbers(String[] allNumbersTemp, String[] allNumbers) {
        for (int i = 0; i < allNumbersTemp.length; i++) {
            if (!allNumbersTemp[i].equals("")) {
                allNumbers[COUNTER_NUMBERS++] = allNumbersTemp[i];
            }
        }
        return allNumbers;
    }

    private static int countNumbers(String[] allNumbersTemp) {
        for (String i : allNumbersTemp) {
            if (!i.equals("")) {
                COUNTER_NUMBERS++;
            }
        }
        return COUNTER_NUMBERS;
    }
}
