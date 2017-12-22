package tlv.academy.android.fundamentals_exercise_8;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 */
public class IntentServiceDownload extends IntentService {
    private static final String ACTION_DOWNLOAD = "tlv.academy.android.fundamentals_exercise_8.action.DOWNLOAD";
    private static final String ACTION_UPLOAD = "tlv.academy.android.fundamentals_exercise_8.action.UPLOAD";

    // Rename parameters
    private static final String EXTRA_PARAM_FILE_NAME = "tlv.academy.android.fundamentals_exercise_8.extra.PARAM_FILE_NAME";


    public IntentServiceDownload() {
        super("IntentServiceDownload");
    }

    /**
     * Starts this service to perform action Download with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionDownload(Context context, String param1) {
        Intent intent = new Intent(context, IntentServiceDownload.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra(EXTRA_PARAM_FILE_NAME, param1);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Upload with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionUpload(Context context, String param1) {
        Intent intent = new Intent(context, IntentServiceDownload.class);
        intent.setAction(ACTION_UPLOAD);
        intent.putExtra(EXTRA_PARAM_FILE_NAME, param1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_DOWNLOAD.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM_FILE_NAME);
                handleActionDownload(param1);
            } else if (ACTION_UPLOAD.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM_FILE_NAME);
                handleActionUpload(param1);
            }
        }
    }

    private void handleActionDownload(String param1) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void handleActionUpload(String param1) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
