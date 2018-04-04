package interfaces;

import application.Result;
import domain.DomainEntity;

public interface IStrategy {
	public Result execute(DomainEntity de);
}
