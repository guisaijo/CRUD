package interfaces;
import application.Result;
import domain.DomainEntity;

public interface IFacade {
	public Result create(DomainEntity de);
	public Result delete(DomainEntity de);
	public Result update(DomainEntity de);
	public Result read(DomainEntity de);
}
