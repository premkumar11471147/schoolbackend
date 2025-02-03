package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Section;

public interface SectionService {

    void deleteSection(Section section);

    Iterable<Section> getAllSection();

    void saveSection(Section section);

    Section getSectionById(long id);
    
}
