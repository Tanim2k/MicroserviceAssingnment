package com.microsrvice.ProjectIdea.service;

import com.microsrvice.ProjectIdea.dto.EntreprenureDto;
import com.microsrvice.ProjectIdea.dto.InvestorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "investor")
public interface InvestorClient {

    @GetMapping("/invest/get/{id}")
    InvestorDto getInvestor(@PathVariable Long id);
}
