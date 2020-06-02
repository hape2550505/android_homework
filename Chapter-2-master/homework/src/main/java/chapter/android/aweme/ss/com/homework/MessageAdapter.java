package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;


public class MessageAdapter extends  RecyclerView.Adapter<MessageAdapter.NumberViewHolder>{

    private static final String TAG = "MessageAdapter";

    private List<Message> mMessageList;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    public MessageAdapter(List <Message> messageList, ListItemClickListener listener) {
        mMessageList=messageList;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        //viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);


        viewHolder.itemView.setBackgroundColor(Color.BLACK);

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {//补全+逻辑代码
        Message message1=mMessageList.get(position);
        numberViewHolder.mTextview1.setText(message1.getTitle());

        numberViewHolder.mTextview2.setText(message1.getDescription());
        numberViewHolder.mTextview3.setText(message1.getTime());



        switch (message1.getIcon()){
            case  "TYPE_ROBOT":
                numberViewHolder.mCircleImageView.setImageResource(R.drawable.session_robot);
                break;
            case  "TYPE_GAME":
                numberViewHolder.mCircleImageView.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case  "TYPE_SYSTEM":
                numberViewHolder.mCircleImageView.setImageResource(R.drawable.session_system_notice);
                break;
            case  "TYPE_USER":
                numberViewHolder.mCircleImageView.setImageResource(R.drawable.icon_girl);
                break;
            case  "TYPE_STRANGER":
                numberViewHolder.mCircleImageView.setImageResource(R.drawable.session_stranger);
                break;

        }
        Log.d(TAG, message1.toString());
        if(message1.isOfficial())
        {
            numberViewHolder.mImageView.setImageResource(R.drawable.im_icon_notice_official);
            numberViewHolder.mImageView.setVisibility(View.VISIBLE);//被隐藏了
        }



    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final CircleImageView mCircleImageView;
        private final ImageView mImageView;
        private final TextView mTextview1;
        private final TextView mTextview2;
        private final TextView mTextview3;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            mCircleImageView = (CircleImageView) itemView.findViewById(R.id.iv_avatar);//建立关联，未实际赋值 提高复用
            mImageView = (ImageView) itemView.findViewById(R.id.robot_notice);
            mTextview1= (TextView) itemView.findViewById(R.id.tv_title);
            mTextview2= (TextView) itemView.findViewById(R.id.tv_description);
            mTextview3= (TextView) itemView.findViewById(R.id.tv_time);


            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            mTextview1.setText(String.valueOf(position));


//            viewHolderIndex.setText(String.format("ViewHolder index: %s", getAdapterPosition()));
//            int backgroundColorForViewHolder = ColorUtils.
//                    getViewHolderBackgroundColorFromInstance(itemView.getContext(), getAdapterPosition() % 10);
//            itemView.setBackgroundColor(backgroundColorForViewHolder);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}