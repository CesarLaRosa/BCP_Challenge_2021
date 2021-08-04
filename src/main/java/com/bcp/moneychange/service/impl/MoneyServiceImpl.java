package com.bcp.moneychange.service.impl;

import com.bcp.moneychange.dto.ChangeMoneyResponseDto;
import com.bcp.moneychange.dto.ChangeMoneySourceDto;
import com.bcp.moneychange.entity.ChangeType;
import com.bcp.moneychange.repository.ChangeTypeRepository;
import com.bcp.moneychange.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class MoneyServiceImpl implements MoneyService{

	@Autowired
	private ChangeTypeRepository changeTypeRepository;

	@Override
	public Observable<ChangeMoneyResponseDto> change(ChangeMoneySourceDto dataSource) {
		return Observable.create(singleSubscriber -> {
			ChangeMoneyResponseDto response = null;
			if (dataSource.getAmount() != null) {
				try {
					response = new ChangeMoneyResponseDto();
					BigDecimal amount = dataSource.getAmount();
					Optional<ChangeType> responseChangeType = changeTypeRepository.findBySourceAndDestinationCurrency(dataSource.getSourceCurrency(), dataSource.getDestinationCurrency());
					BigDecimal result = amount.multiply(responseChangeType.get().getChangeTypeValue());

					response.setAmount(amount);
					response.setSourceCurrency(dataSource.getSourceCurrency());
					response.setDestinationCurrency(dataSource.getDestinationCurrency());
					response.setTypeChange(responseChangeType.get().getChangeTypeValue());
					response.setAmountTypeChange(result);
				} catch (Exception exception) {
					singleSubscriber.onError(new EntityNotFoundException());
				}
			}
			singleSubscriber.onNext(response);
			singleSubscriber.onCompleted();
		});
	}
}
