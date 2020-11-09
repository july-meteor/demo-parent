package com.meteor.demo.pattern.observer.test.definite;

import com.meteor.demo.pattern.observer.definite.ConcreteNotifier;
import com.meteor.demo.pattern.observer.definite.Notifier;

import java.util.Date;

/**
 * Created  meteor on 2020/11/9
 **/
public class Main {

    public static void main(String[] args) {
        Notifier notifier = new ConcreteNotifier();

        PlayingGameListener playingGameListener = new PlayingGameListener();

        notifier.addListener(playingGameListener, "stopPlayingGame", new Date());

        WatchingTVListener watchingTVListener = new WatchingTVListener();

        notifier.addListener(watchingTVListener, "stopWatchingTV", new Date());

        notifier.call();
    }
}
