package comt.king.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity {
    EditText num1;
    EditText num2;
    Button add;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        num1 = (EditText) findViewById(R.id.num1);
         num2 = (EditText) findViewById(R.id.num2);
        add = (Button) findViewById(R.id.add);
      ans = (TextView) findViewById(R.id.ans);

    }

    public void addnumber(View view) {
        int number1 ,number2,sum;
        number1=Integer.parseInt(num1.getText().toString());
        number2=Integer.parseInt(num2.getText().toString());
        sum= number1+number2;
    ans.setText(String.valueOf(sum));



    }

    public void moveBack(View view) {
        startActivity(new Intent(calculator.this,Main2Activity.class));
    }
}
