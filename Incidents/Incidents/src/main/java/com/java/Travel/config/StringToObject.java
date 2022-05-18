package com.java.Travel.config;

import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.repository.DetachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToObject implements Converter<String, DetachmentEntity> {

        @Autowired
        private DetachmentRepository repository;

        @Override
        public DetachmentEntity convert(String source) {
            return repository.findByDetachmentName(source);
        }

}
