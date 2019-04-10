package com.emon.retrofitmvvmlivedatademo2.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.emon.retrofitmvvmlivedatademo2.R;
import com.emon.retrofitmvvmlivedatademo2.model.Model;
import com.emon.retrofitmvvmlivedatademo2.view.adapter.MyAdapter;
import com.emon.retrofitmvvmlivedatademo2.viewmodel.ProjectViewModel;

import org.w3c.dom.Comment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ProjectViewModel projectViewModel;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        progressBar=findViewById(R.id.progressBarID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        projectViewModel = ViewModelProviders.of(this).get(ProjectViewModel.class);
        projectViewModel.getDataObsarvable().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(@Nullable List<Model> models) {
                recyclerView.setAdapter(new MyAdapter(MainActivity.this,models));
                if (models == null){
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}
