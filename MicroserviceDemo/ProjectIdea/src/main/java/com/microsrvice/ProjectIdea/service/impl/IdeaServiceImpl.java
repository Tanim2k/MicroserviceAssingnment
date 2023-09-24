package com.microsrvice.ProjectIdea.service.impl;

import com.microsrvice.ProjectIdea.dto.EntreprenureDto;
import com.microsrvice.ProjectIdea.dto.IdeaAndInvestDto;
import com.microsrvice.ProjectIdea.dto.IdeaDto;
import com.microsrvice.ProjectIdea.dto.InvestorDto;
import com.microsrvice.ProjectIdea.entity.Ideas;
import com.microsrvice.ProjectIdea.networkmanager.EntrepreneurFeignClient;
import com.microsrvice.ProjectIdea.repository.IdeaRepo;
import com.microsrvice.ProjectIdea.service.IdeaService;
import com.microsrvice.ProjectIdea.service.InvestorClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeaServiceImpl implements IdeaService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IdeaRepo ideaRepo;


    private final EntrepreneurFeignClient apiClient;
    @Autowired
    private InvestorClient investorClient;

    public IdeaServiceImpl(EntrepreneurFeignClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public IdeaDto createIdea(Ideas ideas) {
            ideaRepo.save(ideas);
            return modelMapper.map(ideas,IdeaDto.class);
    }

    @Override
    public IdeaAndInvestDto getIdea(Long id) {
        Ideas ideas=ideaRepo.findById(id).orElseThrow();
        Long enpCode = ideas.getIdeaCode();

        EntreprenureDto entreprenureDto=apiClient.getEntrepreneur(enpCode);
        IdeaDto ideaDto=modelMapper.map(ideas,IdeaDto.class);
        InvestorDto investorDto=modelMapper.map(investorClient.getInvestor(ideas.getInvestCode()),InvestorDto.class);
        return new IdeaAndInvestDto(entreprenureDto,ideaDto,investorDto);
    }
}

