package com.bizhi.xiuse;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;

public class WallpaperActivity extends AppCompatActivity {

    ImageView imageView;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallPaper();
            }
        });

        imageUrl = getIntent().getStringExtra("IMAGE_URL");
        imageView = (ImageView) findViewById(R.id.image);
        Ion.with(imageView)
                .placeholder(R.drawable.ic_launcher)
                .error(R.drawable.ic_launcher)
                .load(imageUrl);

        findViewById(R.id.set_wallpaper).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setWallPaper();
            }
        });
    }

    //设置壁纸
    public void setWallPaper() {
        try {
            WallpaperManager mWallManager = WallpaperManager.getInstance(WallpaperActivity.this);
            mWallManager.setBitmap(Ion.with(imageView).getBitmap());
            Toast.makeText(WallpaperActivity.this, "壁纸设置成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(WallpaperActivity.this, "壁纸设置失败", Toast.LENGTH_SHORT).show();
        }
    }
}
