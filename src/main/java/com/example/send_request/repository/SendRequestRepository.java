package com.example.send_request.repository;

import com.example.send_request.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendRequestRepository extends JpaRepository<Log, Long> {
}
