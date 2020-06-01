package com.example.xdiam0nd.happyoclock;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.xdiam0nd.happyoclock.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String[] Deutera;
    public static String[] Triti;
    public static String[] Tetarti;
    public static String[] Pempti;
    public static String[] Paraskeui;
    public static String[] Savvato;
    public static String[] Kuriaki;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    public static String[] Time6;
    public static String[] Time7;
    private String[] PreferredDay;
    private String[] PreferredTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews() {
        listView = (ListView) findViewById(R.id.lvDayDetail);
        toolbar = (Toolbar)findViewById(R.id.ToolbarDayDetail);
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(EvdomadaActivity.sharedPreferences.getString(EvdomadaActivity.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView() {

        Deutera = getResources().getStringArray(R.array.Δευτέρα);
        Triti = getResources().getStringArray(R.array.Τρίτη);
        Tetarti = getResources().getStringArray(R.array.Τετάρτη);
        Pempti = getResources().getStringArray(R.array.Πέμπτη);
        Paraskeui = getResources().getStringArray(R.array.Παρασκευή);
        Savvato = getResources().getStringArray(R.array.Σάββατο);
        Kuriaki = getResources().getStringArray(R.array.Κυριακή);

        Time1 = getResources().getStringArray(R.array.time1);
        Time2 = getResources().getStringArray(R.array.time2);
        Time3 = getResources().getStringArray(R.array.time3);
        Time4 = getResources().getStringArray(R.array.time4);
        Time5 = getResources().getStringArray(R.array.time5);
        Time6 = getResources().getStringArray(R.array.time6);
        Time7 = getResources().getStringArray(R.array.time7);

        String selected_day = EvdomadaActivity.sharedPreferences.getString(EvdomadaActivity.SEL_DAY, null);

        if (selected_day.equalsIgnoreCase("Δευτέρα")) {
            PreferredDay = Deutera;
            PreferredTime = Time1;
        } else if (selected_day.equalsIgnoreCase("Τρίτη")) {
            PreferredDay = Triti;
            PreferredTime = Time2;
        } else if (selected_day.equalsIgnoreCase("Τετάρτη")) {
            PreferredDay = Tetarti;
            PreferredTime = Time3;
        } else if (selected_day.equalsIgnoreCase("Πέμπτη")) {
            PreferredDay = Pempti;
            PreferredTime = Time4;
        } else if (selected_day.equalsIgnoreCase("Παρασκευή")) {
            PreferredDay = Paraskeui;
            PreferredTime = Time5;
        } else if (selected_day.equalsIgnoreCase("Σάββατο")) {
            PreferredDay = Savvato;
            PreferredTime = Time6;
        } else {
            PreferredDay = Kuriaki;
            PreferredTime = Time7;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,PreferredDay,PreferredTime);
        listView.setAdapter(simpleAdapter);


    }
        public class SimpleAdapter extends BaseAdapter {

            private Context mContext;
            private LayoutInflater layoutInflater;
            private TextView subject, time;
            private String[] subjectArray;
            private String[] timeArray;
            private LetterImageView letterImageView;



            public SimpleAdapter(Context context,String[] subjectArray,String[] timeArray)  {
                mContext=context;
                this.subjectArray=subjectArray;
                this.timeArray=timeArray;
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
                    convertView = layoutInflater.inflate(R.layout.day_detail_single_item,null);
                }
                subject =(TextView) convertView.findViewById(R.id.tvSubjectDayDetails);
                time=(TextView)convertView.findViewById(R.id.tvTimeDayDetail);
                letterImageView= (LetterImageView) convertView.findViewById(R.id.ivDayDetails);

                subject.setText(subjectArray[position]);
                time.setText(timeArray[position]);

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

