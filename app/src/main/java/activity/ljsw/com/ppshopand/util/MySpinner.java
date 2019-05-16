package activity.ljsw.com.ppshopand.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.ljsw.com.ppshopand.R;


public class MySpinner extends PopupWindow {
	private View contentView;
	private ListView spinner_list;
	private List<String> list;
	private LayoutInflater inflater;
	public static String str;

	public MySpinner() {
	}

	public Handler handler1;

	public void setHandler(Handler handler1) {
		this.handler1 = handler1;
	}

	public SpinnerItemClickImp spinnerItemClick;
	

	public void setSpinnerItemClick(SpinnerItemClickImp spinnerItemClick) {
		this.spinnerItemClick = spinnerItemClick;
	}

	public interface SpinnerItemClickImp{
		void  OnItemClicK(String result);
	
	}
	
	
	
	public MySpinner(final Activity context, View parent, final TextView tv) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		contentView = inflater.inflate(R.layout.myspinner, null);
		// 设置SelectPicPopupWindow的View
		this.setContentView(contentView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(parent.getWidth());
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(parent.getHeight() * 5);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		// 设置动画
		// this.setAnimationStyle(R.anim.popupwindow_enter);
		this.setOutsideTouchable(true);

		// 这一句是为了实现弹出PopupWindow后，当点击屏幕其他部分及Back键时PopupWindow会消失，
		// 没有这一句则效果不能出来，但并不会影响背景
		this.setBackgroundDrawable(new BitmapDrawable());

		spinner_list = (ListView) contentView.findViewById(R.id.spinner_list);

		spinner_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				str = list.get(arg2);
				Log.i("", "----------str："+str);
				spinnerItemClick.OnItemClicK(str);//这种方法是实现接口的方式获取值
				tv.setText(str);

				MySpinner.this.dismiss();
			}

		});

	}

	


	/**
	 * 显示popupWindow
	 * 
	 * @param parent
	 */
	
	
	public void showPopupWindow(View parent) {
		int[] location = new int[2];
		parent.getLocationOnScreen(location);// 获得指定控件的坐标
		this.showAsDropDown(parent, 0, -10);
	}

	public void setListXJ(Activity context, List<QuanbieXinxi> strs) {
		list = new ArrayList<String>();
		for (QuanbieXinxi xinxi : strs) {
			list.add(xinxi.getQuanbieName());
		}
	}

	public void setListXJ(Activity context, List<QuanbieXinxi> strs, int size) {
		list = new ArrayList<String>();
		for (QuanbieXinxi xinxi : strs) {
			list.add(xinxi.getQuanbieName());
		}
		spinner_list.setAdapter(new mySpinnerAdapter(context, list, size));
	}



	public void setSpinnerHeight(int height) {
		this.setHeight(height);
	}

	public void setTVSize(int size) {
		View view = inflater.inflate(R.layout.spinner_title, null);
		TextView tv = (TextView) view.findViewById(R.id.spinner_tv);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
	}

	
}
	
	
