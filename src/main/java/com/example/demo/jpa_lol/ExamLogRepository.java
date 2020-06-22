package com.example.demo.jpa_lol;

import com.example.demo.entity.ExamLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamLogRepository extends JpaRepository<ExamLog,Long> {
}
