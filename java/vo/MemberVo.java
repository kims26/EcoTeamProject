package vo;

public class MemberVo {
	String mem_name,mem_id,mem_pwd,mem_ip,mem_regdate;
	
	int mem_idx;
	
	
	
	public MemberVo() {
	}

	//insert¿ë
	public MemberVo(String mem_name, String mem_id, String mem_pwd, String mem_ip) {
		super();
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_ip = mem_ip;
	}

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	
	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_ip() {
		return mem_ip;
	}

	public void setMem_ip(String mem_ip) {
		this.mem_ip = mem_ip;
	}

	public String getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
}
