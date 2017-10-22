package login;

import com.sun.istack.internal.Nullable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Login;
import network.RetroInit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button loginBtn;
    @FXML
    private TextField idField, pwField;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginBtn.setOnMouseClicked(event -> {
            RetroInit.getInstance().networkList.login(idField.getText(), pwField.getText()).enqueue(new Callback<Login>() {

                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    if (response.isSuccessful()) {
                        System.out.println("성공");
                        System.out.println(response.body().status.message);
                    } else {
                        System.out.println("클라이언트 오류");
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    System.out.println("서버 오류");
                    t.printStackTrace();
                }
            });
        });
    }

}
