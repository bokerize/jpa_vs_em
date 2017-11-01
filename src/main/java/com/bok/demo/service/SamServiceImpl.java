package com.bok.demo.service;

import com.bok.demo.db.ReqSentJpaRepo;
import com.bok.demo.db.SamJpaRepo;
import com.bok.demo.db.SamRepo;
import com.bok.demo.model.ReqSent;
import com.bok.demo.model.SamJpaTab;
import com.bok.demo.model.SamTab;

import javax.inject.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JerichoJohn on 01-Nov-17.
 */
@Named
public class SamServiceImpl implements SamService {

    @Inject
    SamRepo samRepo;

    @Inject
    SamJpaRepo samJpaRepo;

    @Inject
    ReqSentJpaRepo reqSentJpaRepo;

    public void doEmService(String endPointId, boolean isSaveAndFlush) {

        Iterable<SamTab> iter1 = samRepo.findByOtherIsNull();
        Iterator<SamTab> stIter = iter1.iterator();
System.out.println(" loop sam EM  START ");
        while(stIter.hasNext()) {
            SamTab st = stIter.next();
System.out.println(" loop samTab id [" + st.getId() + "] ep [" + endPointId + "]");
            st.setOther("endpointId [" + endPointId + "]");
            if (isSaveAndFlush) {
                samRepo.save(st);
            } else {
                samRepo.save(st);
            }
            wait(3);

            ReqSent rs = new ReqSent();
            rs.setSamId(String.valueOf(st.getId()));
            rs.setSamType("EM");
            rs.setComment(" sent for endpoint [" + endPointId + "]");

            reqSentJpaRepo.save(rs);
            st.setOther(st.getOther() + " request sent ID " + rs.getId());

            samRepo.save(st);
        }
System.out.println(" loop sam EM  END ");

    }


    public void doJpaService(String endPointId, boolean isSaveAndFlush) {

        Iterable<SamJpaTab> iter1 = samJpaRepo.findByOtherIsNull();
        Iterator<SamJpaTab> stIter = iter1.iterator();
        System.out.println(" loop sam JPA START ");
        while(stIter.hasNext()) {
            SamJpaTab st = stIter.next();
            System.out.println(" loop samTab id [" + st.getId() + "] ep [" + endPointId + "]");
            st.setOther("endpointId [" + endPointId + "]");
            if (isSaveAndFlush) {
                samJpaRepo.save(st);
            } else {
                samJpaRepo.saveAndFlush(st);
            }
            wait(3);

            ReqSent rs = new ReqSent();
            rs.setSamId(String.valueOf(st.getId()));
            rs.setSamType("JPA");
            rs.setComment(" sent for endpoint [" + endPointId + "]");

            reqSentJpaRepo.save(rs);
            st.setOther(st.getOther() + " request sent ID " + rs.getId());

            samJpaRepo.save(st);
        }
        System.out.println(" loop sam JPA END");

    }


    public void doJpaServicePreMark(String endPointId, boolean isSaveAndFlush) {

        Iterable<SamJpaTab> iter1 = samJpaRepo.findByOtherIsNull();
        List<SamJpaTab> list = new ArrayList<>();
        iter1.forEach(list::add);

        System.out.println(" loop sam JPA START 1 --  " + endPointId);

        for (SamJpaTab st : list) {

            System.out.println(" loop sam JPA id " + st.getId());

            st.setOther("endpointId [" + endPointId + "] -- marking");
            if (isSaveAndFlush) {
                samJpaRepo.save(st);
            } else {
                samJpaRepo.saveAndFlush(st);
            }
        }

        System.out.println(" loop sam JPA START 2 " + endPointId);


        for (SamJpaTab st : list) {

            System.out.println(" loop sam JPA id " + st.getId());

            wait(3);
            ReqSent rs = new ReqSent();
            rs.setSamId(String.valueOf(st.getId()));
            rs.setSamType("JPA");
            rs.setComment(" sent for endpoint [" + endPointId + "]");

            reqSentJpaRepo.save(rs);
            st.setOther(st.getOther() + " request sent ID " + rs.getId());

            if (isSaveAndFlush) {
                samJpaRepo.save(st);
            } else {
                samJpaRepo.saveAndFlush(st);
            }
        }

        System.out.println(" loop sam JPA END " + endPointId);

    }
    private void wait(int secs) {
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
        }
    }
}
