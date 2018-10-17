package com.final60.github.client;

import com.final60.github.exception.InvalidCredentialsException;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

import static java.lang.String.format;

/**
 * @author Chris Mepham
 */
public class HttpClient {

    /**
     * The HTTP schema.
     */
    private final String schema;

    /**
     * The POD host.
     */
    private final String host;

    /**
     * The POD login path.
     */
    private final String path;

    /**
     * The username is used when authenticating
     * the user.
     */
    private final String username;

    /**
     * The password is used when authenticating
     * the user.
     */
    private final String password;

    /**
     * The cookie that contains the <em>connect.sid</em>
     * value that is required when making any authenticated
     * request. This cookie will be automatically renewed
     * the next time a request is made and it has expired.
     */
    private Cookie cookie;

    /**
     * The constructor.
     *
     * @param schema The HTTP schema.
     * @param host The POD host.
     * @param path The POD login path.
     * @param username The username.
     * @param password The password.
     * @throws InvalidCredentialsException When user credentials are incorrect.
     * @throws IOException When connection is not possible.
     */
    public HttpClient(String schema, String host, String path, String username, String password) throws InvalidCredentialsException, IOException {
        this.schema = schema;
        this.host = host;
        this.path = path;
        this.username = username;
        this.password = password;
        authenticate();
    }

    /**
     * Get the profile of the user of this client.
     *
     * @return The response body.
     * @throws IOException When connection is not possible.
     */
    public String me() throws IOException {

        final OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new CustomCookieJar())
                .build();

        final Request request = new Request.Builder()
                .headers(getHeaders())
                .url(HttpUrl.get(schema + "://" + username + "." + host + "/profile/card"))
                .build();

        final Response response = client.newCall(request).execute();
        return response.body().string();

    }

    /**
     * Authenticate this client by sending a login request to the
     * specified POD and persisting the returned <em>connect.sid</em>
     * cookie for use in later requests.
     *
     * @throws InvalidCredentialsException When the username and/or password are incorrect.
     * @throws IOException When the connection is not successful.
     */
    public void authenticate() throws InvalidCredentialsException, IOException {

        final OkHttpClient client = new OkHttpClient.Builder()
        .cookieJar(new CustomCookieJar())
        .build();

        final Request request = new Request.Builder()
                .headers(getHeaders())
                .post(getBody(username, password))
                .url(getLoginUrl())
                .build();

        final Response response = client.newCall(request).execute();

        validate(response);
        getCookie(response);
    }

    /**
     * Set the cookie that is retrieved from the successful
     * authentication response.
     *
     * @param response The response from the authentication request.
     */
    private void getCookie(Response response) {

        final String cookieString = response.header("Set-Cookie");
        if (cookieString == null || cookieString.length() == 0) {
            throw new RuntimeException(format("Failed to retrieve connect.sid cookie."));
        }

        cookie = Cookie.parse(getLoginUrl(), cookieString);
    }

    /**
     * Create the okhttp3 url that will be used in requests.
     *
     * @return The okhttp3 url.
     */
    private HttpUrl getLoginUrl() {
        return HttpUrl.get(schema + "://" + host + path);
    }

    /**
     * If the username and/or password are incorrect the {@link InvalidCredentialsException}
     * will be thrown.
     *
     * @param response The response from the authentication request.
     */
    private void validate(Response response) {

        int code = response.code();
        if (code == 400) {
            throw new InvalidCredentialsException(format("Failed to authenticate username %s and password %s.", username, password));
        }
    }

    /**
     * Create the headers required to make the requests.
     *
     * @return The okhttp3 headers.
     */
    private Headers getHeaders() {

        return new Headers.Builder()
                .add("Content-Type", "application/x-www-form-urlencoded")
                .add("cache-control", "no-cache")
                .build();
    }

    /**
     * Create the body for the requests.
     *
     * @param username The username.
     * @param password The password.
     * @return The okhttp3 request body.
     */
    private RequestBody getBody(String username, String password) {

        return new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
    }

    /**
     * Gets the cookie.
     *
     * @return cookie
     */
    public Cookie getCookie()
    {
        return cookie;
    }

    /**
     * Gets the username.
     *
     * @return username
     */
    public String getUsername()
    {
        return username;
    }
}
