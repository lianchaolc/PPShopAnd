package activity.ljsw.com.ppshopand.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import activity.ljsw.com.ppshopand.R;
import activity.ljsw.com.ppshopand.entity.Tab;
import activity.ljsw.com.ppshopand.even.MessageEvent;
import activity.ljsw.com.ppshopand.fragment.CartFragment;
import activity.ljsw.com.ppshopand.fragment.CategoryFragment;
import activity.ljsw.com.ppshopand.fragment.HomeFragment;
import activity.ljsw.com.ppshopand.fragment.MineFragment;
import activity.ljsw.com.ppshopand.widege.FragmentTabHost;
import butterknife.BindView;
import butterknife.ButterKnife;
/***
 * 主页面 框架页面
 */
public class HomeActivity extends  BaseaActivity  implements View.OnClickListener {
    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>(5);
    private CartFragment cartFragment;
    private MineFragment mineFragment;
    private boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        EventBus.getDefault().register(HomeActivity.this);
        initTab();
    }

    /***
     * 框架的初始化
     */
    private void initTab() {
        Tab tab_home = new Tab(HomeFragment.class, R.drawable.selector_icon_home,
                R.string.home);
        Tab tab_category = new Tab(CategoryFragment.class, R.drawable.selector_icon_category,
              R.string.hot);
        Tab tab_cart = new Tab(CartFragment.class, R.drawable.selector_icon_cart,
                R.string.cart);
        Tab tab_mine = new Tab(MineFragment.class, R.drawable.selector_icon_mine,
                R.string.mine);
//添加
        mTabs.add(tab_home);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);

        mInflater = LayoutInflater.from(this);
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (Tab tab : mTabs){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(
                    getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));
            //参数1:设置一个菜单项，参数2:跳转到的fragment，参数3:bundle,传递的值
            mTabhost.addTab(tabSpec, tab.getFragment(), null);
        }
    }
    private View buildIndicator(Tab tab){
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.tab_indicator_icon_iv);
        TextView text = (TextView) view.findViewById(R.id.tab_indicator_title_tv);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 0:



                break;
        }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if ("pay".equals(event.getMessage())){
            b = true;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        if (b){
            mTabhost.setCurrentTab(0);
            b = false;
        }
    }
}
