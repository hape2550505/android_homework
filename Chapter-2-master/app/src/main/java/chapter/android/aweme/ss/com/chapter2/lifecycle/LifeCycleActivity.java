package chapter.android.aweme.ss.com.chapter2.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.util.LinkedList;
import java.util.Queue;

import chapter.android.aweme.ss.com.chapter2.R;

/**
 *
 *
 */
public class LifeCycleActivity extends AppCompatActivity {
    private static final String TAG = "xjc";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private TextView mLifecycleDisplay;



    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

    public void showSaveInstance(View view) {
        startActivity(new Intent(this, SaveInstanceStateActivity.class));
    }

    public void showUpgradeDialog(View view) {
//        new AlertDialog.Builder(this)
//                .setTitle("应用升级")
//                .setMessage("抖音1.1版本升级")
//                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).create().show();
        startActivity(new Intent(this, DialogActivity.class));
    }

    private static Queue<String> mqueue=new LinkedList<>();

    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);

        mqueue.offer(ON_CREATE)  ;

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //logAndAppend(ON_RESTART);

        mqueue.offer(ON_RESTART)  ;


        //for(String q : mqueue)
         //   mLifecycleDisplay.append(q + "\n");//队列输出
    }

    @Override
    protected void onStart() {
        super.onStart();
        //logAndAppend(ON_START);

        mqueue.offer(ON_START);

       // for(String q : mqueue)
         //   mLifecycleDisplay.append(q + "\n");//队列输出
    }

    @Override
    protected void onResume() {
        super.onResume();
        //logAndAppend(ON_RESUME);
        mqueue.offer(ON_RESUME);
        mLifecycleDisplay.setText(null);

        for(String q : mqueue)
            mLifecycleDisplay.append(q + "\n");//队列输出


       // for(String q : mqueue)
       //     mLifecycleDisplay.append(q + "\n");//队列输出
    }


    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
        mqueue.offer(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend(ON_STOP);
        mqueue.offer(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndAppend(ON_DESTROY);
        mqueue.offer(ON_DESTROY);

    }

}
