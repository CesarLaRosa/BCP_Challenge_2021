package com.bcp.moneychange.controller;

import com.bcp.moneychange.entity.ChangeType;
import com.bcp.moneychange.exception.ResourceNotFoundException;
import com.bcp.moneychange.repository.ChangeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/changeType")
public class ChangeTypeController {

    @Autowired
    private ChangeTypeRepository changeTypeRepository;

    @GetMapping("/all")
    public List<ChangeType> getAllChangeTypes() {
        return changeTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity< ChangeType > getChangeTypeById(@PathVariable(value = "id") Long changeTypeId) {
        Optional<ChangeType> response = changeTypeRepository.findById(changeTypeId);
        return ResponseEntity.ok().body(response.get());
    }

    @GetMapping("/{sourceCurrency}/{destinationCurrency}")
    public ResponseEntity< ChangeType > getChangeTypeByCurrency(@PathVariable(value = "sourceCurrency") String sourceCurrency,
                                                                @PathVariable(value = "destinationCurrency") String destinationCurrency)
            throws ResourceNotFoundException {
        ChangeType searchSource = new ChangeType();
        searchSource.setSourceCurrency(sourceCurrency);
        searchSource.setDestinationCurrency(destinationCurrency);

        ChangeType changeType = changeTypeRepository.findBySourceAndDestinationCurrency(sourceCurrency,destinationCurrency)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this combination :: " + sourceCurrency + ","+ destinationCurrency));
        return ResponseEntity.ok().body(changeType);
    }

    @PostMapping()
    public ChangeType createChangeType(@Valid @RequestBody ChangeType changeType) {
        return changeTypeRepository.save(changeType);
    }

    @PutMapping("/{id}")
    public ResponseEntity < ChangeType > updateChangeType(@PathVariable(value = "id") Long changeTypeId,
                                                          @Valid @RequestBody ChangeType changeTypeDetails) throws ResourceNotFoundException {
        Optional<ChangeType> changeType = changeTypeRepository.findById(changeTypeId);

        if (changeType == null) new ResourceNotFoundException("ChangeType not found for this id :: " + changeTypeId);

        changeType.get().setSourceCurrency(changeTypeDetails.getSourceCurrency());
        changeType.get().setDestinationCurrency(changeTypeDetails.getDestinationCurrency());
        changeType.get().setChangeTypeValue(changeTypeDetails.getChangeTypeValue());
        final ChangeType updatedChangeType = changeTypeRepository.save(changeType.get());
        return ResponseEntity.ok(updatedChangeType);
    }

    @DeleteMapping("/{id}")
    public Map< String, Boolean > deleteChangeType(@PathVariable(value = "id") Long changeTypeId)
            throws ResourceNotFoundException {
        Optional<ChangeType> changeType = changeTypeRepository.findById(changeTypeId);
        if (changeType == null) new ResourceNotFoundException("ChangeType not found for this id :: " + changeTypeId);

        changeTypeRepository.delete(changeType.get());
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
