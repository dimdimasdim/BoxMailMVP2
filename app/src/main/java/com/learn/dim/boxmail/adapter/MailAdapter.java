package com.learn.dim.boxmail.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.learn.dim.boxmail.R;
import com.learn.dim.boxmail.model.MainModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by DIM on 29/03/2017.
 */

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailViewHolder> {

    private Context mContext;
    private List<MainModel> mails;
    private int rowLayout;

    public MailAdapter(Context mContext, List<MainModel> mails, int rowLayout) {
        this.mContext = mContext;
        this.mails = mails;
        this.rowLayout = rowLayout;
    }

    @Override
    public MailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MailViewHolder holder, int position) {
        MainModel mail = mails.get(position);

        holder.from.setText(mail.getFrom());
        holder.subject.setText(mail.getSubject());
        holder.message.setText(mail.getMessage());
        holder.timestamp.setText(mail.getTimestamp());
        if (TextUtils.isEmpty(mail.getPicture())){
            holder.iconText.setText(mail.getFrom().substring(0,1));

        }else {
            Glide.with(mContext).load(mail.getPicture())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imgPicture);
            holder.imgPicture.setColorFilter(null);
            holder.iconText.setVisibility(View.GONE);
        }

        if (mail.getIsImportant()){
            holder.iconStar.setImageResource(android.R.drawable.star_on);
        }else {
            holder.iconStar.setImageResource(android.R.drawable.star_off);
        }

        if (mail.getIsRead()){
            holder.from.setTypeface(null, Typeface.NORMAL);
            holder.subject.setTypeface(null, Typeface.NORMAL);
        }else{
            holder.from.setTypeface(null, Typeface.BOLD_ITALIC);
            holder.from.setTypeface(null, Typeface.BOLD);
        }
    }

    @Override
    public int getItemCount() {
        return mails.size();
    }

    public class MailViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_from) TextView from;
        @BindView(R.id.tv_subject) TextView subject;
        @BindView(R.id.tv_message) TextView message;
        @BindView(R.id.tv_time) TextView timestamp;
        @BindView(R.id.icon_text) TextView iconText;
        @BindView(R.id.pic)ImageView imgPicture;
        @BindView(R.id.star)ImageView iconStar;
        @BindView(R.id.mail_container) LinearLayout mailContainer;



        public MailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
