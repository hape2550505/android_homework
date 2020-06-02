package chapter.android.aweme.ss.com.homework;

import java.util.LinkedList;
import java.util.Queue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Exercises1 extends AppCompatActivity {
    private static final String TAG = "xjc";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private TextView mLifecycleDisplay;





    private static Queue<String> mqueue=new LinkedList<>();

    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_homework1);
       // mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);

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
