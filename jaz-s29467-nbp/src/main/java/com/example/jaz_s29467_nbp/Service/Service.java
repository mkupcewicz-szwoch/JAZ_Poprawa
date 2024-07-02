package com.example.jaz_s29467_nbp.Service;

import com.example.jaz_s29467_nbp.Gold_rate;
import com.example.jaz_s29467_nbp.NbpRepository;
import com.example.jaz_s29467_nbp.ResponseNBP;
import com.example.jaz_s29467_nbp.gold;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;



@org.springframework.stereotype.Service
public class Service {


    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;


    public Service(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;

    }



    public ResponseNBP getAvg_total(LocalDate start_date, LocalDate end_date)
    {
        String nbpApiUrl = String.format( "https://api.nbp.pl/api/cenyzlota/%s/%s/", start_date, end_date);
        ResponseNBP response = restTemplate.getForObject(nbpApiUrl,ResponseNBP.class);
        response.setAvg_total(calculateAvg_total(response));
        Gold_rate goldrate = new Gold_rate(null, gold.GOLD, start_date, end_date, response.getAvg_total(), Instant.now());
        return response;
    }



    public double calculateAvg_total(ResponseNBP response){
        return response.getRates()
                .stream()
                .mapToDouble(r -> r.getMid())
                .average()
                .orElse(0.0);
    }
}
