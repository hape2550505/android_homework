package com.example.chapter3.homework;



import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private ListView listView;
    private ArrayList<String> data;
    private MyAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View view= inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = view.findViewById(R.id.list_view);
        adapter = new MyAdapter();
        data= new ArrayList<>();
        for(int i=1;i<=10;i++)
            data.add("好友"+i);
        listView.setAdapter(adapter);
        listView.setAlpha(0.0f);
        animationView=view.findViewById(R.id.animation_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animationView.playAnimation();
        getView().postDelayed(new Runnable() {
            @Override

            public void run() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(animationView,"alpha",1.0f,0.0f);
                animator.setDuration(1000);

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(listView,"alpha",0.0f,1.0f);
                animator1.setDuration(1000);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator,animator1);
                animatorSet.start();
                animationView.pauseAnimation();

            }
        }, 5000);

    }

    public class MyAdapter extends BaseAdapter
    {
        @Override
        public  int getCount()
        {
            return data.size();
        }

        @Override
        public  Object getItem(int position)
        {
            return data.get(position);
        }

        @Override
        public  long getItemId(int position)
        {
            return position;
        }

        @Override
        public  View getView(int position,View convertView,ViewGroup parent)
        {
            if(convertView==null) {
                convertView = View.inflate(parent.getContext(), R.layout.item, null);
            }
            TextView textView=(TextView)convertView.findViewById(R.id.tv_item_number);
            textView.setText((String)getItem(position));
            return convertView;
        }
    }

}