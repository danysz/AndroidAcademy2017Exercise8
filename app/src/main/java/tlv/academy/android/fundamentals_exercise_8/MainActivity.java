package tlv.academy.android.fundamentals_exercise_8;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_PROGRESS = "message_progress";

    private Context mContext;

    private Button mButtonDownload;
    private ReceiverProgress mReceiverProgress;
    private TextView mTextViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        setContentView(R.layout.activity_main);

        mTextViewProgress = findViewById(R.id.textProgress);

        mButtonDownload = findViewById(R.id.buttonStartDownload);

        mButtonDownload.setOnClickListener( OnClickDownload);

        initReceiver();
    }

    private void initReceiver(){

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MESSAGE_PROGRESS);

        mReceiverProgress = new ReceiverProgress();

        mReceiverProgress.setTextViewProgress( mTextViewProgress);
        bManager.registerReceiver(mReceiverProgress, intentFilter);

    }

    private View.OnClickListener OnClickDownload = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doStartDownload();
        }
    };

    private void doStartDownload(){
//        IntentServiceDownload.startActionDownload( mContext, "5MB");
//        IntentServiceDownload.startActionDownload( mContext, "Node-Android-Chat");
        IntentServiceDownload.startActionDownload( mContext, "SpeedTest_16MB");


//
//        Intent intent = new Intent(this, IntentServiceDownload.class);
//        intent.putExtra( EXTRA_PARAM_FILE_NAME, "20MB");
//        startService(intent);
    }
}
