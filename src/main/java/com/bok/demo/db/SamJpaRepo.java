package com.bok.demo.db;

import com.bok.demo.model.SamJpaTab;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JerichoJohn on 01-Nov-17.
 */
public interface SamJpaRepo extends JpaRepository<SamJpaTab, Long>{

    Iterable<SamJpaTab> findByOtherIsNull();
}
