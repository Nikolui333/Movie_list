package com.semenov.movie_list.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semenov.movie_list.R;

import java.util.ArrayList;
import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GanresViewHolder> {

    private List<String> mlists;
    public static List<String> selectedValues;
    private Context mContext1;
    private RecyclerView mRecyclerV1;

    public GenresAdapter(List<String> mlists, Context mContext1, RecyclerView mRecyclerV1) {
        this.mlists = mlists;
        this.mContext1 = mContext1;
        this.mRecyclerV1 = mRecyclerV1;
    }

    @NonNull
    @Override
    public GanresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =inflater.inflate(R.layout.row_values, parent, false);
        GanresViewHolder vh = new GanresViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull GenresAdapter.GanresViewHolder holder, int position) {
        final String al=mlists.get(position);
        holder.cbactivitieslistreg.setText(al);
        holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes1);
        holder.cbactivitieslistreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cbactivitieslistreg.getBackground().getConstantState()!=v.getResources().getDrawable(R.drawable.boxes1).getConstantState()){
                    selectedValues.remove(al);
                    holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes1);
                }
                else{
                    selectedValues.add(al);
                    holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes);
                }
            }});
    }

    @Override
    public int getItemCount() {
        return  mlists.size();
    }

    public List<String> listofselectedactivites(){
        return selectedValues;
    }


    public class GanresViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        TextView cbactivitieslistreg;
        public GanresViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            cbactivitieslistreg=itemView.findViewById(R.id.textView);
            selectedValues=new ArrayList<>();
        }
    }
}
