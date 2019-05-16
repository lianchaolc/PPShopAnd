package activity.ljsw.com.ppshopand.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import activity.ljsw.com.ppshopand.application.ShopAndApplication;
import activity.ljsw.com.ppshopand.entity.User;
import activity.ljsw.com.ppshopand.widege.DialogMaker;

/**
 * Created by lianchao on 2018/12/4.
 */

public class BaseaActivity  extends AppCompatActivity implements DialogMaker.DialogCallBack{
    protected Dialog dialog;

    public void startActivity(Intent intent, boolean isNeedLogin){
        if (isNeedLogin){
            User user = ShopAndApplication.getInstance().getUser();
            if (user != null){
                super.startActivity(intent);
            }else {
                ShopAndApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(this, LoginActivity.class);
                super.startActivity(loginIntent);
            }
        }else{
            super.startActivity(intent);
        }
    }

///节省findview byid
    @SuppressWarnings("unchecked")
    protected <T extends View> T FindViewById(int rsId) {
        return (T) findViewById(rsId);
    }

    /**
     *有没有觉得Toast很长很长...每次都要敲好长一串!
     *这不,这样就可以偷懒了...
     */
    public void Toast(String str)
    {
        android.widget.Toast.makeText(this, str, android.widget.Toast.LENGTH_SHORT).show();
    }


    private void setTranslucentStatus()
    {
        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }

    }

    /**
     * 点击左侧按钮
     * 默认是退出
     */
    protected void onClickLeft() {
        finish();
    }



    @Override
    public void onButtonClicked(Dialog dialog, int position, Object tag) {

    }

    @Override
    public void onCancelDialog(Dialog dialog, Object tag) {

    }
}
