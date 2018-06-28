package org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class page_2 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        inflater.inflate(R.menu.retour, menu);
        return true;
    }

    public void ComicsVine(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://comicvine.gamespot.com/")));
        Toast.makeText(getApplicationContext(),"Bonne visite", Toast.LENGTH_SHORT).show();
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
            case R.id.retour:
                Intent intent1 = new Intent(this, MainActivity.class);
                this.startActivity(intent1);
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


    public void page2(View view) {startActivity(new Intent(this,page_3.class));
    }
}
