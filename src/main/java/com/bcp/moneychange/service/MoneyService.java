package com.bcp.moneychange.service;

import com.bcp.moneychange.dto.ChangeMoneyResponseDto;
import com.bcp.moneychange.dto.ChangeMoneySourceDto;
import rx.Observable;

public interface MoneyService {
	
	Observable<ChangeMoneyResponseDto> change(ChangeMoneySourceDto dataSource);

}
