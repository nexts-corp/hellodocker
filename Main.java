import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;

public class Main {

	  public static void main(String[] args) throws IOException {
        System.out.println("Sever Started");
        HttpServer server = HttpServer.create(new InetSocketAddress(4949), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

    }

    static class MyHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            System.out.println("Client Connected");
            String response = "Hello Simple Web by yellowline : " + new Date().toString();
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
