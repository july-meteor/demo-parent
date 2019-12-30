package com.meteor.demo.dubbo.api;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * created by Meteor on 2019/12/29
 *  dubbo 比较让人讨厌的接口依赖，是它形成了dubbo系统的复杂关系，
 *  但是他也提供了清晰的接口说明 有弊也有利
 */

public interface DemoService extends Serializable {

    String sayHello(String name);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }
}
