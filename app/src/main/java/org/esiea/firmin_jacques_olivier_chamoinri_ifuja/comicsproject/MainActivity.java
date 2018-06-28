package org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class MainActivity extends AppCompatActivity {

    NotificationManager notMan;
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.dc);
        builder.setContentText(getString(R.string.notif_1));
        builder.setContentTitle(getString(R.string.notif_2));
        notMan = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    public void page1(View view) {
        startActivity(new Intent(this, page_2.class));
        notMan.notify(500, builder.build());
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.Comicsvine:
                Toast.makeText(getApplicationContext(),"Bienvenue sur Comics Vine", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.Help:
                Toast.makeText(getApplicationContext(),"Un petit coup de main ?", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.Refresh:
                Toast.makeText(getApplicationContext(),"Rebelote", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.quitter:
                moveTaskToBack(true);
                Process.killProcess(Process.myPid());
                Toast.makeText(getApplicationContext(),"A la prochaine !! ^^", Toast.LENGTH_SHORT).show();
                System.exit(1);
            default:
                return super.onOptionsItemSelected(item);

        }


    }

}

