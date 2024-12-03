package com.ansari.HomeWork.service;

import com.ansari.HomeWork.dto.DepartmentDto;
import com.ansari.HomeWork.entity.DepartmentEntity;
import com.ansari.HomeWork.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;


    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    //Get All Departments
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> allDepartment = departmentRepository.findAll();
        return allDepartment.stream()
                .map(allDepartments -> modelMapper.map(allDepartments, DepartmentDto.class)).toList();
    }

    //Get Department By id
    public DepartmentDto  getDepartmentById(Long id) {
        Optional<DepartmentEntity> department = departmentRepository.findById(id);
        return department
                .map(department1 -> modelMapper.map(department1, DepartmentDto.class)).orElse(null);
    }

    //Create Department
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDto.class);
    }

    public boolean isExist(Long id){
        return departmentRepository.existsById(id);
    }

    //Update Department By id
    public DepartmentDto updateDepartmentById(DepartmentDto departmentDto, Long id) {
        if (isExist(id));
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        departmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    }

    //Delete Department By id
    public boolean deleteDepartment(Long id) {
        if (isExist(id));
        departmentRepository.deleteById(id);
        return true;
    }

    //Update some field by id
    public DepartmentDto updatePartialDepartmentById(Map<String, Object> updates, Long id) {
        if (isExist(id));
            DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDto.class);
    }
}
