package com.salcisne.androidteste.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salcisne.androidteste.R;
import com.salcisne.androidteste.databinding.ActivityListaProdutosBindingImpl;
import com.salcisne.androidteste.model.Produto;
import com.salcisne.androidteste.service.api.ApiModule;
import com.salcisne.androidteste.view.adapter.ProdutosListAdapter;
import com.salcisne.androidteste.viewmodel.ProdutoViewModel;

import java.util.List;

public class ListaProdutoActivity extends AppCompatActivity {

    private ProdutoViewModel viewModel;
    private ActivityListaProdutosBindingImpl binding;
    private RecyclerView produtoRecyclerView;
    private ProdutosListAdapter adapter;
    private final String baseUrl = "http://10.0.2.2:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_lista_produtos);
        binding.setLifecycleOwner(this);
        new ApiModule(baseUrl);

        adapter = new ProdutosListAdapter(this);

        setupViewModel();
        setupRecycleView();
    }

    private void setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(ProdutoViewModel.class);
        viewModel.getListaProdutos().observe(this, new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                if(produtos!=null){
                    adapter.setDataSet(produtos);
                }
            }
        });
        binding.setViewModel(viewModel);

    }

    private void setupRecycleView(){
        produtoRecyclerView = (RecyclerView) findViewById(R.id.produtos_list_rv);
        produtoRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        produtoRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(produtoRecyclerView.getContext(),linearLayoutManager.getOrientation());
        produtoRecyclerView.addItemDecoration(dividerItemDecoration);
        produtoRecyclerView.setAdapter(adapter);



    }
}
