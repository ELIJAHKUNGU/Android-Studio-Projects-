package comt.king.elijahcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button sub;
    private Button add;
    private Button div;
    private Button zero;
    private Button equal;
    private Button clear;
    private Button mutilplication;
    private TextView info;
    private  TextView results;
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
        setContentView(R.layout.activity_main2);
        setupViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "0");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "0");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                results.setText(String.valueOf(val1) + "+");
                info.setText(null);

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBSTRACTION;
                results.setText(String.valueOf(val1) + "-");
                info.setText(null);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                results.setText(String.valueOf(val1) + "/");
                info.setText(null);

            }
        });
        mutilplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                results.setText(String.valueOf(val1) + "+");
                info.setText(null);

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQU;
                results.setText(results.getText().toString() + String.valueOf(val2) + "=");
                info.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    results.setText(null);
                }
            }
        });

    }
    public void setupViews(){

        one =(Button)findViewById(R.id.btnone);
        two =(Button)findViewById(R.id.btntwo);
        three=(Button)findViewById(R.id.btnthree);
        four =(Button)findViewById(R.id.btnfour);
        five =(Button)findViewById(R.id.btnfive);
        six =(Button)findViewById(R.id.btnsix);
        seven =(Button)findViewById(R.id.btnseven);
        eight =(Button)findViewById(R.id.btneight);
        nine =(Button)findViewById(R.id.btnnine);
        zero =(Button)findViewById(R.id.btnzero);
        div =(Button)findViewById(R.id.btndiv);
        sub =(Button)findViewById(R.id.btnsub);
        add =(Button)findViewById(R.id.btnadd);
        mutilplication=(Button)findViewById(R.id.btnmutiplication);
        info=(TextView)findViewById(R.id.tvview);
        results=(TextView)findViewById(R.id.tvresults);

    }
    public void compute() {
        if (!Double.isNaN(val1))
            val2 = Double.parseDouble(info.getText().toString());
        switch (ACTION) {
            case ADDITION:
                val1 = val1 + val2;
                break;
            case SUBSTRACTION:
                val1 = val1 - val2;
                break;
            case MULTIPLICATION:
                val1 = val1 * val2;
                break;
            case DIVISION:
                val1 = val1 / val2;
                break;
            case EQU:
                break;
        }

    }
    }







