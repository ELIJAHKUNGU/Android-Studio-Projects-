package comt.king.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button backspace;
    private Button div;
    private Button add;
    private Button sub;
    private Button decimal;
    private Button modulus;
    private Button mutiplication;
    private Button answer;
    private TextView result;
    private TextView info;
    private final char ADDITION = '+';
    private final char SUBSTRACTION = '-';
    private final char DIVISION ='/';
    private final char MULTIPLICATION = '*' ;
    private final char EQU = '0';
    private double val1=Double.NaN;
    private double val2;
    private char ACTION;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        variable();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");

            }
        }); two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");

            }
        }); three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");

            }
        }); four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");

            }
        }); five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");

            }
        }); six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");

            }
        }); seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");

            }
        }); eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");

            }
        }); nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTION = ADDITION;
                result.setText(String.valueOf(val1)+ "+");
                info.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTION = SUBSTRACTION;
                result.setText(String.valueOf(val1)+ "-");
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTION = DIVISION;
                result.setText(String.valueOf(val1)+ "/");
                info.setText(null);
            }
        });
        mutiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1)+ "*");
                info.setText(null);
            }
        });
        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTION = EQU;
                result.setText(result.getText().toString()+ String.valueOf(val2) + "=");
                info.setText(null);
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info.getText().length()>0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

    }


    public void variable(){
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.btnfive);
        six=(Button)findViewById(R.id.six);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        seven=(Button)findViewById(R.id.seven);
        answer=(Button)findViewById(R.id.answer);
        div=(Button)findViewById(R.id.div);
        result= (TextView) findViewById(R.id.results);
        info= (TextView) findViewById(R.id.info);
        add=(Button)findViewById(R.id.add);
        decimal=(Button)findViewById(R.id.decimal);
        modulus=(Button)findViewById(R.id.modulus);
        mutiplication=(Button)findViewById(R.id.mutiplication);
        backspace=(Button)findViewById(R.id.btnbackspace);



    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBSTRACTION:
                    val1 = val1-val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case EQU:
                    break;

            }


        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}


