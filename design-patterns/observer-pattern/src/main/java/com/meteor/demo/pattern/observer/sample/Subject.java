package com.meteor.demo.pattern.observer.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  meteor on 2020/11/9
 * 主题
 **/
public class Subject {

    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer) {
        list.add(observer);

    }

    public void detach(Observer observer) {
        list.remove(observer);
    }

    /**
     * Object 自带notify 事件 所以这里方法命名为call
     */
    public void call() {
        // 轮询通知
        for (Observer o : list) {
            o.update();
        }
    }


}
