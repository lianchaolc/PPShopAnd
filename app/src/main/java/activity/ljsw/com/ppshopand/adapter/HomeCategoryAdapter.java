package activity.ljsw.com.ppshopand.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import activity.ljsw.com.ppshopand.R;

/**
 * Created by lianchao on 2019/1/4.
 * 主的适配器的类似于recycleview2
 */

public class HomeCategoryAdapter  extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {
    @Override
    public HomeCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HomeCategoryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView textTitle;
        ImageView imageViewBig;
        ImageView imageViewSmallTop;
        ImageView imageViewSmallBottom;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.title_tv);
            imageViewBig = (ImageView) itemView.findViewById(R.id.big_iv);
            imageViewSmallTop = (ImageView) itemView.findViewById(R.id.small_top_iv);
            imageViewSmallBottom = (ImageView) itemView.findViewById(R.id.small_bottom_iv);

            imageViewBig.setOnClickListener(this);
            imageViewSmallTop.setOnClickListener(this);
            imageViewSmallBottom.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
