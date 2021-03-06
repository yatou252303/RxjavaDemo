package com.nuoyuan.rxdemo.category7_conditional_and_boolean_operators;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


/**
 * Author: weichyang
 * Date:   2017/5/12
 * Description:  判定是否包含某个元素
 */
public class Category7Operator8ContainsActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "contains";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_8_contains_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g8_contains;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4, 5)
                .contains(5)
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        System.out.println("onNext: " + aBoolean);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4, 5)\n" +
                "    .contains(5)\n" +
                "    .subscribe(new Subscriber<Boolean>() {\n" +
                "        @Override\n" +
                "        public void onCompleted() {\n" +
                "            System.out.println(\"onCompleted.\");\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onError(Throwable e) {\n" +
                "            System.out.println(\"onError: \" + e.getMessage());\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onNext(Boolean aBoolean) {\n" +
                "            System.out.println(\"onNext: \" + aBoolean);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: true");
        output.add("\nonCompleted.");

        return output;
    }
}
