package com.company.dell_pc.football;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class footballmatchadapter extends RecyclerView.Adapter<footballmatchadapter.ViewHolder> {

    Context context;
    List<H2hpost> post;

    public footballmatchadapter(Context context, List<H2hpost> post) {
        this.context = context;
        this.post = post;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvleague, tvdate, tvhometownteam, tvawayteam, tvhometeamscore, tvawayteamscore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvleague = (TextView) itemView.findViewById(R.id.tvleague);
            tvdate = (TextView) itemView.findViewById(R.id.tvdate);
            tvhometownteam = (TextView) itemView.findViewById(R.id.tvhometownteam);
            tvawayteam = (TextView) itemView.findViewById(R.id.tvawayteam);
            tvhometeamscore = (TextView) itemView.findViewById(R.id.tvhometeamscore);
            tvawayteamscore = (TextView) itemView.findViewById(R.id.tvawayteamscore);
        }
    }

    @NonNull
    @Override
    public footballmatchadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardviewfootball, viewGroup, false);

        return new footballmatchadapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull footballmatchadapter.ViewHolder viewHolder, int i) {
        String leauge = "", date = "", team1 = "", team2 = "", team1score = "", team2score = "";
        leauge="League"+post.get(i).getLeagueName();
        date = "Match Date " + post.get(i).getMatchDate();
        team1 = "Home Team " + post.get(i).getMatchHometeamName();
        team2 = "Second Team " + post.get(i).getMatchAwayteamName();
        team1score = post.get(i).getMatchHometeamName() + " : "+post.get(i).getMatchHometeamScore();
        team2score =  post.get(i).getMatchAwayteamName() + " : "+ post.get(i).getMatchAwayteamScore();
        viewHolder.tvleague.setText(leauge);
        viewHolder.tvdate.setText(date);
        viewHolder.tvhometownteam.setText(team1);
        viewHolder.tvawayteam.setText(team2);
        viewHolder.tvhometeamscore.setText(team1score);
        viewHolder.tvawayteamscore.setText(team2score);
    }

    @Override
    public int getItemCount() {
       return post.size();
    }
}
