package comt.king.layouts;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button btnSubmit;
    RadioButton genderradiobutton;
    RadioGroup radioGroup;
    Button closebutton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        closebutton = (Button) findViewById(R.id.btnclose);
        builder = new AlertDialog.Builder(this);

    }

    public void SubmitGender() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradiobutton = (RadioButton) findViewById(selectedId);

        if (selectedId == -1) {
            Toast.makeText(this, "You have not slected gender", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, genderradiobutton.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    public void Closeup(View view) {
        builder.setMessage(R.string.close_app_message)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(Main2Activity.this, "You have closed this Application", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(Main2Activity.this, "the application is still on", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle(R.string.dialog_title);
        alertDialog.show();


    }
}
