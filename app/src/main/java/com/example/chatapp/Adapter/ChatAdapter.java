package com.example.chatapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chatapp.Model.Message;
import com.example.chatapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageViewHolder> {

    private static final int MSG_LEFT = 0;
    private static final int MSG_RIGHT = 1;

    private Context context;
    private List<Message> messages;
    private String imageURL;

    private FirebaseUser firebaseUser;

    public ChatAdapter(Context context, List<Message> messages, String imageURL){
        this.context = context;
        this.messages = messages;
        this.imageURL = imageURL;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_RIGHT) {
            View view = LayoutInflater.from(context).inflate(R.layout.msg_item_right, parent, false);
            return new ChatAdapter.MessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.msg_item_left, parent, false);
            return new ChatAdapter.MessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messages.get(position);

        holder.show_message.setText(message.getMessage());

        if (imageURL.equals("default")){
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(context).load(imageURL).into(holder.profile_image);
        }

        if (position == messages.size()-1){
            boolean isBool = message.isIsseen();
            if (isBool){
                holder.txt_seen.setText(R.string.seen);
            } else {
                holder.txt_seen.setText(R.string.delivered);
            }
        } else {
            holder.txt_seen.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (messages.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_RIGHT;
        } else {
            return MSG_LEFT;
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    class MessageViewHolder extends RecyclerView.ViewHolder{

        private TextView show_message;
        private ImageView profile_image;
        private TextView txt_seen;

        MessageViewHolder(View itemView) {
            super(itemView);

            show_message = itemView.findViewById(R.id.show_my_message);
            profile_image = itemView.findViewById(R.id.profile_image);
            txt_seen = itemView.findViewById(R.id.txt_my_seen);
        }
    }


}
