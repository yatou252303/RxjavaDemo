package com.nuoyuan.rxdemo.category10_connectable_observable_operators;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * 并不是类似前面的Observer 当有订阅者开始订阅的时候 被观察者开始发送数据
 * <p>
 * Connction 是知道使用Connction 函数才开始发送，保证所有观察者准备完毕，一同进行
 */
public class Category10Operator1ConnectActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "connect";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category10_connectable_observable_operators_1_connect_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.j1_connect;
    }

    @Override
    protected int setImageHeight() {
        return 280;
    }

    @Override
    protected void runSampleCode() {
//        Observable observable = Observable.range(1, 1000000).sample(10, TimeUnit.MILLISECONDS);
        ConnectableObservable observable = Observable.range(1, 1000000).sample(10, TimeUnit.MILLISECONDS).publish();

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted1.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError1: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext1: " + integer);
            }
        });

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted2.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError2: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext2: " + integer);
            }
        });

        observable.connect();
    }

    @Override
    protected String getSampleCode() {
        return "ConnectableObservable observable = Observable.range(1, 1000000).sample(10, TimeUnit.MILLISECONDS).publish();\n" +
                "\n" +
                "observable.subscribe(new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted1.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError1: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        System.out.println(\"onNext1: \" + integer);\n" +
                "    }\n" +
                "});\n" +
                "\n" +
                "observable.subscribe(new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted2.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError2: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        System.out.println(\"onNext2: \" + integer);\n" +
                "    }\n" +
                "});\n" +
                "\n" +
                "observable.connect();";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext1: 20491");
        output.add("\nonNext2: 20491");
        output.add("\nonNext1: 39191");
        output.add("\nonNext2: 39191");
        output.add("\n...");
        output.add("\nonNext1: 997372");
        output.add("\nonNext2: 997372");
        output.add("\nonCompleted1.");
        output.add("\nonCompleted2.");

        return output;
    }
}
