package com.victorqueiroga.spring_ai_project.forms;

import java.io.Serializable;

import lombok.Data;

@Data
public class SimplePromptForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String prompt;

}
