package project.museum.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import project.museum.R;

public class Start extends AppCompatActivity {
    private String username;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Intent intent = getIntent();
        username = intent.getExtras().getString("username");

        textView = (TextView) findViewById(R.id.textViewStartUsername);
        textView.setText(textView.getText() + username);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Logged out", Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }
}
