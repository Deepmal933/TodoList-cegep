package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ArrayList<ListItem> list_item = new ArrayList<>();
    private ListView list_view;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list_item.add(new ListItem("Demo","Work"));




        list_view = findViewById(R.id.listview);
       adapter =  new ListAdapter(MainActivity.this,list_item);
       list_view.setAdapter(adapter);
       list_view.setDivider(null);
       list_view.setDividerHeight(0);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,AddList.class);
                startActivityForResult(in,1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
            if (resultCode == RESULT_OK) {
                Log.d("erre",data.getStringExtra("task").toString());

                // A contact was picked.  Here we will just display it
                // to the user.
                if(data.getStringExtra("task")!=null){
                    list_item.add(new ListItem(data.getStringExtra("task"),data.getStringExtra("category")));
                    adapter.notifyDataSetChanged();
                }

            }

    }
}



class ListAdapter extends ArrayAdapter<ListItem> {
    private final Context context;
    private ArrayList<ListItem> values = new ArrayList<>();


    public ListAdapter(Context context, ArrayList<ListItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_layout, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.todo_title);
        TextView category = (TextView) rowView.findViewById(R.id.category);

        title.setText(values.get(position).getTitle());
        category.setText(values.get(position).getCategory());
        // change the icon for Windows and iPhone

        return rowView;
    }
}