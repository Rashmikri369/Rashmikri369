package dto;

import java.util.Date;

public class SearchCriteria {

	private Date udate;
	private String usource;
	private String udestination;
	private int upersons;
	private int fid;
	private int padded;
	private String pnr;
	private int uticketprice;
	private double totalfare;
 	
	public SearchCriteria() {
		
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public String getUsource() {
		return usource;
	}

	public void setUsource(String usource) {
		this.usource = usource;
	}

	public String getUdestination() {
		return udestination;
	}

	public void setUdestination(String udestination) {
		this.udestination = udestination;
	}

	public int getUpersons() {
		return upersons;
	}

	public void setUpersons(int upersons) {
		this.upersons = upersons;
	}

	public int getFid() {
		return fid;
	}
	
	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getPadded() {
		return padded;
	}
	
	public void setPadded(int padded) {
		this.padded = padded;
	}

	public String getPnr() {
		return pnr;
	}
	
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	public int getUticketprice() {
		return uticketprice;
	}

	public void setUticketprice(int uticketprice) {
		this.uticketprice = uticketprice;
	}

	public double getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(double totalfare) {
		this.totalfare = totalfare;
	}

	@Override
	public String toString() {
		return "SearchCriteria [udate=" + udate + ", usource=" + usource + ", udestination=" + udestination
				+ ", upersons=" + upersons + ", fid=" + fid + ", padded=" + padded + ", pnr=" + pnr + ", uticketprice="
				+ uticketprice + ", totalfare=" + totalfare + "]";
	}
	
	
}