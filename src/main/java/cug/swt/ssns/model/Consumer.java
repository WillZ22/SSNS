package cug.swt.ssns.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

/**
 * 用户模型
 * @author HP
 *
 */
@Entity
@Table(name = "td_consumer", uniqueConstraints = {@UniqueConstraint(columnNames="consumerPort")})
public class Consumer {
	
	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue
	private int cid;
	
	/**
	 * 用户接口
	 */
	@Column(nullable=false)
	private String consumerPort;
	
	/**
	 * 用户订阅传感器列表
	 */
	@ManyToMany
	@JoinColumn(name = "sid", nullable = true)
	private Set<Sensor> subscribedSensor = new HashSet<Sensor>();
	
	
	public String getConsumerPort() {
		return consumerPort;
	}
	public void setConsumerPort(String consumerPort) {
		this.consumerPort = consumerPort;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Set<Sensor> getSubscribedSensor() {
		return subscribedSensor;
	}
	public void setSubscribedSensor(Set<Sensor> subscribedSensor) {
		this.subscribedSensor = subscribedSensor;
	}
	@Override
	public String toString() {
		return "Consumer [cid=" + cid + ", consumerPort=" + consumerPort + ", subscribedSensor=" + subscribedSensor
				+ "]";
	}
	
	
}
