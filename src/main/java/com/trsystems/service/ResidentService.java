package com.trsystems.service;

import com.trsystems.model.Resident;
import com.trsystems.model.record.ResidentRecord;

import jakarta.validation.Valid;

public interface ResidentService {

	ResidentRecord create(@Valid ResidentRecord residentRecord);

	Resident findById(Long id);

}
