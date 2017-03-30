/**
 * 
 */
package cc.chaoyangliu.rmiprac.test;

/**
 * @author bird
 *
 */
public class Student {
	private String name;
	private String id;
	private int grade;

	/**
	 * 
	 */
	public Student(String n, String i, int g) {
		name = n;
		id = i;
		grade = g;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", grade=" + grade + "]";
	}
}
