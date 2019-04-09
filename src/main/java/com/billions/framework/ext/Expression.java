package com.billions.framework.ext;

public enum Expression {
    req("\\S+", "%s参数不能为空"),
    number("\\d+", "%s必须是数字");


    Expression(String regex, String tip) {
        this.regex = regex;
        this.tip = tip;
    }

    /**
     * @param name
     * @return
     */
    public static Expression which(String name) {
        return ValidContext.get(name);
    }

    public final String regex;
    public final String tip;


}
