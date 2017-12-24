package tlv.academy.android.fundamentals_exercise_8;

import android.app.Application;

/**
 * Created by danielszasz on 24/12/2017.
 */

public class AppExercise8 extends Application {

    public static AppExercise8 APP_INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();

        APP_INSTANCE = this;
    }
}
