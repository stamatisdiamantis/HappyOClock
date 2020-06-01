package com.example.xdiam0nd.happyoclock;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xdiam0nd.happyoclock.Utils.LetterImageView;

public class MathimataDetail extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String[] Examino1;
    public static String[] Examino2;
    public static String[] Examino3;
    public static String[] Examino4;
    public static String[] Examino5;
    public static String[] Examino6;
    public static String[] Examino7;
    public static String[] Examino8;
    public static String[] Examino9;
    public static String[] Examino10;
    private String[] PreferredExamino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathimata_detail);

        setupUIViews();
        initToolbar();
        setupListView();

    }

    private void setupUIViews() {
        listView = (ListView) findViewById(R.id.lvMathimaDetail);
        toolbar = (Toolbar)findViewById(R.id.ToolbarMathimaDetail);
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Mathimata.sharedPreferences.getString(Mathimata.SEL_CLASS,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {

        Examino1 = getResources().getStringArray(R.array.Εξάμηνο1);
        Examino2 = getResources().getStringArray(R.array.Εξάμηνο2);
        Examino3 = getResources().getStringArray(R.array.Εξάμηνο3);
        Examino4 = getResources().getStringArray(R.array.Εξάμηνο4);
        Examino5 = getResources().getStringArray(R.array.Εξάμηνο5);
        Examino6 = getResources().getStringArray(R.array.Εξάμηνο6);
        Examino7 = getResources().getStringArray(R.array.Εξάμηνο7);
        Examino8 = getResources().getStringArray(R.array.Εξάμηνο8);
        Examino9 = getResources().getStringArray(R.array.Εξάμηνο9);
        Examino10 = getResources().getStringArray(R.array.Εξάμηνο10);


        String selected_examino = Mathimata.sharedPreferences.getString(Mathimata.SEL_CLASS, null);

        if (selected_examino.equalsIgnoreCase("Εξάμηνο Α")) {
            PreferredExamino = Examino1;

        } else if (selected_examino.equalsIgnoreCase("Εξάμηνο Β")) {
            PreferredExamino = Examino2;

        } else if (selected_examino.equalsIgnoreCase("Εξάμηνο Γ")) {
            PreferredExamino = Examino3;

        } else if (selected_examino.equalsIgnoreCase("Εξάμηνο Δ")) {
            PreferredExamino = Examino4;

        } else if (selected_examino.equalsIgnoreCase("Εξάμηνο Ε")) {
            PreferredExamino = Examino5;

        } else if (selected_examino.equalsIgnoreCase("Εξάμηνο ΣΤ")) {
            PreferredExamino = Examino6;

        }  else if (selected_examino.equalsIgnoreCase("Εξάμηνο Ζ")) {
            PreferredExamino = Examino7;

        }  else if (selected_examino.equalsIgnoreCase("Εξάμηνο Η")) {
            PreferredExamino = Examino8;

        }  else if (selected_examino.equalsIgnoreCase("Εξάμηνο Θ")) {
            PreferredExamino = Examino9;

        } else {
            PreferredExamino = Examino10;

        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,PreferredExamino);
        listView.setAdapter(simpleAdapter);


    }
    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject;
        private String[] subjectArray;
        private LetterImageView letterImageView;



        public SimpleAdapter(Context context,String[] subjectArray)  {
            mContext=context;
            this.subjectArray=subjectArray;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {

            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {

            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = layoutInflater.inflate(R.layout.activity_mathimata_single_item,null);
            }
            subject =(TextView) convertView.findViewById(R.id.tvMathimaMain);
            letterImageView= (LetterImageView) convertView.findViewById(R.id.ivMathimaLetter);

            subject.setText(subjectArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));


            return convertView;
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
