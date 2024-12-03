package com.ansari.HomeWork.controller;
//week twogit
import com.ansari.HomeWork.dto.DepartmentDto;
import com.ansari.HomeWork.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // GET: /departments
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    //GET: /departments/{id}
    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);

    }

    //POST: /departments
    @PostMapping
    public ResponseEntity<DepartmentDto> createNewDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    //PUT: /departments/{DepartmentId}
    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) {
        return new ResponseEntity<>(departmentService.updateDepartmentById(departmentDto, id), HttpStatus.OK);
    }

    // DELETE: /departments
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long id) {
        boolean deleted = departmentService.deleteDepartment(id);
        if (deleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    //PATCH: /departmens/{DepartmentId}
    @PatchMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> updatePartialDepartmentById(@RequestBody Map<String, Object> updates,
                                                                     @PathVariable Long id) {
        DepartmentDto departmentDto = departmentService.updatePartialDepartmentById(updates, id);
        if(departmentDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDto);
    }


}
