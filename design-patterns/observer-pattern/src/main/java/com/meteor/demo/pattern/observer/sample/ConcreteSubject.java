package com.meteor.demo.pattern.observer.sample;

/**
 * Created  meteor on 2020/11/9
 **/
public class ConcreteSubject extends  Subject {

    /**
     *  被观察者状态
     */
    private String subjectState;


    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }


}
