package com.atlassian.tutorial.myPlugin.impl;

import com.atlassian.tutorial.myPlugin.impl.JStack;
public class BalancedParenthisisCheck {
    @org.jetbrains.annotations.NotNull
    public static Boolean  checkBalance(String str) {
        JStack stack = new JStack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (  ch == ')'
                    && (!stack.isEmpty())) {
                if ((char) stack.peek() == '(' && ch == ')')
                {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                if (ch == ')') {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

}
