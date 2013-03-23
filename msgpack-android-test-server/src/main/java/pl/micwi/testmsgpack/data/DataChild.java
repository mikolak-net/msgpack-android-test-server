package pl.micwi.testmsgpack.data;

import org.msgpack.annotation.MessagePackBeans;

@MessagePackBeans
public class DataChild {

	private int someNum;
	
	private String aString;
	
	private DataParent parent;

	@Override
	public String toString() {
		return "DataChild [someNum=" + someNum + ", aString=" + aString + "]";
	}

	public int getSomeNum() {
		return someNum;
	}

	public void setSomeNum(int someNum) {
		this.someNum = someNum;
	}

	public String getaString() {
		return aString;
	}

	public void setaString(String aString) {
		this.aString = aString;
	}

	public DataParent getParent() {
		return parent; 
	}

	public void setParent(DataParent parent) {
		this.parent = parent;
	}
	
	
	
	
	
}
