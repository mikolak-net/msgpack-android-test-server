package pl.micwi.testObjTransfer;

import java.io.IOException;

import org.junit.Test;
import org.msgpack.MessagePack;

import pl.micwi.testmsgpack.data.DataParent;



public class TestLoad {


	@Test
	public void doTest() throws IOException {
		
		DataParent data = new DataParent();
		
		data.setSomeString("BLAHPARENT");

		
		MessagePack pack = new MessagePack();
        byte[] bytes = pack.write(data);

        System.out.println(pack.read(bytes,DataParent.class).getSomeString());
 
	}
}
