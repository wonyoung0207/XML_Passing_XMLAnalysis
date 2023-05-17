package XML_FileAnalysis.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import XML_FileAnalysis.vo.BaseFile;

public class BaseFileHandler extends DefaultHandler{

	//파싱한 객체를 넣을 리스트
	private  HashMap<String, BaseFile> map;

	//파싱한 객체
	private BaseFile obj;

	//character 메소드에서 저장할 문자열 변수
	private String str;

	public BaseFileHandler() {
		map = new HashMap<>();
	}

	public void startElement(String uri, String localName, String name, Attributes att) {
		//시작 태그를 만났을 때 발생하는 이벤트
		if(name.equals("FILE_ID")) {
			obj = new BaseFile();
		}
	}
	public void endElement(String uri, String localName, String name) {
		//끝 태그를 만났을 때,
		if(name.equals("FILE_ID")) {
			obj.setFileId(str);
			map.put(str, obj);
		}

	}
	public void characters(char[] ch, int start, int length) { // 태그내에 context만나면 실행 
		//태그와 태그 사이의 내용을 처리
		str = new String(ch,start,length);
		if (str.trim().equals("")) { // 빈 태그 값 처리 
			str = "";
		} 
	}

	public HashMap<String, BaseFile> getMap(){
		return map;
	}

	public void setMap(HashMap<String, BaseFile> map) {
		this.map = map;
	}

}
