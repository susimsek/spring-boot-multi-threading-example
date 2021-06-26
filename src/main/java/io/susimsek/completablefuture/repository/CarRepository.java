package io.susimsek.completablefuture.repository;

import io.susimsek.completablefuture.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}