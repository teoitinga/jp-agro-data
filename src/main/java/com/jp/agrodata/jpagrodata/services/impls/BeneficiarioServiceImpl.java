package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.dtos.BeneficiarioPostDTO;
import com.jp.agrodata.jpagrodata.models.entities.Beneficiario;
import com.jp.agrodata.jpagrodata.services.BeneficiarioService;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {
    @Override
    public BeneficiarioPostDTO registraBeneficiario(BeneficiarioPostDTO dto) {
        Beneficiario beneficiario = toBeneficiario(dto);
        BeneficiarioPostDTO response = toBeneficiarioPostDTO(beneficiario);
        return response;
    }

    private BeneficiarioPostDTO toBeneficiarioPostDTO(Beneficiario beneficiario) {
        return null;
    }

    private Beneficiario toBeneficiario(BeneficiarioPostDTO dto) {
        return null;
    }
}
