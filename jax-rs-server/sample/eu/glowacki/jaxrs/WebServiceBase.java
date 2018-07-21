package eu.glowacki.jaxrs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.glassfish.jersey.server.ServerProperties;

public abstract class WebServiceBase {
	
	private static final int POOL_SIZE = 10;
	
	private static final ExecutorService _pool;
	
	static {
		_pool = Executors.newFixedThreadPool(POOL_SIZE);
		System.setProperty(ServerProperties.FEATURE_AUTO_DISCOVERY_DISABLE, "false");
	}
	
	protected <TResult> void submit(TaskBase<TResult> task) {
		_pool.submit(task);
	}
}