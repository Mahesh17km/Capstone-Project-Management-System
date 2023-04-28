package com.example.faculty;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Faculty {


    @EqualsAndHashCode.Include
    @Id
    private String name;
    private String faculty_id;
    private String specialization;
    private String email;
    private String teams;

}
