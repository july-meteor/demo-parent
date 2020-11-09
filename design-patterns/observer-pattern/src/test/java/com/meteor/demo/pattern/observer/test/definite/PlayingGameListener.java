package com.meteor.demo.pattern.observer.test.definite;

import java.util.Date;

/**
 * Created  meteor on 2020/11/9
 **/
public class PlayingGameListener {

    public PlayingGameListener() {
        System.out.println("playing");
    }

    public void stopPlayingGame(Date date) {
        System.out.println("stop playing" + date);
    }

}
