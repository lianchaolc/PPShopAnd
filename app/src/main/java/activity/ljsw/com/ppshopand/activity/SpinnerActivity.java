package activity.ljsw.com.ppshopand.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import activity.ljsw.com.ppshopand.R;

public class SpinnerActivity extends AppCompatActivity {
private TextView   mTextView;
    private Spinner  mSpinner;
    private String[] datas;
     private Boolean isSpinnerFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initView();
        loadDate();
    }
    public   void  initView(){
        mSpinner=(Spinner)findViewById(R.id.mySpinnerA);
                mTextView=(TextView)findViewById(R.id.mytv);
        datas = new String[] { "张三", "李四", "王五", "赵六" };
    };
    public  void  loadDate(){
        //原生态样式,以android.R.layout.simple_spinner_dropdown_item为例，其他修改类似



        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, datas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
//        https://www.2cto.com/kf/201409/334785.html
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                if (isSpinnerFirst) {
                    //第一次初始化spinner时，不显示默认被选择的第一项即可
                    view.setVisibility(View.INVISIBLE) ;
                }
                isSpinnerFirst = false ;

                Toast.makeText(SpinnerActivity.this, "你点击的是:"+datas[pos], 1000).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }
}
