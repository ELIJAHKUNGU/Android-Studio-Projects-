package comt.king.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mFname, mSname, mdno;
    Button btnadd;


    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFname = (EditText) findViewById(R.id.fname);
        mSname = (EditText) findViewById(R.id.sname);
        mdno = (EditText) findViewById(R.id.idno);
        btnadd = (Button) findViewById(R.id.btnadd);

        db = openOrCreateDatabase("DetailsDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS personreg(fname VARCHAR,sname VARCHAR,id int)");

    }

    public void Addtodb(View view) {
        String getFname = mFname.getText().toString();
        String getsname = mSname.getText().toString();
        String getid = mdno.getText().toString();
        if (getFname.isEmpty()) {
            messageDisplay("FIRST Name ERROR", "Please Enter the First Name");

        } else if (getsname.isEmpty()) {
            messageDisplay("Second NAME ERROR", "Please Enter the Second Name");

        } else if (getid.isEmpty()) {
            messageDisplay("ID NO.ERROR", "Please Enter the ID NO.");

        } else {
            db.execSQL("INSERT INTO  personreg VALUES('" + getFname + "','" + getsname + "','" + getid + "')");
            messageDisplay("Success", "All Details added successfully");
            clear();

        }


    }

    private void clear() {
        mFname.setText("");
        mSname.setText("");
        mdno.setText("");


    }

    private void messageDisplay(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.create().show();
    }

    public void ViewData(View view) {
        Cursor cursor = db.rawQuery("SELECT *FROM personreg", null);
        if (cursor.getCount() == 0) {
            messageDisplay("No Records", "Sorry , no records were found");
        } else {
            StringBuffer buffer=new StringBuffer();
            while (cursor.moveToNext()){
                buffer.append("\n");
                buffer.append("First Name:"+cursor.getString(0));
                buffer.append("\n");
                buffer.append("Second Name:"+cursor.getString(1));
                buffer.append("\n");
                buffer.append("ID NO:"+cursor.getString(2));
                buffer.append("\n");
            }
            messageDisplay("Databse Records",buffer.toString());


        }
    }

    public void DeleteData(View view) {
        String checkid=mdno.getText().toString();
        if (checkid.isEmpty()){

            messageDisplay("ID ERROR","Please fill your input");
        }else {

            Cursor cursor=db.rawQuery("SELECT * FROM personreg WHERE id='"+checkid+"'",null);
        if (cursor.moveToFirst()){
            db.execSQL("DELETE FROM personreg WHERE id='"+checkid+"'");
            messageDisplay("DELETED","Records deleted succesfully");
            clear();
        }
        }
    }
}

