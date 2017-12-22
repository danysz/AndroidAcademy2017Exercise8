package tlv.academy.android.fundamentals_exercise_8;


import retrofit2.Retrofit;

/**
 * Created by danielszasz on 22/12/2017.
 */

public class NetworkImpl {
    private static final NetworkImpl ourInstance = new NetworkImpl();

    public static NetworkImpl getInstance() {
        return ourInstance;
    }

    private INetwork mNetworkService;

    private NetworkImpl() {

//        http://ipv4.download.thinkbroadband.com/1GB.zip

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ipv4.download.thinkbroadband.com")
                .build();

        mNetworkService = retrofit.create(INetwork.class);
    }

    public void doDownloadFile(String aFileName){
        mNetworkService.doDownloadFile( aFileName);
    }
}
