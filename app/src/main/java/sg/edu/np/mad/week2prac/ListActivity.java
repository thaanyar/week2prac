package sg.edu.np.mad.week2prac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[]={R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24,R.drawable.ic_baseline_android_24};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerview);

        s1 = getResources().getStringArray(R.array.usernames);
        s2 = getResources().getStringArray(R.array.descriptions);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter( this, s1,s2, images);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageAlert = findViewById(R.id.imageView);
        imageAlert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                AlertDialog.Builder imagePopup = new AlertDialog.Builder(ListActivity.this);
                imagePopup.setTitle("Profile");
                imagePopup.setMessage("MADness");
                //imagePopup.setCancelable(true);
                imagePopup.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                imagePopup.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Random random = new Random();
                        Integer randomnumber = random.nextInt();
                        Intent passrandomIntent = new Intent(ListActivity.this,MainActivity.class);
                        passrandomIntent.putExtra("randomnumbers",randomnumber);
                        startActivity(passrandomIntent);
                    }
                });
                imagePopup.show();
            }
        });
    }
}