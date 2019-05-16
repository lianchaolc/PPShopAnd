package http;

import android.content.Context;
import android.content.Intent;

import java.io.IOException;

import activity.ljsw.com.ppshopand.activity.LoginActivity;
import activity.ljsw.com.ppshopand.util.ToastUtils;
import dmax.dialog.SpotsDialog;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by flashing on 2016/9/19.
 */
public abstract class SpotsCallBack<T> extends BaseCallback<T>{
    private Context mContext;
    private SpotsDialog mDialog;///带运动的点 的dialog  的提示框

    public SpotsCallBack(Context context) {
        this(context, "拼命加载中……");
    }

    public SpotsCallBack(Context context, String message) {
        mContext = context;
        mDialog = new SpotsDialog(mContext, message);
    }

    public void showDialog(){
        mDialog.show();
    }

    public void dissmissDialog(){
        if (mDialog != null){
            mDialog.dismiss();
        }
    }

    public void setMessage(String msg){
        mDialog.setMessage(msg);
    }

    @Override
    public void onRequestBefore(Request request) {
        showDialog();
    }

    @Override
    public void onFailure(Request request, IOException e) {
        e.printStackTrace();
        dissmissDialog();
    }

    @Override
    public void onTokenError(Response response, int code) {
        ToastUtils.show(mContext, "登陆失效重新登陆");
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
//        PhoenixApplication.getInstance().clearUser();
    }

    @Override
    public void onResponse(Response response) {
        dissmissDialog();
    }

}
