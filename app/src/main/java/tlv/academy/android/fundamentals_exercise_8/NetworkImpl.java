package tlv.academy.android.fundamentals_exercise_8;


import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by danielszasz on 22/12/2017.
 */

public class NetworkImpl {
    private static final String TAG = "NetworkImpl";

    private static final NetworkImpl ourInstance = new NetworkImpl();


    public static NetworkImpl getInstance() {
        return ourInstance;
    }

    private INetwork mNetworkService;

    private NetworkImpl() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://scop-sys.info")
                .build();

        mNetworkService = retrofit.create(INetwork.class);
    }

    public void doDownloadFile(String aFileName) {
        Call<ResponseBody> responseDownload = mNetworkService.doDownloadFile(aFileName);

        responseDownload.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "server contacted and has file");

                    boolean writtenToDisk = writeResponseBodyToDisk(response.body());

                    Log.d(TAG, "file download was a success? " + writtenToDisk);
                } else {
                    Log.d(TAG, "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error : " + t.getMessage());
            }
        });


    }

    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "Future Studio Icon.png");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    TransferDetails transferDetails;

                    transferDetails = new TransferDetails("", Math.round(fileSizeDownloaded * 100 / fileSize), fileSize, fileSizeDownloaded);

                    sendUpdate(transferDetails);
                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }


    private void sendUpdate(TransferDetails aTransferDetails) {

        Intent intent = new Intent(MainActivity.MESSAGE_PROGRESS);
        intent.putExtra("transfer_details", aTransferDetails);
        LocalBroadcastManager.getInstance(AppExercise8.APP_INSTANCE).sendBroadcast(intent);
    }


}
