package XML_FileAnalysis;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

import XML_FileAnalysis.handler.FHandler;
import XML_FileAnalysis.handler.ShapeFactory;
import XML_FileAnalysis.vo.BaseFile;
import XML_FileAnalysis.vo.F;

public class StartAnalysis {
	public static void main(String[] args) {
		// 실행전 시간
		long beforeTime = System.nanoTime();
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();

		// 실행전 메모리 사용량 조회
		long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		
		// ******* 측정 코드 시작 ********
		Analysis anlaysis = new Analysis();
		anlaysis.run(); // 분석 시작 
		

		// ******* 측정 코드 끝 ********
		// 실행 후 시간
		long afterTime = System.nanoTime();
		
		// 실행 전 후 시간 차이
		double secDiffTime = (double)(afterTime - beforeTime)/1000000;

		// 실행 후 메모리 사용량 조회
		long after  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		// 메모리 사용량 측정
		long usedMemory = (after - before)/1024;

		System.out.println("메모리 사용량(kbyte) : " + usedMemory);
		System.out.println("소요시간(ms) : "+secDiffTime);

	}
}
