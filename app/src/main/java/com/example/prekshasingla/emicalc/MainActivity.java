package com.example.prekshasingla.emicalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueButton;
import com.truecaller.android.sdk.TrueClient;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueProfile;

public class MainActivity extends AppCompatActivity implements ITrueCallback {

    TrueClient mTrueClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mTrueClient = new TrueClient(this, this);

        ((TrueButton) findViewById(R.id.com_truecaller_android_sdk_truebutton)).setTrueClient(mTrueClient);


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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (mTrueClient.onActivityResult(requestCode, resultCode, data)) {
            return;
        }
    }

    @Override
    public void onSuccesProfileShared(@NonNull TrueProfile trueProfile) {


        Log.e("Phone",trueProfile.phoneNumber.toString());
        Log.e("Profile","done");

        Intent i = new Intent(this, EMIActivity.class);
        i.putExtra("Phone",trueProfile.phoneNumber.toString());
        startActivity(i);

        this.finish();
    }

    @Override
    public void onFailureProfileShared(@NonNull TrueError trueError) {

        Toast.makeText(MainActivity.this, "Please login using Truecaller first", Toast.LENGTH_SHORT).show();
    }
}
