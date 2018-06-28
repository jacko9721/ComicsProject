package org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class page_3 extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_CHARACTER = "Name";

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_3);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        inflater.inflate(R.menu.retour, menu);
        return true;
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

    private void parseJSON() {

        String URL = "https://comicvine.gamespot.com/api/characters/?api_key=4c0a75deb958541f66786fa3cf07b0287bfdd8ef&image=name&sort=name&field_list=name&format=json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject results = jsonArray.getJSONObject(i);

                                String characterName = results.getString("name");


                                mExampleList.add(new ExampleItem(characterName));
                            }

                            mExampleAdapter = new ExampleAdapter(page_3.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(page_3.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mRequestQueue.add(request);
        Toast.makeText(getApplicationContext(),getString(R.string.toast), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ExampleItem clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_CHARACTER, clickedItem.getCharacter());

        startActivity(detailIntent);
    }
}
