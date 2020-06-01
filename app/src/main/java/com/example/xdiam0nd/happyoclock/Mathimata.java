package com.example.xdiam0nd.happyoclock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xdiam0nd.happyoclock.Utils.LetterImageView;

public class Mathimata extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_CLASS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathimata);


        setupUIViews();
        initToolbar();
        setupListView();


    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarMathima);
        listView = (ListView) findViewById(R.id.lvMathima);
        sharedPreferences = getSharedPreferences("MY_CLASS",MODE_PRIVATE);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Μαθήματα ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {

        String[] mathima = getResources().getStringArray(R.array.Examina);

        MathimataAdapter mathimaAdapter = new MathimataAdapter(this,R.layout.activity_mathimata_single_item,mathima);

        listView.setAdapter(mathimaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                switch(position) {
                    case 0: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Α").apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS,"Εξάμηνο Β").apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Γ").apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Δ").apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Ε").apply();
                        break;
                    }
                    case 5: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο ΣΤ").apply();
                        break;
                    }
                    case 7: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Ζ").apply();
                        break;
                    }case 8: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Η").apply();
                        break;
                    }case 9: {
                        startActivity(new Intent(Mathimata.this, MathimataDetail.class));
                        sharedPreferences.edit().putString(SEL_CLASS, "Εξάμηνο Θ").apply();
                        break;
                    }
                    default: break;
                }
            }
        });

}

    public class MathimataAdapter extends ArrayAdapter {

        private int resourse;
        private LayoutInflater layoutInflater;
        private String[] mathima=new String[]{};


        public MathimataAdapter(Context context, int resourse, String[] objects)  {
            super(context,resourse,objects);
            this.resourse=resourse;
            this.mathima=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resourse,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivMathimaLetter);
                holder.tvMathima = (TextView)convertView.findViewById(R.id.tvMathimaMain);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(mathima[position].charAt(8));
            holder.tvMathima.setText(mathima[position]);

            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvMathima;
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
