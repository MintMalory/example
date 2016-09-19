package com.ua.sng.fourthdimension.retrofit2;

import com.ua.sng.fourthdimension.models.GoalItem;
import com.ua.sng.fourthdimension.models.ImageListResponseEntity;
import com.ua.sng.fourthdimension.service.MusicItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Sopilko on 09.09.2016.
 */
public interface RetrofitService {

    // https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit

    String API_BASE_URL = "http://5.101.116.20:8885/";

    /*
        http://5.101.116.20:8885/api/musics/

    */

    String api_version = "api/";


    @GET(api_version + "images/")
    Call<ImageListResponseEntity> getAllImageSets();

    @GET
    Call<ImageListResponseEntity> getNextImagesPage(@Url String url);

    @GET(api_version + "notifications/")
    Call<ArrayList<GoalItem>> getAllNotifications();

    @GET
    Call<ImageListResponseEntity> getNotificationNextTexts(@Url String url);

    //@GET
    //Call<ArrayList<MusicItem>> getMusic(@Url String url);
    @GET(api_version + "musics/")
    //Call<MusicResponse> getMusic();
    Call<ArrayList<MusicItem>> getMusic();

    @FormUrlEncoded
    @POST(api_version + "increment_download_count/")
    Call<Object> incrementDownloadCount(@Field("id") int Id);

//    @GET(NetworkUrls.GET_IMAGE_SET)
//    Call<ImageSetEntity> getImageSet(@Path("image_set_number") int imageSetNumber);



}
