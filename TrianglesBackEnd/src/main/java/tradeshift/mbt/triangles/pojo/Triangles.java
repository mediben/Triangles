package tradeshift.mbt.triangles.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Triangles")
public class Triangles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "pointA")
	private float pointA;
	
	@Column(name = "pointB")
	private float pointB;
	
	@Column(name = "pointC")
	private float pointC;
	
	@Column(name = "type")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPointA() {
		return pointA;
	}

	public void setPointA(float pointA) {
		this.pointA = pointA;
	}

	public float getPointB() {
		return pointB;
	}

	public void setPointB(float pointB) {
		this.pointB = pointB;
	}

	public float getPointC() {
		return pointC;
	}

	public void setPointC(float pointC) {
		this.pointC = pointC;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
