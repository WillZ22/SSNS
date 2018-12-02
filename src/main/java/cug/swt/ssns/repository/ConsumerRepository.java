package cug.swt.ssns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cug.swt.ssns.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer>{

	public Consumer getConsumerByconsumerPort(String consumerPort);
	
}
