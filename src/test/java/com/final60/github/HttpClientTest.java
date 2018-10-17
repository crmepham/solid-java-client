package com.final60.github;

import com.final60.github.client.HttpClient;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link HttpClient}.
 *
 * @author Chris Mepham
 */
public class HttpClientTest
{

    @Test
    public void testSuccess() throws IOException {
        assertNotNull(getClient().getCookie());
    }

    @Test
    public void testMe() throws IOException {
        assertTrue(getClient().me().contains("United Kingdom"));
    }

    private HttpClient getClient() throws IOException {
        return new HttpClient("https", "solid.community", "/login/password",
                "crmepham2", "testing");
    }
}
