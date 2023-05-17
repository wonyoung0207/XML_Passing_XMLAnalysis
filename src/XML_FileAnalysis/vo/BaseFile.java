package XML_FileAnalysis.vo;

public class BaseFile{ // FIleID 가지고 있는 기본제공 파일 
//    <COL>FILE_ID</COL>
//    <COL>FILE_NAME</COL>
//    <COL>FILE_EXT</COL>
//    <COL>FILE_PATH</COL>
//    <COL>REAL_PATH</COL>
//    <COL>COPY_PATH</COL>
//    <COL>STATUS</COL>
//    <COL>START_TIME</COL>
//    <COL>END_TIME</COL>
//    <COL>TARGET_FILE_COUNT</COL>
//    <COL>EXCLUSION_COUNT</COL>
	
	private String fileId;
//	private String fileName;
//	private String fileExt;
//	private String filePath;
//	private String realPath;
//	private String copyPath;
//	private String status;
//	private String startTime;
//	private String endTime;
//	private String targetFileCount;
//	private String exclusionCount;
	
	
	public BaseFile() {
		
	}
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getFileExt() {
//		return fileExt;
//	}
//	public void setFileExt(String fileExt) {
//		this.fileExt = fileExt;
//	}
//	public String getFilePath() {
//		return filePath;
//	}
//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//	}
//	public String getRealPath() {
//		return realPath;
//	}
//	public void setRealPath(String realPath) {
//		this.realPath = realPath;
//	}
//	public String getCopyPath() {
//		return copyPath;
//	}
//	public void setCopyPath(String copyPath) {
//		this.copyPath = copyPath;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getStartTime() {
//		return startTime;
//	}
//	public void setStartTime(String startTime) {
//		this.startTime = startTime;
//	}
//	public String getEndTime() {
//		return endTime;
//	}
//	public void setEndTime(String endTime) {
//		this.endTime = endTime;
//	}
//	public String getTargetFileCount() {
//		return targetFileCount;
//	}
//	public void setTargetFileCount(String targetFileCount) {
//		this.targetFileCount = targetFileCount;
//	}
//	public String getExclusionCount() {
//		return exclusionCount;
//	}
//	public void setExclusionCount(String exclusionCount) {
//		this.exclusionCount = exclusionCount;
//	}
//	
	@Override
	public String toString() {
		return "BaseFile [fileId = " + fileId + "]";
//		return "BaseFile [fileId=" + fileId + ", fileName=" + fileName + ", fileExt=" + fileExt + ", filePath=" + filePath
//				+ ", realPath=" + realPath + ", copyPath=" + copyPath + ", status=" + status + ", startTime="
//				+ startTime + ", endTime=" + endTime + ", targetFileCount=" + targetFileCount + ", exclusionCount="
//				+ exclusionCount + "]";
	}
	
	
	

}
