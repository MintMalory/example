package ua.mintmalory.exoplayerservice;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class MainActivity extends AppCompatActivity {
    private Button mStartBtn;
    private Button mStopBtn;
    private SeekBar mProgress;

    private ExoPlayer videoPlayer;
    private PlayerControl playerControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartBtn = (Button) findViewById(R.id.start);
        mStopBtn = (Button) findViewById(R.id.stop);
        mProgress = (SeekBar) findViewById(R.id.seekBar);

        initPlayer();

        playerControl = new PlayerControl(videoPlayer);



        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerControl.start();
                mProgress.setMax(playerControl.getDuration());

//                startService(new Intent(MainActivity.this, PlayerService.class));
            }
        });

        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerControl.pause();
//                stopService(new Intent(MainActivity.this, PlayerService.class));
            }
        });


        mProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                playerControl.seekTo(seekBar.getProgress());
            }
        });

    }

    private void initPlayer() {
        Handler handler = new Handler();
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter(handler, null);


        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "ExoPlayerService"),
                bandwidthMeter);
        Uri uri = Uri.parse("http://rtmp.cdn.ua/vo.org.ua_live/_definst_/online-ru-hotbird-high/playlist.m3u8");
        MediaSource sampleSource =  new HlsMediaSource(uri, dataSourceFactory, null, null);


        /*MediaSource sampleSource = new ExtractorMediaSource(
                uri,
                new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayerService")*//*"Android-ExoPlayer"*//*, bandwidthMeter),
                new DefaultExtractorsFactory(), null, null);*/

        if (videoPlayer == null) {
            Handler mainHandler = new Handler();
            TrackSelection.Factory videoTrackSelectionFactory =
                    new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
            TrackSelector trackSelector =
                    new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);
            LoadControl loadControl = new DefaultLoadControl();
            videoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
        }

        videoPlayer.prepare(sampleSource);

        //    videoPlayer.setPlayWhenReady(true);



        /*        Handler handler = new Handler();
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter(handler, null);

        Uri uri = Uri.parse("http://rtmp.cdn.ua/vo.org.ua_live/_definst_/online-ru-hotbird-audio/playlist.m3u8");

        MediaSource sampleSource = new ExtractorMediaSource(
                uri,
                new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayerService")*/
/*"Android-ExoPlayer"*//*
,
                        bandwidthMeter),
                new DefaultExtractorsFactory(), null, null);

        if (videoPlayer == null) {
            Handler mainHandler = new Handler();
            TrackSelection.Factory videoTrackSelectionFactory =
                    new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
            TrackSelector trackSelector =
                    new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);
            LoadControl loadControl = new DefaultLoadControl();
            videoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
        }

        videoPlayer.prepare(sampleSource);

        videoPlayer.setPlayWhenReady(true);
        ((SimpleExoPlayerView) findViewById(R.id.player_view)).setPlayer(videoPlayer);

*/
    }
}
