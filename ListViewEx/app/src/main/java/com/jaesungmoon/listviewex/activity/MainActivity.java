package com.jaesungmoon.listviewex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jaesungmoon.listviewex.R;
import com.jaesungmoon.listviewex.model.ColorItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    private static final String KEY_NAME_ENGLISH = "name_english";
    private static final String KEY_NAME_JAPANESE = "name_japanese";
//    private static final String KEY_IMAGE_ID = "image_id";

    private static final String[] FROM = new String[] {
            KEY_NAME_ENGLISH, KEY_NAME_JAPANESE /**, KEY_IMAGE_ID */
    };
    private static final int[] TO = new int[] {
            R.id.name_english_text_view, R.id.name_japanese_text_view /**, R.id.color_image_view */
    };


    private static final List<ColorItem> COLOR_ITEM;

    static {
        COLOR_ITEM = new ArrayList<ColorItem>();
        COLOR_ITEM.add(new ColorItem("Blue", "青", 0));
        COLOR_ITEM.add(new ColorItem("Cyan", "シアン", 1));
        COLOR_ITEM.add(new ColorItem("Green", "緑", 2));
        COLOR_ITEM.add(new ColorItem("Magenta", "マゼンタ", 3));
        COLOR_ITEM.add(new ColorItem("Red", "赤", 4));
        COLOR_ITEM.add(new ColorItem("Yellow", "黄色", 5));
    }

    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });

        List<ColorItem> colorItemList = new ArrayList<>(COLOR_ITEM);
        List<Map<String, ?>> data = colorItemListToMapList(colorItemList);
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.my_list_item, FROM, TO);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    private List<Map<String, ?>> colorItemListToMapList(List<ColorItem> colorItemList) {
        List<Map<String, ?>> data = new ArrayList<Map<String, ?>>();
        for (ColorItem colorItem : colorItemList) {
            data.add(colorItemToMap(colorItem));
        }
        return data;
    }

    private Map<String, ?> colorItemToMap(ColorItem colorItem) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(KEY_NAME_ENGLISH, colorItem.getNameEnglish());
        map.put(KEY_NAME_JAPANESE, colorItem.getNameJapanese());
//        map.put(KEY_IMAGE_ID, Integer.valueOf(colorItem.getImageId()));

        return map;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, DetailActivity.class));
    }
}
