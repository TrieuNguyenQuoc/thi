package com.example.test4.service.impl;


import com.example.test4.model.PhongBan;
import com.example.test4.repository.PhongBanRepository;
import com.example.test4.service.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhongBanService implements IPhongBanRepository {
    @Autowired
    private PhongBanRepository phongBanRepository;
    @Override
    public Iterable<PhongBan> findAll() {
        return phongBanRepository.findAll();
    }

    @Override
    public Optional<PhongBan> findById(Long id) {
        return phongBanRepository.findById(id);
    }

    @Override
    public void save(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    @Override
    public void delete(Long id) {
        phongBanRepository.deleteById(id);
    }
}
