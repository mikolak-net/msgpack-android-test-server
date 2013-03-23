package pl.micwi.testmsgpack;

import pl.micwi.testmsgpack.data.DataParent;

public interface TestServerIFace {

	public void send(DataParent data);
	
	void shutdown();
}
