package ua.mintmalory.retrofit2xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ua.mintmalory.retrofit2xml.retrofit2.api.RetrofitService;
import ua.mintmalory.retrofit2xml.retrofit2.model.NewsListXML;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.ENDPOINT)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        Call<NewsListXML> call = service.getNewsListXML();

        call.enqueue(new Callback<NewsListXML>() {
            @Override
            public void onResponse(Call<NewsListXML> call, Response<NewsListXML> response) {
                int i = 0;
            }

            @Override
            public void onFailure(Call<NewsListXML> call, Throwable t) {
                int i = 0;
            }
        });

    }
}
