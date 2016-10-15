import org.apache.catalina.startup.Embedded;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;

import java.io.File;

public class MyWebServer {

    private static final String DEFAULT_ENGINE = "default";
    private static final String DEFAULT_HOST = "localhost";
    private static final String WEB_APPS_NAME = "myapps";
    private static final String DOC_BASE = "docbase";

    private Embedded embedded;
    private String catalinaHome;

    public MyWebServer() {
        // Register a shutdown hook to do a clean shutdown
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        stopServer();
                    }
                });
    }

    private void init() throws Exception {
        File home = (new File(".")).getCanonicalFile();
        catalinaHome = home.getAbsolutePath();

        embedded = new Embedded();
        embedded.setCatalinaHome(catalinaHome);

        // Create an Engine
        Engine engine = embedded.createEngine();
        engine.setName(DEFAULT_ENGINE);
        engine.setDefaultHost(DEFAULT_HOST);
        embedded.addEngine(engine);

        // Create a Host
        File webAppsLocation = new File(home, WEB_APPS_NAME);
        Host host = embedded.createHost(
                DEFAULT_HOST, webAppsLocation.getAbsolutePath());
        engine.addChild(host);


        // Add the context
        File docBase = new File(webAppsLocation, DOC_BASE);
        Context context = createContext("",docBase.getAbsolutePath());
        host.addChild(context);

        // Create a connector that listens on all addresses
        // on port 5050
        Connector connector = embedded.createConnector(
                (String)null, 5050, false);
        
        // Wire up the connector
        embedded.addConnector(connector);

    }

    private Context createContext(String path, String docBase){
        // Create a Context
        Context context = embedded.createContext(path, docBase);
        context.setParentClassLoader(this.getClass().getClassLoader());

        // Create a default servlet
        Wrapper servlet = context.createWrapper();
        servlet.setName("default");
        servlet.setServletClass(
                "org.apache.catalina.servlets.DefaultServlet");
        servlet.setLoadOnStartup(1);
        servlet.addInitParameter("debug", "0");
        servlet.addInitParameter("listings", "false");
        context.addChild(servlet);
        context.addServletMapping("/", "default");

        // Create a handler for jsps
        Wrapper jspServlet = context.createWrapper();
        jspServlet.setName("jsp");
        jspServlet.setServletClass(
                "org.apache.jasper.servlet.JspServlet");
        jspServlet.addInitParameter("fork", "false");
        jspServlet.addInitParameter("xpoweredBy", "false");
        jspServlet.setLoadOnStartup(2);
        context.addChild(jspServlet);
        context.addServletMapping("*.jsp", "jsp");
        context.addServletMapping("*.jspx", "jsp");

        // Set seme default welcome files
        context.addWelcomeFile("index.html");
        context.addWelcomeFile("index.htm");
        context.addWelcomeFile("index.jsp");
        context.setSessionTimeout(30);

        // Add some mime mappings
        context.addMimeMapping("html", "text/html");
        context.addMimeMapping("htm", "text/html");
        context.addMimeMapping("gif", "image/gif");
        context.addMimeMapping("jpg", "image/jpeg");
        context.addMimeMapping("png", "image/png");
        context.addMimeMapping("js", "text/javascript");
        context.addMimeMapping("css", "text/css");
        context.addMimeMapping("pdf", "application/pdf");

        return context;
    }

    public void startServer() throws Exception {
        init();
        embedded.start();
    }

    public void stopServer() {
        if (embedded != null) {
            try {
                System.out.println("Shutting down MyServer...");
                embedded.stop();
                System.out.println("MyServer shutdown.");
            } catch (Exception e) {
                //No need to do anything
            }
        }
    }

    public static void main(String args[]) throws Exception {

        MyWebServer server = new MyWebServer();
        server.startServer();

        // This code is just to prevent the sample
        // application from terminating
        synchronized (server) {
            server.wait();
        }
    }
}
