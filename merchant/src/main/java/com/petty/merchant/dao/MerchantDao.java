package com.petty.merchant.dao;

import com.petty.merchant.entity.Merchant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDao {
    Merchant findMerchantByNameAndPW(@Param("username") String username, @Param("password") String password);
}
