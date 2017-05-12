package com.nuoyuan.rxdemo.category5_error_handling_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.BaseActivity;


public class Category5_ErrorHandlingOperatorsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category5_error_handling_operators);
    }

    /**
     * 5.1.1 onErrorReturn
     *
     * @param view
     */
    public void jumpToCategory5Operator1_1OnErrorReturnActivity(View view) {
        startActivity(new Intent(this, Category5Operator1_1OnErrorReturnActivity.class));
    }

    /**
     * 5.1.2 onErrorResumeNext
     *
     * @param view
     */
    public void jumpToCategory5Operator1_2OnErrorResumeNextActivity(View view) {
        startActivity(new Intent(this, Category5Operator1_2OnErrorResumeNextActivity.class));
    }

    /**
     * 5.1.3 onExceptionResumeNext
     *
     * @param view
     */
    public void jumpToCategory5Operator1_3OnExceptionResumeNextActivity(View view) {
        startActivity(new Intent(this, Category5Operator1_3OnExceptionResumeNextActivity.class));
    }

    /**
     * 5.2 retry
     *
     * @param view
     */
    public void jumpToCategory5Operator2RetryActivity(View view) {
        startActivity(new Intent(this, Category5Operator2RetryActivity.class));
    }
}
