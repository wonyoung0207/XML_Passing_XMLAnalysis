package XML_FileAnalysis;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import XML_FileAnalysis.vo.BaseFile;
import XML_FileAnalysis.vo.F;
import XML_FileAnalysis.vo.P;

public class Analysis {
	String targetFile = "T_BASEFILE_TB.xml";
	String projectPath = "C:/Users/user/git/repository/XML_Passing/src/";
	String resultFilePath = projectPath + "FileResultFolder/";
	
	FileMapPaser<BaseFile> baseMapParser = new FileMapPaser<>(); // XML 파일의 데이터를 읽어오는 클래스 
	FileMapPaser<F> fMapParser = new FileMapPaser<>();
	FileMapPaser<P> pMapParser = new FileMapPaser<>();
	HashMap<String, BaseFile> baseFileMap = null; // BaseFile 담는 리스트
	HashMap<String, F> fMap = null; // F 파일 담는 리스트
	HashMap<String, P> pMap = null; // P 파일 담는 리스트
	HashMap<String, F> rMap = new HashMap<>(); // 결과 파일 담는 리스트


	public Analysis() {
	}

	public void run() {
		try {
			baseFileMap = baseMapParser.getPaser(projectPath, targetFile, "BaseFile"); // fileId로 된 리스트 뽑아옴
			for (String baseFilekey : baseFileMap.keySet()) {// BaseFile 의 File_Id 를 기준으로 반복문 실행
				rMap.clear();
				//	            System.out.println( "BaseFileKey : " + baseFilekey + ", BaseFileValue : " + baseFileMap.get(baseFilekey));
				fMap = fMapParser.getPaser(projectPath, "F_" + baseFilekey + "_TB.xml", "F");// fileId로 된 F 파일 읽어오기
				pMap = pMapParser.getPaser(projectPath, "P_" + baseFilekey + "_TB.xml", "P");// fileId로 된 P 파일 읽어오기

				// F 파일 순회 
				for (String fFilekey : fMap.keySet()) {
					if ((fMap.get(fFilekey).getSimilarRate() / 100) > 50) { // similer_rate / 100 이 50 이상인 F 만 걸러냄
						//						System.out.println("살아남은 fList => fFileKey : " + fFilekey + ", fFileValue : " + fMap.get(fFilekey));
						rMap.put(fFilekey, fMap.get(fFilekey)); // rate 50 넘는 값들만 저장
						//						System.out.println(rMap.get(fFilekey));
						
					}
				}
				fMap.clear(); // fMap은 여기서부터 쓸모 없음 

				// F 파일에서 rate > 50 조건 만족한 F 만 순회 
				for (String rFilekey : rMap.keySet()) {
					String pid = rMap.get(rFilekey).getpId(); 
					if(pMap.get(pid) != null && pid.equals(pMap.get(pid).getpId())) { // P파일중 pid가 있는 태그만 실행
						rMap.get(rFilekey).setComment(pMap.get(pid).getLicenseId());
					}
				}
				pMap.clear(); // pMap 여기서부터 쓸모 없음. 
				
				// XML 파일로 출력하기  
				if(!rMap.isEmpty()) {
					fileOutput(baseFileMap.get(baseFilekey).getFileId());
				}
				

//				rMap.clear(); // fu
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	// file 내보내는 부분 
	public void fileOutput(String fildId) {
//		for (String rFilekey : rMap.keySet()) {
//			System.out.println("rMap => rFilekey : " + rFilekey + ", rFileValue : " + rMap.get(rFilekey));
//		}
//		System.out.println(fildId + " : " + rMap.get(0) );
		System.out.println("fildID : " + fildId);
		try {
			// XML 파일 출력시 필요한 클래스 
//			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			// File Output 보조 스트
			FileOutputStream fos = new FileOutputStream( resultFilePath + "T_" + fildId + "_TB.xml");
			DataOutputStream dos = new DataOutputStream(fos);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            
            // 생성되는 파일마다 가장 상위에 있는 ROWS 태그 생성 
            Element rootElement = doc.createElement("ROWS");
           
            
            // rMap 에 있는 값 
            // Map의 value에 있는 F 파일 객체 이용하기 위해
            for (HashMap.Entry<String, F> entry : rMap.entrySet()) { 
            	// ROWS 밑에 들어가는 row 태그 생성 
            	Element rowElement = rowElement = doc.createElement("ROW");// fildId 만큼 ROW 가 생성되야 함 
            	// ROWS 밑에 row 태그 추가
            	
            	// rowId로 하위 태그생성 
                Element rowIdElement = doc.createElement("ROWID");
                rowIdElement.appendChild(doc.createTextNode(entry.getValue().getRowId()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(rowIdElement); // ROW 태그 밑에 추가 
            	
                Element volumeElement = doc.createElement("VOLUME");
                volumeElement.appendChild(doc.createTextNode(entry.getValue().getVolume()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(volumeElement); // ROW 태그 밑에 추가 
            	
                Element fileNameElement = doc.createElement("FILE_NAME");
                fileNameElement.appendChild(doc.createTextNode(entry.getValue().getFileName()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(fileNameElement); // ROW 태그 밑에 추가 
            	
            	Element releseNameElement = doc.createElement("RELEASE_NAME");
            	releseNameElement.appendChild(doc.createTextNode(entry.getValue().getReleseName()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(releseNameElement); // ROW 태그 밑에 추가 
            	
            	Element similarRateElement = doc.createElement("SIMILAR_RATE");
            	similarRateElement.appendChild(doc.createTextNode(entry.getValue().getSimilarRate()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(similarRateElement); // ROW 태그 밑에 추가 
            	
            	Element filePathElement = doc.createElement("FILE_PATH");
            	filePathElement.appendChild(doc.createTextNode(entry.getValue().getFilePath()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(filePathElement); // ROW 태그 밑에 추가 
            	
            	Element pIdElement = doc.createElement("P_ID");
            	pIdElement.appendChild(doc.createTextNode(entry.getValue().getpId()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(pIdElement); // ROW 태그 밑에 추가 
            	
            	Element exclusionElement = doc.createElement("EXCLUSION");
            	exclusionElement.appendChild(doc.createTextNode(entry.getValue().getExclusion()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(exclusionElement); // ROW 태그 밑에 추가 
            	
            	Element commentElement = doc.createElement("COMMENT");
            	commentElement.appendChild(doc.createTextNode(entry.getValue().getComment()+"")); // 태그 안에 들어갈 text 내용 추가 
            	rowElement.appendChild(commentElement); // ROW 태그 밑에 추가 
            	
            	
            	rootElement.appendChild(rowElement); // ROWS에 ROW 추가 
            }
            doc.appendChild(rootElement); // doc문서 바로 밑에 ROWS 태그 생성 -> 가장 상위 

            byte[] bytes = docToString(doc).getBytes();
            dos.write(bytes);
            dos.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private String docToString(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
