package com.example.debaterunker_outline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

//public class gameListLayout_Adapter  extends ArrayAdapter<gameListLayout> {
//
//    List<gameListLayout> mGameListLayout;
//
//    public gameListLayout_Adapter(Context context, int layoutResourceId, List<gameListLayout> object){
//        super(context, layoutResourceId, object);
//
//        mGameListLayout = object;
//    }
//
//    @Override
//    public int getCount(){
//        return mGameListLayout.size();
//    }
//
//    @Override
//    public gameListLayout getItem(int position){
//        return mGameListLayout.get(position);
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent){
//        final GameList_Layout gameList_layout;
//
//        if (convertView == null){
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game_list_layout, null);
//            gameList_layout = new GameList_Layout(convertView);
//            convertView.setTag(gameList_Layout);
//        }else{
//            gameList_Layout = (GameList_layout) convertView.getTag();
//        }
//
//        return convertView;
//    }
//
//
//    public static class GameList_Layout{
//        TextView team1;
//        TextView team2;
//        TextView vote1;
//        TextView vote2;
//        TextView com1;
//        TextView com2;
//
//        public gameList_Layout(View view){
//
//            team1 = (TextView)view.findViewById(R.id.team1);
//            team2 = (TextView)view.findViewById(R.id.team2);
//            vote1 = (TextView)view.findViewById(R.id.vote1);
//            vote2 = (TextView)view.findViewById(R.id.vote2);
//            com1 = (TextView)view.findViewById(R.id.com1);
//            com2 = (TextView)view.findViewById(R.id.com2);
//
//        }
//    }
//
//}
