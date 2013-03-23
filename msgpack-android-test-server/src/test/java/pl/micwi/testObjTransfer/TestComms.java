package pl.micwi.testObjTransfer;

import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.msgpack.rpc.Client;
import org.msgpack.rpc.loop.EventLoop;

import pl.micwi.testmsgpack.ServerConstants;
import pl.micwi.testmsgpack.TestServerIFace;
import pl.micwi.testmsgpack.data.DataParent;
import pl.micwi.testmsgpack.serverimpl.TestServerApp;



public class TestComms {
	private TestServerIFace server;

	@Before
	public void setUp() {
		Thread serverThread = new Thread() { 
			@Override
			public void run() {
				new TestServerApp().start();
			}
		};
		
		serverThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        EventLoop loop = EventLoop.defaultEventLoop();
        
        Client cli;
		try {
			cli = new Client("localhost", ServerConstants.SERVER_PORT, loop);
	        server = cli.proxy(TestServerIFace.class);
		} catch (UnknownHostException e) {
			Assert.fail(e.getLocalizedMessage()+"\n"+e.getStackTrace());
		}
	}
	
	@After 
	public void tearDown() {
        server.shutdown();
	}
	
	@Test
	public void doTest() {
		
		DataParent data = new DataParent();
		
		data.setSomeString("BLAHPARENT");
		
		
		server.send(data);
 
	}
}
