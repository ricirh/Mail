package com.petty.order.params;

import com.petty.general.params.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderParam extends PageParam {
    @ApiModelProperty(value = "用户Id", name = "userId")
    String userId;
}
