package network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInit {
    private static RetroInit ourInstance = new RetroInit();

    public static RetroInit getInstance() {
        return ourInstance;
    }

    private String SERVER_URL = "http://rinc.kr:7002";
    public NetworkList networkList;
    private RetroInit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        networkList = retrofit.create(NetworkList.class);
    }
}