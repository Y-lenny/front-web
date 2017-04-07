package com.hawk.springel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yannfeng on 2016/11/14.
 */
public class SpringElTest {

    @Test
    public void testSpringEL() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("T(com.hawk.springboot.base.BeanDataFactory).getAdminAccountById(1)");
        String message = (String) exp.getValue();

        System.out.println(message);
    }
}
