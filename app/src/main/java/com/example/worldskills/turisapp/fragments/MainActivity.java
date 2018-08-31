package com.example.worldskills.turisapp.fragments;


import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

    //Instancio los componentes que nesecito.
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

        //Instacio el fragment a cargar especifico por defecto.
        InicioFragment inicioFragment = new InicioFragment();
        //Apenas inicie el fragment me carge el de Inicio con su respectivo contenido.
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, inicioFragment).commit();

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

            alertaSalida();

        }
        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main, miFragment, null)
                    .commit();
            toolbar.setTitle(titulo);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void alertaSalida() {
        //Creo un nuevo Alert Dialog para el usuario al momento que desee salir de la aplicación.
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());
        alertDialog.setCancelable(false);
        alertDialog.setMessage("¿Esta seguro que desea salir de la aplicación?");
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finaliza la aplicación, si presiona Aceptar.
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
