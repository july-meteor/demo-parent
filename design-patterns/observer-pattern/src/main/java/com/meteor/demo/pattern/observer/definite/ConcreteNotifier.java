package com.meteor.demo.pattern.observer.definite;

/**
 * Created  meteor on 2020/11/9
 * 具体实现
 **/
public class ConcreteNotifier extends Notifier {
    @Override
    public void addListener(Object object, String methodName, Object... params) {
        this.getHandler().attach(object, methodName, params);

    }

    @Override
    public void call() {
        try {
            this.getHandler().call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
