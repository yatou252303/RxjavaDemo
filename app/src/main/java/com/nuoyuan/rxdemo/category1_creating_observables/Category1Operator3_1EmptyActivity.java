package com.nuoyuan.rxdemo.category1_creating_observables;

import com.nuoyuan.rxdemo.base.SampleTempActivity;
import com.nuoyuan.rxdemo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


public class Category1Operator3_1EmptyActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "empty";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_31_empty_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a3_1_empty;
    }

    @Override
    protected void runSampleCode() {
        Observable.empty()
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext: " + o);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.empty()\n" +
                "                .subscribe(new Subscriber<Object>() {\n" +
                "                    @Override\n" +
                "                    public void onCompleted() {\n" +
                "                        System.out.println(\"onCompleted.\");\n" +
                "                    }\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onError(Throwable e) {\n" +
                "                        System.out.println(\"onError: \" + e.getMessage());\n" +
                "                    }\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onNext(Object o) {\n" +
                "                        System.out.println(\"onNext: \" + o);\n" +
                "                    }\n" +
                "                });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onCompleted.");

        return output;
    }
}
