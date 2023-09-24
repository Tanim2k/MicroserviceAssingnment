package com.microsrvice.ProjectIdea.networkmanager;

import com.microsrvice.ProjectIdea.dto.EntreprenureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "entrepreneur")
public interface EntrepreneurFeignClient {
    @GetMapping("/api/get/{id}")
    EntreprenureDto getEntrepreneur(@PathVariable Long id);
}
