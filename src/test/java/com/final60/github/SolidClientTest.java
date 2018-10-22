package com.final60.github;

import com.final60.github.client.SolidClient;
import com.final60.github.model.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SolidClient}.
 */
public class SolidClientTest
{
    @Test
    public void testMe() throws Exception {
        final SolidClient client = new SolidClient("https", "solid.community", "/login/password", "crmepham2", "testing");
        final Person me = client.me();
        assertThat(me).isNotNull();
        assertThat(me.getKnows().size()).isPositive();
        assertThat(me.getKnows().iterator().next().getVcard()).isNotNull();
    }
}
