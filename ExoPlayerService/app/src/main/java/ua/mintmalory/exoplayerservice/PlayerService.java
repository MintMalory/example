package ua.mintmalory.exoplayerservice;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Util;


/**
 * Created by Администратор on 20.10.2016.
 */

public class PlayerService extends Service {
    private SimpleExoPlayer player;
    private static final int BUFFER_SEGMENT_SIZE = 64 * 1024;
    private static final int BUFFER_SEGMENT_COUNT = 256;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
/*
        // 1. Create a default TrackSelector
        Handler mainHandler = new Handler();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);

// 2. Create a default LoadControl
        LoadControl loadControl = new DefaultLoadControl();

// 3. Create the player



        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "yourApplicationName"));





     DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "yourApplicationName"), bandwidthMeter);

        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        MediaSource videoSource = new ExtractorMediaSource(Uri.parse("http://rtmp.cdn.ua/vo.org.ua_live/_definst_/online-ru-amos-high/playlist.m3u8"),
                dataSourceFactory, extractorsFactory, null, null);
*/



// String with the url of the radio you want to play
        String url = "http://rtmp.cdn.ua/vo.org.ua_live/_definst_/online-ru-amos-high/playlist.m3u8";
        Uri radioUri = Uri.parse(url);
// Settings for exoPlayer
        Allocator allocator = new DefaultAllocator(BUFFER_SEGMENT_SIZE);
        String userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        DataSource dataSource = new DefaultUriDataSource(this, null, userAgent);
        ExtractorSampleSource sampleSource = new ExtractorSampleSource(
                radioUri, dataSource, allocator, BUFFER_SEGMENT_SIZE * BUFFER_SEGMENT_COUNT);
        audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource);












        player.prepare();

        //http://rtmp.cdn.ua/vo.org.ua_live/_definst_/online-ru-amos-high/playlist.m3u8
        // player.prepare();


        player.setPlayWhenReady(true);

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.setPlayWhenReady(false);

    }
}
