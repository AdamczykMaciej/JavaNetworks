package eu.glowacki.jaxrs.client.chunked.proxy;

import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ChunkedInput;

public final class StringGenericType extends GenericType<ChunkedInput<String>> {
}