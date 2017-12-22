package tlv.academy.android.fundamentals_exercise_8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceDownload extends Service {
    public ServiceDownload() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
