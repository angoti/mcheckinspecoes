package com.mcheck.inspection.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-delivery-man")
public interface UsuarioFeign {
    @GetMapping("/deliveryman/delete/{id}")
    void getUsuario(@PathVariable String id);

}
