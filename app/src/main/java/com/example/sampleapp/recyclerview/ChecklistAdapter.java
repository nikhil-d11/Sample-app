package com.example.sampleapp.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleapp.R;

import java.util.ArrayList;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ViewHolder>{

    private ArrayList<Model> data;
    private Context context;

    public ChecklistAdapter(Context context,ArrayList<Model> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ChecklistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.checklist_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistAdapter.ViewHolder holder, final int position) {

        final Model cur=data.get(position);

        holder.checkBox.setChecked(cur.getIschecked());
        holder.name.setText(cur.getName());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyItemRemoved(position);
                //notifyItemRangeChanged(position,data.size()-1);
            }
        });

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("testing checked",""+position);
                cur.setIschecked(isChecked);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView name;
        Button delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checklist_cell_checkbox);
            name=itemView.findViewById(R.id.checklist_cell_text);
            delete=itemView.findViewById(R.id.checklist_cell_delete);
        }
    }
}
