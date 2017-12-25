package tlv.academy.android.fundamentals_exercise_8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import static tlv.academy.android.fundamentals_exercise_8.MainActivity.MESSAGE_PROGRESS;

public class ReceiverProgress extends BroadcastReceiver {

    private TextView mTextViewProgress;

    public void setTextViewProgress(TextView aTextViewProgress) {
        mTextViewProgress = aTextViewProgress;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(MESSAGE_PROGRESS)){

            TransferDetails transferDetails = (TransferDetails) intent.getSerializableExtra("transfer_details");

            if (mTextViewProgress != null){
                mTextViewProgress.setText( "progress : " + String.valueOf( transferDetails.getProgress()));
            }

        }
    }
}
