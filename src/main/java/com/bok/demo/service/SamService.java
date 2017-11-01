package com.bok.demo.service;
/**
 * Created by JerichoJohn on 01-Nov-17.
 */
public interface SamService {

    void doEmService(String endPointId, boolean isSaveAndFlush);
    void doJpaService(String endPointId, boolean isSaveAndFlush);
    void doJpaServicePreMark(String endPointId, boolean isSaveAndFlush);
}
