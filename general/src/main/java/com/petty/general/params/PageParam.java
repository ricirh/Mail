package com.petty.general.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PageParam {
    @ApiModelProperty(name = "pageNum", required = true, value = "页码")
    private int pageNum;
    @ApiModelProperty(name = "pageSize", required = true, value = "单页大小")
    private int pageSize;
}
