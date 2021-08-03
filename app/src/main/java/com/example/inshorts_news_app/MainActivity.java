package com.example.inshorts_news_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;
    private NewsAdapter newsAdapter;
    private List<DataModel> dataItemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerContainer);
        editText = findViewById(R.id.searchEditText);
        button = findViewById(R.id.searchButton);
        setAdapter();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString()!=null){
                    callApi();
                }
            }
        });


    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(dataItemsList);
        recyclerView.setAdapter(newsAdapter);

    }

    private void callApi() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        String category = editText.getText().toString();
        apiClient.getPosts(category).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body()!= null){
                    ResponseModel responseModel = response.body();

                    dataItemsList = responseModel.getData();
                    setAdapter();
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}