package com.ua.sng.fourthdimension.retrofit2;

import java.io.Serializable;

/**
 * Created by Sopilko on 09.09.2016.
 */
public class Meta implements Serializable {
    public int limit;
    public int offset;
    public String next;
    public String previous;
    public int total_count;
}
