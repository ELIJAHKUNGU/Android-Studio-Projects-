package comt.king.uptempo;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.cert.Extension;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //declare variables
    Button play, pause, stop;
    MediaPlayer mediaPlayer;

    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.btnPlay);
        pause = (Button) findViewById(R.id.btnPause);
        stop = (Button) findViewById(R.id.btnStop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

//        View view = null;
        switch (v.getId()) {

            case R.id.btnPlay:
                if (mediaPlayer == null) {

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                }

                else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);

                    mediaPlayer.start();
                }
                    break;

                    case R.id.btnPause:

                        if (mediaPlayer!=null) {
                            mediaPlayer.pause();
                            pauseCurrentPosition=mediaPlayer.getCurrentPosition();

                        }
                        break;

                    case R.id.btnStop:
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer = null;

                        }
                            break;



                }
        }
    }