package com.show.admin.scetc.annotation;

import java.lang.annotation.*;

/**
 * @author 徐塬峰 2019/4/14
 * 以自定义注解的方式记录日志
 * 注解在方法级别上 运行时启动
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
