package tradeshift.mbt.triangles.pojo;

public class Shape {
	private Float pointA;
	private Float pointB;
	private Float pointC;
	
	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shape(Float pointA, Float pointB, Float pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	public Float getPointA() {
		return pointA;
	}
	public void setPointA(Float pointA) {
		this.pointA = pointA;
	}
	public Float getPointB() {
		return pointB;
	}
	public void setPointB(Float pointB) {
		this.pointB = pointB;
	}
	public Float getPointC() {
		return pointC;
	}
	public void setPointC(Float pointC) {
		this.pointC = pointC;
	}
	
}
