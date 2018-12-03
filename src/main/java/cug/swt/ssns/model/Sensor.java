package cug.swt.ssns.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 传感器模型
 * @author HP
 *
 */
@Entity
@Table(name = "td_sensor", uniqueConstraints = {@UniqueConstraint(columnNames = "sensorid")})
public class Sensor {
	
	/**
	 *传感器ID
	 */
	@Id
	@GeneratedValue
	private int sid;
	
	@Column(nullable=false)
	private String sensorid;
	
	/**
	 * 传感器数据地址
	 */
	@Column(nullable=false)
	private String sosAdress;
	
	/**
	 * 传感器状态
	 */
	@Column(nullable=true)
	private String status;
	
	/**
	 * 改变时间
	 */
	@Column(nullable=true)
	private String changeTime;
	
	/**
	 * 订阅的用户
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid", nullable = true)
	private Set<Consumer> consumers = new HashSet<Consumer>();

	
	public String getSosAdress() {
		return sosAdress;
	}

	public void setSosAdress(String sosAdress) {
		this.sosAdress = sosAdress;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Set<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(Set<Consumer> consumers) {
		this.consumers = consumers;
	}
	

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String getSensorid() {
		return sensorid;
	}

	public void setSensorid(String sensorid) {
		this.sensorid = sensorid;
	}

	@Override
	public String toString() {
		return "Sensor [sid=" + sid + ", sensorid=" + sensorid + ", sosAdress=" + sosAdress + ", status=" + status
				+ ", changeTime=" + changeTime + ", consumers=" + consumers + "]";
	}
}
