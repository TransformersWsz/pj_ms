package com.bosch.pj_ms.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WriteModel {
    @ColumnWidth(30)
    @ExcelProperty(value = "PRJ MCR-ID", index = 0)
    private String mcrId;

    @ColumnWidth(40)
    @ExcelProperty(value = "PRJ NAME", index = 1)
    private String name;
}
