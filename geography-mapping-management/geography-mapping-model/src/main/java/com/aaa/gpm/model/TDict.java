package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TDict {
    private Long dictId;

    private Long keyy;

    private String valuee;

    private String fieldName;

    private String tableName;
}