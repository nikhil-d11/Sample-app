package com.example.sampleapp.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sampleapp.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class ChecklistActivity extends AppCompatActivity {

    ArrayList<Model> data=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button addrandom,markall,deleteselected,unmarkall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        addrandom=findViewById(R.id.button_addrandom);
        markall=findViewById(R.id.button_markall);
        unmarkall=findViewById(R.id.button_unmarkall);

        deleteselected=findViewById(R.id.button_deleteselected);

        Dataprovider dataprovider=new Dataprovider();
        data=dataprovider.getDataforRecyclerview();

        recyclerView=findViewById(R.id.recycler_checklist);
        //check reverseLayout
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        final ChecklistAdapter adapter=new ChecklistAdapter(this,data);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));

        addrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(new Model(UUID.randomUUID().toString().substring(0,6)));
                adapter.notifyItemInserted(data.size()-1);
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
                    if(itr.next().getIschecked()){
                        itr.remove();
                    }
                }
               adapter.notifyDataSetChanged();
            }
        });

    }
}