package XML_FileAnalysis;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import XML_FileAnalysis.handler.BaseFileHandler;
import XML_FileAnalysis.handler.FHandler;
import XML_FileAnalysis.handler.PHandler;
import XML_FileAnalysis.handler.ShapeFactory;
import XML_FileAnalysis.vo.BaseFile;
import XML_FileAnalysis.vo.F;	
import XML_FileAnalysis.vo.P;

public class FileMapPaser<T> {
	private String filePath ;
	private ShapeFactory shapeFactory ;
	private SAXParserFactory factory ;

	public FileMapPaser(){
		shapeFactory = new ShapeFactory(); // handler 선택하는 객체 
		factory = SAXParserFactory.newInstance();
//		filePath = "C:/Users/user/eclipse-workspace/XML_Passing/src/XML_FileAnalysis/FileAllFolder/"; // Paths.get("").toAbsolutePath()
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, T> getPaser(String projectPath, String targetFile, String objFileName ){
		HashMap<String, T> map = null;

		try {
			SAXParser parser = factory.newSAXParser();
			File file = new File(projectPath + "XML_FileAnalysis/FileAllFolder/" + targetFile);
			DefaultHandler handler = shapeFactory.getShape(objFileName); // 각각의 파일 핸들러 꺼내오기

			parser.parse(file, handler);

			if(handler instanceof FHandler) {// handler downCasting 해줘야함 
//				System.out.println("FHandler Start...");
				map = (HashMap<String, T>) ((FHandler) handler).getMap(); 
			}else if(handler instanceof PHandler) {
//				System.out.println("PHandler Start...");
				map = (HashMap<String, T>) ((PHandler) handler).getMap(); 
			}else if(handler instanceof BaseFileHandler) {
//				System.out.println("BaseFileHandler Start...");
				map = (HashMap<String, T>) ((BaseFileHandler) handler).getMap(); 
			}

	        
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	
	
}
