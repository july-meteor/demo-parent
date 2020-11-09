package com.meteor.demo.pattern.observer.definite;

/**
 * Created  meteor on 2020/11/9
 **/
public abstract class Notifier {

    private EventHandler handler = new EventHandler();

    public EventHandler getHandler() {
        return handler;
    }

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }

    /**
     * 添加监听
     * @param object 对象
     * @param methodName 方法名
     * @param params  参数
     */
    public abstract void addListener(Object object, String methodName, Object... params);

    /**
     *  触发回调
     */
    public abstract void call();

}
