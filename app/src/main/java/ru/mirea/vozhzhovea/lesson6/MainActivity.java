package ru.mirea.vozhzhovea.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.vozhzhovea.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        String group = sharedPref.getString("GROUP", "unknown");
        int number = sharedPref.getInt("NUMBER_IN_GROUP", 0);
        String film = sharedPref.getString("FILM", "unknown");
        binding.editTextGroup.setText(group);
        binding.editTextNumber.setText(String.valueOf(number));
        binding.editTextFilm.setText(film);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("GROUP", binding.editTextGroup.getText().toString());
                editor.putInt("NUMBER_IN_GROUP", Integer.parseInt(binding.editTextNumber.getText().toString()));
                editor.putString("FILM", binding.editTextFilm.getText().toString());
                editor.apply();
            }
        });

    }
}