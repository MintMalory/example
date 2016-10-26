package ua.mintmalory.retrofit2xml.retrofit2.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.mintmalory.retrofit2xml.retrofit2.model.Rss;

/**
 * Retrofit service for endpoint
 */
public interface RetrofitService {

//   String ENDPOINT = "http://k.img.com.ua/rss/ru/";
   String ENDPOINT = "http://fakty.ua/rss_feed/";
  //  String ENDPOINT = "http://nbnews.com.ua/ru/";

//            @GET("companies.xml")
  @GET("politics")
   // @GET("rss/")
    Call<Rss> getNewsListXML();

}
