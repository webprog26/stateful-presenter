package com.example.webprog26.statefulpresenter;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Contract.View{


    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.sb_bar)
    SeekBar mSbBar;

    private Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new ProgressBarPresenter();
        presenter.subscribe(this, null);
        mSbBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                presenter.onProgressBarPositionChanged(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);


    }

    @Override
    public void updateTitle(@NonNull String text) {
        mTvTitle.setText(text);
    }

    @Override
    public void setProgressbarPosition(int position) {
        mSbBar.setProgress(position);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }
}
