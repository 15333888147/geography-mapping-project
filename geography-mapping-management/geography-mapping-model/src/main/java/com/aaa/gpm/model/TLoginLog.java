package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TLoginLog {
    private String username;

    private String loginTime;

    private String location;

    private String ip;

    private String operationType;

    private String operationName;
}