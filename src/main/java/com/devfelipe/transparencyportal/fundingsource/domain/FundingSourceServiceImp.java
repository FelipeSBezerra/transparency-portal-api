package com.devfelipe.transparencyportal.fundingsource.domain;

import com.devfelipe.transparencyportal.common.domain.BaseServiceImp;
import com.devfelipe.transparencyportal.fundingsource.domain.model.FundingSource;
import com.devfelipe.transparencyportal.fundingsource.dto.FundingSourceMapper;
import com.devfelipe.transparencyportal.fundingsource.dto.FundingSourceRequestDto;
import com.devfelipe.transparencyportal.fundingsource.dto.FundingSourceResponseDto;
import com.devfelipe.transparencyportal.fundingsource.infra.FundingSourceRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class FundingSourceServiceImp extends BaseServiceImp<FundingSource, Integer, FundingSourceRequestDto, FundingSourceResponseDto> implements FundingSourceService{

    private final FundingSourceMapper fundingSourceMapper;

    protected FundingSourceServiceImp(final FundingSourceRepository fundingSourceRepository, FundingSourceMapper fundingSourceMapper) {
        super(FundingSource.class, fundingSourceRepository, fundingSourceMapper);
        this.fundingSourceMapper = fundingSourceMapper;
    }

    @Override
    protected FundingSource _createEntityFromDto(FundingSourceRequestDto fundingSourceRequestDto) {
        return this.fundingSourceMapper.mapToFundingSource(fundingSourceRequestDto);
    }

    @Override
    protected FundingSource _updateEntityFromDto(Integer entityId, FundingSourceRequestDto fundingSourceRequestDto) {
        FundingSource savedFundingSource = this.findByIdReturnsEntity(entityId);
        _updateData(savedFundingSource, fundingSourceRequestDto);
        return savedFundingSource;
    }

    private void _updateData(FundingSource savedFundingSource, FundingSourceRequestDto fundingSourceRequestDto) {
        savedFundingSource.setName(fundingSourceRequestDto.name());
        savedFundingSource.setUpdatedAt(Instant.now());
    }
}