
public class Student {
	int id;
	String name;
	double pointConcept, pointPractice;

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getPointConcept() {
		return pointConcept;
	}

	void setPointConcept(double pointConcept) {
		this.pointConcept = pointConcept;
	}

	double getPointPractice() {
		return pointPractice;
	}

	void setPointPractice(double pointPractice) {
		this.pointPractice = pointPractice;
	}

	public Student(int id, String name, double pointConcept, double pointPractice) {
		this.id = id;
		this.name = name;
		this.pointConcept = pointConcept;
		this.pointPractice = pointPractice;
	}

	public double getPointAverage(Student s) {
		return (s.getPointConcept() * 1 + s.getPointPractice() * 2) / 3;
	}

	public static void displayStudent(Student s) {
		System.out.println("Code:  " + s.getId() + " Student " + s.getName() + ", Point : " + s.getPointAverage(s));
	}

	public static void main(String[] args) {
		Student st1 = new Student(1, "Linh1", 8f, 9f);
		Student st2 = new Student(2, "Linh2", 8f, 9f);
		Student st3 = new Student(3, "Linh3", 8f, 9f);
		displayStudent(st1);
		displayStudent(st2);
		displayStudent(st3);

	}

}
