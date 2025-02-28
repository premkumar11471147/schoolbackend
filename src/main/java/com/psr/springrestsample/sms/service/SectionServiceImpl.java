package com.psr.springrestsample.sms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psr.springrestsample.sms.model.SectionModel;
import com.psr.springrestsample.sms.repository.SectionRepository;

@Service
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepository;

    @Autowired
    public void setSectionService(SectionRepository sectionRepository){
        this.sectionRepository = sectionRepository;
    }

    @Override
    public void deleteSection(SectionModel section) {
        
        sectionRepository.delete(section);
    }

    @Override
    public Iterable<SectionModel> getAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public void saveSection(SectionModel section) {
        sectionRepository.save(section);
    }

    @Override
    public SectionModel getSectionById(long id) {
        return sectionRepository.findById(id);
    }
     
}
