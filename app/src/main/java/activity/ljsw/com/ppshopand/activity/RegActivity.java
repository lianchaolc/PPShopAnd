package activity.ljsw.com.ppshopand.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import activity.ljsw.com.ppshopand.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 注册页面
 * lc
 * 2018-12-10
 */
public class RegActivity extends BaseaActivity implements View.OnClickListener {
    @BindView(R.id.regin_phone_cet)
    EditText   regin_phone_cet;
    @BindView(R.id.regin_pwd_cet)
    EditText regin_pwd_cet;
    @BindView(R.id.regin_btn_regin)
    EditText regin_btn_regin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        initvView();
    }
public  void  initvView(){

}
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regin_btn_regin:
//                账户名称
           String   phone=     regin_phone_cet.getText().toString().trim();
                String   password  = regin_pwd_cet.getText().toString().trim();
                if(phone.equals("")&&password.equals("")){
                    Toast.makeText(RegActivity.this,"账户秘密不能为null",1000).show();
                    return;
                }else{
                    innetrequest();


                }



                break;
            case 2:
                break;
        }
    }

    /***
     * 网络请求获取上传数据
     */
    private void innetrequest() {



    }
}
