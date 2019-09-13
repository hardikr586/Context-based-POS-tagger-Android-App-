package com.example.admin.module1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.button);


    }


    public void splitt(View view)
    {

        EditText ed = (EditText)findViewById(R.id.editText);
        ListView lv = (ListView)findViewById(R.id.listview) ;
        String str = ed.getText().toString();

        Trie noun = new Trie();

        String splitstring[] = str.split(" ");
        Scanner reader = null;
        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("nouns.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }

       String nouns[] = new String[100];
        int nounsi =0;
        while(true) {

            String nextLine = reader.nextLine();

            if(nextLine == "" || nextLine ==" "|| nextLine.equals('\n'))break;
            noun.insert(nextLine);
            nounsi++;
            if(!reader.hasNext())break;

        }
        for( int i =0; i< splitstring.length;i++ ){
            int flag =0;
            for(int j =0;j<nounsi;j++){
                if(noun.search(splitstring[i])){flag =1;Log.d("eureka","eureka");break;}
            }
            if(flag == 1){
                splitstring[i] = splitstring[i] + "-noun";
                Log.d("noun",nouns[0]);
            }
        }

        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("verbs.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String verbs[] = new String[100];
        int verbsi =0;
        while(true) {

            String nextLine = reader.nextLine();

            if(nextLine == "" || nextLine ==" "|| nextLine.equals('\n'))break;
            verbs[verbsi] = nextLine;
            verbsi++;
            if(!reader.hasNext())break;

        }
        for( int i =0; i< splitstring.length;i++ ){
            int flag =0;
            for(int j =0;j<verbsi;j++){
                if( verbs[j].equals(splitstring[i])){flag =1;Log.d("eureka","eureka");break;}
            }
            if(flag == 1){
                splitstring[i] = splitstring[i] + "-verb";
                Log.d("noun",nouns[0]);
            }
        }

        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("preposition.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String prepos[] = new String[100];
        int preposi =0;
        while(true) {

            String nextLine = reader.nextLine();

            if(nextLine == "" || nextLine ==" "|| nextLine.equals('\n'))break;
            prepos[preposi] = nextLine;
            preposi++;
            if(!reader.hasNext())break;

        }
        for( int i =0; i< splitstring.length;i++ ){
            int flag =0;
            for(int j =0;j<preposi;j++){
                if( prepos[j].equals(splitstring[i])){flag =1;Log.d("eureka","eureka");break;}
            }
            if(flag == 1){
                splitstring[i] = splitstring[i] + "-preposition";
                Log.d("noun",nouns[0]);
            }
        }



        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("conjunction.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String conju[] = new String[100];
        int conjui =0;
        while(true) {

            String nextLine = reader.nextLine();

            if(nextLine == "" || nextLine ==" "|| nextLine.equals('\n'))break;
            conju[conjui] = nextLine;
            conjui++;
            if(!reader.hasNext())break;

        }
        for( int i =0; i< splitstring.length;i++ ){
            int flag =0;
            for(int j =0;j<conjui;j++){
                if( conju[j].equals(splitstring[i])){flag =1;Log.d("eureka","eureka");break;}
            }
            if(flag == 1){
                splitstring[i] = splitstring[i] + "-conjunction";
                Log.d("noun",nouns[0]);
            }
        }


        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("determiner.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String deter[] = new String[100];
        int deteri =0;
        while(true) {

            String nextLine = reader.nextLine();

            if(nextLine == "" || nextLine ==" "|| nextLine.equals('\n'))break;
            deter[deteri] = nextLine;
            deteri++;
            if(!reader.hasNext())break;

        }
        for( int i =0; i< splitstring.length;i++ ){
            int flag =0;
            for(int j =0;j<deteri;j++){
                if( deter[j].equals(splitstring[i])){flag =1;Log.d("eureka","eureka");break;}
            }
            if(flag == 1){
                splitstring[i] = splitstring[i] + "-preposition";
                Log.d("noun",nouns[0]);
            }
        }



        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("pronoun.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String prono[] = new String[100];
        int pronoi =0;
        while(true) {

            String nextLine = reader.nextLine();

            if(nextLine == "" || nextLine ==" "|| nextLine.equals('\n'))break;
            prono[pronoi] = nextLine;
            pronoi++;
            if(!reader.hasNext())break;

        }
        for( int i =0; i< splitstring.length;i++ ){
            int flag =0;
            for(int j =0;j<pronoi;j++){
                if( prono[j].equals(splitstring[i])){flag =1;Log.d("eureka","eureka");break;}
            }
            if(flag == 1){
                splitstring[i] = splitstring[i] + "-pronoun";
                Log.d("noun",nouns[0]);
            }
        }





        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, splitstring);

        lv.setAdapter(adapter);
    }
}
