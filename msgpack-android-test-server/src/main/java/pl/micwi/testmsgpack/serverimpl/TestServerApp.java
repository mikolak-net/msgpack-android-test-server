package pl.micwi.testmsgpack.serverimpl;

import java.io.IOException;

import org.msgpack.rpc.Server;
import org.msgpack.rpc.loop.EventLoop;

import pl.micwi.testmsgpack.ServerConstants;
import pl.micwi.testmsgpack.TestServerIFace;
import pl.micwi.testmsgpack.data.DataParent;

public class TestServerApp implements TestServerIFace {

	
	private EventLoop loop;
	private Server svr;

	public void start() {
        svr = new Server();
        
		loop = EventLoop.defaultEventLoop();
        

        svr.serve(this);


        try {
    		svr.listen(ServerConstants.SERVER_PORT);
			loop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void send(DataParent data) {
		System.out.println("REQUEST!");
		System.out.println(data.getSomeString());
	}
	
	public static void main(String[] args) {
		new TestServerApp().start();
	}
	
	@Override
	public void shutdown() {
			svr.close();
			loop.shutdown();
			System.out.println("SHUTDOWN!");
	}

}
