package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.Queue;
import android.widget.LinearLayout;
/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_homework2)
      // LinearLayout rootView = findViewById(R.id.now_view);
        TextView textView = new TextView(this);
       //textView.setText("有"+getAllChildViewCount(rootView)+"个view");
     //  rootView.addView(textView);
    }

    public int getAllChildViewCount(View view) {
        int count=0;
        Queue<ViewGroup> mqueue=new LinkedList<>();
        if(!mqueue.isEmpty())
        {
            mqueue.offer((ViewGroup)view);
            while(!mqueue.isEmpty())
            {
                ViewGroup now=mqueue.poll();
                count++;
                for(int i=0;i<now.getChildCount();i++)
                {
                    if(now.getChildAt(i) instanceof  ViewGroup)
                        mqueue.offer((ViewGroup)now.getChildAt(i));
                    else
                        count++;
                }
            }
        }
        return count;
    }
    }

