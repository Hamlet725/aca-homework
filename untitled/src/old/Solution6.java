package old;

import java.util.*;

class Solution6 {
    static Expression[] expressions;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        expressions = new  Expression[N];
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            Expression expression = new Expression(operation, arg1, arg2);
            expressions[i] = expression;
        }
        for (int i = 0; i < N; i++) {
            Expression g = Solution6.expressions[i];
            Expression expression = new Expression(g.getOperation(), g.getArg1(), g.getArg2());
            int[] k = lookAtTheExpressionLine(expression.getArg1(), expression.getArg2());
            expression.setValue1(k[0]);
            expression.setValue2(k[1]);
            int c = evaluateExpression(expression);
            System.out.println(c);
        }
    }

    public static int[] lookAtTheExpressionLine(String arg1, String arg2) {
        int[] ints = new int[2];
        if (arg1.charAt(0) == '$') {
            int k = evaluateExpressionForReference(arg1);
            arg1 = String.valueOf(k);
        }
        if (arg2.charAt(0) == '$') {
            int k = evaluateExpressionForReference(arg2);
            arg2 = String.valueOf(k);
        }
        if (arg2.equals("_")) {
            ints[0] = Integer.parseInt(arg1);
            return ints;
        }
        ints[0] = Integer.parseInt(arg1);
        ints[1] = Integer.parseInt(arg2);
        return ints;
    }

    public static int evaluateExpressionForReference(String str) {
        char[] chars = new char[str.length() - 1];
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current >= '0' && current <= '9') {
                chars[j] = current;
                ++j;
            }
        }
        int k = Integer.parseInt(String.valueOf(chars));
        Expression g = Solution6.expressions[k];
        if (g.getEvaluatedValue() != null) {
            return g.getEvaluatedValue();
        }
        String x = g.getArg1();
        String y = g.getArg2();
        int[] argumentValues = lookAtTheExpressionLine(x, y);
        g.setValue1(argumentValues[0]);
        g.setValue2(argumentValues[1]);
        int o = evaluateExpression(g);
        g.setEvaluatedValue(o);
        return o;
    }

    public static int evaluateExpression(Expression expression) {
        int k = 0;
        switch (expression.getOperation()) {
            case "VALUE": {
                k = expression.getValue1();
                break;
            }
            case "ADD": {
                k = expression.getValue1() + expression.getValue2();
                break;
            }
            case "SUB": {
                k = expression.getValue1() - expression.getValue2();
                break;
            }
            case "MULT": {
                k = expression.getValue1() * expression.getValue2();
                break;
            }
        }
        return k;
    }
}

class Expression {
    private int value1;
    private int value2;
    private String operation;
    private String arg1;
    private String arg2;
    private Integer evaluatedValue;

    public Expression(String operation, String arg1, String arg2) {
        this.operation = operation;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public String getOperation() {
        return operation;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public Integer getEvaluatedValue() {
        return evaluatedValue;
    }

    public void setEvaluatedValue(Integer evaluatedValue) {
        this.evaluatedValue = evaluatedValue;
    }
}