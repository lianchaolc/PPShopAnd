package activity.ljsw.com.ppshopand.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import activity.ljsw.com.ppshopand.R;
import activity.ljsw.com.ppshopand.util.ToastUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import http.OkHttpHelper;


/**
 * Created by flashing on 2016/8/21.
 *
 * 登陆页面
 */
public class LoginActivity extends BaseaActivity {
//    @BindView(R.id.toolbar)
//    PhoenixToolbar mToolbar;
    @BindView(R.id.btn_login)
    Button    btnlogin;
    @BindView(R.id.etuserName)
    EditText mEtxtPhone;
    @BindView(R.id.mEtxtPwd)
    EditText mEtxtPwd;
    private OkHttpHelper okHttpHelper = OkHttpHelper.getInstance();
//    @BindView(toolbar)
//     Toolbar mToolbar;

private RelativeLayout otherlogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initToolBar();
        otherlogin= (RelativeLayout) findViewById(R.id.otherlogin);
        otherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"三方的登陆的方法",Toast.LENGTH_LONG).show();
            }
        });
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initToolBar(){
//        mToolbar.setLeftButtonClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LoginActivity.this.finish();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick({R.id.btn_login, R.id.loginn_reg_tv})
    public void loginOrReg(View view){
        switch (view.getId()) {
            case R.id.btn_login:
                String phone = mEtxtPhone.getText().toString().trim();
                phone="admin";

                if (TextUtils.isEmpty(phone)) {
                    ToastUtils.show(this, "请输入手机号码");
                    return;
                }

                String pwd = mEtxtPwd.getText().toString().trim();
                pwd="admin";
                if (TextUtils.isEmpty(pwd)) {
                    ToastUtils.show(this, "请输入密码");
                    return;
                }

                Map<String, Object> params = new HashMap<>(2);
                params.put("phone", phone);
                params.put("password",(pwd));


                if(pwd.equals("admin")&&phone.equals("admin")){
                    Intent    intent =new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra("id","admin");
                    startActivity(intent);
                    if(dialog!=null){
                        dialog.dismiss();
                    }
                    LoginActivity.this.finish();

                }
//                okHttpHelper.post(Contants.API.LOGIN, params,
//                        new SpotsCallBack<LoginRespMsg<User>>(this) {
//                            @Override
//                            public void onSuccess(Response response, LoginRespMsg<User> userLoginRespMsg) {
////                                PhoenixApplication application = PhoenixApplication.getInstance();
//                                ShopAndApplication   saaplication=new  ShopAndApplication();
////                                saaplication.putUser(userLoginRespMsg.getData(), userLoginRespMsg.getToken());
////                                if (application.getIntent() == null) {
////                                    setResult(RESULT_OK);
////                                }else{
////                                    application.jumpToTargetActivity(LoginActivity.this);
////                                }
//                                finish();
//                            }
//
//                            @Override
//                            public void onError(Response response, int code, Exception e) {
//
//                            }
//
//                        });
                break;
            case R.id.loginn_reg_tv:
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;

        }
    }
}
