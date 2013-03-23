package pl.micwi.testmsgpack.data;

import org.msgpack.annotation.MessagePackBeans;

@MessagePackBeans
public class DataParent {

	private String someString;

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

}
