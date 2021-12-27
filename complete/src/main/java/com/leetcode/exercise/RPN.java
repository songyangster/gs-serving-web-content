package com.leetcode.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class RPN {
    enum Op {
        PLUS ("+"),
        MINUS("-"),
        MULTI("*"),
        DIV("/");

        private final String label;

        Op(String op) {
            this.label = op;
        }

        public String getLabel() {
            return label;
        }


        // ... enum values

        private static final Map<String, Op> BY_LABEL = new HashMap<>();

        static {
            for (Op e: values()) {
                BY_LABEL.put(e.label, e);
            }
        }

        // ... fields, constructor, methods

        public static Op valueOfLabel(String label) {
            Op op = BY_LABEL.get(label);
            if (op != null) {
                return op;
            } else {
                throw new RuntimeException("No matching op");
            }

        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            try {
                Op op = Op.valueOfLabel(token);
                int o2 = stack.pop();
                int o1 = stack.pop();
                int val = calc(op, o1, o2);
                stack.push(val);
            } catch (Exception e) {
                try {
                    stack.push(Integer.valueOf(token));
                } catch (Exception e1) {
                    System.out.println("Invalid int " + token);
                    return -1;
                }
            }
        }

        return stack.pop();
    }

    private int calc(Op op, int o1, int o2) {
        switch (op) {
            case PLUS:
                return o1 + o2;
            case MINUS:
                return o1 - o2;
            case MULTI:
                return o1 * o2;
            case DIV:
                return o1 / o2;
        }
        return 0;
    }

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    // Ensure this only gets done once for ALL test cases.
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    public int evalRPNLambda(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!OPERATIONS.containsKey(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();
            BiFunction<Integer, Integer, Integer> operation;
            operation = OPERATIONS.get(token);
            int result = operation.apply(number1, number2);
            stack.push(result);
        }

        return stack.pop();

    }

}
