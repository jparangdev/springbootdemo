package kr.co.jparangdev.springbootdemo.kakao.service;


import kr.co.jparangdev.springbootdemo.kakao.models.Stores;
import kr.co.jparangdev.springbootdemo.kakao.repository.StoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoresService {


    private static final Logger LOG = LoggerFactory.getLogger(BookMarkedStoresService.class);
    private final StoresRepository storesRepository;

    public StoresService(StoresRepository storesRepository) {
        this.storesRepository = storesRepository;
    }

    @Transactional
    public List<Stores> searchStores(String time) {


        return storesRepository.findAll().stream().map(s->{
            s.getName();
            StoresUtil.isOpen(s,time);
            return s;
        }).collect(Collectors.toList());
    }


}