package com.billions.framework.ext;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ValidContext {

    private final static Map<String, Expression> context;

    static {
        Map<String, Expression> kv = Arrays.stream(Expression.values()).collect(Collectors.toMap(Expression::name, Function.identity()));
        context = Collections.unmodifiableMap(kv);
    }


    public static Expression get(String name) {
        return context.get(name);
    }

}
