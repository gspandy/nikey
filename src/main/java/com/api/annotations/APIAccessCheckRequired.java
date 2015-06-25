package com.api.annotations;

/**
 * Created by arvin on 2015/6/24.
 * API 访问注解接口类
 * @author 王鹏飞
 * @since  2015/6/24
 */
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface APIAccessCheckRequired {}
