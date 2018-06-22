package com.example.asus.hw3_catgag_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CommentsActivity extends AppCompatActivity {

    private RecyclerView recViewComments;

    private Button btnSend;
    private EditText editComment;

    ArrayList<String> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        editComment = (EditText) findViewById(R.id.edit_comment);
        btnSend = (Button) findViewById(R.id.btn_send);

        Intent intent = getIntent();
        comments = intent.getStringArrayListExtra("comments");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = String.valueOf(editComment.getText());
                comments.add(comment);
                setCommentAdapter(recViewComments, comments);
            }
        });

        setCommentAdapter(recViewComments, comments);

    }

    private void setCommentAdapter(RecyclerView recView, ArrayList<String> data) {
        recViewComments = findViewById(R.id.rec_view_comments);

        recViewComments.setLayoutManager(new LinearLayoutManager(this));
        recViewComments.setAdapter(new CommentAdapter(this, data));
    }

}
