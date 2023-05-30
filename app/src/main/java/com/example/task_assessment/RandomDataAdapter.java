package com.example.task_assessment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task_assessment.model.CategoriesItem;
import com.example.task_assessment.model.RandomDataResponse;

import java.util.List;

import retrofit2.Callback;

public class RandomDataAdapter extends RecyclerView.Adapter<RandomDataAdapter.ViewHolder>{




    private Context context;
    private List<CategoriesItem> randomDataList;

    public RandomDataAdapter(Context context, List<CategoriesItem> randomDataList) {
        this.context = context;
        this.randomDataList = randomDataList;
    }

    @NonNull
    @Override
    public RandomDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.remote_data, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomDataAdapter.ViewHolder holder,  int position) {
        CategoriesItem randomData=randomDataList.get(position);

        holder.textView1.setText(randomData.getIdCategory());
        holder.textView2.setText(randomData.getStrCategory());
        Glide.with(context)

                .load(randomDataList.get(position).getStrCategoryThumb())

                .into(holder.imageView);





    }



    @Override
    public int getItemCount() {
        return randomDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.text);

        }
    }
}
