package com.salcisne.androidteste.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salcisne.androidteste.R;
import com.salcisne.androidteste.model.Produto;

import java.util.ArrayList;
import java.util.List;


public class ProdutosListAdapter extends RecyclerView.Adapter<ProdutosListAdapter.ViewHolder> {
    public List<Produto> dataSet;
    public Context context;

    public ProdutosListAdapter(Context context){
        this.dataSet = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item,parent,false);
        return new ProdutosListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.produtoNome.setText("Nome: "+dataSet.get(position).getNome());
        holder.produtoLocal.setText("Local: "+dataSet.get(position).getLocal());
        holder.produtoQuandidade.setText("Quantidade: "+dataSet.get(position).getQuantidade().toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setDataSet(List<Produto> newDataSet){
        this.dataSet = newDataSet;
        this.notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public TextView produtoNome;
        public TextView produtoLocal;
        public TextView produtoQuandidade;



        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            produtoNome = (TextView) mView.findViewById(R.id.produto_nome);
            produtoLocal = (TextView) mView.findViewById(R.id.produto_local);
            produtoQuandidade = (TextView) mView.findViewById(R.id.produto_quantidade);
        }
    }

}
