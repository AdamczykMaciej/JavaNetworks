package eu.glowacki.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@ApplicationPath("/")
public class ApplicationConfiguration extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(Calculator.class);
		classes.add(MOXyJsonProvider.class);
		classes.add(MoxyXmlFeature.class);
		return classes;
	}
}