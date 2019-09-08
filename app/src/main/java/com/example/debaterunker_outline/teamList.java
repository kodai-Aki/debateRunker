package com.example.debaterunker_outline;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.HashMap;
import java.util.TreeSet;

public class teamList extends AppCompatActivity {

    ListView teamListView;

//  ArrayAdapterを用意
    ArrayAdapter<String> teamAdapter;

//  チームネームを入力するEditTextを用意
    EditText teamNameText;

//  HashMapを宣言
    HashMap<String, String> teamHashMap;
//  TreeSetを宣言
    TreeSet<String> teamWordSet;
//  SharedPreferencesを宣言
    SharedPreferences teamPref;
//  SharedPreferencesのEditorを宣言
    SharedPreferences.Editor teamEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_team_list);

            teamListView = (ListView)findViewById(R.id.teamList);
            teamNameText = (EditText)findViewById(R.id.teamName);

//          ArrayAdapterを作成
            teamAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

//          HasMapのインスタンスを作成
            this.teamHashMap = new HashMap<>();
//          TreeSetのインスタンスを作成
            teamWordSet = new TreeSet<String>();
//          SharedPreferencesのインスタンスを作成
            teamPref = getSharedPreferences("teamName" , MODE_PRIVATE);
            teamEditor = teamPref.edit();

//          次回起動時にSetに保存した単語を取得
            teamWordSet.addAll(teamPref.getStringSet("teamWordSet", teamWordSet));

//          Setに保存したSharedPreferencesのkeyの情報をMapに追加
            for (String word : teamWordSet){
//              SharedPreferences内の日本語を取得
//              Mapに追加
                this.teamHashMap.put(word, teamPref.getString(word, null));

//              adapterに追加
                teamAdapter.add(word);
            }

//          ListViewに表示
            teamListView.setAdapter(teamAdapter);


//      ListViewを長押しした際にListViewの文字列を消去
        teamListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)teamAdapter.getItem(position);
                teamAdapter.remove(item);

                teamWordSet.clear();

                return false;
            }
        });

    }

    public void add (View v) {
//      String型の変数を宣言、EditTextに入力した内容を入れる
        String teamName = teamNameText.getText().toString();

//      Setに入力した単語をkeyとして保存
        teamWordSet.add(teamName);
//      SharedPreferencesにSetの値(単語)を追加
        teamEditor.putStringSet("teamWordSet", teamWordSet);

        teamEditor.apply();

        teamEditor.commit();
//      adapterに単語をセット
        teamAdapter.add(teamName);

        teamNameText.setText("");


    }

}