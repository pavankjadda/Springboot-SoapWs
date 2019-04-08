package com.springdemo.soapws.web;

import com.bcmcgroup.mockdbsoap.generatedws.ApplicantIdWrapper;
import com.bcmcgroup.mockdbsoap.generatedws.ApplicantInfo;
import com.springdemo.soapws.constants.ApiConstants;
import com.springdemo.soapws.model.Applicant;
import com.springdemo.soapws.repository.ApplicantRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class ApplicantEndpoint
{
    private final ApplicantRepository applicantRepository;

    public ApplicantEndpoint(ApplicantRepository applicantRepository)
    {
        this.applicantRepository = applicantRepository;
    }

    @PayloadRoot(namespace = ApiConstants.NAMESPACE_URI, localPart = "applicantLookupRequest")
    @ResponsePayload
    public ApplicantInfo getApplicant(@RequestPayload ApplicantIdWrapper applicantIdWrapper)
    {
        ApplicantInfo applicantInfo = new ApplicantInfo();
        Optional<Applicant> applicantOptional = applicantRepository.findById(Long.valueOf(applicantIdWrapper.getAid()));
        if (applicantOptional.isPresent())
        {
            Applicant applicant = applicantOptional.get();
            applicantInfo.setAid(String.valueOf(applicant.getId()));
            applicantInfo.setAlienNumber(String.valueOf(applicant.getAlienNumber()));
            applicantInfo.setDob(String.valueOf(applicant.getDob()));
        }
        return applicantInfo;
    }
}
