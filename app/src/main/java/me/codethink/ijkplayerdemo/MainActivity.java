package me.codethink.ijkplayerdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {
    IjkVideoView mIjkVideoView = null;
    FrameLayout container = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        container = (FrameLayout) findViewById(R.id.container);

        mIjkVideoView = (IjkVideoView)findViewById(R.id.video_view);
        mIjkVideoView.setRender(IjkVideoView.RENDER_TEXTURE_VIEW);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                mIjkVideoView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//                    mIjkVideoView.setRotation(90);
//                container.setRotation(90);


//                int w = container.getWidth();
//                int h = container.getHeight();
//
//                container.setRotation(270.0f);
//                container.setTranslationX((w - h) / 2);
//                container.setTranslationY((h - w) / 2);
//
//                ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) container.getLayoutParams();
//                lp.height = w;
//                lp.width = h;
//                container.requestLayout();
                mIjkVideoView.toggleFullscreen();


            }
        });



        mIjkVideoView.setVideoURI(Uri.parse("http://7xli8r.com5.z0.glb.qiniucdn.com/zuiehehee11000k"));
        mIjkVideoView.start();
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
}
