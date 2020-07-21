package com.example.sampleapp.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sampleapp.R;
import com.example.sampleapp.recyclerview.ChecklistAdapter;
import com.example.sampleapp.recyclerview.Dataprovider;
import com.example.sampleapp.recyclerview.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class CheckListWithDBActivity extends AppCompatActivity {

    ArrayList<Model> data=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button addrandom,markall,deleteselected,unmarkall;
    AppDatabase database;
    ChecklistAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);


        addrandom=findViewById(R.id.button_addrandom);
        markall=findViewById(R.id.button_markall);
        unmarkall=findViewById(R.id.button_unmarkall);

        deleteselected=findViewById(R.id.button_deleteselected);


        database=AppDatabase.getInstance(this);
        recyclerView=findViewById(R.id.recycler_checklist);
        //check reverseLayout
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);



        adapter=new ChecklistAdapter(this,data);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));

        Getlist task=new Getlist();
        task.execute();

        addrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model=new Model(UUID.randomUUID().toString().substring(0,6));
                data.add(model);
                adapter.notifyItemInserted(data.size()-1);
                Log.d("testing size",""+data.size());
                InsertList insertList=new InsertList();
                insertList.execute(model);
            }
        });


        markall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int pos=0;pos<data.size();pos++){
                    data.get(pos).setIschecked(true);
                    adapter.notifyItemChanged(pos);
                }
                //adapter.notifyDataSetChanged();
                unmarkall.setVisibility(View.VISIBLE);
                markall.setVisibility(View.GONE);
            }
        });
        unmarkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int pos=0;pos<data.size();pos++){
                    data.get(pos).setIschecked(false);
                    adapter.notifyItemChanged(pos);
                }
                //adapter.notifyDataSetChanged();
                markall.setVisibility(View.VISIBLE);
                unmarkall.setVisibility(View.GONE);
            }
        });

        deleteselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<Model> itr=data.iterator();
                while (itr.hasNext()){
                    Model model=itr.next();
                    if(model.getIschecked()){
                        itr.remove();
                        DeleteList deleteList=new DeleteList();
                        deleteList.execute(model);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

    }

    class Getlist extends AsyncTask<Void,Void, List<Model>>{

        @Override
        protected List<Model> doInBackground(Void... voids) {
            return database.modelDao().getAll();
        }

        @Override
        protected void onPostExecute(List<Model> models) {
            super.onPostExecute(models);
            data.addAll(new ArrayList<Model>(models));

            //Log.d("testing data",""+data.toString());
            adapter.notifyDataSetChanged();
        }
    }

    class InsertList extends AsyncTask<Model,Void, Void>{

        @Override
        protected Void doInBackground(Model... models) {
            database.modelDao().insert(models[0]);
            return null;
        }
    }

    class DeleteList extends AsyncTask<Model,Void, Void>{

        @Override
        protected Void doInBackground(Model... models) {
            database.modelDao().delete(models[0]);
            return null;
        }
    }


}