package top.ornobug.annotation;


import java.lang.annotation.*;

/**
 * 切面注解
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CrossSection {

    /**
     * 要拦截的注解
     *
     * @return
     */
    Class<? extends Annotation> value();

}
