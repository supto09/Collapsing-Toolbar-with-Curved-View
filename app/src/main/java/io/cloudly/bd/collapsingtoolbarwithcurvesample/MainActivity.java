package io.cloudly.bd.collapsingtoolbarwithcurvesample;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import developer.shivam.crescento.CrescentoContainer;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.crescentoContainer)
    CrescentoContainer crescentoContainer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.title_text)
    TextView titleText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float offsetAlpha = (appBarLayout.getY() / appBarLayout.getTotalScrollRange());


//                change the alpha or size depending on th scrolling
                titleText.setAlpha(1 - (offsetAlpha * -1));
                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) { //==0
                    //  Collapsed
                } else {
                    //Expanded
                }

            }


        });
    }
}
