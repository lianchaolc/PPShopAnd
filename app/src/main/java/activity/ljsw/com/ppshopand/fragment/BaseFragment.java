package activity.ljsw.com.ppshopand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activity.ljsw.com.ppshopand.activity.LoginActivity;
import activity.ljsw.com.ppshopand.application.ShopAndApplication;
import activity.ljsw.com.ppshopand.entity.User;
import butterknife.ButterKnife;

/**
 * Created by lianchao on 2019/1/1.
 */

/***
 * 基类baseframent   抽象的类  里面抽象的方法
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        initToolBar();
        init();
        return view;
    }
    public void startActivityForResult(Intent intent, int requestCode, boolean isNeedLogin){
        if (isNeedLogin){
            User user = ShopAndApplication.getInstance().getUser();
            if (user != null){
                super.startActivityForResult(intent, requestCode);
            }else {
                ShopAndApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                super.startActivityForResult(loginIntent, requestCode);
            }
        }else{
            super.startActivityForResult(intent, requestCode);
        }
    }
    protected abstract void init();

    /***
     * initToolBar  方法没写
     */
    protected  void initToolBar(){};

    public abstract View createView(LayoutInflater inflater, ViewGroup container,
                                    Bundle savedInstanceState);
}
