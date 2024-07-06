package TruckCreation;

import java.io.Serializable;
import java.time.LocalDate;

public class Truckbean implements Serializable {
	private String truckmodel;
	private int truckno;
	private String insurecnce;
	private String cmpname;
	private String owner;
	private long mobileno;
	private String route_from;
	private String route_to;
	private LocalDate adddate;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getAdddate() {
		return adddate;
	}
	public void setAdddate(LocalDate adddate) {
		this.adddate = adddate;
	}
	public String getTruckmodel() {
		return truckmodel;
	}
	public void setTruckmodel(String truckmodel) {
		this.truckmodel = truckmodel;
	}
	public int getTruckno() {
		return truckno;
	}
	public void setTruckno(int truckno) {
		this.truckno = truckno;
	}
	public String getInsurecnce() {
		return insurecnce;
	}
	public void setInsurecnce(String insurecnce) {
		this.insurecnce = insurecnce;
	}
	public String getCmpname() {
		return cmpname;
	}
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getRoute_from() {
		return route_from;
	}
	public void setRoute_from(String route_from) {
		this.route_from = route_from;
	}
	public String getRoute_to() {
		return route_to;
	}
	public void setRoute_to(String route_to) {
		this.route_to = route_to;
	}
	
	
	

}
