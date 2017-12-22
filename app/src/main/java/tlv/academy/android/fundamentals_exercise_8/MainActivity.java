package tlv.academy.android.fundamentals_exercise_8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_PROGRESS = "message_progress";
    private Button mButtonDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonDownload = findViewById(R.id.buttonStartDownload);

        mButtonDownload.setOnClickListener( OnClickDownload);
    }

    private View.OnClickListener OnClickDownload = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doStartDownload();
        }
    };

    private void doStartDownload(){
        Intent intent = new Intent(this, IntentServiceDownload.class);
        startService(intent);
    }
}
