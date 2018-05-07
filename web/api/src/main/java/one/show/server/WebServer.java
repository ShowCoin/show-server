package one.show.server;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import one.show.common.thread.Dispatcher;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServer {
	//
	private static final Logger logger = LoggerFactory
			.getLogger(WebServer.class);
	//
	private Server server;
	private HandlerCollection handlers;
	private WebAppContext webAppContext;
	private int port=8080;
	private int idleTimeout=30;//30seconds
	//
	private WebAppContext createWebAppContext(String contextPath){
		WebAppContext webAppContext=new WebAppContext();
		webAppContext.setContextPath(contextPath);
		 // 设置描述符位置  
		webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");    
	    // 设置Web内容上下文路径  
		webAppContext.setResourceBase("src/main/webapp");
		
		List<String>configList=new ArrayList<String>();
		configList.add("org.eclipse.jetty.webapp.WebInfConfiguration");
		configList.add("org.eclipse.jetty.webapp.WebXmlConfiguration");
		configList.add("org.eclipse.jetty.webapp.MetaInfConfiguration");
		configList.add("org.eclipse.jetty.webapp.FragmentConfiguration");
		configList.add("org.eclipse.jetty.plus.webapp.EnvConfiguration");
		configList.add("org.eclipse.jetty.plus.webapp.PlusConfiguration");
		configList.add("org.eclipse.jetty.annotations.AnnotationConfiguration");
		webAppContext.setConfigurationClasses(configList.toArray(new String[configList.size()]));
		webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());  
		webAppContext.setConfigurationDiscovered(true);  
		webAppContext.setParentLoaderPriority(true);  
		//
		return webAppContext;
	}
	
	//--------------------------------------------------------------------------
	//
	static class JettyThreadPool implements ThreadPool{
		@Override
		public void execute(Runnable command) {
			Dispatcher.getInstance().execute(command);
		}
		//
		@Override
		public int getIdleThreads() {
			return Dispatcher.getInstance().getMaximumPoolSize()-Dispatcher.getInstance().getActiveCount();
		}
		//
		@Override
		public int getThreads() {
			return Dispatcher.getInstance().getMaximumPoolSize();
		}
		//
		@Override
		public boolean isLowOnThreads() {
			return false;
		}
		//
		@Override
		public void join() throws InterruptedException {
			logger.info("call JettyThreadPool join");
		}
	}
	//
	public void init()throws Exception{
		//set up jetty logger
		server = new Server(new JettyThreadPool());
		webAppContext = createWebAppContext("/");
		
		// Setup JMX
		MBeanContainer mbContainer=new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
		server.addEventListener(mbContainer);
		server.addBean(mbContainer);
		// Add loggers MBean to server (will be picked up by MBeanContainer above)
		server.addBean(Log.getLog());
		
	    List<Connector>connectors=new ArrayList<Connector>();
		//
		HttpConfiguration httpConfig = new HttpConfiguration();
        ServerConnector httpConnector = new ServerConnector(server,
        		new HttpConnectionFactory(httpConfig)); 
		httpConnector.setPort(port);
		httpConnector.setIdleTimeout(idleTimeout*1000);
		connectors.add(httpConnector);
		//
		server.setConnectors(connectors.toArray(new Connector[connectors.size()]));		
        server.setHandler(webAppContext);
        server.start();
        logger.info("SERVER START SUCCESS !!! PORT : "+port+" , "+webAppContext.getContextPath());
	}
	//
	public void stop() throws Exception{
		server.stop();
	}
	
	public static void main(String[] args) throws Exception {
		new WebServer().init();
	}
	
	
}
