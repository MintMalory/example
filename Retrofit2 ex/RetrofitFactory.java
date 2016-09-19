package com.ua.sng.fourthdimension.retrofit2;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.ua.sng.fourthdimension.App;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sopilko on 09.09.2016.
 */
public class RetrofitFactory {

    private static final boolean DEBUG_MODE = false;

    private static final int CONNECT_TIMEOUT = 45;
    private static final int WRITE_TIMEOUT = 60;
    private static final int TIMEOUT = 60;

    private static final int cacheInt = 10; // 10 Mb cache
    private static final int cacheSize = cacheInt * 1024 * 1024;

    /*
    private static final OkHttpClient CLIENT = new OkHttpClient();
    static {
        CLIENT.setConnectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setWriteTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);
//        File cacheDirectory = new File(RegnumApp.getInstance()
//                .getCacheDir().getAbsolutePath(), "HttpReponces5454667");
//        Cache cache = new Cache(cacheDirectory, cacheSize);
//        if (cache != null) {
//            CLIENT.setCache(cache);
//        }
    }
    */

    @NonNull
    public static RetrofitService getRetrofitService() {
        return getRetrofitDefault().create(RetrofitService.class);
    }

    @NonNull
    private static Retrofit getRetrofitDefault() {


        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder builder = original.newBuilder();
                builder.header("Accept-Language", App.getInstance().config.lang.toString());
                /*
                if (config.user != null) {
                    builder.header("Authorization", "Token " + config.user.token);
                }
                */
                Request request = builder.method(original.method(), original.body()).build();

                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (DEBUG_MODE) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            // Can be Level.BASIC, Level.HEADERS, or Level.BODY
            // See http://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.networkInterceptors().add(httpLoggingInterceptor);
        }

        builder.addInterceptor(headerInterceptor);
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newCachedThreadPool())
                .callbackExecutor(new Executor() {
                    private final Handler mHandler = new Handler(Looper.getMainLooper());

                    @Override
                    public void execute(Runnable command) {
                        mHandler.post(command);
                    }
                })
                .client(okHttpClient)
                .build();



        return retrofit;
    }

}