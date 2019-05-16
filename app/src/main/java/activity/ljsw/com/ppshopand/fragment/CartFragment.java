package activity.ljsw.com.ppshopand.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import activity.ljsw.com.ppshopand.R;
import butterknife.BindView;

/**
 * Created by lianchao on 2019/2/14.
 */
//购物车1
//购物车详情
public class CartFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.carchebox)
    CheckBox carchebox;
    @BindView(R.id.carfragment_recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.tvheji)
    TextView mTextTotal;
    @BindView(R.id.cart_order_btn)
    Button mBtnOrder;
    @BindView(R.id.cart_del_btn)
    Button mBtnDel;

    @Override
    protected void init() {

    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart_del_btn:
                break;
        }
    }
}
