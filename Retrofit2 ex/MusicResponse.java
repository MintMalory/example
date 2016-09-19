package com.ua.sng.fourthdimension.retrofit2;

import com.ua.sng.fourthdimension.service.MusicItem;

import java.util.List;

/**
 * Created by Sopilko on 09.09.2016.
 */
public class MusicResponse extends AbstractResponse<List<MusicItem>> {

    public MusicResponse(List<MusicItem> data) {
        super(data);
    }
}
