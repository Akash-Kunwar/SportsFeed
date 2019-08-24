package com.company.dell_pc.football;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class footballallmatchadapter extends RecyclerView.Adapter<footballallmatchadapter.ViewHolder>{
    Context context;
    List<FootballPost> footballPosts;

    public footballallmatchadapter(Context context, List<FootballPost> footballPosts) {
        this.context = context;
        this.footballPosts = footballPosts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvleague, tvdate, tvhometownteam, tvawayteam, tvhometeamscore, tvawayteamscore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvleague=(TextView)itemView.findViewById(R.id.tvleague);
            tvdate=(TextView)itemView.findViewById(R.id.tvdate);
            tvhometownteam=(TextView)itemView.findViewById(R.id.tvhometownteam);
            tvawayteam=(TextView)itemView.findViewById(R.id.tvawayteam);
            tvhometeamscore=(TextView)itemView.findViewById(R.id.tvhometeamscore);
            tvawayteamscore=(TextView)itemView.findViewById(R.id.tvawayteamscore);
        }
    }
    @NonNull
    @Override
    public footballallmatchadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardviewfootball,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull footballallmatchadapter.ViewHolder viewHolder, int i) {
        String league,hometownteamname,awayteamname,date,hometeamscore,awayteamscore;
        league="League Name"+footballPosts.get(i).getLeagueName();
        hometownteamname="Home Team : "+footballPosts.get(i).getMatchHometeamName();
        awayteamname="Second Team : "+footballPosts.get(i).getMatchAwayteamName();
        date="Match Date"+footballPosts.get(i).getMatchDate();
        hometeamscore=footballPosts.get(i).getMatchHometeamName()+":"+footballPosts.get(i).getMatchHometeamScore();
        awayteamscore=footballPosts.get(i).getMatchAwayteamName()+":"+footballPosts.get(i).getMatchAwayteamScore();
        viewHolder.tvleague.setText(league);
        viewHolder.tvhometownteam.setText(hometownteamname);
        viewHolder.tvawayteam.setText(awayteamname);
        viewHolder.tvdate.setText(date);
        viewHolder.tvhometeamscore.setText(hometeamscore);
        viewHolder.tvawayteamscore.setText(awayteamscore);
    }

    @Override
    public int getItemCount() {
        return footballPosts.size();
    }
}
