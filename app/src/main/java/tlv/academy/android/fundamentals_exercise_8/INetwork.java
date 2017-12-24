package tlv.academy.android.fundamentals_exercise_8;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by danielszasz on 22/12/2017.
 */

public interface INetwork {

    @GET("/files/{file_name}.dat")
    Call<ResponseBody> doDownloadFile(@Path("file_name") String aFileName);

}
