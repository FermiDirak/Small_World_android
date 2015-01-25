package manuele.bryan.small_world.Activities;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import manuele.bryan.small_world.R;
import manuele.bryan.small_world.User;


public class UserActivity extends ActionBarActivity {

    ImageView userImage;
    TextView usernameField;
    Button meetButton;
    Button chatButton;
    TextView rankField;

    User user = new User("test", "best", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("USERNAME");
            String distance = extras.getString("DISTANCE");
            int profileNumber = extras.getInt("PROFILENUMBER");

            user = new User(username, distance, profileNumber);
        }

        userImage = (ImageView) findViewById(R.id.userImage);
        usernameField = (TextView) findViewById(R.id.username);
        meetButton = (Button) findViewById(R.id.meetButton);
        chatButton = (Button) findViewById(R.id.chatButton);
        rankField = (TextView) findViewById(R.id.rankNumber);

        switch (user.image) {
            case 0:
                userImage.setImageDrawable(getResources().
                        getDrawable(R.drawable.pofile1));
                break;
            case 1:
                userImage.setImageDrawable(getResources().
                        getDrawable(R.drawable.profile2));
                break;
            case 2:
                userImage.setImageDrawable(getResources().
                        getDrawable(R.drawable.profile3));
                break;
            case 3:
                userImage.setImageDrawable(getResources().
                        getDrawable(R.drawable.profile4));
                break;
            case 4:
                userImage.setImageDrawable(getResources().
                        getDrawable(R.drawable.profile5));
                break;
            case 5:
                userImage.setImageDrawable(getResources().
                        getDrawable(R.drawable.profile6));
                break;
        }

        usernameField.setText(user.username);

        Random random = new Random();
        rankField.setText(random.nextInt(20) + "");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
