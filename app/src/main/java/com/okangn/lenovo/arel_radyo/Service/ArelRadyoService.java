package com.okangn.lenovo.arel_radyo.Service;

import com.okangn.lenovo.arel_radyo.Models.AllData;
import com.okangn.lenovo.arel_radyo.Models.Data;
import com.okangn.lenovo.arel_radyo.Models.Example;
import com.okangn.lenovo.arel_radyo.Models.Info;
import com.okangn.lenovo.arel_radyo.Models.Uppro;
import com.okangn.lenovo.arel_radyo.Models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ArelRadyoService {
    @POST("User/register")
    @FormUrlEncoded
    Call<Info> register(@Field("User_UserName") String User_UserName,
                        @Field("User_FullName") String User_FullName,
                        @Field("User_Email") String User_Email,
                        @Field("User_Password") String User_Password);

    @FormUrlEncoded
    @POST("User/login")
    Call<Data> Login(
            @Field("User_UserName") String User_UserName,
         //   @Field("User_FullName") String User_FullName,
           // @Field("User_Email") String User_Email,
            @Field("User_Password") String User_Password);

    @FormUrlEncoded
    @POST("User/update")
    Call<Info> Update(@Field("User_UserName") String User_UserName,
                       @Field("User_FullName") String User_FullName,
                       @Field("User_Email") String User_Email,
                       @Field("User_Password") String User_Password);



    @GET("User/all")
    Call<List<AllData>> getLIST_CALL();

    @GET("ttr6pw3f/")
   Call<List<Example>>  getMyRadyoList(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/oldschool4/")
    Call<Example> getMyRadyoOld4(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/oldschool/")
    Call<Example> getMyRadyoOld(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/oldschool3/")
    Call<Example> getMyRadyoOld3(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/oldschool2/")
    Call<Example> getMyRadyoOld2(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/oldschool5/")
    Call<Example> getMyRadyoOld5(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/muhammet-ali-kanbur-old-school/")
    Call<Example> getMyRadyoOld6(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/akif-old-school01/")
    Call<Example> getMyRadyoOld7(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/rap/")
    Call<Example> getMyRadyoOld8(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/spirit-70s/")
    Call<Example> getMyRadyoSprit(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/70s-rock/")
    Call<Example> getMyRadyoSprit1(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/70s-rock2/")
    Call<Example> getMyRadyoSprit2(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/70s-rock3/")
    Call<Example> getMyRadyoSprit3(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/70s-rock4/")
    Call<Example> getMyRadyoSprit4(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/70s-rock5/")
    Call<Example> getMyRadyoSprit5(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/201/")
    Call<Example> getMyRadyoSprit6(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/berfn-70ler01/")
    Call<Example> getMyRadyoSprit7(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/sena-delikgz01/")
    Call<Example> getMyRadyoSprit8(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/funk/")
    Call<Example> getMyRadyoFunk(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/funkmixdown/")
    Call<Example> getMyRadyoFunk1(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/funk2mixdown/")
    Call<Example> getMyRadyoFunk2(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/funk3mixdown/")
    Call<Example> getMyRadyoFunk3(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/funk4mixdown/")
    Call<Example> getMyRadyoFunk4(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);
    @GET("ttr6pw3f/funk5mixdown/")
    Call<Example> getMyRadyoFunk5(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/meryem-erol-funk-the-fun/")
    Call<Example> getMyRadyoFunk6(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/best-of-80s/")
    Call<Example> getMyRadyoDecan1(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/80s-rock/")
    Call<Example> getMyRadyoDecan2(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/80s-rock2/")
    Call<Example> getMyRadyoDecan3(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/80s-rock3/")
    Call<Example> getMyRadyoDecan4(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/80s-rock4/")
    Call<Example> getMyRadyoDecan5(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);

    @GET("ttr6pw3f/80s-rock5/")
    Call<Example> getMyRadyoDecan6(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);


    @GET("ttr6pw3f/merve-bostan-decadence-80s/")
    Call<Example> getMyRadyoDecan7(
            @Query("type") String param1,
            @Query("page") String param2,
            @Query("count") String param3);


 @GET("ttr6pw3f/rasta-zone/")
 Call<Example> getMyRadyoRasta(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/reggae1/")
 Call<Example> getMyRadyoRasta1(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/reggae2/")
 Call<Example> getMyRadyoRasta2(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/reggae3/")
 Call<Example> getMyRadyoRasta3(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/reggae4/")
 Call<Example> getMyRadyoRasta4(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/reggae5/")
 Call<Example> getMyRadyoRasta5(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/deephouse/")
 Call<Example> getMyRadyoDeep(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/deep-house/")
 Call<Example> getMyRadyoDeep1(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/deep-house2/")
 Call<Example> getMyRadyoDeep2(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/deep-house3/")
 Call<Example> getMyRadyoDeep3(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/deep-house4/")
 Call<Example> getMyRadyoDeep4(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/deep-house5/")
 Call<Example> getMyRadyoDeep5(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/ekin01/")
 Call<Example> getMyRadyoDeep6(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/night-n-blues/")
 Call<Example> getMyRadyoNigt(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/blues1/")
 Call<Example> getMyRadyoNigt1(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/blues2/")
 Call<Example> getMyRadyoNigt2(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/blues3/")
 Call<Example> getMyRadyoNigt3(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/blues4/")
 Call<Example> getMyRadyoNigt4(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/blues5/")
 Call<Example> getMyRadyoNigt5(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/ervanur-nightinblues01/")
 Call<Example> getMyRadyoNigt6(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/alternate-side/")
 Call<Example> getMyRadyoAltter(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/alternativesidemixdown/")
 Call<Example> getMyRadyoAltter1(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/alternativeside2/")
 Call<Example> getMyRadyoAltter2(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/alternativeside3/")
 Call<Example> getMyRadyoAltter3(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/alternativeside4/")
 Call<Example> getMyRadyoAltter4(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/alternativeside5/")
 Call<Example> getMyRadyoAltter5(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/jazz-esintisi/")
 Call<Example> getMyRadyoBreathjazz(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/jazzmixdown/")
 Call<Example> getMyRadyoBreathjazz1(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/jazz2mixdown/")
 Call<Example> getMyRadyoBreathjazz2(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/jazz3mixdown/")
 Call<Example> getMyRadyoBreathjazz3(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/jazz4mixdown/")
 Call<Example> getMyRadyoBreathjazz4(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/jazz5mixdown/")
 Call<Example> getMyRadyoBreathjazz5(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/irem-jazz01/")
 Call<Example> getMyRadyoBreathjazz6(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/rock-6/")
 Call<Example> getMyRadyoRockFree(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/rock-5/")
 Call<Example> getMyRadyoRockFree1(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/rock-4/")
 Call<Example> getMyRadyoRockFree2(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/rock-3/")
 Call<Example> getMyRadyoRockFree3(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/rock-2/")
 Call<Example> getMyRadyoRockFree4(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);

 @GET("ttr6pw3f/rock-1/")
 Call<Example> getMyRadyoRockFree5(
         @Query("type") String param1,
         @Query("page") String param2,
         @Query("count") String param3);


   /* @PATCH("ttr6pw3f/")oldschool4//muhammet-ali-kanbur-old-school4/ meryem-erol-funk-the-fun  merve-bostan-decadence-80s  ervanur-nightinblues01  alternativesidemixdown
    Call<List<User>>  getUserMyRadyoList(              alternativeside2  jazz-esintisi  jazzmixdown   irem-jazz01
            @Header("type") String type,
            @Header("page") int page,
            @Header("count") int count);

  /*  @GET("ttr6pw3f/")
    Call<ResponseBody> User(@Path("type") String type,
                            @Path("page") int page,
                            @Path("count") int count); */

}