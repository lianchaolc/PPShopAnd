package activity.ljsw.com.ppshopand.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import activity.ljsw.com.ppshopand.R;
import activity.ljsw.com.ppshopand.application.ShopAndApplication;
import activity.ljsw.com.ppshopand.entity.User;
import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lianchao on 2019/2/14.
 */


/***
 * 自己页面 仿制淘宝
 */
public class MineFragment   extends BaseFragment {

    @Nullable
    @BindView(R.id.min_civ)
    CircleImageView CalendarView1;

  @BindView(R.id.min_btn_outlogin)
    Button  bntoutlogin;
    @Override
    protected void init() {

    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_min, container, false);
        bntoutlogin= (Button) view.findViewById(R.id.min_btn_outlogin);
        CalendarView1= (CircleImageView) view.findViewById(R.id.min_civ);
        initView();
        loadData();
        return view;
    }

    private void loadData() {

    }

    /***
     * 组建初始化
     */
    private void initView() {
        showUI();
    }

    private void showUI() {
        ShopAndApplication sapl=new ShopAndApplication();
      User  user= sapl.getUser();
        if(user==null){
            bntoutlogin.setVisibility(View.GONE);
            CalendarView1.setImageResource(R.drawable.default_head);
//            mUsernameTV.setText(R.string.to_login);
        }

    }


}
