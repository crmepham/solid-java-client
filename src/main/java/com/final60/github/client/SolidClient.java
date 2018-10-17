package com.final60.github.client;

import com.final60.github.exception.InvalidCredentialsException;
import com.final60.github.model.Person;
import com.google.common.collect.ImmutableSet;
import com.taxonic.carml.rdf_mapper.util.RdfObjectLoader;
import com.taxonic.carml.util.IoUtils;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.rio.RDFFormat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.function.Function;

/**
 *
 *
 * @author Chris Mepham
 */
public class SolidClient {

    /**
     * The HTTP Client used to make HTTP requests
     * to the POD.
     */
    private final HttpClient httpClient;

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
    public SolidClient(String schema, String host, String path, String username, String password)
            throws InvalidCredentialsException, IOException {

        this.httpClient = new HttpClient(schema, host, path, username, password);
    }

    /**
     * Gets the profile information for the
     * clients user.
     *
     * @return An instance of {@link Person}.
     * @throws Exception okok
     */
    public Person me() throws Exception {

        final String body = httpClient.me();

        System.out.println(body);

        ValueFactory VF = SimpleValueFactory.getInstance();

        Model model = IoUtils.parse(new ByteArrayInputStream(body.getBytes()), RDFFormat.TURTLE);

        Function<Model, Set<Resource>> selectPersons =
                m ->
                        ImmutableSet.copyOf(
                                model
                                        .filter(null, RDF.TYPE, VF.createIRI("http://schema.org/Person"))
                                        .subjects()
                        );

        Set<Person> people = RdfObjectLoader.load(selectPersons, Person.class, model);

        return null;
    }
}
