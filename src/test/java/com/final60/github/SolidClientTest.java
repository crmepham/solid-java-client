package com.final60.github;

import com.final60.github.client.SolidClient;
import com.final60.github.model.Person;
import org.junit.Test;

import java.util.Set;

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
        final String name = me.getName();
        final Set<Person> friends = me.getKnows();

        StringBuilder builder = new StringBuilder();
        builder.append("Welcome to this app " + name + "\n");

        if (!friends.isEmpty()) {

            builder.append("Friends list:\n");

            friends.forEach(f -> builder.append(f.getName() + "\n"));
        }

        System.out.println(builder.toString());

        assertThat(me).isNotNull();
        assertThat(me.getKnows().size()).isPositive();
        assertThat(me.getKnows().iterator().next().getVcard()).isNotNull();
    }
}
