package com.orientacionvocacional;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
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

import idioma.varidioma;

public class FullscreenIngeniero extends AppCompatActivity {
    varidioma clidioma=new varidioma();
    VideoView myVideoView;
    VideoView myVideo2;

    protected TextView customFont;
    protected TextView customFont2;
    protected TextView customFont3;

    String videoSource =
            "rtsp://r4---sn-q4fl6n7y.googlevideo.com/Cj0LENy73wIaNAlfqbr0nF6jYhMYDSANFC01sERXMOCoAUIASARg2YjbtbTPq6JXigELTGpqb1RJRjIzZDgM/34E76D53C111C45F39EE8353B4559C231A5E5E8F.D84A0F8C95038DF919AB6916A2B90DEFE3F298EE/yt6/1/video.3gp";
    Uri uriVideoSource;
    String videoSource2=
            "rtsp://r14---sn-q4fl6nee.googlevideo.com/Cj0LENy73wIaNAkjnfi7ytiBmxMYDSANFC1SsERXMOCoAUIASARg2YjbtbTPq6JXigELTGpqb1RJRjIzZDgM/B2CB15DF54E718B27C32097F7D34636B19B6EA95.45F9F7250AF7B46C018BB621399F33F643652266/yt6/1/video.3gp";
    Uri uriVideoSource2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_ingeniero);
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
                startActivity(new Intent(FullscreenIngeniero.this, Profesiones.class));
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FullscreenIngeniero.this, ahorcadoingen.class));
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
                    Toast.makeText(FullscreenIngeniero.this, "Por favor regrese a la anterior pantalla",
                            Toast.LENGTH_LONG).show();
                }
            };

    MediaPlayer.OnPreparedListener MyVideoViewPreparedListener =
            new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {

                    long duration = myVideoView.getDuration(); //in millisecond
                    Toast.makeText(FullscreenIngeniero.this,
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

                    Toast.makeText(FullscreenIngeniero.this,
                            "Error!!!\n" +
                                    "what: " + errWhat + "\n" +
                                    "extra: " + errExtra,
                            Toast.LENGTH_LONG).show();
                    return true;
                }
            };
}
