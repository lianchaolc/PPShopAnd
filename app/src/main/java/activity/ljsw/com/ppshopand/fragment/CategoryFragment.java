package activity.ljsw.com.ppshopand.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activity.ljsw.com.ppshopand.R;

/**
 * Created by lianchao on 2019/3/21.
 */

public class CategoryFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categoryfragment, container, false);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
