package comt.king.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView =(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem =getResources().getStringArray(R.array.programming_languages);


        final ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=adapter.getItem(position);
                Toast.makeText(MainActivity.this, "You Clicked"+value, Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();

        inflater.inflate(R.menu.main_menu,menu);
        menu.setHeaderTitle("Choose an Action");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.menuone:
               Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
               return true;
           case R.id.menutwo:
               Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
               return true;
           case R.id.menuthree:
               Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
               return true;
               default:
                   return super.onContextItemSelected(item);
       }
    }
}
