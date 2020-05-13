package com.example.android_422;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomAppBar bar;
    private FloatingActionButton floatingActionButton;
    private ItemsDataAdapter adapter;
    private List<Drawable> images = new ArrayList<>();
    //private TextView title = findViewById(R.id.title);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (BottomAppBar) findViewById(R.id.bar);
        setSupportActionBar(bar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        ListView listView = findViewById(R.id.listView);
        fillImages();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomItemData();
            }
        });

        adapter = new ItemsDataAdapter(this, null);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_text_small:
                //title.setTextSize(14);
                return true;
            case R.id.menu_text_medium:
                //title.setTextSize(18);
                return true;
            case R.id.menu_text_large:
                //title.setTextSize(24);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.mipmap.sym_def_app_icon));
    }

    private void generateRandomItemData() {
        adapter.addItem(new ItemData(
                images.get(0),
                "ellipsize - место в котором можно будет поставить ... если заголовок окажется супердлинным. Может быть в начале, в середине и в конце.",
                "It\'s me " + adapter.getCount()));
    }

}

