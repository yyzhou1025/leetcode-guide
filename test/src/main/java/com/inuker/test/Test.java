package com.inuker.test;

/**
 * Created by liwentian on 2017/12/4.
 */

public class Test {

    Caller mCaller;

     void call(String name) {
        if (mCaller == null) {
            mCaller = new Caller() {
                @Override
                public void call() {
                    System.out.println(name);
                }
            };
        }
        mCaller.call();
    }

    interface Caller {
        void call();
    }
}
