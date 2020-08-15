package comt.king.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox coffee,tea,mandizi,sausage;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleMenu();
    }
    private  void handleMenu(){
        coffee=(CheckBox)findViewById(R.id.cb1);
        tea=(CheckBox)findViewById(R.id.cb2);
        mandizi=(CheckBox)findViewById(R.id.cb3);
        sausage=(CheckBox)findViewById(R.id.cb4);
        order=(Button)findViewById(R.id.btnOrder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalOrderAmount=0;
                StringBuilder result=new StringBuilder();
                result.append("selected Order is : ");
                if (coffee.isChecked()){
                    result.append("\n coffee is ksh.200");
                    totalOrderAmount+=200;

                }
                if (tea.isChecked()){
                    result.append("\n tea is ksh 100");
                    totalOrderAmount+=100;

                }
                if (mandizi.isChecked()){
                    result.append("\n mandizi is ksh .50");
                    totalOrderAmount+=50;

                }
                if (sausage.isChecked()){
                    result.append("\n sausage is ksh 80");
                    totalOrderAmount+=80;

                }
                result.append("\n Total order is ksh."+totalOrderAmount);
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void MoveNext(View view) {

    }
}
