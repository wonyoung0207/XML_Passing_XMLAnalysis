package XML_FileAnalysis.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import XML_FileAnalysis.vo.P;

public class PHandler extends DefaultHandler{

	//파싱한 객체를 넣을 리스트
	private  HashMap<String, P> map;

	//파싱한 객체
	private P obj;

	//character 메소드에서 저장할 문자열 변수
	private String str;

	public PHandler() {
		map = new HashMap<>();
	}

	public void startElement(String uri, String localName, String name, Attributes att) {
		//시작 태그를 만났을 때 발생하는 이벤트 -> 해당 태그를 기점으로 하나의 객체 만들고 싶을 경우 사용 
		if(name.equals("P_ID")) {// 따라서 P_ID 태그가 오면 P 객체 하나 생성함 
			obj = new P();
			map.put(str, obj);
		}
	}

	public void endElement(String uri, String localName, String name) {
		//끝 태그를 만났을 때, startElements에서 생성한 객체에 필요한 정보 셋팅 할 경우 사용 
		if(name.equals("P_ID")) { // 생성한 P 객체에다가 LICENSE_ID 값을 설정함 
			obj.setpId(str);
			map.put(str, obj);
		}else if(name.equals("LICENSE_ID")) {  
			obj.setLicenseId(str);
		}
	}

	public void characters(char[] ch, int start, int length) {
		//태그와 태그 사이의 내용을 처리
		str = new String(ch,start,length);

		if (str.trim().equals("")) {// 빈 태그 값 처리 
			str = "";
		} 
	}

	public HashMap<String, P> getMap(){
		return map;
	}
	public void setMap( HashMap<String, P> map) {
		this.map = map;
	}

}
