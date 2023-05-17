package XML_FileAnalysis.vo;

public class ResultFile { // 결과 생성 파일 
//    <ROWID>130484953</ROWID>
//    <VOLUME>v_12</VOLUME>
//    <FILE_NAME/>
//    <RELEASE_NAME/>
//    <SIMILAR_RATE>1731</SIMILAR_RATE>
//    <FILE_PATH/>
//    <P_ID>171356</P_ID>
//    <EXCLUSION>YES</EXCLUSION>
//    <COMMENT/>
	
	private String rowId;
	private String volume;
	private String fileName;
	private String releseName;
	private String similarRate;
	private String filePath;
	private String pId;
	private String exclusion;
	private String comment;
	
	public ResultFile() {
		
	}
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReleseName() {
		return releseName;
	}
	public void setReleseName(String releseName) {
		this.releseName = releseName;
	}
	public String getSimilarRate() {
		return similarRate;
	}
	public void setSimilarRate(String similarRate) {
		this.similarRate = similarRate;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getExclusion() {
		return exclusion;
	}
	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "ResultFile [rowId=" + rowId + ", volume=" + volume + ", fileName=" + fileName + ", releseName=" + releseName
				+ ", similarRate=" + similarRate + ", filePath=" + filePath + ", pId=" + pId + ", exclusion="
				+ exclusion + ", comment=" + comment + "]";
	}
	
	

}
