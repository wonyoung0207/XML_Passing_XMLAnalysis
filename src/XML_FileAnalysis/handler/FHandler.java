package XML_FileAnalysis.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import XML_FileAnalysis.vo.F;

public class FHandler extends DefaultHandler{

	//파싱한 객체를 넣을 리스트
	private HashMap<String, F> map;

	//파싱한 객체
	private F obj;

	//character 메소드에서 저장할 문자열 변수
	private String str;

	public FHandler() {
		map = new HashMap<>();
	}

	public void startElement(String uri, String localName, String name, Attributes att) {
		//시작 태그를 만났을 때 발생하는 이벤트 -> 해당 태그를 기점으로 하나의 객체 만들고 싶을 경우 사용 
		if(name.equals("ROWID")) {
			obj = new F();
		}
	}

	public void endElement(String uri, String localName, String name) {
		//끝 태그를 만났을 때, startElements에서 생성한 객체에 필요한 정보 셋팅 할 경우 사용 
		if(name.equals("ROWID")) {
			obj.setRowId(str);
			map.put(str, obj);
		}else if(name.equals("VOLUME")) {
			obj.setVolume(str);
		}else if(name.equals("FILE_NAME")) {
			obj.setFileName(str);
		}
		else if(name.equals("RELEASE_NAME")) {
			obj.setReleseName(str);
		}
		else if(name.equals("SIMILAR_RATE")) {
			obj.setSimilarRate(Double.parseDouble(str));
//			obj.setSimilarRate(Math.round(Double.parseDouble(str))); // 소수점 제거 ? 
		}
		else if(name.equals("FILE_PATH")) {
			obj.setFilePath(str);
		}
		else if(name.equals("P_ID")) {
			obj.setpId(str);
		}
		else if(name.equals("EXCLUSION")) {
			obj.setExclusion(str);
		}
		else if(name.equals("COMMENT")) {
			obj.setComment(str);
		}

		//		if(name.equals("")) {
		//			return;
		//		}else {
		//			switch (name) {
		//			case "ROWID": 
		//				obj.setRowId(str);
		//				break;
		//			case "VOLUME": 
		//				obj.setVolume(str);
		//				break;
		//			case "FILE_NAME":
		//				obj.setFileName(str);
		//				break;
		//			case "RELEASE_NAME":
		//				obj.setReleseName(str);
		//				break;
		//			case "SIMILAR_RATE":
		//				obj.setSimilarRate(str);
		//				break;
		//			case "FILE_PATH":
		//				obj.setFilePath(str);
		//				break;
		//			case "P_ID":
		//				obj.setpId(str);
		//				break;
		//			case "EXCLUSION":
		//				obj.setExclusion(str);
		//				break;
		//			case "COMMENT":
		//				obj.setComment(str);
		//				break;
		//
		//			default:
		//				//			throw new IllegalArgumentException("Unexpected value: " + key);
		//			}
		//		}


	}
	public void characters(char[] ch, int start, int length) {
		//태그와 태그 사이의 내용을 처리
		str = new String(ch,start,length);
		if (str.trim().equals("")) {// 빈 태그 값 처리 
			str = "";
		} 
	}

	public HashMap<String, F> getMap(){
		return map;
	}
	public void setMap(HashMap<String, F> map) {
		this.map = map;
	}

}
