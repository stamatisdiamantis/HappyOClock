package com.example.xdiam0nd.happyoclock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.xdiam0nd.happyoclock.Utils.LetterImageView;

import org.w3c.dom.Text;

public class EvdomadaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evdomada);

        setupUIViews();
        initToolbar();
        setupListView();

    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarWeek);
        listView = (ListView) findViewById(R.id.lvWeek);
        sharedPreferences = getSharedPreferences("MY_DAY",MODE_PRIVATE);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {

        String[] week = getResources().getStringArray(R.array.Week);

        WeekAdapter weekAdapter = new WeekAdapter(this,R.layout.activity_evdomada_single_item,week);

        listView.setAdapter(weekAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                switch(position) {
                    case 0: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Δευτέρα").apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Τρίτη").apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Τετάρτη").apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Πέμπτη").apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Παρασκευή").apply();
                        break;
                    }
                    case 5: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Σάββατο").apply();
                        break;
                    }
                    case 6: {
                        startActivity(new Intent(EvdomadaActivity.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Κυριακή").apply();
                        break;
                    }
                    default: break;
                }
            }
        });
    }

    public class WeekAdapter extends ArrayAdapter {

        private int resourse;
        private LayoutInflater layoutInflater;
        private String[] week=new String[]{};


        public WeekAdapter(Context context, int resourse, String[] objects)  {
            super(context,resourse,objects);
            this.resourse=resourse;
            this.week=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resourse,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvWeek = (TextView)convertView.findViewById(R.id.tvWeekMain);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));
            holder.tvWeek.setText(week[position]);

            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvWeek;
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
