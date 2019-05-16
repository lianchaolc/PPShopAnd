package activity.ljsw.com.ppshopand.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.google.gson.Gson;

import java.util.List;

import activity.ljsw.com.ppshopand.R;
import activity.ljsw.com.ppshopand.adapter.HomeCategoryAdapter;
import activity.ljsw.com.ppshopand.entity.msg.Banner;
import http.OkHttpHelper;

/**
 * Created by lianchao on 2019/1/4.
 * 主页面
 */

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private SliderLayout mSliderLayout;///   图片的加载框架
    private PagerIndicator mIndicator;
    private RecyclerView mRecyclerView;
    private HomeCategoryAdapter mAdapter;
    private Gson mGson = new Gson();
    private List<Banner> mBanners;
    private OkHttpHelper okHttpHelper = OkHttpHelper.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View   view=inflater.inflate(R.layout.fragment_home,container,false);

        mSliderLayout = (SliderLayout) view.findViewById(R.id.slider);
        mIndicator = (PagerIndicator) view.findViewById(R.id.custom_indicator);

        requestImages();
        initRecyclerView(view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void requestImages() {
    }

    private void initRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_rv);

//        okHttpHelper.get(Contants.API.CAMPAIGN_HOME,
//                new BaseCallback<List<HomeCampaign>>() {
//                    @Override
//                    public void onRequestBefore(Request request) {
//                    }
//
//                    @Override
//                    public void onFailure(Request request, IOException e) {
//                    }
//
//                    @Override
//                    public void onSuccess(Response response, List<HomeCampaign> homeCampaigns) {
//                        initData(homeCampaigns);
//                    }
//
//                    @Override
//                    public void onError(Response response, int code, Exception e) {
//                    }
//
//                    @Override
//                    public void onTokenError(Response response, int code) {
//                    }
//
//                    @Override
//                    public void onResponse(Response response) {
//                    }
//                });
    }
}
