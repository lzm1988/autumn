package top.ornobug.core.bean;

/**
 * 将xml中定义的bean映射成这个类的实例
 */
public class BeanDefine {

    private String beanId;

    private String beanClass;

    private boolean lazyInit;

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
