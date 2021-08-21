package com.geektech.android3_hw2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.android3_hw2.data.models.Films;
import com.geektech.android3_hw2.databinding.ItemFilmsBinding;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private final Listener listener;
    private ItemFilmsBinding binding;
    private final List<Films> list;

    public FilmsAdapter(List<Films> list, Listener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemFilmsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ItemFilmsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.getRoot().setOnClickListener(v -> listener.onClick(list.get(getAdapterPosition()).getId()));
        }

        public void onBind(Films film) {
            binding.itemTextView.setText(film.getTitle());
        }
    }

    public interface Listener {
        void onClick(String id);
    }
}
