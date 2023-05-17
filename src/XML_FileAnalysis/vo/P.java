package XML_FileAnalysis.vo;

public class P { // License 값 가지고 있는 파일 
//    <COL>P_ID</COL>
//    <COL>PROJECT_NAME</COL>
//    <COL>LICENSE_ID</COL>
//    <COL>LICENSE_NAME</COL>
//    <COL>LICENSE_DISPLAY</COL>
//    <COL>SIZE</COL>
//    <COL>TOPIC_CD</COL>
//    <COL>TOPIC_NAME</COL>
	
	
	private String pId;
	private String licenseId;
//	private String projectName;
//	private String licenseName;
//	private String licenseDisplay;
//	private String size;
//	private String topicCD;
//	private String topicName;
	
	
	public P() {
		
	}
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
//	public String getProjectName() {
//		return projectName;
//	}
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}
//	public String getLicenseName() {
//		return licenseName;
//	}
//	public void setLicenseName(String licenseName) {
//		this.licenseName = licenseName;
//	}
//	public String getLicenseDisplay() {
//		return licenseDisplay;
//	}
//	public void setLicenseDisplay(String licenseDisplay) {
//		this.licenseDisplay = licenseDisplay;
//	}
//	public String getSize() {
//		return size;
//	}
//	public void setSize(String size) {
//		this.size = size;
//	}
//	public String getTopicCD() {
//		return topicCD;
//	}
//	public void setTopicCD(String topicCD) {
//		this.topicCD = topicCD;
//	}
//	public String getTopicName() {
//		return topicName;
//	}
//	public void setTopicName(String topicName) {
//		this.topicName = topicName;
//	}
	
	@Override
	public String toString() {
		return "P [pId=" + pId + ", licenseId=" + licenseId + "]";
		
//		return "P [pId=" + pId + ", projectName=" + projectName + ", licenseId=" + licenseId + ", licenseName="
//				+ licenseName + ", licenseDisplay=" + licenseDisplay + ", size=" + size + ", topicCD=" + topicCD
//				+ ", topicName=" + topicName + "]";
	}
	

}
