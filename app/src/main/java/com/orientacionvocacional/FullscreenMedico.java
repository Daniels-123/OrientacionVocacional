package com.orientacionvocacional;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Locale;

import idioma.varidioma;

public class FullscreenMedico extends AppCompatActivity {
    varidioma clidioma=new varidioma();
    String idioma3;
    VideoView myVideoView;
    VideoView myVideo2;

    protected TextView customFont;
    protected TextView customFont2;
    protected TextView customFont3;

    String videoSource =
            "rtsp://r5---sn-q4fl6n7s.googlevideo.com/Cj0LENy73wIaNAmP6-Imm0-QURMYDSANFC2msERXMOCoAUIASARg2YjbtbTPq6JXigELTGpqb1RJRjIzZDgM/6736CA7185E174E01D30F0758724394C354C9978.29146AF85B55F731268C399A92C8A0E340D31FF7/yt6/1/video.3gp";
    Uri uriVideoSource;

    String videoSource2=
            "rtsp://r3---sn-q4fl6n7s.googlevideo.com/Cj0LENy73wIaNAmuiIi-ZQujTxMYDSANFC2BsERXMOCoAUIASARg2YjbtbTPq6JXigELTGpqb1RJRjIzZDgM/928B9B33BBA680ABAF04C88750F205B11E552116.7E521ADC0322F091CF41CBF89DB61AE6EA1B6161/yt6/1/video.3gp";
    Uri uriVideoSource2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_medico);
        myVideoView = (VideoView) findViewById(R.id.videoView2);

        prepareVideo();


        customFont = (Button) findViewById(R.id.button4);
        Typeface font = Typeface.createFromAsset(getAssets(), "letras/gloriahallelujah.ttf");
        customFont.setTypeface(font);


        customFont2 = (Button) findViewById(R.id.button5);
        customFont2.setTypeface(font);

        customFont3 = (TextView) findViewById(R.id.textView3);
        customFont3.setTypeface(font);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FullscreenMedico.this, Profesiones.class));
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FullscreenMedico.this, ahorcadomedi.class));
            }
        });
    }

    private void prepareVideo() {


        uriVideoSource = Uri.parse(videoSource);
        uriVideoSource2 = Uri.parse(videoSource2);

        if(clidioma.idioma.equals("en")){
            myVideoView.setVideoURI(uriVideoSource);
        }
        if(clidioma.idioma.equals("es")){
            myVideoView.setVideoURI(uriVideoSource2);
        }


        myVideoView.setOnCompletionListener(myVideoViewCompletionListener);
        myVideoView.setOnPreparedListener(MyVideoViewPreparedListener);
        myVideoView.setOnErrorListener(myVideoViewErrorListener);

        myVideoView.requestFocus();
        myVideoView.start();

    }




    MediaPlayer.OnCompletionListener myVideoViewCompletionListener =
            new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer arg0) {
                    Toast.makeText(FullscreenMedico.this, "Por favor regrese a la anterior pantalla",
                            Toast.LENGTH_LONG).show();
                }
            };

    MediaPlayer.OnPreparedListener MyVideoViewPreparedListener =
            new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {

                    long duration = myVideoView.getDuration(); //in millisecond
                    Toast.makeText(FullscreenMedico.this,
                            "Se ha iniciado el video",
                            Toast.LENGTH_LONG).show();

                }
            };

    MediaPlayer.OnErrorListener myVideoViewErrorListener =
            new MediaPlayer.OnErrorListener() {

                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {

                    String errWhat = "";
                    switch (what) {
                        case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                            errWhat = "MEDIA_ERROR_UNKNOWN";
                            break;
                        case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                            errWhat = "MEDIA_ERROR_SERVER_DIED";
                            break;
                        default:
                            errWhat = "unknown what";
                    }

                    String errExtra = "";
                    switch (extra) {
                        case MediaPlayer.MEDIA_ERROR_IO:
                            errExtra = "MEDIA_ERROR_IO";
                            break;
                        case MediaPlayer.MEDIA_ERROR_MALFORMED:
                            errExtra = "MEDIA_ERROR_MALFORMED";
                            break;
                        case MediaPlayer.MEDIA_ERROR_UNSUPPORTED:
                            errExtra = "MEDIA_ERROR_UNSUPPORTED";
                            break;
                        case MediaPlayer.MEDIA_ERROR_TIMED_OUT:
                            errExtra = "MEDIA_ERROR_TIMED_OUT";
                            break;
                        default:
                            errExtra = "...others";

                    }

                    Toast.makeText(FullscreenMedico.this,
                            "Error!!!\n" +
                                    "what: " + errWhat + "\n" +
                                    "extra: " + errExtra,
                            Toast.LENGTH_LONG).show();
                    return true;
                }
            };

}

