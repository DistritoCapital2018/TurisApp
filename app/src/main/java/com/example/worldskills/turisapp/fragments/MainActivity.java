package com.example.worldskills.turisapp.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.interfaces.InterfaceFragments;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, InterfaceFragments {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Agregar titulo fragment Inicio
        toolbar.setTitle("Inicio");
        setSupportActionBar(toolbar);


        //Rama carlos developer


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Menus nav del navigation drawer.
        Fragment miFragment = null;
        boolean fragmentTransaction = false;
        String titulo = "";

        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            miFragment = new InicioFragment();
            fragmentTransaction = true;
            titulo = "Inicio";

        } else if (id == R.id.nav_sitios) {
            miFragment = new SitioFragment();
            fragmentTransaction = true;
            titulo = "Sitios";

        } else if (id == R.id.nav_hotel) {
            miFragment = new HotelFragment();
            fragmentTransaction = true;
            titulo = "Hoteles";

        } else if (id == R.id.nav_restaurante) {
            miFragment = new RestauranteFragment();
            fragmentTransaction = true;
            titulo = "Restaurantes";

        } else if (id == R.id.nav_salir) {

        }
        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main, miFragment, null)
                    .commit();
            toolbar.setTitle(titulo);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
