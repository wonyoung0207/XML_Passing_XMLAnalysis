package XML_FileAnalysis.handler;

import org.xml.sax.helpers.DefaultHandler;

public class ShapeFactory {  // 알맞은 Handler 리턴해주는 클래스 

	public DefaultHandler getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("BaseFile")) {
			return new BaseFileHandler();
		}
		if(shapeType.equalsIgnoreCase("F")) {
			return new FHandler();
		}
		if(shapeType.equalsIgnoreCase("P")) {
			return new PHandler();
		}
		return null;
	}

}
