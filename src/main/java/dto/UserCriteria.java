package dto;

public class UserCriteria {
	private int uid;
	private int fid;
	private int did;
	
	public UserCriteria() {
		
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	@Override
	public String toString() {
		return "UserCriteria [uid=" + uid + ", fid=" + fid + ", did=" + did + "]";
	}
	
}
