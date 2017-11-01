package com.bok.demo.db;

import com.bok.demo.model.SamJpaTab;
import com.bok.demo.model.SamTab;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by JerichoJohn on 01-Nov-17.
 */
public interface SamRepo  extends CrudRepository<SamTab, Long> {/**
 * Created by JerichoJohn on 30-Sep-17.
 */
    Iterable<SamTab> findByOtherIsNull();
}
