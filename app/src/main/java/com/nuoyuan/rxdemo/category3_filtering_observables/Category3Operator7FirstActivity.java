package com.nuoyuan.rxdemo.category3_filtering_observables;

import com.nuoyuan.rxdemo.base.SampleTempActivity;
import com.nuoyuan.rxdemo.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


public class Category3Operator7FirstActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "first";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category3_filtering_observables_7_first_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.c7_first;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .first()
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
        return "Observable.just(1, 2, 3, 4, 5, 6)\n" +
                "        .first()\n" +
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
        output.add("\nonCompleted.");

        return output;
    }
}
