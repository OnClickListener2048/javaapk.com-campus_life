package com.yhx.app.campus_life;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yhx.app.common.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PublisherRegisterActivity extends BaseActivity {

    @InjectView(R.id.button_back)
    Button mButtonBack;
    @InjectView(R.id.title_tv)
    TextView mTitleTv;
    @InjectView(R.id.button_right)
    Button mButtonRight;
    @InjectView(R.id.et_email)
    EditText mEtEmail;
    @InjectView(R.id.et_username)
    EditText mEtUsername;
    @InjectView(R.id.et_user_pwd)
    EditText mEtUserPwd;
    @InjectView(R.id.et_school)
    EditText mEtSchool;
    @InjectView(R.id.cb_protocol)
    CheckBox mCbProtocol;
    @InjectView(R.id.tv_user_use_protocol)
    TextView mTvUserUseProtocol;
    @InjectView(R.id.tv_warn)
    TextView mTvWarn;
    @InjectView(R.id.btn_register)
    Button mBtnRegister;
    private String mEmail;
    private String mUsername;
    private String mPassword;
    private String mCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher_register);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        mButtonRight.setVisibility(View.GONE);
    }

    @OnClick({R.id.button_back, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_back:
                this.finish();
                break;
            case R.id.btn_register:
                checkNulls();
                break;
            default:
        }
    }

    private void login() {
        OkGo.<String>get(Constants.URL + "/second-hand/add_user.do")
                .params("email", mEmail)
                .params("username", mUsername)
                .params("pwd", mPassword)
                .params("school", mCompany)
                .params("identity", 1)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        ToastUtils.showShort(response.body());
                        if ("注册成功".equals(response.body())) {
                            finish();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        ToastUtils.showShort("onError", response.body());
                    }
                });
    }

    private void checkNulls() {
        mEmail = mEtEmail.getText().toString();
        if (TextUtils.equals("", mEmail)) {
            ToastUtils.showShort("邮箱不能为空");
            return;
        }

        mUsername = mEtUsername.getText().toString();
        if (TextUtils.equals("", mUsername)) {
            ToastUtils.showShort("用户名不能为空");
            return;
        }

        mPassword = mEtUserPwd.getText().toString();
        if (TextUtils.equals("", mPassword)) {
            ToastUtils.showShort("密码不能为空");
            return;
        }

        mCompany = mEtSchool.getText().toString();
        if (TextUtils.equals("", mCompany)) {
            ToastUtils.showShort("公司名称不能为空");
            return;
        }

        if (!mCbProtocol.isChecked()) {
            ToastUtils.showShort("必须同意协议");
            return;
        }

        login();
    }
}


