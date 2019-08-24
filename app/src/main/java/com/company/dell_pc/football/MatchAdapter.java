package com.company.dell_pc.football;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    Post post;
    Context context;

    public MatchAdapter(Post post, Context context) {
        this.post = post;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtournament, tvteam1, tvteam2, tvmatch_status, tvtoss, tvbatsman, tvbowlers;
        ImageView iv1,iv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtournament = (TextView) itemView.findViewById(R.id.tvtournament);
            tvteam1 = (TextView) itemView.findViewById(R.id.tvteam1);
            tvteam2 = (TextView) itemView.findViewById(R.id.tvteam2);
            tvtoss = (TextView) itemView.findViewById(R.id.tvtoss);
            tvbatsman = (TextView) itemView.findViewById(R.id.tvBatsman);
            tvbowlers = (TextView) itemView.findViewById(R.id.tvbowlers);
            tvmatch_status = (TextView) itemView.findViewById(R.id.tvmatch_status);
            iv1 = (ImageView) itemView.findViewById(R.id.iv1);
            iv2 = (ImageView) itemView.findViewById(R.id.iv2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

    @NonNull

    @Override
    public MatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchAdapter.ViewHolder viewHolder, int i) {
        List<Batsman> batsmans;
        batsmans = post.getMatches().get(i).getBatsman();
        if (batsmans != null) {
            for (Batsman batsman : batsmans) {
                String use = "";
                use += batsman.getName() + "(" + batsman.getR() + ")" + " , ";
                viewHolder.tvbatsman.append(use);
            }
        }
        List<Bowler> bowlers;
        bowlers = post.getMatches().get(i).getBowler();
        if (bowlers != null) {
            for (Bowler bowler : bowlers) {
                String use = "";
                use += bowler.getName() + "(" + bowler.getW() + ")" + " , ";
                viewHolder.tvbowlers.append(use);
            }

        }

        String team1_text = post.getMatches().get(i).getTeam1().getName().toUpperCase();
        String team2_text = post.getMatches().get(i).getTeam2().getName().toUpperCase();
        viewHolder.tvtournament.setText(post.getMatches().get(i).getSeriesName());
        viewHolder.tvteam1.setText(team1_text);
        viewHolder.tvteam2.setText(team2_text);
        viewHolder.tvmatch_status.setText(post.getMatches().get(i).getHeader().getStatus());
        viewHolder.tvtoss.setText(post.getMatches().get(i).getHeader().getToss() + " Type" + post.getMatches().get(i).getHeader().getType());
        if(team1_text=="INDIA")
        {
            Glide.with(context).load(R.drawable.ind).into(viewHolder.iv1);
        }
        else if(team1_text=="AUSTRALIA")
        {
            Glide.with(context).load(R.drawable.aus).into(viewHolder.iv1);
        }
        else if(team1_text=="ENGLAND")
        {
            Glide.with(context).load(R.drawable.eng).into(viewHolder.iv1);
        }
        else if(team1_text=="AFGANISTAN")
        {
            Glide.with(context).load(R.drawable.afg).into(viewHolder.iv1);
        }
        else if(team1_text=="SRILANKA")
        {
            Glide.with(context).load(R.drawable.sri).into(viewHolder.iv1);
        }
        else if(team1_text=="IRELAND")
        {
            Glide.with(context).load(R.drawable.ire).into(viewHolder.iv1);
        }
        else if(team1_text=="SOUTH AFRICA")
        {
            Glide.with(context).load(R.drawable.sa).into(viewHolder.iv1);
        }
        else if(team1_text=="WEST INDIES")
        {
            Glide.with(context).load(R.drawable.wi).into(viewHolder.iv1);
        }
        else if(team1_text=="SCOTLAND")
        {
            Glide.with(context).load(R.drawable.sct).into(viewHolder.iv1);
        }
        else if(team1_text=="BANGLADESH")
        {
            Glide.with(context).load(R.drawable.bng).into(viewHolder.iv1);
        }
        else if(team1_text=="PAKISTAN")
        {
            Glide.with(context).load(R.drawable.pak).into(viewHolder.iv1);
        }
        else if(team1_text=="NEW ZEALAND")
        {
            Glide.with(context).load(R.drawable.nz).into(viewHolder.iv1);
        }
        else
        {
            Glide.with(context).load(R.drawable.cricketicon2).into(viewHolder.iv1);
        }
        if(team2_text=="INDIA")
        {
            Glide.with(context).load(R.drawable.ind).into(viewHolder.iv2);
        }
        else if(team2_text=="AUSTRALIA")
        {
            Glide.with(context).load(R.drawable.aus).into(viewHolder.iv2);
        }
        else if(team2_text=="ENGLAND")
        {
            Glide.with(context).load(R.drawable.eng).into(viewHolder.iv2);
        }
        else if(team2_text=="AFGANISTAN")
        {
            Glide.with(context).load(R.drawable.afg).into(viewHolder.iv2);
        }
        else if(team2_text=="SRILANKA")
        {
            Glide.with(context).load(R.drawable.sri).into(viewHolder.iv2);
        }
        else if(team2_text=="IRELAND")
        {
            Glide.with(context).load(R.drawable.ire).into(viewHolder.iv2);
        }
        else if(team2_text=="SOUTH AFRICA")
        {
            Glide.with(context).load(R.drawable.sa).into(viewHolder.iv2);
        }
        else if(team2_text=="WEST INDIES")
        {
            Glide.with(context).load(R.drawable.wi).into(viewHolder.iv2);
        }
        else if(team2_text=="SCOTLAND")
        {
            Glide.with(context).load(R.drawable.sct).into(viewHolder.iv2);
        }
        else if(team2_text=="BANGLADESH")
        {
            Glide.with(context).load(R.drawable.bng).into(viewHolder.iv2);
        }
        else if(team2_text=="PAKISTAN")
        {
            Glide.with(context).load(R.drawable.pak).into(viewHolder.iv2);
        }
        else if(team2_text=="NEW ZEALAND")
        {
            Glide.with(context).load(R.drawable.nz).into(viewHolder.iv2);
        }
        else
        {
            Glide.with(context).load(R.drawable.cricketicon2).into(viewHolder.iv2);
        }
    }

    @Override
    public int getItemCount() {
        return post.getMatches().size();
    }
}
