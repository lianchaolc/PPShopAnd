package activity.ljsw.com.ppshopand.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;

import activity.ljsw.com.ppshopand.entity.User;

/**
 * Created by lianchao on 2018/12/5.
 */

public class ShopAndApplication  extends Application{

    private static ShopAndApplication mInstance;
    private User user;
    private Intent intent;

    //当前屏幕的宽高
    public int screenW = 0;
    public int screenH = 0;

    public static ShopAndApplication getInstance(){
        return mInstance;
    }

    public Intent getIntent() {
        return intent;
    }

    public void putIntent(Intent intent) {
        this.intent = intent;
    }

    @Override

    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //得到屏幕的宽度和高度
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenW = dm.widthPixels;
        screenH = dm.heightPixels;

//        Fresco.initialize(this);
//        ShareSDK.initSDK(this);
        initUser();
    }
//
    private void initUser(){
//        this.user = UserLocalData.getUser(this);
    }
//
    public User getUser(){
        return user;
    }
//
//    public void putUser(User user, String token){
//        this.user = user;
//        UserLocalData.putUser(this, user);
//        UserLocalData.putToken(this, token);
//    }
//
//    public void clearUser(){
//        this.user = null;
//        UserLocalData.clearUser(this);
//        UserLocalData.clearToken(this);
//    }
//
//    public String getToken(){
//        return UserLocalData.getToken(this);
//    }
//
//    @Override
//    public void onTerminate() {
//        super.onTerminate();
//        ShareSDK.stopSDK(this);
//    }

    public void jumpToTargetActivity(Context context) {
        context.startActivity(intent);
        intent = null;
    }
}
