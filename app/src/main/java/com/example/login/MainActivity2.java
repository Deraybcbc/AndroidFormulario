package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.login.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*
        ImageView imagen = findViewById(R.id.Nissan);

        // Configura un OnClickListener para el ImageView
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código a ejecutar cuando se hace clic en la imagen
                Toast.makeText(MainActivity2.this, "Es un Nissan Skyline", Toast.LENGTH_SHORT).show();
            }
        });*/



        String Bienvenida = getIntent().getStringExtra("Usuario");

        Toast toast = Toast.makeText(this,"Bienvenido "+Bienvenida,Toast.LENGTH_LONG);
        toast.show();

        FloatingActionButton volver = (FloatingActionButton) findViewById(R.id.Atras);

        volver.setOnClickListener(this);

        Button boto = (Button) findViewById(R.id.button_first);

        boto.setOnClickListener(this::onClick);
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

        Intent intent2 = new Intent(this,formulario.class);
        startActivity(intent2);

    }

}