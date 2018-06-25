package org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class page_2 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);

    }
    public void page2(View view) {startActivity(new Intent(this,page_3.class));
    }
}
