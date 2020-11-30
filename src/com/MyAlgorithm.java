package com;

import java.util.Stack;

public class MyAlgorithm {
    private Stack<Double> numStack = new Stack<>();
    private Stack<Character> operStack = new Stack<>();
    private StringBuilder number = new StringBuilder();

    public String Calculate(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else {
                numStack.push(Double.parseDouble(number.toString()));
                number = new StringBuilder();

                if (!operStack.isEmpty()) {
                    while (IsBigger(operStack.peek(), c)) {
                        double x;
                        x = numStack.pop();
                        switch (operStack.pop()) {
                            case '+' -> numStack.push(x + numStack.pop());
                            case '-' -> numStack.push(numStack.pop() - x);
                            case '*' -> numStack.push(x * numStack.pop());
                            case '/' -> numStack.push(numStack.pop() / x);
                            case ')' -> {
                                char d = operStack.pop();
                                while (d != '(') {
                                    double y = numStack.pop();
                                    y = switch (d) {
                                        case '+' -> y + numStack.pop();
                                        case '-' -> numStack.pop() - y;
                                        case '*' -> y + numStack.pop();
                                        case '/' -> numStack.pop() / y;
                                        default -> 0;
                                    };
                                    numStack.push(y);
                                    d = operStack.pop();
                                }
                            }
                        }
                    }
                }
                operStack.push(c);
            }
        }
        numStack.push(Double.parseDouble(number.toString()));
        while (!operStack.empty()) {
            char c = operStack.pop();
            double x = numStack.pop();
            switch (c) {
                case '+' -> numStack.push(x + numStack.pop());
                case '-' -> numStack.push(numStack.pop() - x);
                case '*' -> numStack.push(x * numStack.pop());
                case '/' -> numStack.push(numStack.pop() / x);
            }
        }
        return numStack.pop().toString();
    }

    private boolean IsBigger(char a, char b) {
        int x, y;
        x = switch (a) {
            case '+', '-' -> 2;
            case '*', '/' -> 3;
            case '(' -> 4;
            case ')' -> 1;
            default -> 0;
        };
        y = switch (b) {
            case '+', '-' -> 2;
            case '*', '/' -> 3;
            case '(' -> 4;
            case ')' -> 1;
            default -> 0;
        };
        return x > y;
    }
}
