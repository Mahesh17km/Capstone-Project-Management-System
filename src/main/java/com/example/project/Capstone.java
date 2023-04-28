package com.example.project;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Capstone {


    @EqualsAndHashCode.Include
    @Id
    private int pid;
    private String problem_st;
    private String domain;
    private String team_id;
    private String guide;
    private String students;

    public Integer getId() {
        return pid;
    }

}
