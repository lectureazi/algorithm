package c_datastructure.dto;

import java.util.Objects;

public class School implements Comparable<School> {
	
	private String name;
	private String address;
	private int level;
	
	public School(String name, String address, int levle) {
		super();
		this.name = name;
		this.address = address;
		this.level = levle;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof School school)) return false;
        return level == school.level && Objects.equals(name, school.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, level);
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", address=" + address + ", levle=" + level + "]";
	}

	@Override
	public int compareTo(School o) {
		//* level 기준으로 오름차순 정렬하되, 만약 level이 같다면 대학교 이름으로 내림차순정렬
		if(this.level == o.level) {
			return this.name.compareTo(o.name) * -1;
		}
		
		return this.level - o.level;
	}


}
