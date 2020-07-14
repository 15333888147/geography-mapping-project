package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TLoginLog implements Serializable {
    private String username;

    private String loginTime;

    private String location;

    private String ip;

    private String operationType;

    private String operationName;
}