package com.example.xdiam0nd.happyoclock;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xdiam0nd.happyoclock.Utils.LetterImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class Erwtimatologio extends AppCompatActivity {

    private Toolbar toolbar;
    private Button goToSchedule;
    private ListView listView;
    private CheckBox checkBox;





    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erwtimatologio);

        toolbar = (Toolbar) findViewById(R.id.ToolbarErwtimatologio);
        listView = (ListView) findViewById(R.id.lvErwtiseis);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        checkBox = (CheckBox) findViewById(R.id.cberwtisi);
        goToSchedule = (Button) findViewById(R.id.button3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ερωτηματολόγιο");

        setupListView();



        goToSchedule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openTimeSchedule();
            }
        });

    }



    private void setupListView() {

        String[] erwtisi = getResources().getStringArray(R.array.Erwtiseis);

        ErwtisiAdapter erwtisiAdapter = new ErwtisiAdapter(this,R.layout.activity_erwtimatologio_single_item,erwtisi);
        listView.setAdapter(erwtisiAdapter);

    }


    public void openTimeSchedule() {
        Intent intentTimeSchedule = new Intent(Erwtimatologio.this, Main_Sector_Selection.class);
        startActivity(intentTimeSchedule);
        finish();

    }




    public class ErwtisiAdapter extends ArrayAdapter {

        private int resourse;
        private LayoutInflater layoutInflater;
        private String[] erwtisi=new String[]{};



        public ErwtisiAdapter(Context context, int resourse, String[] objects)  {
            super(context,resourse,objects);
            this.resourse=resourse;
            this.erwtisi=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            final ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resourse,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.iverwtisei);
                holder.tvErwtisi = (TextView)convertView.findViewById(R.id.tvErwtisiMain);
                holder.cberwtisi = (CheckBox)convertView.findViewById(R.id.cberwtisi);



                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(erwtisi[position].charAt(0));
            holder.tvErwtisi.setText(erwtisi[position]);


            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvErwtisi;
            private CheckBox cberwtisi;
        }
    }



}


