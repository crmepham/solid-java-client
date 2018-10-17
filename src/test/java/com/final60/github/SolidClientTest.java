package com.final60.github;

import com.final60.github.client.SolidClient;
import com.final60.github.model.Person;
import org.junit.Test;

import java.io.IOException;

/**
 * Tests for {@link SolidClient}.
 */
public class SolidClientTest
{

    /**
     *
     * @throws Exception okok
     */
    @Test
    public void testMe() throws Exception
    {

        Person me = getClient().me();
    }

    /**
     *
     * @return
     * @throws IOException okok
     */
    private SolidClient getClient() throws IOException {
        return new SolidClient("https", "solid.community", "/login/password", "crmepham2", "testing");
    }
}
