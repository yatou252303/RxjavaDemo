package com.nuoyuan.rxdemo.transportcontrol;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Author: weichyang
 * Date:   2017/4/21
 * Description:
 */
public class Category2Operator3ScanActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "scan";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category2_transforming_observables_3_scan_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.b3_scan;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer sum, Integer item) {
                        return sum + item;
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4, 5)\n" +
                "        .scan(new Func2<Integer, Integer, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Integer sum, Integer item) {\n" +
                "                return sum + item;\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Subscriber<Integer>() {\n" +
                "            @Override\n" +
                "            public void onCompleted() {\n" +
                "                System.out.println(\"onCompleted.\");\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onError(Throwable e) {\n" +
                "                System.out.println(\"onError: \" + e.getMessage());\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onNext(Integer integer) {\n" +
                "                System.out.println(\"onNext: \" + integer);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1");
        output.add("\nonNext: 3");
        output.add("\nonNext: 6");
        output.add("\nonNext: 10");
        output.add("\nonNext: 15");
        output.add("\nonCompleted.");

        return output;
    }
}
