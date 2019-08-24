package com.company.dell_pc.football;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class newspostadapter extends RecyclerView.Adapter<newspostadapter.ViewHolder>{

    Context context;
    NewsPost newsPost;

    public newspostadapter(Context context, NewsPost newsPost) {
        this.context = context;
        this.newsPost = newsPost;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvtitle,tvdescription,tvcontent,tvurl;
        ImageView iv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtitle=(TextView)itemView.findViewById(R.id.tvtitle);
            tvdescription=(TextView)itemView.findViewById(R.id.tvdescription);
            tvcontent=(TextView)itemView.findViewById(R.id.tvcontent);
            tvurl=(TextView)itemView.findViewById(R.id.tvurl);
            iv=(ImageView)itemView.findViewById(R.id.iv);


        }
    }
    @NonNull
    @Override
    public newspostadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newslayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull newspostadapter.ViewHolder viewHolder, int i) {

        List<Article> articles=newsPost.getArticles();
        if(articles!=null)
        {
            viewHolder.tvcontent.setText(articles.get(i).getContent());
            viewHolder.tvdescription.setText(articles.get(i).getDescription());
            viewHolder.tvurl.setText(articles.get(i).getUrl());
            viewHolder.tvtitle.setText(articles.get(i).getTitle());
            Glide.with(context).load(articles.get(i).getUrlToImage()).into(viewHolder.iv);
        }
    }

    @Override
    public int getItemCount() {
        return newsPost.getArticles().size();
    }
}
