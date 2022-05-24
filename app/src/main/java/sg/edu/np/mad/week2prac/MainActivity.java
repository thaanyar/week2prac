package sg.edu.np.mad.week2prac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


//hello

public class MainActivity extends AppCompatActivity {

    public MainActivity(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button followbutton = findViewById(R.id.button);
        User user1 = initial();
        followstatus(user1, followbutton);
        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user1.followed == false)
                {
                    user1.followed = true;
                    CharSequence followedtoasttxt = "Followed";
                    int ftoastduration = Toast.LENGTH_SHORT;
                    Toast ftoast = Toast.makeText(MainActivity.this,followedtoasttxt,ftoastduration);
                    ftoast.show();
                }
                else
                {
                    user1.followed = false;
                    CharSequence unfollowedtoasttxt = "Unfollowed";
                    int ftoastduration = Toast.LENGTH_SHORT;
                    Toast ftoast2 = Toast.makeText(MainActivity.this,unfollowedtoasttxt,ftoastduration);
                    ftoast2.show();
                }
                followstatus(user1,followbutton);
            }
        });

        Intent randomreceive = getIntent();
        int randonum = randomreceive.getIntExtra("randomnumbers",0);
        TextView randomnumtxt = findViewById(R.id.BigText);
        String numbers = "MAD" + " " + randonum;
        randomnumtxt.setText(numbers);



    }

    Button groupOne,groupTwo;
    TextView button1;

    private Bundle savedInstanceState = new Bundle();

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groupOne = findViewById(R.id.groupOne);
        groupTwo = findViewById(R.id.groupTwo);

        groupOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragement(new groupOnefrag());
            }
        });

        groupTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragement(new groupTwofrag());

            }
        });
        Object onClick;
        View v; {

        }
        Button followbutton = findViewById(R.id.button);
        User user1 = initial();
        followstatus(user1, followbutton);
        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user1.followed = user1.followed == false;
                followstatus(user1,followbutton);
            }
        });

        Button btn = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MessageGroup.class));
            }
        });



    }

    private User initial() {
        return null;
    }

    private void replaceFragement(Fragment Fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,groupOnefrag);
        fragmentTransaction.commit();

    }

    private void replaceFragement(Fragment Fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,groupTwofrag );
        fragmentTransaction.commit();

    }


    public void followstatus (User user, Button button) {
        TextView txt = button;
        if (user.followed == false) {
            txt.setText("Follow");
        } else {
            txt.setText("Unfollow");
        }
    }

    public void follow(View view) {
    }
}