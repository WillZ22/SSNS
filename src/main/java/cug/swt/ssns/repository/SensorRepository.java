package cug.swt.ssns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cug.swt.ssns.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer>{

	public Sensor getSensorBysensorid(String sensorID);
}
