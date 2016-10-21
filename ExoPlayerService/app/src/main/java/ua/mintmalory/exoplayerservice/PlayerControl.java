package ua.mintmalory.exoplayerservice;

import android.widget.MediaController.MediaPlayerControl;

import com.google.android.exoplayer2.ExoPlayer;

/**
 * An implementation of {@link MediaPlayerControl} for controlling an {@link ExoPlayer} instance.
 * <p>
 * This class is provided for convenience, however it is expected that most applications will
 * implement their own player controls and therefore not require this class.
 */
public class PlayerControl implements MediaPlayerControl {

    private final ExoPlayer exoPlayer;

    public PlayerControl(ExoPlayer exoPlayer) {
        this.exoPlayer = exoPlayer;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBufferPercentage() {
        return exoPlayer.getBufferedPercentage();
    }

    @Override
    public int getCurrentPosition() {
        return (int) exoPlayer.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return (int) exoPlayer.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return exoPlayer.getPlayWhenReady();
    }

    @Override
    public void start() {
        exoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void pause() {
        exoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void seekTo(int timeMillis) {
        long seekPosition= Math.min(Math.max(0, timeMillis), getDuration());
        exoPlayer.seekTo(seekPosition);
    }

}