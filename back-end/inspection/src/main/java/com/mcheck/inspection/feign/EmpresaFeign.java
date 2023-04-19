package com.mcheck.inspection.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ms-delivery-man")
public interface EmpresaFeign {
}
