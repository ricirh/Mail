package com.petty.commdity.params;

import com.petty.general.params.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class GoodsParam extends PageParam {

    @ApiModelProperty(name = "keyword", value = "关键词", dataType = "string")
    private String keyword;

    @ApiModelProperty(name = "minPrice", value = "最低价格", dataType = "double")
    private Double minPrice;

    @ApiModelProperty(name = "maxPrice", value = "最高价格", dataType = "double")
    private Double maxPrice;

    @ApiModelProperty(name = "sourceSite", value = "货源地", dataType = "string")
    private String sourceSite;

    @ApiModelProperty(name = "labels", value = "标签", dataType = "list")
    private String labels;

    @ApiModelProperty(name = "brands", value = "品牌", dataType = "list")
    private String brands;
}
