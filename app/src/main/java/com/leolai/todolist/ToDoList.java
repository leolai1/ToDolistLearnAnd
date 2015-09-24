package com.leolai.todolist;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoList extends Activity implements NewItemFragment.OnFragmentInteractionListener {

    ArrayList<ToDoItem> todoItems;
    ToDoItemAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        /*ListView myList = (ListView) findViewById(R.id.myListView);
        final EditText myEdit = (EditText)findViewById(R.id.editItem);

        final ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                todoItems);
        myList.setAdapter(ad);

        myEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER ||
                        keyCode == KeyEvent.KEYCODE_ENTER) {
                        todoItems.add(myEdit.getText().toString());
                        ad.notifyDataSetChanged();
                        myEdit.setText("");
                    }
                }
                return false;
            }
        });*/

        FragmentManager mFragMag = getFragmentManager();
        TodoListFragement mTodoFrag = new TodoListFragement();
        NewItemFragment mNFrag = new NewItemFragment();
        FragmentTransaction mTransaction = mFragMag.beginTransaction();

        mTransaction.add(R.id.new_item_frag, mNFrag);
        mTransaction.add(R.id.list_frag, mTodoFrag);
        mTransaction.commit();

        todoItems = new ArrayList<ToDoItem>();
        ad = new ToDoItemAdapter(this, R.layout.todolist_item,
                todoItems);
        mTodoFrag.setListAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_to_do_list, menu);
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

    @Override
    public void  onNewItemAdded(ToDoItem nItem) {
        todoItems.add(nItem);
        ad.notifyDataSetChanged();
    }

}
