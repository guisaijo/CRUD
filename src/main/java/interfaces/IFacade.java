package interfaces;
import application.Result;
import domain.DomainEntity;

public interface IFacade {
	public Result create(DomainEntity domainEntity);
	public Result delete(DomainEntity domainEntity);
	public Result update(DomainEntity domainEntity);
	public Result read(DomainEntity domainEntity);
}
