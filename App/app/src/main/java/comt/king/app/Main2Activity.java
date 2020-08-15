package comt.king.app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button buttonE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonA = (Button)findViewById(R.id.btnRed);
        buttonB = (Button)findViewById(R.id.btnGreen);
        buttonC = (Button)findViewById(R.id.btnBlue);
        buttonD = (Button)findViewById(R.id.btnYellow);
        buttonE = (Button)findViewById(R.id.btnBlack);
    }

    public void moveBack(View view) {
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }

    public void toRed(View view) {
        buttonA.setBackgroundColor(Color.RED);
        Toast.makeText(this,"Red button clicked",Toast.LENGTH_SHORT).show();

    }

    public void toGreen(View view) {
        buttonB.setBackgroundColor(Color.GREEN);
        Toast.makeText(this,"Green button clicked",Toast.LENGTH_SHORT).show();
    }

    public void toBlue(View view) {
        buttonC.setBackgroundColor(Color.BLUE);
        Toast.makeText(this,"Blue button clicked",Toast.LENGTH_SHORT).show();
    }

    public void toYellow(View view) {
        buttonD.setBackgroundColor(Color.YELLOW);
        Toast.makeText(this,"Yellow button clicked",Toast.LENGTH_SHORT).show();
    }

    public void toBlack(View view) {
        buttonE.setBackgroundColor(Color.BLACK);
        Toast.makeText(this,"Black button clicked",Toast.LENGTH_SHORT).show();
    }

    public void moveNext(View view) {
  startActivity(new Intent(Main2Activity.this,calculator.class));
    }
}
