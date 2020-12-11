package demoprojects.currencyconverterapi.controllers;

import demoprojects.currencyconverterapi.models.dto.response.ConvertCurrencyResponseDTO;
import demoprojects.currencyconverterapi.models.dto.request.ConvertCurrencyRequestDTO;
import demoprojects.currencyconverterapi.services.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    @Autowired
    CurrencyServiceImpl currencyService;

    @GetMapping("/convert")
    public ResponseEntity<ConvertCurrencyResponseDTO> convertCurrency(@RequestBody ConvertCurrencyRequestDTO convertCurrencyRequestDTO){
        ConvertCurrencyResponseDTO response = currencyService.convertCurrency(convertCurrencyRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
