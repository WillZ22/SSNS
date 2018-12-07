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
	 * 传感器频率
	 */
	@Column(nullable=false)
	private String frequence;
	
	/**
	 * 状态改变时间
	 */
	@Column(nullable=true)
	private String statusChangeTime;
	
	/**
	 * 观测频率改变时间
	 */
	@Column(nullable=true)
	private String frequenceChangeTime;
	
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
	

	public String getSensorid() {
		return sensorid;
	}

	public void setSensorid(String sensorid) {
		this.sensorid = sensorid;
	}

	public String getStatusChangeTime() {
		return statusChangeTime;
	}

	public void setStatusChangeTime(String statusChangeTime) {
		this.statusChangeTime = statusChangeTime;
	}

	public String getFrequenceChangeTime() {
		return frequenceChangeTime;
	}

	public void setFrequenceChangeTime(String frequenceChangeTime) {
		this.frequenceChangeTime = frequenceChangeTime;
	}

	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}

	@Override
	public String toString() {
		return "Sensor [sid=" + sid + ", sensorid=" + sensorid + ", sosAdress=" + sosAdress + ", status=" + status
				+ ", frequence=" + frequence + ", statusChangeTime=" + statusChangeTime + ", frequenceChangeTime="
				+ frequenceChangeTime + ", consumers=" + consumers + "]";
	}

	

	
}
