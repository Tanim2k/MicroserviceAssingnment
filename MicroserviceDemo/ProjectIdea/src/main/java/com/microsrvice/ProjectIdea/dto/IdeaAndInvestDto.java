package com.microsrvice.ProjectIdea.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IdeaAndInvestDto {
    private EntreprenureDto entreprenureDto;
    private IdeaDto ideaDto;
    private InvestorDto investorDto;
}
