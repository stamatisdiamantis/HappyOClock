package com.example.xdiam0nd.happyoclock;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xdiam0nd.happyoclock.Utils.AboutFragment;


public class Main_Sector_Selection extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private ListView listView;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__sector__selection);



//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.about:
//                        menuItem.setChecked(true);
//                        displayMessage("Info...");
//                        drawerLayout.closeDrawers();
//                        return true;
//                    case R.id.developer:
//                        menuItem.setChecked(true);
//                        displayMessage("Developer...");
//                        drawerLayout.closeDrawers();
//                        return true;
//                }
//                return false;
//            }
//        });

        setupUIViews();
        initToolbar();

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {

//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
//                    new AboutFragment()).commit();
//            navigationView.setCheckedItem(R.id.about);
        }

        setupListView();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new AboutFragment()).commit();
                AlertDialog.Builder builder =new AlertDialog.Builder(Main_Sector_Selection.this);

                builder.setCancelable(true);
                builder.setTitle(R.string.kalosIr);
                builder.setMessage(R.string.welcomeMess);


                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.show();

                break;
            case R.id.developer:
                AlertDialog.Builder builder1 =new AlertDialog.Builder(Main_Sector_Selection.this);

                builder1.setCancelable(true);
                builder1.setTitle("The Developer");
                builder1.setMessage("Όνομα: Σταματής Διαμαντής \n" + "Αριθμός Μητρώου: 164784 \n" + "Email: stamatisdiamantis@hotmail.com \n");



                builder1.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder1.show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarMain);
        listView = (ListView) findViewById(R.id.lvMain);


    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Timetable App");
    }

    private void displayMessage(String message) {
        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }

    private void setupListView() {

        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,title,description);

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(Main_Sector_Selection.this,EvdomadaActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent1 = new Intent(Main_Sector_Selection.this,Mathimata.class);
                        startActivity(intent1);
                        break;
                    }
                    case 2: {
                        Intent intent2 = new Intent(Main_Sector_Selection.this,Erwtimatologio.class);
                        startActivity(intent2);
                        break;
                    }
//                    edw mporoyme na prosthesoume perisotera sto arxeio menou
//                    px to Programma ta Mathimata ktlp

                }
            }
        });

    }



    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;



        public SimpleAdapter(Context context,String[] title,String[] description)  {
            mContext=context;
            titleArray=title;
            descriptionArray=description;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {

            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {

            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_sector_selection_single_item,null);
            }
            title =(TextView) convertView.findViewById(R.id.tvMain);
            description=(TextView)convertView.findViewById(R.id.tvDescription);
            imageView= (ImageView)convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Πρόγραμμα")) {
                imageView.setImageResource(R.drawable.programma);
            }else if (titleArray[position].equalsIgnoreCase("Μαθήματα")){
                imageView.setImageResource(R.drawable.mathimata);
            }else if (titleArray[position].equalsIgnoreCase("Ερωτηματολόγιο")) {
                imageView.setImageResource(R.drawable.erwtiseis);
            }

            return convertView;
        }


    }
}
