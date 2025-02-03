package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Classe;

public interface ClasseService{

    Iterable<Classe> getAllClasse();

    void deleteClasse(Classe classe);

    void saveClasse(Classe classe);

    Classe getClasseById(long id);


	
}