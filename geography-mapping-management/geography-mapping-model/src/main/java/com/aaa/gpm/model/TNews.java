package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TNews implements Serializable {
    private Long id;

    private String title;

    private String digest;

    private Date gmtCreate;

    private Date gmtModified;

    private String body;
}