package com.final60.github.client;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Persists cookie between redirect.
 *
 * @author Chris Mepham
 */
public class CustomCookieJar implements CookieJar {

    private List<Cookie> cookies;

    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        this.cookies =  cookies;
    }

    public List<Cookie> loadForRequest(HttpUrl url) {
        if (cookies != null) {

            return cookies;
        }

        return new ArrayList<Cookie>();
    }
}
