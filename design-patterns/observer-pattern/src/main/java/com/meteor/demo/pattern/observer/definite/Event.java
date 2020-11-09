package com.meteor.demo.pattern.observer.definite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created  meteor on 2020/11/9
 * 事件处理器， java 通过反射实现方法回调
 *
 * @author meteor
 **/
public class Event  {
    /**
     * 对象类
     */
    private Object object;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数
     */
    private Object[] params;
    /**
     * 参数类型
     */
    private Class[] paramTypes;

    public Event(Object obj, String methodName, Object... params) {
        this.object = obj;
        this.methodName = methodName;
        this.params = params;
        convertParamType(params);
    }

    public void invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getMethod(methodName, paramTypes);
        // 判断是否有这个方法
        if (null == method) {
            return;
        }
        method.invoke(object, params);
    }

    private void convertParamType(Object[] params) {
        int size = params.length;
        this.paramTypes = new Class[size];
        for (int i = 0; i < size; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }
}
