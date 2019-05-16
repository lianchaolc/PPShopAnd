package activity.ljsw.com.ppshopand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import activity.ljsw.com.ppshopand.activity.LoginActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 项目主要暂时以商城为主 和其他一些辅助功能保存数据等
 * lc
 * 2018_12_1
 * 引导页面
 */
public class MainActivity extends Activity {
    @BindView(R.id.guid_iv)// 单个控件绑定
    ImageView  MainIvGuid;//引导页动画
    @BindView(R.id.tvtime)
     TextView MainTvTime;

    Timer timer = new Timer();
    int    time=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//绑定控件

        InitView();
    }

    private void InitView() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time --;
                        MainTvTime.setText("已发送(" + String.valueOf(time) + ")");

                        if (time <= 0) {
                            MainTvTime.setEnabled(true);
                            MainTvTime.setText(""+time);
                            Intent mintent=new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(mintent);
                            MainActivity.this.finish();
                            timer.cancel();
                        }
                    }
                });
            }
        };
        timer.schedule(task, time, 1000);

    }

    @OnClick({R.id.guid_iv})
    public void click(View view){

    }

}
