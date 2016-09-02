package com.src.sim.cardviewapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.src.sim.cardviewapp.R;
import com.src.sim.cardviewapp.fragment.FragmentStandard;


public class MainActivity extends Activity {

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragmentStandard();
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

    // ** FRAGMENT ****************************************************************************** //
    public void showFragmentStandard() {
        FragmentStandard fragmentStandard = FragmentStandard.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_fragment_container,
                        fragmentStandard,
                        fragmentStandard.TAG)
                //.addToBackStack(FragmentListProject.TAG)
                .commit();
        Log.i(TAG, "Show Fragment [" + fragmentStandard.TAG + "].");
    }
}
