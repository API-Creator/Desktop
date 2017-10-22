package network;

import model.Login;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NetworkList {
    @POST("/sign")
    @FormUrlEncoded
    Call<Login> login(@Field("id") String id, @Field("pw") String pw);
}
