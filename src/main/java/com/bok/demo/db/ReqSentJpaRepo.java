package com.bok.demo.db;

import com.bok.demo.model.ReqSent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JerichoJohn on 01-Nov-17.
 */
public interface ReqSentJpaRepo extends JpaRepository<ReqSent, Long> {
}
