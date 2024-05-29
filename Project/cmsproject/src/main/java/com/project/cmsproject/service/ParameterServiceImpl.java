package com.project.cmsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cmsproject.entities.Parameter;
import com.project.cmsproject.repsoitories.ParameterRepository;

@Service
@Transactional
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterRepository parameterRepository;

    @Override
    public Parameter createParameter(Parameter parameter) {
        return parameterRepository.save(parameter);
    }
}
