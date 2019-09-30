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

public class FullscreenBombero extends AppCompatActivity {
    varidioma clidioma=new varidioma();
    String idioma3;
    VideoView myVideoView;
    VideoView myVideo2;

    protected TextView customFont;
    protected TextView customFont2;
    protected TextView customFont3;

    String videoSource =
            "rtsp://r4---sn-q4f7sn7z.googlevideo.com/Cj0LENy73wIaNAmb_BLQUqUqsBMYDSANFC0Dr0RXMOCoAUIASARg2YjbtbTPq6JXigELTGpqb1RJRjIzZDgM/D56CBBD319BB967C2132E43E205340A02396B861.5F47CD876279246168E0551CFEA83A00671E635E/yt6/1/video.3gp";
    Uri uriVideoSource;

    String videoSource2=
            "rtsp://r4---sn-q4fl6ne7.googlevideo.com/Cj0LENy73wIaNAl-H-u1IrqRfRMYDSANFC3GrkRXMOCoAUIASARg2YjbtbTPq6JXigELTGpqb1RJRjIzZDgM/6C667A63788A7A2507BE66E6830793DC4D9A616C.30AA1B67E1A04F015B47495F2034AC27F3AA91E1/yt6/1/video.3gp";
    Uri uriVideoSource2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_bombero);
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
                startActivity(new Intent(FullscreenBombero.this, Profesiones.class));
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FullscreenBombero.this, ahorcadobomb.class));
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
                    Toast.makeText(FullscreenBombero.this, "Por favor regrese a la anterior pantalla",
                            Toast.LENGTH_LONG).show();
                }
            };

    MediaPlayer.OnPreparedListener MyVideoViewPreparedListener =
            new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {

                    long duration = myVideoView.getDuration(); //in millisecond
                    Toast.makeText(FullscreenBombero.this,
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

                    Toast.makeText(FullscreenBombero.this,
                            "Error!!!\n" +
                                    "what: " + errWhat + "\n" +
                                    "extra: " + errExtra,
                            Toast.LENGTH_LONG).show();
                    return true;
                }
            };

}
