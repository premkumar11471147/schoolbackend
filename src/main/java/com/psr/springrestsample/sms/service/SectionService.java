package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.SectionModel;

public interface SectionService {

    void deleteSection(SectionModel section);

    Iterable<SectionModel> getAllSection();

    void saveSection(SectionModel section);

    SectionModel getSectionById(long id);
    
}
