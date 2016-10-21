package ua.mintmalory.exoplayerservice;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

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


/**
 * Created by Администратор on 20.10.2016.
 */

public class PlayerService extends Service {
    private ExoPlayer videoPlayer;
    //private MediaCodecAudioTrackRenderer audioRenderer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
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

        videoPlayer.setPlayWhenReady(true);


        /*String url = "http://player.hungama.com/mp3/Manma_Emotion_Jaage.mp3"; //Url for your mp3 file
        Uri uri = Uri.parse(url); //Convert that to uri
        videoPlayer = ExoPlayer.Factory.newInstance(1); // new Exoplayer instance, only one render, as we're playing only audio, in case of video
        // we need two renders, one for audio and one for video
        DataSource dataSource = new DefaultUriDataSource(this, TAG); // this instance is reqd to pass data to exoplayer
        ExtractorSampleSource extractorSampleSource = new ExtractorSampleSource(uri, dataSource, new DefaultAllocator(64 * 1024), 64 * 1024 * 256);
        //ExtractorSampleSource is used for mp3 or mp4, uri is passed, datasource is passed, a DefaultAllocator instance is also passed)
        // to know more about this go on exoplayers (see description for links)
        audioRenderer = new MediaCodecAudioTrackRenderer(extractorSampleSource, MediaCodecSelector.DEFAULT);
        //here we prepare audioRenderer by passing extractorSampleSource and MediaCodecSelector
        videoPlayer.prepare(audioRenderer);
        // finally we prepare player
        videoPlayer.setPlayWhenReady(true);*/



        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        videoPlayer.setPlayWhenReady(false);
        videoPlayer.release();

    }
}
