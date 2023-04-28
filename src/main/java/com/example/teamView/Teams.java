package com.example.teamView;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Teams {


    @EqualsAndHashCode.Include
    @Id
    private String team_id;
    private String guide;
    private String students;
    private String project_title;
}
