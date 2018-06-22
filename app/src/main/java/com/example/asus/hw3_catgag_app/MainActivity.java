package com.example.asus.hw3_catgag_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Post newPost = new Post("Title " + i);

            for (int j = 1; j < 50; j++) {
                Comment comment = new Comment("Comment " + j);
                newPost.addComment(comment);
            }

            posts.add(newPost);
        }
        recView = findViewById(R.id.rec_view);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(new PostAdapter(this, posts));


    }


}

