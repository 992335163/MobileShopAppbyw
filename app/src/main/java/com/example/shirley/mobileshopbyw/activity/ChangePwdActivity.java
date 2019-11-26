package com.example.shirley.mobileshopbyw.activity;

import android.view.View;
import android.widget.TextView;

import com.example.shirley.mobileshopbyw.R;
import com.example.shirley.mobileshopbyw.common.BaseActivity;

public class ChangePwdActivity extends BaseActivity {

    TextView tvTitle;

    @Override
    public int getContentViewId() { return R.layout.activity_change_pwd; }

    @Override
    protected void initView() {
        super.initView();
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("修改密码");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
    }

    void close(){ finish();}
}
