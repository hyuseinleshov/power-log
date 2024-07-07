package com.hyuseinlesho.powerlog.repository;

import com.hyuseinlesho.powerlog.model.entity.UserEntity;
import com.hyuseinlesho.powerlog.model.entity.WeightLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public interface WeightLogRepository extends JpaRepository<WeightLog, Long> {
    List<WeightLog> findAllByUser(UserEntity currentUser);

    List<WeightLog> findByUserOrderByDateAsc(UserEntity currentUser);

    List<WeightLog> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
