package me.test.catsanddogs.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.test.catsanddogs.R;
import me.test.catsanddogs.mvp.model.ApiResponse;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<ApiResponse.ImageDescription> data;

    public void displayData(List<ApiResponse.ImageDescription> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mainView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ListViewHolder(mainView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        ApiResponse.ImageDescription currentDescription = data.get(i);
        Picasso.get().load(currentDescription.url).into((ImageView) listViewHolder.itemView.findViewById(R.id.picture));
        ((TextView)listViewHolder.itemView.findViewById(R.id.title)).setText(currentDescription.title);
    }

    @Override
    public int getItemCount() {
        if(data == null)
            return 0;
        return data.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
