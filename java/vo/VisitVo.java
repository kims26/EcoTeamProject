package vo;


public class VisitVo {
	int visit_idx,mem_idx;
	String visit_content,visit_ip,regdate;
	
	MemberVo mem_vo;
	
	

	public VisitVo() {
		super();
	}
	
	
	public VisitVo(int mem_idx, String visit_content, String visit_ip) {
		super();
		this.mem_idx = mem_idx;
		this.visit_content = visit_content;
		this.visit_ip = visit_ip;
	}

	public MemberVo getMem_vo() {
		return mem_vo;
	}
	public void setMem_vo(MemberVo mem_vo) {
		this.mem_vo = mem_vo;
	}
	public int getVisit_idx() {
		return visit_idx;
	}
	public void setVisit_idx(int visit_idx) {
		this.visit_idx = visit_idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getVisit_content() {
		return visit_content;
	}
	public void setVisit_content(String visit_content) {
		this.visit_content = visit_content;
	}
	public String getVisit_ip() {
		return visit_ip;
	}
	public void setVisit_ip(String visit_ip) {
		this.visit_ip = visit_ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
