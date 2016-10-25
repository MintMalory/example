package ua.mintmalory.retrofit2xml.retrofit2.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.mintmalory.retrofit2xml.retrofit2.model.NewsListXML;

/**
 * Retrofit service for endpoint
 */
public interface RetrofitService {

    //    String ENDPOINT = "http://k.img.com.ua/rss/ru/";
    String ENDPOINT = "http://nv.ua/xml/";

    //    @GET("all_news2.0.xml")
    @GET("rss.html")
    Call<NewsListXML> getNewsListXML();


    /*@GET("posts/list?limit=20&stripTags=1&tags=1,2,3,4,5,6,7")
    Call<NewsList> getNewsList(@Query("page") int pageNumber);

    @GET("posts/{newsId}")
    Call<NewsDetails> getNewsDetails(@Path("newsId") String newsId);

    @GET("front/timers")
    Call<NextOnlineTime> getTimers();

    @GET("tv-guide/types")
    Call<BrodcastTypesList> getBrodcastTypesList();

    @GET("tv-guide/list/{typeList}/ru")
    Call<TVGuidesList> getTVGuidesList(@Path("typeList") String tvGuidesListType);*/
}
