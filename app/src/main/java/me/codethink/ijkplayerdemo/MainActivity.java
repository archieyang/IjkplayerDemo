package me.codethink.ijkplayerdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    IjkVideoView mIjkVideoView = null;
    LinearLayout container = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);

        mIjkVideoView = (IjkVideoView)findViewById(R.id.video_view);
        mIjkVideoView.setRender(IjkVideoView.RENDER_TEXTURE_VIEW);


        findViewById(R.id.video_controller__screen_size).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.tv).setVisibility(View.GONE);
                ViewGroup.LayoutParams layoutParams = ((FrameLayout)findViewById(R.id.con2)).getLayoutParams();

                layoutParams.height = container.getWidth();
                findViewById(R.id.con2).requestLayout();


                int w = container.getWidth();
                int h = container.getHeight();

                container.setRotation(90);
                container.setTranslationX((w - h) / 2);
                container.setTranslationY((h - w) / 2);

                ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) container.getLayoutParams();
                lp.height = w;
                lp.width = h;
                container.requestLayout();

            }
        });

        findViewById(R.id.player_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.tv).setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams layoutParams = ((FrameLayout)findViewById(R.id.con2)).getLayoutParams();
                layoutParams.height = 609;
                findViewById(R.id.con2).requestLayout();


                int w = container.getWidth();
                int h = container.getHeight();

                container.setRotation(0);
                container.setTranslationX(0);
                container.setTranslationY(0);

                ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) container.getLayoutParams();
                lp.height = w;
                lp.width = h;
                container.requestLayout();

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
